/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Return extends Instrucciones{
    private Instrucciones expresion;

    public Return(Instrucciones expresion, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);
        if (expresion != null) {
            this.type = new Tipo(expresion.type.getTipo());
        }
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        if(this.expresion == null){
            return new ValorReturn(TipoDato.VOID, null);
        }else{
            var resultado = this.expresion.interpretar(tree, table);
            if(resultado instanceof ValorReturn){
                return resultado;
            }
            return new ValorReturn(this.type.getTipo(), resultado);
        }
    }
    
    
}
