/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class DeclaracionVUD extends Instrucciones{
    private String Identificador;
    private LinkedList<Instrucciones> ListaValores;
    private boolean IsMutable;
    
    //(ID, LISTA INSTRUCCIONES, MUTABILIDAD, TIPO, LINE, COLUMNA)
    public DeclaracionVUD(String Identificador, LinkedList<Instrucciones> ListaValores, boolean IsMutable, Tipo type, int line, int column) {
        super(type, line, column);
        this.Identificador = Identificador;
        this.ListaValores = ListaValores;
        this.IsMutable = IsMutable;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        if(this.ListaValores == null){
            return new Errores("SEMANTICO","Se necesita un valor para declarar el vector", this.line, this.column);
        }
        
        LinkedList<Object> valores = new LinkedList<>();
        
        for(Instrucciones valor : this.ListaValores){
            var ValorInterpretado = valor.interpretar(tree, table);
            
            if(ValorInterpretado instanceof Errores){
                return ValorInterpretado;
            }
            
            if(valor.type.getTipo() != this.type.getTipo()){
                return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
            }
            
            valores.add(ValorInterpretado);
        }
        
        Simbolo nuevoSimbolo = new Simbolo(this.type, this.Identificador, valores, this.IsMutable);
        table.setVariable(nuevoSimbolo);
        
        return null;
    }
}
