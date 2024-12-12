/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokens;

/**
 *
 * @author jpsam
 */
public class Tokens {
    private String lexema;
    private String type;
    private int line;
    private int column;

    public Tokens(String lexema, String type, int line, int column) {
        this.lexema = lexema;
        this.type = type;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Tokens{" + "type=" + lexema + ", desc=" + type + ", line=" + line + ", column=" + column + '}';
    }
    
    public Object[] getToken(){
        return new Object[]{0,this.lexema, this.type, this.line, this.column};
    }
}
