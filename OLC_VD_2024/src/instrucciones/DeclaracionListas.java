/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.TablaSimbolos;
import simbolo.Tipo;

/**
 *
 * @author jpsam
 */
public class DeclaracionListas extends Instrucciones{
    private String Indentificador;
    private boolean isMutable;
    
    //LISTAS(ID, MUTABLE, TIPO, LINE, COLUMNA)
    public DeclaracionListas(String Indentificador, boolean isMutable, Tipo type, int line, int column) {
        super(type, line, column);
        this.Indentificador = Indentificador;
        this.isMutable = isMutable;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        LinkedList<Object> valores = new LinkedList<>();
        
        Simbolo nuevoSimbolo = new Simbolo(this.type, this.Indentificador, valores, this.isMutable);
        table.setVariable(nuevoSimbolo);
        
        return null;
    }
    
    
}
