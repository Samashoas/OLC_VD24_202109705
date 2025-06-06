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
        if(this.index2 == null){
            return new Errores("SEMANTIC", "Index no puede tener un valor nulo", this.line, this.column);
        }
        
        var newValor = this.expresion.interpretar(tree, table);
        if(newValor instanceof Errores){
            return newValor;
        }
        
        Object index = this.index.interpretar(tree, table);
        if(index instanceof Errores){
            return index;
        }
        if(!(index instanceof Integer)){
            return new Errores("SEMANTICO", "El indice debe ser un valor de tipo entero", this.line, this.column);
        }
        
        Object index2 = this.index2.interpretar(tree, table);
        if(index2 instanceof Errores){
            return index2;
        }
        if(!(index2 instanceof Integer)){
            return new Errores("SEMANTICO", "El indice debe ser un valor entero", this.line, this.column);
        }
        if(vector.getType().getTipo() != this.expresion.type.getTipo()){
            return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
        }
        
        if(vector.getValue() instanceof LinkedList){
            LinkedList<LinkedList<Object>> lista_valores = new LinkedList<>();
            lista_valores = (LinkedList<LinkedList<Object>>) vector.getValue();

            int NumIndex = (int) index;
            int NumIndex2 = (int) index2;
            if (NumIndex < 0 || NumIndex >= lista_valores.size() || NumIndex2 < 0 || NumIndex2 >= lista_valores.get(NumIndex).size()) {
                return new Errores("Semántico","Index fuera de los límites del vector", this.line, this.column);
            }
        
            lista_valores.get(NumIndex).set(NumIndex2, newValor);
            vector.setValue(lista_valores);
        }else{
            return new Errores("SEMANTICO", "No es un vector", this.line, this.column);
        }
        return null;
    }
}
