
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
import expresiones.OperadoresAritmeticos;
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
    "\000\024\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\005\007" +
    "\000\002\006\004\000\002\006\005\000\002\006\005\000" +
    "\002\006\005\000\002\006\005\000\002\006\005\000\002" +
    "\006\005\000\002\006\005\000\002\006\003\000\002\006" +
    "\003\000\002\006\003\000\002\006\003\000\002\006\003" +
    "\000\002\006\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\044\000\004\012\006\001\002\000\006\002\000\012" +
    "\006\001\002\000\006\002\ufffe\012\ufffe\001\002\000\004" +
    "\013\012\001\002\000\004\002\011\001\002\000\006\002" +
    "\ufffd\012\ufffd\001\002\000\004\002\001\001\002\000\020" +
    "\004\014\005\022\006\021\007\015\010\016\013\017\016" +
    "\013\001\002\000\020\004\014\005\022\006\021\007\015" +
    "\010\016\013\017\016\013\001\002\000\022\014\ufff1\015" +
    "\ufff1\016\ufff1\020\ufff1\021\ufff1\022\ufff1\023\ufff1\024\ufff1" +
    "\001\002\000\022\014\ufff2\015\ufff2\016\ufff2\020\ufff2\021" +
    "\ufff2\022\ufff2\023\ufff2\024\ufff2\001\002\000\022\014\uffef" +
    "\015\uffef\016\uffef\020\uffef\021\uffef\022\uffef\023\uffef\024" +
    "\uffef\001\002\000\020\004\014\005\022\006\021\007\015" +
    "\010\016\013\017\016\013\001\002\000\022\014\032\015" +
    "\024\016\027\020\031\021\030\022\025\023\023\024\026" +
    "\001\002\000\022\014\ufff3\015\ufff3\016\ufff3\020\ufff3\021" +
    "\ufff3\022\ufff3\023\ufff3\024\ufff3\001\002\000\022\014\ufff0" +
    "\015\ufff0\016\ufff0\020\ufff0\021\ufff0\022\ufff0\023\ufff0\024" +
    "\ufff0\001\002\000\020\004\014\005\022\006\021\007\015" +
    "\010\016\013\017\016\013\001\002\000\020\004\014\005" +
    "\022\006\021\007\015\010\016\013\017\016\013\001\002" +
    "\000\020\004\014\005\022\006\021\007\015\010\016\013" +
    "\017\016\013\001\002\000\020\004\014\005\022\006\021" +
    "\007\015\010\016\013\017\016\013\001\002\000\020\004" +
    "\014\005\022\006\021\007\015\010\016\013\017\016\013" +
    "\001\002\000\020\004\014\005\022\006\021\007\015\010" +
    "\016\013\017\016\013\001\002\000\020\004\014\005\022" +
    "\006\021\007\015\010\016\013\017\016\013\001\002\000" +
    "\004\011\033\001\002\000\006\002\ufffc\012\ufffc\001\002" +
    "\000\022\014\ufff8\015\ufff8\016\ufff8\020\ufff8\021\ufff8\022" +
    "\025\023\023\024\026\001\002\000\022\014\ufff7\015\ufff7" +
    "\016\ufff7\020\ufff7\021\ufff7\022\025\023\023\024\026\001" +
    "\002\000\022\014\ufff9\015\ufff9\016\ufff9\020\031\021\030" +
    "\022\025\023\023\024\026\001\002\000\014\014\ufff4\015" +
    "\ufff4\016\ufff4\020\ufff4\021\ufff4\001\002\000\014\014\ufff6" +
    "\015\ufff6\016\ufff6\020\ufff6\021\ufff6\001\002\000\022\014" +
    "\ufffa\015\ufffa\016\ufffa\020\031\021\030\022\025\023\023" +
    "\024\026\001\002\000\014\014\ufff5\015\ufff5\016\ufff5\020" +
    "\ufff5\021\ufff5\001\002\000\022\014\044\015\024\016\027" +
    "\020\031\021\030\022\025\023\023\024\026\001\002\000" +
    "\022\014\uffee\015\uffee\016\uffee\020\uffee\021\uffee\022\uffee" +
    "\023\uffee\024\uffee\001\002\000\022\014\ufffb\015\ufffb\016" +
    "\ufffb\020\ufffb\021\ufffb\022\ufffb\023\ufffb\024\ufffb\001\002" +
    "\000\006\002\uffff\012\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\044\000\012\002\006\003\003\004\004\005\007\001" +
    "\001\000\006\004\045\005\007\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\017\001\001\000\004\006\044" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\042\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\041\001\001\000" +
    "\004\006\040\001\001\000\004\006\037\001\001\000\004" +
    "\006\036\001\001\000\004\006\035\001\001\000\004\006" +
    "\034\001\001\000\004\006\033\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

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
          case 14: // expresion ::= ENTERO 
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
          case 15: // expresion ::= DECIMAL 
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
          case 16: // expresion ::= CARACTER 
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
          case 17: // expresion ::= CADENA 
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
          case 18: // expresion ::= BOOLEANO 
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
          case 19: // expresion ::= PAR1 expresion PAR2 
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
