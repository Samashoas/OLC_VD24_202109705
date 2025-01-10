/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instrucciones;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Round extends Instrucciones{
    private Instrucciones expresion;

    public Round(Instrucciones expresion, int line, int column) {
        super(new Tipo(TipoDato.ENTERO), line, column);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        Object Valor = null;
        Valor = this.expresion.interpretar(tree, table);
        
        if(Valor instanceof Errores){
            return Valor;
        }
        
        if(this.expresion.type.getTipo() != TipoDato.DECIMAL && this.expresion.type.getTipo() != TipoDato.ENTERO){
            return new Errores("SEMANTICO", "La funcion Round solo acepta valores numericos", this.line, this.column);
        }
        
        //return Math.round((Double)Valor);
        
        if(Valor instanceof Double){
            return Math.round((Double)Valor);
        }else if(Valor instanceof Integer){
            return Math.round((Integer)Valor);
        }else{
            return new Errores("SEMANTICO", "Valor no numerico en la funcion Round", this.line, this.column);
        }
    }
    
    
}
