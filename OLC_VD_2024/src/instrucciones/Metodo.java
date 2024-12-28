/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import java.util.HashMap;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.Tipo;

/**
 *
 * @author jpsam
 */
public class Metodo extends Instrucciones{
    public String id;
    public LinkedList<HashMap> parametros;
    public LinkedList<Instrucciones> instrucciones;

    public Metodo(String id, LinkedList<HashMap> parametros, LinkedList<Instrucciones> instrucciones, Tipo type, int line, int column) {
        super(type, line, column);
        this.id = id;
        this.instrucciones = instrucciones;
        this.parametros = parametros;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        for(var i: this.instrucciones){
            /*if(i == null){
            continue;
            >>>>> O tambien puede ser:
            return new Errores("SEMANTICO", "DESCRIPCION", LINE, COLUMNA)
            }*/
            var resultado = i.interpretar(tree, table);
            //Agrega la recuperación de Errores
        }
        return null;
    }
}
