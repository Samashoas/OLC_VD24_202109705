/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracto;

import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.Tipo;

/**
 *
 * @author jpsam
 */
public abstract class Instrucciones {
    public Tipo type;
    public int line;
    public int column;
    
    public Instrucciones(Tipo type, int line, int column){
        this.type = type;
        this.line = line;
        this.column = column;
    }
    
    public abstract Object interpretar(Arbol tree, TablaSimbolos table);
}
