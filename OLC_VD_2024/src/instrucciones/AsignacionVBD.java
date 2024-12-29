/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class AsignacionVBD extends Instrucciones{
    public String id;
    public Instrucciones index;
    public Instrucciones index2;
    public Instrucciones expresion;
    
    //VBD(ID, INDEX1, INDEX2, EXPRESION, LINEA, COLUMNA)
    public AsignacionVBD(String id, Instrucciones index, Instrucciones index2, Instrucciones expresion, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.index = index;
        this.index2 = index2;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        
       Simbolo vector = table.getVariable(id);
        if (vector == null) {
            return new Errores("SEMANTICO", "El vector no existe", this.line, this.column);
        }

        if (!vector.isMutable()) {
            return new Errores("SEMANTICO", "La variable no es mutable", this.line, this.column);
        }

        if (index == null || index2 == null) {
            return new Errores("SEMANTICO", "Index no puede tener un valor nulo", this.line, this.column);
        }

        Object newValor = interpretarExpresion(tree, table);
        if (newValor instanceof Errores) {
            return newValor;
        }

        Object indexValue = interpretarIndex(tree, table, index);
        if (indexValue instanceof Errores) {
            return indexValue;
        }

        Object indexValue2 = interpretarIndex(tree, table, index2);
        if (indexValue2 instanceof Errores) {
            return indexValue2;
        }

        return asignarValor(vector, (int) indexValue, (int) indexValue2, newValor);
    }
    
    private Object interpretarExpresion(Arbol tree, TablaSimbolos table) {
        Object newValor = expresion.interpretar(tree, table);
        if (newValor instanceof Errores) {
            return newValor;
        }
        if (expresion.type.getTipo() != this.type.getTipo()) {
            return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
        }
        return newValor;
    }
    
    private Object interpretarIndex(Arbol tree, TablaSimbolos table, Instrucciones index) {
        Object indexValue = index.interpretar(tree, table);
        if (!(indexValue instanceof Integer)) {
            return new Errores("SEMANTICO", "El indice debe de ser un valor entero", this.line, this.column);
        }
        return indexValue;
    }
    
    private Object asignarValor(Simbolo vector, int index, int index2, Object newValor) {
        LinkedList<LinkedList<Object>> listaValores = (LinkedList<LinkedList<Object>>) vector.getValue();
        if (index < 0 || index >= listaValores.size()) {
            return new Errores("SEMANTICO", "El indice esta fuera del rango", this.line, this.column);
        }
        LinkedList<Object> subLista = listaValores.get(index);
        if (index2 < 0 || index2 >= subLista.size()) {
            return new Errores("SEMANTICO", "El indice esta fuera del rango", this.line, this.column);
        }
        subLista.set(index2, newValor);
        return null;
    }
}
