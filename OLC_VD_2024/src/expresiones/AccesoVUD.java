/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class AccesoVUD extends Instrucciones{
    private String id;
    private Instrucciones index;

    //(id, index, linea, columna)
    public AccesoVUD(String id, Instrucciones index, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.index = index;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var vector = table.getVariable(id);
        if(vector == null){
            return new Errores("SEMANTICO", "El vector no existe", this.line, this.column);
        }
        
        if(this.index == null){
            return new Errores("SEMANTICO", "El indice no puede ser un valor nulo", this.line, this.column);
        }
        
        var index = this.index.interpretar(tree, table);
        if(!(index instanceof Integer)){
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        
        if(this.index.type.getTipo() != TipoDato.ENTERO){
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        
        int NumIndex = (int) index;
        
        if(!(vector.getValue() instanceof LinkedList)){
            return new Errores("SEMANTICO", "No es un vector", this.line, this.column);
        }
        
        LinkedList<Object> lista_valores = (LinkedList<Object>)vector.getValue();
        
        if(NumIndex < 0 || NumIndex >= lista_valores.size()){
            return new Errores("SEMANTICO", "Index fuera de los limites", this.line, this.column);
        }
        
        this.type.setTipo(vector.getType().getTipo());
        return lista_valores.get(NumIndex);
    } 
}
