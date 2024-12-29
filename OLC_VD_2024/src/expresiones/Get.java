/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Get extends Instrucciones{
    private String Indentificador;
    private Instrucciones index;
    
    //GET(ID, INDEX, LINEA, COLUMNA)
    public Get(String Indentificador, Instrucciones index, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.Indentificador = Indentificador;
        this.index = index;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var ListaSimbolo = table.getVariable(Indentificador);
        if(ListaSimbolo == null){
            return new Errores("SEMANTICO", "La lista no existe", this.line, this.column);
        }
        if(!(ListaSimbolo.getValue() instanceof LinkedList)){
            return new Errores("SEMANTICO", "El ID no pertenece a una lista", this.line, this.column);
        }
        
        LinkedList<Object> lista = (LinkedList<Object>) ListaSimbolo.getValue();
        
        Object IndexValue = index.interpretar(tree, table);
        if(IndexValue instanceof Errores){
            return IndexValue;
        }
        
        if(!(IndexValue instanceof Integer)){
            return new Errores("SEMANTICO", "El index de ser un valor de tipo entero", this.line, this.column);
        }
        
        int NumIndex = (int)IndexValue;
        if(NumIndex < 0 || NumIndex >= lista.size()){
            return new Errores("SEMANTICO", "El indice está fuera del rango", this.line, this.column);
        }
        
        this.type.setTipo(ListaSimbolo.getType().getTipo());
        return lista.get(NumIndex);
    }
    
    
}
