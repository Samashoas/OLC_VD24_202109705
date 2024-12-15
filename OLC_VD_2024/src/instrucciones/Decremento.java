/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Decremento extends Instrucciones{
    private String id;

    public Decremento(String id, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var variable = table.getVariable(id);

        if (variable == null) {
            return new Errores("SEMANTICO", "Variable no existente", this.line, this.column);
        }

        //var tipo1 = variable.getType().getTipo();
        var tipo1 = variable.getType().getTipo();

        switch (tipo1) {
            case ENTERO -> {
                this.type.setTipo(TipoDato.ENTERO);
                int valorActual = (int) variable.getValue();
                variable.setValue(valorActual - 1);
                return null;
            }
            case DECIMAL -> {
                this.type.setTipo(TipoDato.DECIMAL);
                double valorActual = (double) variable.getValue();
                variable.setValue(valorActual - 1);
                return null;
            }
            default -> {
                return new Errores("SEMANTICO", "Solo se puede incrementar enteros y decimales", this.line, this.column);
            }
        }
    }
    
}
