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
public class AccesoVUD extends Instrucciones{
    private String id;
    private Instrucciones index;

    //(id, index, linea, columna)
    public AccesoVUD(String id, Instrucciones index, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.index = index;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        Simbolo vector = table.getVariable(id);
        if (vector == null) {
            return new Errores("SEMANTICO", "El vector no existe", this.line, this.column);
        }

        if (index == null) {
            return new Errores("SEMANTICO", "El indice no puede ser un valor nulo", this.line, this.column);
        }

        Object indexValue = interpretarIndex(tree, table);
        if (indexValue instanceof Errores) {
            return indexValue;
        }

        return accederValor(vector, (int) indexValue);
    }
    
    private Object interpretarIndex(Arbol tree, TablaSimbolos table) {
        Object indexValue = index.interpretar(tree, table);
        if (!(indexValue instanceof Integer)) {
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        return indexValue;
    }

    private Object accederValor(Simbolo vector, int index) {
        LinkedList<Object> listaValores = (LinkedList<Object>) vector.getValue();
        if (index < 0 || index >= listaValores.size()) {
            return new Errores("SEMANTICO", "Index fuera de los limites", this.line, this.column);
        }
        this.type.setTipo(vector.getType().getTipo());
        return listaValores.get(index);
    }
}
