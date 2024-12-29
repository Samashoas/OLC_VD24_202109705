/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.Collections;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Reverse extends Instrucciones{
    private String Indentificador;

    public Reverse(String Indentificador, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.Indentificador = Indentificador;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var ListaSimbolo = table.getVariable(Indentificador);
        if(ListaSimbolo == null){
            return new Errores("SEMANTICO", "La lista no existe", this.line, this.column);
        }
        
        if(!(ListaSimbolo.getValue() instanceof LinkedList)){
            return new Errores("SEMANTICO", "El ID no corresponde a una lista", this.line, this.column);
        }
        
        LinkedList<Object> lista = (LinkedList<Object>) ListaSimbolo.getValue();
        
        if(lista.isEmpty()){
            return new Errores("SEMANTICO", "La lista se encuentra vacia", this.line, this.column);
        }
        
        Collections.reverse(lista);
        ListaSimbolo.setValue(lista);
        
        return null;
    }
}
