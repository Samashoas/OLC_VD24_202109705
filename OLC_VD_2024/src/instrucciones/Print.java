/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.Tipo;
import simbolo.TipoDato;

/**
 *
 * @author jpsam
 */
public class Print extends Instrucciones{
    private Instrucciones expresion;

    public Print(Instrucciones expresion, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.expresion = expresion;
    }
    
    public Object interpretar(Arbol tree, TablaSimbolos table){
        var valor = this.expresion.interpretar(tree, table);
        if(valor instanceof Errores)return valor;
        tree.Print(valor.toString());
        return null;
    }

}
