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
public class Declaracion extends Instrucciones{
    private String Identificador;
    private Instrucciones valor;
    private boolean IsMutable;

    public Declaracion(String Identificador, Instrucciones valor,  Tipo type, boolean IsMutable, int line, int column) {
        super(type, line, column);
        this.Identificador = Identificador;
        this.valor = valor;
        this.IsMutable = IsMutable;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        Object ValInterpretado;
        if (this.valor != null) {
            ValInterpretado = this.valor.interpretar(tree, table);
            if (ValInterpretado instanceof Errores) {
                return ValInterpretado;
            }

            if (this.valor.type.getTipo() != this.type.getTipo()) {
                return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
            }
        } else {
            ValInterpretado = getDefaultValue(this.type.getTipo());
        }

        if (table.setVariable(new Simbolo(this.type, this.Identificador, ValInterpretado, this.IsMutable))) {
            return null;
        }
        return new Errores("SEMANTICO", "La variable ya existe", this.line, this.column);
    }

    private Object getDefaultValue(TipoDato tipo) {
        switch (tipo) {
            case ENTERO:
                return 0;
            case DECIMAL:
                return 0.0;
            case BOOLEANO:
                return false;
            case CADENA:
                return "";
            case CARACTER:
                return '\u0000';
            default:
                return null;
        }
    }
}
