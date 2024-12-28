/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.HashMap;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class Llamada extends Instrucciones{
    
    private String id;
    private LinkedList<HashMap> parametros;

    public Llamada(String id, LinkedList<HashMap> parametros, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.parametros = parametros;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var busqueda = tree.getFuncion(id);
        if(busqueda == null){
            return new Errores("SEMANTICO", "No existe ninguna función con el nombre indicado", this.line, this.column);
        }
        
        if(busqueda instanceof Metodo metodo){
            var newTabla = new TablaSimbolos(tree.getTablaGlobal());
            newTabla.setNombre("Llamada " + id);
            
            // >>>Recorrer los parametros de la llamada
            //Se declaran los parametros como si fueran una variable
            for(var i = 0; i < metodo.parametros.size(); i++){
                var identificador = (String) metodo.parametros.get(i).get("id");
                var tipo = (Tipo) metodo.parametros.get(i).get("tipo");
                var expresion = (Instrucciones) metodo.parametros.get(i).get("expresion");
                
                Object valExp = null;
                
                //Se valida la expresion
                if(expresion != null){
                    valExp = expresion.interpretar(tree, newTabla);
                    if(valExp instanceof Errores){
                        return valExp;
                    }
                    if(tipo.getTipo()!=expresion.type.getTipo()){
                        return new Errores("SEMANTICO", "Los tipos no coinciden", this.line, this.column);
                    }
                }
                //Verificar si el parametro está declarado
                if(!newTabla.setVariable(new Simbolo(tipo, identificador, valExp, false))){
                    return new Errores("SEMANTICO", "Hay errores en los parametros", this.line, this.column);
                }
            }
            
            //Se reasigna el valor
            for(int i = 0; i< this.parametros.size(); i++){
                var variable = newTabla.getVariable((String)this.parametros.get(i).get("id"));
                if(variable == null){
                    return new Errores("SEMANTICO", "El parametro no existe", this.line, this.column);
                }
                
                var Valor = (Instrucciones)this.parametros.get(i).get("expresion");
                var resValor = Valor.interpretar(tree, table); /*Cambio para llamada*/
                if(resValor instanceof Errores){
                    return resValor;
                }
                
                if(Valor.type.getTipo() != variable.getType().getTipo()){
                    return new Errores("SEMANTICO", "El tipo que tiene el parametro y el valor no coninciden", this.line, this.column);
                    
                }
                
                variable.setValue(resValor);
            }
            
            //Validar que no se tengan parametros nulos
            for(int i = 0; i< metodo.parametros.size(); i++){
                var identificador = (String) metodo.parametros.get(i).get("id");
                var resultado = newTabla.getVariable(identificador);
                if(resultado == null){
                    return new Errores("SEMANTICO","El parametro no está declarado", this.line, this.column);
                }
                
                if(resultado.getValue()==null){
                    return new Errores("SEMANTICO","El parametro no tiene valor", this.line, this.column);
                }
            }
            
            var resultadoMetodo = metodo.interpretar(tree, newTabla);
            if(resultadoMetodo instanceof Errores){
                return resultadoMetodo;
            }
            if(resultadoMetodo instanceof ValorReturn){
                this.type = metodo.type;
                ValorReturn ValorRes = (ValorReturn) resultadoMetodo;
                return ValorRes.getValor();
            }
        }
        return null;
    }
}
/*El return es como una llamada pero este llama a la función misma función en la que se encuentra,
además de que el return tiene que validar que el tipo de dato que está retornando sea igual al de
la función en la que se encuentra*/