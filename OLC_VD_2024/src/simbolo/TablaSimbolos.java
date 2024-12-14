/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jpsam
 */
public class TablaSimbolos {
    private HashMap<String, Simbolo> tablaActual;
    private String nombre;
    
    public TablaSimbolos(){
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public HashMap<String, Simbolo> getTablaActual() {
        return tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTablaActual(HashMap<String, Simbolo> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean setVariable(Simbolo simbolo){
        Simbolo busqueda = (Simbolo)this.tablaActual.get(simbolo.getId().toLowerCase());
        if(busqueda==null){
            this.tablaActual.put(simbolo.getId().toLowerCase(), simbolo);
            return true;
        }
        return false;
    }
    
    public Simbolo getVariable(String id){
        Simbolo busqueda = (Simbolo)this.tablaActual.get(id.toLowerCase());
        if(busqueda!=null){
            return busqueda;
        }
        return null;
    }
    
}
