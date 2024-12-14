/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

/**
 *
 * @author jpsam
 */
public class Simbolo {
    private Tipo type;
    private String id;
    private Object value;
    private boolean Mutabilidad;

    public Simbolo(Tipo type, String id) {
        this.type = type;
        this.id = id;
    }

    public Simbolo(Tipo type, String id, Object value, boolean mutable) {
        this.type = type;
        this.id = id;
        this.value = value;
        this.Mutabilidad = mutable;
    }

    public Tipo getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public void setType(Tipo type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    public Boolean isMutable(){
        return Mutabilidad;
    }
    
    
}
