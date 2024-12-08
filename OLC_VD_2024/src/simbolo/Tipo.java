/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

/**
 *
 * @author jpsam
 */
public class Tipo {
    private TipoDato type;

    public Tipo(TipoDato type) {
        this.type = type;
    }

    public TipoDato getTipo() {
        return type;
    }

    public void setTipo(TipoDato tipo) {
        this.type = tipo;
    }
}
