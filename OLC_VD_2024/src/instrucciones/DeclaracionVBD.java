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
        if(this.Listas_DlistValores == null){
            return new Errores("SEMANTICO", "No se puede declarar el vector sin valores", this.line, this.column);
        }
        
        LinkedList<LinkedList<Object>> Listas_DlistInterpretado = new LinkedList<>();
        
        for(LinkedList<Instrucciones> lista_valores : this.Listas_DlistValores){
            if(lista_valores == null){
                return new Errores("SEMANTICO", "No se puede declarar el vector sin valores", this.line, this.column);
            }
            
            LinkedList<Object> valores = new LinkedList<>();
            
            for(Instrucciones valor : lista_valores){
                var ValorInterpretado = valor.interpretar(tree, table);
                
                if(ValorInterpretado instanceof Errores){
                    return ValorInterpretado;
                }
                
                if(valor.type.getTipo() != this.type.getTipo()){
                    return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
                }
                valores.add(ValorInterpretado);
            }
            
            Listas_DlistInterpretado.add(valores);
        }
        
        Simbolo nuevoSimbolo = new Simbolo(this.type, this.Identificador, Listas_DlistInterpretado, this.IsMutable);
        table.setVariable(nuevoSimbolo);
        
        return null;
    }
}
