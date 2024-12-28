/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

import abstracto.Instrucciones;
import excepciones.Errores;
import instrucciones.Metodo;
import java.util.LinkedList;

/**
 *
 * @author jpsam
 */
public class Arbol {
    private LinkedList<Instrucciones> instrucciones;
    private String console;
    private LinkedList<Errores> errors;
    private TablaSimbolos TablaGlobal;
    private LinkedList<Instrucciones> funciones;
    //tabla de simbolos (global)

    public Arbol(LinkedList<Instrucciones> instrucciones) {
        this.instrucciones = instrucciones;
        console = "";
        this.errors = new LinkedList<>();
        this.funciones = new LinkedList<>();
    }

    public LinkedList<Instrucciones> getInstructions() {
        return instrucciones;
    }

    public String getConsole() {
        return console;
    }
    
    public LinkedList<Errores> getErrores(){
        return errors;
    }

    public TablaSimbolos getTablaGlobal() {
        return TablaGlobal;
    }

    public LinkedList<Instrucciones> getFunciones() {
        return funciones;
    }
    
    public Instrucciones getFuncion(String id){
        for(var i: this.funciones){
            if(i instanceof Metodo metodo){
                if(metodo.id.equalsIgnoreCase(id)){
                    return i;
                }
            }
        }
        return null;
    }

    public void setTablaGlobal(TablaSimbolos TablaGlobal) {
        this.TablaGlobal = TablaGlobal;
    }
    
    public void setInstructions(LinkedList<Instrucciones> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public void setFunciones(LinkedList<Instrucciones> funciones) {
        this.funciones = funciones;
    }
    
    public void Print(String value){
        this.console += value + "\n";
    }
    
    public void AddErrores(Errores e){
        this.errors.add(e);
    }
    
    public void addFunciones(Instrucciones funcion){
        this.funciones.add(funcion);
    }
    
}
