/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Caso extends Instrucciones{
    private Instrucciones expresion;
    private LinkedList<Instrucciones> instrucciones;

    public Caso(Instrucciones expresion, LinkedList<Instrucciones> instrucciones, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.expresion = expresion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        return this.expresion.interpretar(tree, table);
    }
    public LinkedList<Instrucciones> getInstrucciones(){
        return instrucciones;
    }
}
