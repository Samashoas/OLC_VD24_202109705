package analizador;

// importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import excepciones.Errores;
import tokens.Tokens;

%%

// codigo de usuario
%{
    public LinkedList<Errores> erroresLexicos = new LinkedList<>();
    public LinkedList<Tokens> MisTokens = new LinkedList<>();
%}

// inicializacion
%init{
    yyline = 1;
    yycolumn = 1;
    erroresLexicos = new LinkedList<>();
    MisTokens = new LinkedList<>();
%init}

// declaracion de caracteristicas de jflex
%cup
%class scanner //nombre de la clase
%public //tipo de clase
%line //conteo de lineas
%char //conteo de caracteres
%column //conteo de columnas
%full // reconocimiento de caracteres
%ignorecase //ignorar mayusculas y minusculas

// Creacion de estados, si fuese necesario
%state CADENA

// definir simbolos del sistema

// ------>PALABRAS RESERVADAS<------
//Imprensión en consola
IMPRIMIR = "console.log"

// ------>OPERACIONES<------
//Operadores aritmeticos
MAS = "+"
MENOS = "-"
POR = "*"
DIVISION = "/"
POTENCIA = "^"
RAIZ = "$"
MODULO = "%"
//Operadores Relacionales
IGUALACION = "=="
DIFERENCIA = "!="
MAYOR = ">"
MAYORIGUAL = ">="
MENOR = "<"
MENORIGUAL = "<="
//Operadores Logicos
AND = "&&"
OR = "||"
NOT = "!"

// ------>SIMBOLOS<------
PAR1 = "("
PAR2 = ")"
FINCADENA = ";"

// ------>Expresiones regulares<------
BOOLEANO = "true"|"false"
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CARACTER = \'([^\']|[\t]|[\n]|[\r]|[ ])\' 
CADENA = \"([^\"]|[\t]|[\n]|[\r]|[ ])*\" 

WHITESPACE = [ \t\r\f\n]+

// retorno de expresiones regulares
%%
<YYINITIAL> {WHITESPACE}     {}
<YYINITIAL> {IMPRIMIR}       {MisTokens.add(new Tokens("IMPRIMIR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());
                             }

<YYINITIAL> {BOOLEANO}       {MisTokens.add(new Tokens("BOOLEANO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {DECIMAL}        {MisTokens.add(new Tokens("DECIMAL",yytext(), yyline, yycolumn));
                                return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {ENTERO}         {MisTokens.add(new Tokens("ENTERO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());
                             }

<YYINITIAL> {CARACTER}       {String caracter = yytext(); 
                             caracter=caracter.substring(1, caracter.length() - 1);
                             MisTokens.add(new Tokens("CARACTER",caracter, yyline, yycolumn));
                             return new Symbol(sym.CARACTER, yyline, yycolumn, caracter);
                             }   
<YYINITIAL> {CADENA}         {String cadena = yytext(); 
                             cadena=cadena.substring(1, cadena.length() - 1);
                             MisTokens.add(new Tokens("CADENA",cadena, yyline, yycolumn));
                             return new Symbol(sym.CADENA, yyline, yycolumn, cadena);
                             }

<YYINITIAL> {PAR1}           {MisTokens.add(new Tokens("PAR1",yytext(), yyline, yycolumn));
                              return new Symbol(sym.PAR1, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {PAR2}           {MisTokens.add(new Tokens("PAR2",yytext(), yyline, yycolumn));
                              return new Symbol(sym.PAR2, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {FINCADENA}      {MisTokens.add(new Tokens("FINCADENA",yytext(), yyline, yycolumn));
                              return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());
                             }

<YYINITIAL> {MAS}            {MisTokens.add(new Tokens("MAS",yytext(), yyline, yycolumn));
                                return new Symbol(sym.MAS, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {MENOS}          {MisTokens.add(new Tokens("MENOS",yytext(), yyline, yycolumn));
                               return new Symbol(sym.MENOS, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {POR}            {MisTokens.add(new Tokens("POR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.POR, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {DIVISION}       {MisTokens.add(new Tokens("DIVISION",yytext(), yyline, yycolumn));
                                return new Symbol(sym.DIVISION, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {POTENCIA}       {MisTokens.add(new Tokens("POTENCIA",yytext(), yyline, yycolumn));
                                return new Symbol(sym.POTENCIA, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {RAIZ}           {MisTokens.add(new Tokens("RAIZ",yytext(), yyline, yycolumn));
                                return new Symbol(sym.RAIZ, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {MODULO}         {MisTokens.add(new Tokens("MODULO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.MODULO, yyline, yycolumn, yytext());
                             }

<YYINITIAL> {IGUALACION}     {MisTokens.add(new Tokens("IGUALACION",yytext(), yyline, yycolumn));
                                return new Symbol(sym.IGUALACION, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {DIFERENCIA}     {MisTokens.add(new Tokens("DIFERENCIA",yytext(), yyline, yycolumn));
                                return new Symbol(sym.DIFERENCIA, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {MAYORIGUAL}     {MisTokens.add(new Tokens("MAYORIGUAL",yytext(), yyline, yycolumn));
                                return new Symbol(sym.MAYORIGUAL, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {MENORIGUAL}     {MisTokens.add(new Tokens("MENORIGUAL",yytext(), yyline, yycolumn));
                                return new Symbol(sym.MENORIGUAL, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {MAYOR}          {MisTokens.add(new Tokens("MAYOR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {MENOR}          {MisTokens.add(new Tokens("MENOR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.MENOR, yyline, yycolumn, yytext());
                             }

<YYINITIAL> {AND}            {MisTokens.add(new Tokens("AND",yytext(), yyline, yycolumn));
                                return new Symbol(sym.AND, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {OR}             {MisTokens.add(new Tokens("OR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.OR, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {NOT}            {MisTokens.add(new Tokens("NOT",yytext(), yyline, yycolumn));
                                return new Symbol(sym.NOT, yyline, yycolumn, yytext());
                                }

<YYINITIAL>. {erroresLexicos.add(new Errores("LEXICO", "El caracter "+ yytext() + " no pertenece al lenguaje", yyline, yycolumn));}