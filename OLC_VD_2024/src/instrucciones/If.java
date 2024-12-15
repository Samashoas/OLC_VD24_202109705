/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class If extends Instrucciones{
    private Instrucciones condicion;
    private LinkedList<Instrucciones> instrucciones;

    public If(Instrucciones condicion, LinkedList<Instrucciones> instruccion, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.condicion = condicion;
        this.instrucciones = instruccion;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var cond = this.condicion.interpretar(tree, table);
        if(cond instanceof Errores){
            return cond;
        }
        
        if(this.condicion.type.getTipo() != TipoDato.BOOLEANO){
            return new Errores("SEMANTICO", "La condicion debe de ser booleana", this.line, this.column);
        }
        
        //Se tiene un bloque -> Crear nuevo entorno
        var nuevaTabla = new TablaSimbolos(table);
        /*Para if else se crea una nueva Lista de instrucciones (InstruccionesElse)
        y en el else se hace el mismo procedimiento de la creacion del nuevo entorno
        */
        if((boolean)cond){
            //Creacion del nuevo entorno
            for(var i : this.instrucciones){
                var resultado = i.interpretar(tree, nuevaTabla);
                if(resultado instanceof Errores){
                    tree.AddErrores((Errores) resultado);
                }
            }
        }
        return null;
    } 
}
