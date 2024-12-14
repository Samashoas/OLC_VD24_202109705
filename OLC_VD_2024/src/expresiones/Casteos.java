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
public class Casteos extends Instrucciones{
    private Instrucciones expresion;
    private Tipo tipodest;

    public Casteos(Instrucciones expresion, Tipo tipodest, int line, int column) {
        super(tipodest, line, column);
        this.expresion = expresion;
        this.tipodest = tipodest;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object Valor = null;
        Valor = this.expresion.interpretar(arbol, tabla);
        if (Valor instanceof Errores) {
                return Valor;
            }
        
        return switch (this.tipodest.getTipo()) {
            case ENTERO ->
                this.castofint(Valor);
            case DECIMAL ->
                this.castofdouble(Valor);
            case CARACTER ->
                this.castofchar(Valor);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.line, this.column);
        };
    }
    
    public Object castofint (Object valor){
         var tipo1 = this.expresion.type.getTipo();

        switch (tipo1) {
            case DECIMAL -> {
                this.type.setTipo(TipoDato.ENTERO);
                Double doubleVar = Math.floor((Double) valor);
                Integer integerValue = doubleVar.intValue(); 
                return integerValue;
            }
            case CARACTER -> {
                this.type.setTipo(TipoDato.ENTERO);
                //System.out.println("el valor ingresado es: " + valor);
                return (int) valor.toString().charAt(0);
            }
            default -> {
                return new Errores("SEMANTICO", "El casteo a entero solo puedo ser de decimal o caracter", this.line, this.column);
            }
        }
    }
    
    public Object castofdouble(Object valor){
        var tipo1 = this.expresion.type.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                this.type.setTipo(TipoDato.DECIMAL);
                Double valorDouble = ((Integer) valor).doubleValue(); // Conversión explícita
                return valorDouble;
            }
            case CARACTER -> {
                this.type.setTipo(TipoDato.DECIMAL);
                return (double) valor.toString().charAt(0);
            }
            default -> {
                return new Errores("SEMANTICO", "Casteo a double erroneo", this.line, this.column);
            }
        }
    }
    
    public Object castofchar (Object valor){
        var tipo1 = this.expresion.type.getTipo();
        /*
        if (op1 instanceof Integer) {
            if((int) op1 < 0 && (int) op1 > 255) {
                Variables.addToGlobalLinkedList(new Errores("SEMANTICO", "Esta fuera del rango del codigo ASCII", this.linea, this.col));
                return new Errores("SEMANTICO", "Esta fuera del rango del codigo ASCII", this.linea, this.col);
            }
        }
        */
        
        switch (tipo1) {
            case ENTERO -> {
                this.type.setTipo(TipoDato.CARACTER);
                return (char) ((Integer) valor).intValue();
            }
            default -> {
                return new Errores("SEMANTICO", "Casteo a double erroneo", this.line, this.column);
            }
        }
    }
    
}
