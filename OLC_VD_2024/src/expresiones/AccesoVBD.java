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
public class AccesoVBD extends Instrucciones{
    private String id;
    private Instrucciones index;
    private Instrucciones index2;

    public AccesoVBD(String id, Instrucciones index, Instrucciones index2, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.index = index;
        this.index2 = index2;
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
        if(this.index2 == null){
            return new Errores("SEMANTICO", "El indice no puede ser un valor nulo", this.line, this.column);
        }
        
        var index = this.index.interpretar(tree, table);
        if(!(index instanceof Integer)){
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        if(this.index.type.getTipo() != TipoDato.ENTERO){
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        
        var index2 = this.index2.interpretar(tree, table);
        if(!(index2 instanceof Integer)){
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        if(this.index.type.getTipo() != TipoDato.ENTERO){
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        
        if(!(vector.getValue() instanceof LinkedList)){
            return new Errores("SEMANTICO", "No es un vector", this.line, this.column);
        }
        
        LinkedList<LinkedList<Instrucciones>> lista_valores = new LinkedList<>();
        lista_valores = (LinkedList<LinkedList<Instrucciones>>) vector.getValue();
        
        int NumIndex = (int) index;
        if(NumIndex < 0){
            return new Errores("SEMANTICO", "Indice fuera de rango", this.line, this.column);
        }
        if(NumIndex >= lista_valores.size()){
            return new Errores("SEMANTICO", "Indice fuera de rango", this.line, this.column);
        }
        
        int NumIndex2 = (int) index2;
        if(NumIndex2 < 0){
            return new Errores("SEMANTICO", "Indice fuera de rango", this.line, this.column);
        }
        if(NumIndex2 >= lista_valores.size()){
            return new Errores("SEMANTICO", "Indice fuera de rango", this.line, this.column);
        }
        
        this.type.setTipo(vector.getType().getTipo());
        return lista_valores.get(NumIndex).get(NumIndex2);
    }
    
    
}
