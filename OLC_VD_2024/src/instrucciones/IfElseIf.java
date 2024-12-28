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
public class IfElseIf extends Instrucciones{
    private Instrucciones condicion;
    private LinkedList<Instrucciones> instrucciones;
    private Instrucciones sentIfElse;

    public IfElseIf(Instrucciones condicion, LinkedList<Instrucciones> instrucciones, Instrucciones sentIfElse, int line, int column) {
        super(new Tipo(TipoDato.BOOLEANO), line, column);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.sentIfElse = sentIfElse;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var cond = this.condicion.interpretar(tree, table);
        if (cond instanceof Errores) {
            return cond;
        }

        if (this.condicion.type.getTipo() != TipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion debe de ser booleana", this.line, this.column);
        }

        var nuevaTabla = new TablaSimbolos(table);

        if ((boolean) cond) {
            for (var i : this.instrucciones) {
                if(i == null){
                    return new Errores ("SEMANTICO", "Error en el if", this.line, this.column);
                }
                if(i instanceof Break){
                    return i;
                }
                if(i instanceof Continue){
                    return i;
                }
                var resultado = i.interpretar(tree, nuevaTabla);
                if(resultado instanceof Break){
                    return resultado;
                }
                if(resultado instanceof Continue){
                    return resultado;
                }
                if(resultado instanceof ValorReturn){
                    return resultado;
                }
                if (resultado instanceof Errores) {
                    tree.AddErrores((Errores) resultado);
                }
            }
        } else if (this.sentIfElse != null) {
            if(this.sentIfElse == null){
                return new Errores ("SEMANTICO", "Error en el if else", this.line, this.column);
            }
            if(this.sentIfElse instanceof Break){
                return this.sentIfElse;
            }
            if(this.sentIfElse instanceof Continue){
                return this.sentIfElse;
            }
            var resultado = this.sentIfElse.interpretar(tree, nuevaTabla);
            if(resultado instanceof Break){
                return resultado;
            }
            if(resultado instanceof Continue){
                return resultado;
            }
            if(resultado instanceof ValorReturn){
                return resultado;
            }
            if (resultado instanceof Errores) {
                tree.AddErrores((Errores) resultado);
            }
        }

        return null;
    }
}
