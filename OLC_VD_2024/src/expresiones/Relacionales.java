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
public class Relacionales extends Instrucciones{
    private Instrucciones operando1;
    private Instrucciones operando2;
    private OperadoresRelacionales operacion;
    
    public Relacionales(Instrucciones operando1, Instrucciones operando2, OperadoresRelacionales operacion, int linea, int col) {
        super(new Tipo(TipoDato.BOOLEANO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object opIzq = null, opDer = null, Unico = null;
            opIzq = this.operando1.interpretar(arbol, tabla);
            if (opIzq instanceof Errores) {
                return opIzq;
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Errores) {
                return opDer;
            }

        return switch (operacion) {
            case IGUALACION ->
                this.igualacion(opIzq, opDer);
            case DIFERENCIA ->
                this.diferencia(opIzq, opDer);
            case MAYORQUE ->
                this.mayorque(opIzq, opDer);
            case MAYORIGUAL ->
                this.mayorigual(opIzq, opDer);
            case MENORQUE ->
                this.menorque(opIzq, opDer);
            case MENORIGUAL ->
                this.menorigual(opIzq, opDer);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.line, this.column);
        };
    }
    
    public Object igualacion(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case ENTERO ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 == (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 == (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 == (int)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case DECIMAL ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 == (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 == (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 == (double)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1.toString().charAt(0) == (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1.toString().charAt(0) == (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().charAt(0) == op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case BOOLEANO ->{
                switch(tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString() == op2.toString();
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CADENA ->{
                switch(tipo2){
                    case CADENA ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().equals(op2.toString());
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
            }
        }
    }
    
    public Object diferencia(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case ENTERO ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 != (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 != (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 != (int)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case DECIMAL ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 != (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 != (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 != (double)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1.toString().charAt(0) != (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1.toString().charAt(0) != (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().charAt(0) != op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case BOOLEANO ->{
                switch(tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString() != op2.toString();
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CADENA ->{
                switch(tipo2){
                    case CADENA ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return !(op1.toString().equals(op2.toString()));
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
            }
        }
    }
    
    public Object mayorque(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case ENTERO ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 > (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 > (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 > (int)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case DECIMAL ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 > (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 > (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 > (double)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1.toString().charAt(0) > (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1.toString().charAt(0) > (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().charAt(0) > op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case BOOLEANO ->{
                switch(tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        int bool1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int bool2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0; 
                        return bool1>bool2;
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
            }
        }
    }
    
    public Object mayorigual(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case ENTERO ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 >= (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 >= (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 >= (int)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case DECIMAL ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 >= (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 >= (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 >= (double)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1.toString().charAt(0) >= (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1.toString().charAt(0) >= (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().charAt(0) >= op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case BOOLEANO ->{
                switch(tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        int bool1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int bool2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0; 
                        return bool1 >= bool2;
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
            }
        }
    }
    
    public Object menorque(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case ENTERO ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 < (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 < (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 < (int)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case DECIMAL ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 < (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 < (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 < (double)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1.toString().charAt(0) < (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1.toString().charAt(0) < (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().charAt(0) < op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case BOOLEANO ->{
                switch(tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        int bool1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int bool2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0; 
                        return bool1 < bool2;
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
            }
        }
    }
    
    public Object menorigual(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();
        
        switch(tipo1){
            case ENTERO ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 <= (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 <= (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1 <= (int)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case DECIMAL ->{
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 <= (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 <= (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1 <= (double)op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (int)op1.toString().charAt(0) <= (int)op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return (double)op1.toString().charAt(0) <= (double)op2;
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        return op1.toString().charAt(0) <= op2.toString().charAt(0);
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            case BOOLEANO ->{
                switch(tipo2){
                    case BOOLEANO ->{
                        this.type.setTipo(TipoDato.BOOLEANO);
                        int bool1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int bool2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0; 
                        return bool1 <= bool2;
                    }
                    default ->{
                        return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Igualación no permitida", this.line, this.column);
            }
        }
    }
}
