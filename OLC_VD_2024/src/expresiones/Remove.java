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
public class Remove extends Instrucciones{
    private String Identificador;
    private Instrucciones Index;

    public Remove(String Identificador, Instrucciones Index, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.Identificador = Identificador;
        this.Index = Index;
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
        
        Object ValIndex = Index.interpretar(tree, table);
        if(ValIndex instanceof Errores){
            return ValIndex;
        }
        
        if(!(ValIndex instanceof Integer)){
            return new Errores("SEMANTICO", "El Index tiene que ser de tipo entero", this.line, this.column);
        }
        
        int NumIndex = (int) ValIndex;
        if(NumIndex < 0 || NumIndex >= lista.size()){
            return new Errores("SEMANTICO", "El Index está fuera de rango", this.line, this.column);
        }
        
        this.type.setTipo(ListaSimbolo.getType().getTipo());
        return lista.remove(NumIndex);
    }
    
    
}
