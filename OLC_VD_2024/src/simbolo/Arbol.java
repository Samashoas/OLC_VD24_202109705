/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

import abstracto.Instrucciones;
import excepciones.Errores;
import java.util.LinkedList;

/**
 *
 * @author jpsam
 */
public class Arbol {
    private LinkedList<Instrucciones> instructions;
    private String console;
    private LinkedList<Errores> errors;
    // tabla de simbolos (global)

    public Arbol(LinkedList<Instrucciones> instrucciones) {
        this.instructions = instrucciones;
        console = "";
        this.errors = new LinkedList<>();
    }

    public LinkedList<Instrucciones> getInstructions() {
        return instructions;
    }

    public String getConsole() {
        return console;
    }
    
    public void setInstructions(LinkedList<Instrucciones> instrucciones) {
        this.instructions = instrucciones;
    }
    
    public void Print(String value){
        this.console += value + "\n";
    }
    
    public void AddErrores(Errores e){
        this.errors.add(e);
    }
}
