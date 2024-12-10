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
public class Aritmeticas extends Instrucciones {

    private Instrucciones operando1;
    private Instrucciones operando2;
    private OperadoresAritmeticos operacion;
    private Instrucciones operandoUnico;

    //negacion 
    public Aritmeticas(Instrucciones operandoUnico, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(TipoDato.ENTERO), linea, col);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    //cualquier operacion menos negacion
    public Aritmeticas(Instrucciones operando1, Instrucciones operando2, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(TipoDato.ENTERO), linea, col);
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
            case SUMA ->
                this.suma(opIzq, opDer);
            case RESTA ->
                this.resta(opIzq, opDer);
            case MULTIPLICACION ->
                this.multiplicacion(opIzq, opDer);
            case DIVISION ->
                this.division(opIzq, opDer);
            case POTENCIA ->
                this.potencia(opIzq, opDer);
            case RAIZ ->
                this.raiz(opIzq, opDer);
            case NEGATIVO ->
                this.negacion(Unico);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.line, this.column);
        };
    }

    public Object suma(Object op1, Object op2) {
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf((int) op1 + (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((int) op1 + (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf((int) op1 + op2.toString().charAt(0));
                    }
                    case CADENA->{
                        this.type.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case BOOLEANO->{
                        this.type.setTipo(TipoDato.ENTERO);
                        if(op2.toString() == "true"){
                            return Integer.valueOf((int) op1 + 1);
                        }
                        return op1;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 + (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 + (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 + op2.toString().charAt(0));
                    }
                    case CADENA ->{
                        this.type.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case BOOLEANO->{
                        this.type.setTipo(TipoDato.DECIMAL);
                        if(op2.toString() == "true"){
                            return (double) op1 + 1;
                        }
                        return op1;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case CARACTER ->{
                switch (tipo2){
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf(op1.toString().charAt(0) + (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf(op1.toString().charAt(0) + (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case CADENA -> {
                        this.type.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2){
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.CADENA);
                        return Integer.valueOf(op1.toString() + op2.toString());
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.CADENA);
                        return Double.valueOf(op1.toString() + op2.toString());
                    }
                    case CARACTER ->{
                        this.type.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case CADENA -> {
                        this.type.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case BOOLEANO -> {
                switch(tipo2){
                    case ENTERO ->{
                        this.type.setTipo(TipoDato.ENTERO);
                        if(op1.toString() == "true"){
                            return 1 + (int) op2;
                        }
                        return op2;
                    }
                    case DECIMAL ->{
                        this.type.setTipo(TipoDato.DECIMAL);
                        if(op1.toString() == "true"){
                            return 1 + (double) op2;
                        }
                        return op2;
                    }
                    case CADENA ->{
                        this.type.setTipo(TipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma NO valida", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
            }
        }
    }
    
    public Object resta(Object op1, Object op2) {
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf((int) op1 - (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((int) op1 - (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf((int) op1 - op2.toString().charAt(0));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        //return (double) op1 - (int) op1;
                        return Double.valueOf((double) op1 - (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 - (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 - op2.toString().charAt(0));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case CARACTER ->{
                switch (tipo2){
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf(op1.toString().charAt(0) - (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf(op1.toString().charAt(0) - (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);

            }
        }
    }

    public Object multiplicacion(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf((int) op1 * (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((int) op1 * (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf((int) op1 * op2.toString().charAt(0));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        //return (double) op1 - (int) op1;
                        return Double.valueOf((double) op1 * (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 * (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 * op2.toString().charAt(0));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case CARACTER ->{
                switch (tipo2){
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return Integer.valueOf(op1.toString().charAt(0) * (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf(op1.toString().charAt(0) * (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);

            }
        }
    }
    
    public Object division(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double)(int) op1 / (double)(int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((int) op1 / (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((int) op1 / (double)op2.toString().charAt(0));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        //return (double) op1 - (int) op1;
                        return Double.valueOf((double) op1 / (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 / (double) op2);
                    }
                    case CARACTER -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double) op1 / (double)op2.toString().charAt(0));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case CARACTER ->{
                switch (tipo2){
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double)op1.toString().charAt(0) / (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf((double)op1.toString().charAt(0) / (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);

            }
        }
    }
    
    public Object potencia(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.ENTERO);
                        return (int)Math.pow((int) op1, (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Math.pow((int) op1, (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        //return (double) op1 - (int) op1;
                        return Math.pow((double) op1, (int) op2);
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Math.pow((double) op1, (double) op2);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.line, this.column); 
            }
        }
    }
    
    public Object raiz(Object op1, Object op2){
        var tipo1 = this.operando1.type.getTipo();
        var tipo2 = this.operando2.type.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Double.valueOf(Math.pow((int) op1, ((double)1/(int)op2)));
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Math.pow((int) op1, (1/(double) op2));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    case ENTERO -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        //return (double) op1 - (int) op1;
                        return Math.pow((double) op1, ((double)1/(int)op2));
                    }
                    case DECIMAL -> {
                        this.type.setTipo(TipoDato.DECIMAL);
                        return Math.pow((double) op1, (1/(double) op2));
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.line, this.column);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.line, this.column); 
            }
        }
    }
    
    public Object negacion(Object op1) {
        var opU = this.operandoUnico.type.getTipo();
        switch (opU) {
            case ENTERO -> {
                this.type.setTipo(TipoDato.ENTERO);
                return Integer.valueOf((int) op1 * -1);
            }
            case DECIMAL -> {
                this.type.setTipo(TipoDato.DECIMAL);
                return Double.valueOf((double) op1 * -1);
            }
            default -> {
                return new Errores("SEMANTICO", "Negacion erronea", this.line, this.column);
            }
        }
    }
}
