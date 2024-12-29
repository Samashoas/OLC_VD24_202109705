/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Length extends Instrucciones{
    private Instrucciones expresion;

    public Length(Instrucciones expresion, int line, int column) {
        super(new Tipo(TipoDato.ENTERO), line, column);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        Object valor = expresion.interpretar(tree, table);
        
        if(valor instanceof Errores){
            return valor;
        }
        
        if(valor instanceof String){
            return((String)valor).length();
        }else if(valor instanceof LinkedList){
            return((LinkedList<?>) valor).size();
        }else {
            return new Errores("SEMANTICO", "Solo se aceptan Cadenas, vectores y listas", this.line, this.column);
        }
    }
}
