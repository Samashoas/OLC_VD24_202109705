/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.TablaSimbolos;
import simbolo.Tipo;

/**
 *
 * @author jpsam
 */
public class DeclaracionVBD extends Instrucciones{
    private String Identificador;
    private LinkedList<LinkedList<Instrucciones>> Listas_DlistValores;
    private boolean IsMutable;

    //(ID, LISTA DE LISTAS, MUTABILIDAD, TIPO, LINEA, COLUMNA)
    public DeclaracionVBD(String Identificador, LinkedList<LinkedList<Instrucciones>> Listas_DlistValores, boolean IsMutable, Tipo type, int line, int column) {
        super(type, line, column);
        this.Identificador = Identificador;
        this.Listas_DlistValores = Listas_DlistValores;
        this.IsMutable = IsMutable;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        if (Listas_DlistValores == null) {
            return new Errores("SEMANTICO", "No se puede declarar el vector sin valores", this.line, this.column);
        }

        LinkedList<LinkedList<Object>> listasDlistInterpretado = new LinkedList<>();

        for (LinkedList<Instrucciones> listaValores : Listas_DlistValores) {
            if (listaValores == null) {
                return new Errores("SEMANTICO", "No se puede declarar el vector sin valores", this.line, this.column);
            }

            LinkedList<Object> valores = new LinkedList<>();

            for (Instrucciones valor : listaValores) {
                Object valorInterpretado = valor.interpretar(tree, table);

                if (valorInterpretado instanceof Errores) {
                    return valorInterpretado;
                }

                if (valor.type.getTipo() != this.type.getTipo()) {
                    return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
                }
                valores.add(valorInterpretado);
            }

            listasDlistInterpretado.add(valores);
        }

        Simbolo nuevoSimbolo = new Simbolo(this.type, this.Identificador, listasDlistInterpretado, this.IsMutable);
        table.setVariable(nuevoSimbolo);

        return null;
    }
}
