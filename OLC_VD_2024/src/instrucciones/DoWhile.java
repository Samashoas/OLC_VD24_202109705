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
public class DoWhile extends Instrucciones{
    private Instrucciones condicion;
    private LinkedList<Instrucciones> instrucciones;

    public DoWhile(Instrucciones condicion, LinkedList<Instrucciones> instrucciones, int line, int column) {
        super(new Tipo(TipoDato.BOOLEANO), line, column);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var nuevaTabla = new TablaSimbolos(table);
        do {
            var nuevaTabla2 = new TablaSimbolos(nuevaTabla);
            for (var i : this.instrucciones) {
                if(i == null){
                    return new Errores("SEMANTICO", "error en el do while", this.line, this.column);
                }
                if(i instanceof Break){
                    return null;
                }
                if(i instanceof Continue){
                    break;
                }
                var resIns = i.interpretar(tree, nuevaTabla2);
                if(resIns instanceof Break){
                    return null;
                }
                if(resIns instanceof Continue){
                    break;
                }
                if(resIns instanceof ValorReturn){
                    return resIns;
                }
                if (resIns instanceof Errores) {
                    tree.AddErrores((Errores) resIns);
                }
            }
            var cond = this.condicion.interpretar(tree, nuevaTabla);
            if (cond instanceof Errores) {
                return cond;
            }
            if (this.condicion.type.getTipo() != TipoDato.BOOLEANO) {
                return new Errores("SEMANTICO", "La condicion debe de ser de tipo booleano", this.line, this.column);
            }
        } while ((boolean) this.condicion.interpretar(tree, nuevaTabla));
        return null;
    }
    
    
}
