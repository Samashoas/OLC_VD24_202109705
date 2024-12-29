/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Append extends Instrucciones{
    private String Identificador;
    private Instrucciones valor;
    
    //APPEND(ID, VALOR, LINEA, COLUMNA)
    public Append(String Identificador, Instrucciones valor, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.Identificador = Identificador;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var ListaSimbolo = table.getVariable(Identificador);
        if(ListaSimbolo == null){
            return new Errores("SEMANTICO", "La lista no existe", this.line, this.column);
        }
        
        if(!(ListaSimbolo.getValue() instanceof LinkedList)){
            return new Errores("SEMANTICO", "El ID no corresponde a una lista", this.line, this.column);
        }
        
        LinkedList<Object> lista = (LinkedList<Object>) ListaSimbolo.getValue();
        
        Object ValorInterpretado = valor.interpretar(tree, table);
        if(valor.type.getTipo() == ListaSimbolo.getType().getTipo()){
            lista.add(ValorInterpretado);
            ListaSimbolo.setValue(lista);
        }else{
            return new Errores("SEMANTICO", "El tipo de dato no coincide", this.line, this.column);
        }
        
        return null;
        
    }
}
