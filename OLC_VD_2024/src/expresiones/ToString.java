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
public class ToString extends Instrucciones{
    private Instrucciones expresion;

    public ToString(Instrucciones expresion, int line, int column) {
        super(new Tipo(TipoDato.CADENA), line, column);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        Object valor = expresion.interpretar(tree, table);
        
        if (valor instanceof Errores) {
            return valor;
        }

        // Convertir el valor a cadena
        return valor.toString();
    }
}
