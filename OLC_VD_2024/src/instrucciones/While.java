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
public class While extends Instrucciones{
    private Instrucciones condicion;
    private LinkedList<Instrucciones> instrucciones;

    public While(Instrucciones condicion, LinkedList<Instrucciones> instrucciones, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var cond = this.condicion.interpretar(tree, table);
        if (cond instanceof Errores) {
            return cond;
        }

        if (this.condicion.type.getTipo() != TipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion debe de ser de tipo booleano", this.line, this.column);
        }
        
        if(cond instanceof String){
            cond = (cond.toString().toLowerCase()).equals("true") ? true : false;
        }

        var nuevaTabla = new TablaSimbolos(table);
        while ((boolean) this.condicion.interpretar(tree, nuevaTabla)) {
            var nuevaTabla2 = new TablaSimbolos(nuevaTabla);
            for (var i : this.instrucciones) {
                if(i instanceof Break){
                    return null;
                }
                var resIns = i.interpretar(tree, nuevaTabla2);
                if(resIns instanceof Break){
                    return null;
                }
                if (resIns instanceof Errores) {
                    return new Errores("SEMANTICO", "Error encotrado dentro de sentencia While", this.line, this.column);
                }
            }
        }
        return null;
    }
}
    
    
