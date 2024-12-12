/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author jpsam
 */
public class Errores {
    private String type;
    private String desc;
    private int line;
    private int column;

    public Errores(String type, String desc, int line, int column) {
        this.type = type;
        this.desc = desc;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Errores{" + "type=" + type + ", desc=" + desc + ", line=" + line + ", column=" + column + '}';
    }
    
    public Object[] getError(){
        return new Object[]{0,this.type, this.desc, this.line, this.column};
    }
}
