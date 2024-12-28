/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.HashMap;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.TablaSimbolos;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Metodo extends Instrucciones{
    public String id;
    public LinkedList<HashMap> parametros;
    public LinkedList<Instrucciones> instrucciones;

    public Metodo(String id, LinkedList<HashMap> parametros, LinkedList<Instrucciones> instrucciones, Tipo type, int line, int column) {
        super(type, line, column);
        this.id = id;
        this.instrucciones = instrucciones;
        this.parametros = parametros;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        
        for(var i: this.instrucciones){
            if(i == null){
            continue;
            }
            var resultado = i.interpretar(tree, table);
            
            if(resultado instanceof ValorReturn){
                ValorReturn ValorRes = (ValorReturn) resultado;
                
                if(!(this.type.getTipo()== TipoDato.VOID)){
                    if(ValorRes.getTipo() != this.type.getTipo()){
                        return new Errores("SEMANTICO", "Tipos no coinciden", this.line, this.column);
                    }
                    return resultado;
                }
                if(ValorRes.getValor() == null){
                    continue;
                }
                return resultado;
            }
            //Agrega la recuperación de Errores
        }
        
        if(this.type.getTipo() != TipoDato.VOID){
            return new Errores("SEMANTICO", "Se debe retornar un valor", this.line, this.column);
        }
        return null;
    }
}
