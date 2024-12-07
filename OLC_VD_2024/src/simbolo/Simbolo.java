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

    public Simbolo(Tipo type, String id) {
        this.type = type;
        this.id = id;
    }

    public Simbolo(Tipo type, String id, Object value) {
        this.type = type;
        this.id = id;
        this.value = value;
    }
}
