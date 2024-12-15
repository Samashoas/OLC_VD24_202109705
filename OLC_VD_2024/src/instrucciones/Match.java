/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Match extends Instrucciones{
    private Instrucciones expresion;
    private LinkedList<Caso> casos;
    private LinkedList<Instrucciones> defaultInstrucciones;

    public Match(Instrucciones expresion, LinkedList<Caso> casos, LinkedList<Instrucciones> defaultInstrucciones, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.expresion = expresion;
        this.casos = casos;
        this.defaultInstrucciones = defaultInstrucciones;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var valorExpresion = this.expresion.interpretar(tree, table);
        if (valorExpresion instanceof Errores) {
            return valorExpresion;
        }

        for (var caso : casos) {
            var valorCaso = caso.interpretar(tree, table);
            if (valorCaso instanceof Errores) {
                return valorCaso;
            }

            if (valorExpresion.equals(valorCaso)) {
                var nuevaTabla = new TablaSimbolos(table);
                for (var instruccion : caso.getInstrucciones()) {
                    var resultado = instruccion.interpretar(tree, nuevaTabla);
                    if (resultado instanceof Errores) {
                        tree.AddErrores((Errores) resultado);
                    }
                }
                return null;
            }
        }

        if (defaultInstrucciones != null) {
            var nuevaTabla = new TablaSimbolos(table);
            for (var instruccion : defaultInstrucciones) {
                var resultado = instruccion.interpretar(tree, nuevaTabla);
                if (resultado instanceof Errores) {
                    tree.AddErrores((Errores) resultado);
                }
            }
        }

        return null;
    }
    
    

}
