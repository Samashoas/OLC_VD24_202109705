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
public class For extends Instrucciones{
    private Instrucciones asignacion;
    private Instrucciones condicion;
    private Instrucciones actualización;
    private LinkedList<Instrucciones> instrucciones;

    public For(Instrucciones asignacion, Instrucciones condicion, Instrucciones actualización, LinkedList<Instrucciones> instrucciones, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.asignacion = asignacion;
        this.condicion = condicion;
        this.actualización = actualización;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var asg = this.asignacion.interpretar(tree, table);
        if(asg  instanceof Errores){
            return asg ;
        }
        
        var cond = this.condicion.interpretar(tree, table);
        if(cond instanceof Errores){
            return cond;
        }
        
        if(this.condicion.type.getTipo() != TipoDato.BOOLEANO){
            return new Errores("SEMANTICO", "La condicion debe de ser de tipo booleano", this.line, this.column);
        }
        
        var nuevaTabla = new TablaSimbolos(table);
        while((boolean)this.condicion.interpretar(tree, nuevaTabla)){
            var nuevaTabla2 = new TablaSimbolos(nuevaTabla);
            for(var i: this.instrucciones){
                if(i instanceof Break){
                    return null;
                }
                if(i instanceof Continue){
                    System.out.println("Continue instrucciones");
                    break;
                }
                var resIns = i.interpretar(tree, nuevaTabla2);
                if(resIns instanceof Break){
                    return null;
                }
                if(resIns instanceof Continue){
                    System.out.println("clase resultado");
                    break;
                }
                if(resIns instanceof Errores){
                    tree.AddErrores((Errores) resIns);
                }
            }
            var act = this.actualización.interpretar(tree, nuevaTabla);
            if(act instanceof Errores){
                return act;
            }
        }
        return null;
    }
    
    
}
