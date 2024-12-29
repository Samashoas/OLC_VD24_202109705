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
public class AsignacionVUD extends Instrucciones{
    public String id;
    public Instrucciones index;
    public Instrucciones expresion;
    
    //(ID, INDEX, EXPRESION, LINEA, COLUMNA)
    public AsignacionVUD(String id, Instrucciones index, Instrucciones expresion, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.index = index;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var vector = table.getVariable(id);
        if(vector == null){
            return new Errores("SEMANTICO", "El vector no existe", this.line, this.column);
        }
        
        if(!vector.isMutable()){
            return new Errores("SEMANTICO", "La variable no es mutable", this.line, this.column);
        }
        
        if(this.index == null){
            return new Errores("SEMANTICO", "Index no puede tener un valor nulo", this.line, this.column);
        }
        
        var newValor = this.expresion.interpretar(tree, table);
        if(newValor instanceof Errores){
            return newValor;
        }
        if(vector.getType().getTipo() != this.expresion.type.getTipo()){
            return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
        }
        
        var index = this.index.interpretar(tree, table);
        if(index instanceof Errores){
            return index;
        }
        if(!(index instanceof Integer)){
            return new Errores("SEMANTICO", "El indice debe de ser un valor entero", this.line, this.column);
        }
        
        int ValIndex = (int) index;
        if(!(vector.getValue() instanceof LinkedList)){
            return new Errores("SEMANTICO", "No es un vector", this.line, this.column);
        }
        
        LinkedList<Object> lista_valores = (LinkedList<Object>)vector.getValue();
        
        if(ValIndex < 0 || ValIndex >= lista_valores.size()){
            return new Errores("SEMANTICO", "El indice esta fuera del rango", this.line, this.column);
        }
        
        lista_valores.set(ValIndex, newValor);
        vector.setValue(lista_valores);
        
        return null;
    }
}
