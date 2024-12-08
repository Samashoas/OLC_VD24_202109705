
import abstracto.Instrucciones;
import analizador.parser;
import analizador.scanner;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.TablaSimbolos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jpsam
 */
public class OLC_VD_2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            String texto = "console.log(\"Mi cadena\");console.log(2+3+4);console.log(3.33);";
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
            
            var ast = new Arbol((LinkedList<Instrucciones>) resultado.value);
            var tabla = new TablaSimbolos();
            
            for(var a:ast.getInstructions()){
                var res = a.interpretar(ast, tabla);
            }
            System.out.println(ast.getConsole());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
