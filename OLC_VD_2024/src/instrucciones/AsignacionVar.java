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
public class AsignacionVar extends Instrucciones{
    private String id;
    private Instrucciones exp;

    public AsignacionVar(String id, Instrucciones exp, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
        this.exp = exp;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var variable = table.getVariable(id);
        if(variable == null){
            return new Errores("SEMANTICO", "La variable no existe", this.line, this.column);
        }
        
        //Es mutable o no, si la variable ya fue declarada como const
        
        if(!variable.isMutable()){
            return new Errores("SEMANTICO", "La variable no es mutable", this.line, this.column);
        }

        var newValor = this.exp.interpretar(tree, table);
        if(newValor instanceof Errores){
            return newValor;
        }
        
        if(variable.getType().getTipo()!= this.exp.type.getTipo()){
            return new Errores("SEMANTICO", "Los tipos no son compatibles", this.line, this.column);
        }
        
        this.type.setTipo(variable.getType().getTipo());
        variable.setValue(newValor);
        return null;
    }
}
