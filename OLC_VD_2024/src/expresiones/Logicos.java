/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instrucciones;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Logicos extends Instrucciones{
    private Instrucciones operando1;
    private Instrucciones operando2;
    private OperadoresLogicos operacion;
    private Instrucciones operandoUnico;

    //negacion 
    public Logicos(Instrucciones operandoUnico, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(TipoDato.BOOLEANO), linea, col);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    //cualquier operacion menos negacion
    public Logicos(Instrucciones operando1, Instrucciones operando2, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(TipoDato.BOOLEANO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object opIzq = null, opDer = null, Unico = null;
        if (this.operandoUnico != null) {
            Unico = this.operandoUnico.interpretar(arbol, tabla);
            if (Unico instanceof Errores) {
                return Unico;
            }
        } else {
            opIzq = this.operando1.interpretar(arbol, tabla);
            if (opIzq instanceof Errores) {
                return opIzq;
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Errores) {
                return opDer;
            }
        }

        return switch (operacion) {
            case AND ->
                this.and(opIzq, opDer);
            case OR ->
                this.or(opIzq, opDer);
            case NOT ->
                this.not(Unico);
            default ->
                new Errores("SEMANTICO", "Operador logico invalido", this.line, this.column);
        };
    }
    
    public Object and(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case BOOLEANO ->{
                switch (tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return Boolean.parseBoolean(op1.toString()) && Boolean.parseBoolean(op2.toString());
                    }
                    default ->{
                        return new Errores("SEMANTICO", "No es un valor Booleano", this.line, this.column);
                    }
                }
            }
            default ->{
                return new Errores("SEMANTICO", "No es un valor Booleano", this.line, this.column);
            }
        }
    }
    
    public Object or(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case BOOLEANO ->{
                switch (tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return Boolean.parseBoolean(op1.toString()) || Boolean.parseBoolean(op2.toString());
                    }
                    default ->{
                        return new Errores("SEMANTICO", "No es un valor Booleano", this.line, this.column);
                    }
                }
            }
            default ->{
                return new Errores("SEMANTICO", "No es un valor Booleano", this.line, this.column);
            }
        }
    }
    
    public Object not(Object op1) {
        var opU = this.operandoUnico.type.getTipo();
        switch (opU) {
            case BOOLEANO -> {
                this.type.setTipo(TipoDato.BOOLEANO);
                return !Boolean.parseBoolean(op1.toString());
            }
            default -> {
                return new Errores("SEMANTICO", "Tipo de dato no compatible con Negacion", this.line, this.column);
            }
        }
    }
}
