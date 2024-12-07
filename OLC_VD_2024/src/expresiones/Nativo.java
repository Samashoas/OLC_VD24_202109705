/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instrucciones;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.Tipo;
import simbolo.TipoDato;

/**
 *
 * @author jpsam
 */
public class Nativo extends Instrucciones{
    public Object value;

    public Nativo(Object value, Tipo type, int line, int column) {
        super(type, line, column);
        this.value = value;
    }
  
    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        return this.value;
    }
    
}
