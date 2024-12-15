/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Continue extends Instrucciones{

    public Continue(int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        return this;
    }
    
    
    
}
