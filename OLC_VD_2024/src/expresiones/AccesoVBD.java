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
public class AccesoVBD extends Instrucciones{
    private String id;
    private Instrucciones index;
    private Instrucciones index2;

    public AccesoVBD(String id, Instrucciones index, Instrucciones index2, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.index = index;
        this.index2 = index2;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        Simbolo vector = table.getVariable(id);
        if (vector == null) {
            return new Errores("SEMANTICO", "El vector no existe", this.line, this.column);
        }

        if (index == null || index2 == null) {
            return new Errores("SEMANTICO", "El indice no puede ser un valor nulo", this.line, this.column);
        }

        Object indexValue = interpretarIndex(tree, table, index);
        if (indexValue instanceof Errores) {
            return indexValue;
        }

        Object indexValue2 = interpretarIndex(tree, table, index2);
        if (indexValue2 instanceof Errores) {
            return indexValue2;
        }

        return accederValor(vector, (int) indexValue, (int) indexValue2);
    }
    
    private Object interpretarIndex(Arbol tree, TablaSimbolos table, Instrucciones index) {
        Object indexValue = index.interpretar(tree, table);
        if (!(indexValue instanceof Integer)) {
            return new Errores("SEMANTICO", "El valor del indice tiene que ser de tipo entero", this.line, this.column);
        }
        return indexValue;
    }
    
    private Object accederValor(Simbolo vector, int index, int index2) {
        LinkedList<LinkedList<Object>> listaValores = (LinkedList<LinkedList<Object>>) vector.getValue();
        if (index < 0 || index >= listaValores.size()) {
            return new Errores("SEMANTICO", "Index fuera de los limites", this.line, this.column);
        }
        LinkedList<Object> subLista = listaValores.get(index);
        if (index2 < 0 || index2 >= subLista.size()) {
            return new Errores("SEMANTICO", "Index fuera de los limites", this.line, this.column);
        }
        this.type.setTipo(vector.getType().getTipo());
        return subLista.get(index2);
    }
}
