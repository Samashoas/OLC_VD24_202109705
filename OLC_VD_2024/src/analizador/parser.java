
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizador;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import abstracto.Instrucciones;
import simbolo.*;
import instrucciones.Print;
import expresiones.Nativo;
import expresiones.Aritmeticas;
import expresiones.Relacionales;
import expresiones.OperadoresAritmeticos;
import expresiones.OperadoresRelacionales;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\005\007" +
    "\000\002\006\004\000\002\006\005\000\002\006\005\000" +
    "\002\006\005\000\002\006\005\000\002\006\005\000\002" +
    "\006\005\000\002\006\005\000\002\006\005\000\002\006" +
    "\005\000\002\006\005\000\002\006\005\000\002\006\003" +
    "\000\002\006\003\000\002\006\003\000\002\006\003\000" +
    "\002\006\003\000\002\006\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\004\012\006\001\002\000\006\002\000\012" +
    "\006\001\002\000\006\002\ufffe\012\ufffe\001\002\000\004" +
    "\013\012\001\002\000\004\002\011\001\002\000\006\002" +
    "\ufffd\012\ufffd\001\002\000\004\002\001\001\002\000\020" +
    "\004\014\005\017\006\021\007\015\010\016\013\020\016" +
    "\013\001\002\000\020\004\014\005\017\006\021\007\015" +
    "\010\016\013\020\016\013\001\002\000\032\014\uffed\015" +
    "\uffed\016\uffed\020\uffed\021\uffed\022\uffed\023\uffed\024\uffed" +
    "\025\uffed\026\uffed\027\uffed\030\uffed\001\002\000\032\014" +
    "\uffee\015\uffee\016\uffee\020\uffee\021\uffee\022\uffee\023\uffee" +
    "\024\uffee\025\uffee\026\uffee\027\uffee\030\uffee\001\002\000" +
    "\032\014\uffeb\015\uffeb\016\uffeb\020\uffeb\021\uffeb\022\uffeb" +
    "\023\uffeb\024\uffeb\025\uffeb\026\uffeb\027\uffeb\030\uffeb\001" +
    "\002\000\032\014\uffec\015\uffec\016\uffec\020\uffec\021\uffec" +
    "\022\uffec\023\uffec\024\uffec\025\uffec\026\uffec\027\uffec\030" +
    "\uffec\001\002\000\020\004\014\005\017\006\021\007\015" +
    "\010\016\013\020\016\013\001\002\000\032\014\uffef\015" +
    "\uffef\016\uffef\020\uffef\021\uffef\022\uffef\023\uffef\024\uffef" +
    "\025\uffef\026\uffef\027\uffef\030\uffef\001\002\000\032\014" +
    "\032\015\030\016\023\020\025\021\035\022\024\023\026" +
    "\024\034\025\036\026\027\027\033\030\031\001\002\000" +
    "\020\004\014\005\017\006\021\007\015\010\016\013\020" +
    "\016\013\001\002\000\020\004\014\005\017\006\021\007" +
    "\015\010\016\013\020\016\013\001\002\000\020\004\014" +
    "\005\017\006\021\007\015\010\016\013\020\016\013\001" +
    "\002\000\020\004\014\005\017\006\021\007\015\010\016" +
    "\013\020\016\013\001\002\000\020\004\014\005\017\006" +
    "\021\007\015\010\016\013\020\016\013\001\002\000\020" +
    "\004\014\005\017\006\021\007\015\010\016\013\020\016" +
    "\013\001\002\000\020\004\014\005\017\006\021\007\015" +
    "\010\016\013\020\016\013\001\002\000\004\011\043\001" +
    "\002\000\020\004\014\005\017\006\021\007\015\010\016" +
    "\013\020\016\013\001\002\000\020\004\014\005\017\006" +
    "\021\007\015\010\016\013\020\016\013\001\002\000\020" +
    "\004\014\005\017\006\021\007\015\010\016\013\020\016" +
    "\013\001\002\000\020\004\014\005\017\006\021\007\015" +
    "\010\016\013\020\016\013\001\002\000\032\014\ufff3\015" +
    "\030\016\023\020\025\021\035\022\024\023\026\024\034" +
    "\025\ufff3\026\ufff3\027\ufff3\030\ufff3\001\002\000\032\014" +
    "\ufff7\015\ufff7\016\ufff7\020\ufff7\021\ufff7\022\024\023\026" +
    "\024\ufff7\025\ufff7\026\ufff7\027\ufff7\030\ufff7\001\002\000" +
    "\032\014\ufff4\015\ufff4\016\ufff4\020\ufff4\021\ufff4\022\024" +
    "\023\026\024\ufff4\025\ufff4\026\ufff4\027\ufff4\030\ufff4\001" +
    "\002\000\032\014\ufff1\015\030\016\023\020\025\021\035" +
    "\022\024\023\026\024\034\025\ufff1\026\ufff1\027\ufff1\030" +
    "\ufff1\001\002\000\006\002\ufffc\012\ufffc\001\002\000\032" +
    "\014\ufff0\015\030\016\023\020\025\021\035\022\024\023" +
    "\026\024\034\025\ufff0\026\ufff0\027\ufff0\030\ufff0\001\002" +
    "\000\032\014\ufffa\015\ufffa\016\ufffa\020\025\021\035\022" +
    "\024\023\026\024\034\025\ufffa\026\ufffa\027\ufffa\030\ufffa" +
    "\001\002\000\032\014\ufff2\015\030\016\023\020\025\021" +
    "\035\022\024\023\026\024\034\025\ufff2\026\ufff2\027\ufff2" +
    "\030\ufff2\001\002\000\026\014\ufff5\015\ufff5\016\ufff5\020" +
    "\ufff5\021\ufff5\024\ufff5\025\ufff5\026\ufff5\027\ufff5\030\ufff5" +
    "\001\002\000\032\014\ufff8\015\ufff8\016\ufff8\020\ufff8\021" +
    "\ufff8\022\024\023\026\024\ufff8\025\ufff8\026\ufff8\027\ufff8" +
    "\030\ufff8\001\002\000\026\014\ufff6\015\ufff6\016\ufff6\020" +
    "\ufff6\021\ufff6\024\ufff6\025\ufff6\026\ufff6\027\ufff6\030\ufff6" +
    "\001\002\000\032\014\ufff9\015\ufff9\016\ufff9\020\025\021" +
    "\035\022\024\023\026\024\034\025\ufff9\026\ufff9\027\ufff9" +
    "\030\ufff9\001\002\000\032\014\054\015\030\016\023\020" +
    "\025\021\035\022\024\023\026\024\034\025\036\026\027" +
    "\027\033\030\031\001\002\000\032\014\uffea\015\uffea\016" +
    "\uffea\020\uffea\021\uffea\022\uffea\023\uffea\024\uffea\025\uffea" +
    "\026\uffea\027\uffea\030\uffea\001\002\000\032\014\ufffb\015" +
    "\ufffb\016\ufffb\020\ufffb\021\ufffb\022\ufffb\023\ufffb\024\ufffb" +
    "\025\ufffb\026\ufffb\027\ufffb\030\ufffb\001\002\000\006\002" +
    "\uffff\012\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\012\002\006\003\003\004\004\005\007\001" +
    "\001\000\006\004\055\005\007\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\021\001\001\000\004\006\054" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\006\052\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\051\001\001\000" +
    "\004\006\050\001\001\000\004\006\047\001\001\000\004" +
    "\006\046\001\001\000\004\006\045\001\001\000\004\006" +
    "\044\001\001\000\004\006\043\001\001\000\002\001\001" +
    "\000\004\006\041\001\001\000\004\006\040\001\001\000" +
    "\004\006\037\001\001\000\004\006\036\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    scanner s;
    parser(scanner s){this.s = s;}

    public void syntax_error(Symbol s){}

    public void unrecovered_syntax_error (Symbol s){}



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {



  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instrucciones> start_val = (LinkedList<Instrucciones>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= instrucciones 
            {
              LinkedList<Instrucciones> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		LinkedList<Instrucciones> a = (LinkedList<Instrucciones>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // instrucciones ::= instrucciones instruccion 
            {
              LinkedList<Instrucciones> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instrucciones> a = (LinkedList<Instrucciones>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = a; RESULT.add(b); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instrucciones",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // instrucciones ::= instruccion 
            {
              LinkedList<Instrucciones> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new LinkedList<Instrucciones>(); RESULT.add(a); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instrucciones",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // instruccion ::= impresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // impresion ::= IMPRIMIR PAR1 expresion PAR2 FINCADENA 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		 RESULT = new Print(a, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("impresion",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expresion ::= MENOS expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, OperadoresAritmeticos.NEGATIVO, aleft, aright);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expresion ::= expresion MAS expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.SUMA, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expresion ::= expresion MENOS expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.RESTA, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expresion ::= expresion POR expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.MULTIPLICACION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // expresion ::= expresion DIVISION expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.DIVISION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expresion ::= expresion POTENCIA expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.POTENCIA, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expresion ::= expresion RAIZ expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.RAIZ, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expresion ::= expresion MODULO expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.MODULO, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // expresion ::= expresion IGUALACION expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.IGUALACION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expresion ::= expresion DIFERENCIA expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.DIFERENCIA, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expresion ::= expresion MAYOR expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.MAYORQUE, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expresion ::= expresion MAYORIGUAL expresion 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instrucciones b = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.MAYORIGUAL, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expresion ::= ENTERO 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(Integer.parseInt(a), new Tipo(TipoDato.ENTERO), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expresion ::= DECIMAL 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(new Double(a), new Tipo(TipoDato.DECIMAL), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expresion ::= CARACTER 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(a, new Tipo(TipoDato.CARACTER), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expresion ::= CADENA 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(a ,new Tipo(TipoDato.CADENA), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expresion ::= BOOLEANO 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(Boolean.parseBoolean(a), new Tipo(TipoDato.BOOLEANO), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expresion ::= PAR1 expresion PAR2 
            {
              Instrucciones RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instrucciones a = (Instrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
