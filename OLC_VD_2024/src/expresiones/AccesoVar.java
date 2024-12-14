/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instrucciones;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author jpsam
 */
public class AccesoVar extends Instrucciones{
    private String id;

    public AccesoVar(String id, int line, int column) {
        super(new Tipo(TipoDato.VOID), line, column);
        this.id = id;
    }

    @Override
    public Object interpretar(Arbol tree, TablaSimbolos table) {
        var valor = table.getVariable(id);
        if(valor == null){
            return new Errores("SEMANTICO", "La variable no existe", this.line, this.column);
        }
        
        this.type.setTipo(valor.getType().getTipo());
        return valor.getValue();
    }
    
}
