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
//Generales
CAST = "cast"
AS = "as"
LET = "let"
CONST = "const"
LIST = "list"
APPEND = "append"
REVERSE = "reverse"
SET = "set"
GET = "get"
REMOVE = "remove"
POP = "pop"
ROUND = "round"
LENGTH = "length"
TOSTRING = "toString"
//Sentencias
IF = "if"
ELSE = "else"
FOR = "for"
WHILE = "while"
DO = "do"
MATCH = "match"
DEFAULT = "default"
RETURN = "return"
BREAK = "break"
CONTINUE = "continue"
//Imprensión en consola
IMPRIMIR = "console.log"
RUN = "run_main"
//Tipos de datos
INT = "int"
DOUBLE = "double"
CHAR = "char"
STRING = "string"
BOOL = "bool"
VOID = "void"

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
//Incrementos y Decrementos
INCREMENTO = "++"
DECREMENTO = "--"

// ------>SIMBOLOS<------
TO = "=>"
LKEY = "{"
RKEY = "}"
IGUAL = "="
PAR1 = "("
PAR2 = ")"
COMA = ","
LBRACKET = "["
RBRACKET = "]"
COLOM = ":"
FINCADENA = ";"
DOT = "."

// ------>Expresiones regulares<------
BOOLEANO = "true"|"false"
ID = [a-zA-Z][a-zA-Z0-9_]*
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CARACTER = \'([^\']|[\t]|[\n]|[\r]|[ ])\' 
CADENA = \"([^\"\\]|\\.)*\" //cambiar ER si muere todo \"([^\"]|[\t]|[\n]|[\r]|[ ])*\"

WHITESPACE = [ \t\r\f\n]+

// retorno de expresiones regulares
%%
<YYINITIAL> {WHITESPACE}     {}
<YYINITIAL> {RUN}            {MisTokens.add(new Tokens("RUN",yytext(), yyline, yycolumn));
                                return new Symbol(sym.RUN, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {IMPRIMIR}       {MisTokens.add(new Tokens("IMPRIMIR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {CAST}           {MisTokens.add(new Tokens("CAST",yytext(), yyline, yycolumn));
                                return new Symbol(sym.CAST, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {AS}             {MisTokens.add(new Tokens("AS",yytext(), yyline, yycolumn));
                                return new Symbol(sym.AS, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {LET}            {MisTokens.add(new Tokens("LET",yytext(), yyline, yycolumn));
                                return new Symbol(sym.LET, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {CONST}          {MisTokens.add(new Tokens("CONST",yytext(), yyline, yycolumn));
                                return new Symbol(sym.CONST, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {LIST}           {MisTokens.add(new Tokens("LIST",yytext(), yyline, yycolumn));
                                return new Symbol(sym.LIST, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {APPEND}         {MisTokens.add(new Tokens("APPEND",yytext(), yyline, yycolumn));
                                return new Symbol(sym.APPEND, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {REVERSE}        {MisTokens.add(new Tokens("REVERSE",yytext(), yyline, yycolumn));
                                return new Symbol(sym.REVERSE, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {GET}            {MisTokens.add(new Tokens("GET",yytext(), yyline, yycolumn));
                                return new Symbol(sym.GET, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {REMOVE}         {MisTokens.add(new Tokens("REMOVE",yytext(), yyline, yycolumn));
                                return new Symbol(sym.REMOVE, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {POP}            {MisTokens.add(new Tokens("POP",yytext(), yyline, yycolumn));
                                return new Symbol(sym.POP, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {SET}            {MisTokens.add(new Tokens("SET",yytext(), yyline, yycolumn));
                                return new Symbol(sym.SET, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {ROUND}          {MisTokens.add(new Tokens("ROUND",yytext(), yyline, yycolumn));
                                return new Symbol(sym.ROUND, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {LENGTH}         {MisTokens.add(new Tokens("LENGTH",yytext(), yyline, yycolumn));
                                return new Symbol(sym.LENGTH, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {TOSTRING}       {MisTokens.add(new Tokens("ToString",yytext(), yyline, yycolumn));
                                return new Symbol(sym.TOSTRING, yyline, yycolumn, yytext());
                             }
                             
<YYINITIAL> {IF}             {MisTokens.add(new Tokens("IF",yytext(), yyline, yycolumn));
                                return new Symbol(sym.IF, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {ELSE}           {MisTokens.add(new Tokens("ELSE",yytext(), yyline, yycolumn));
                                return new Symbol(sym.ELSE, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {FOR}            {MisTokens.add(new Tokens("FOR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.FOR, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {WHILE}          {MisTokens.add(new Tokens("WHILE",yytext(), yyline, yycolumn));
                                return new Symbol(sym.WHILE, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {DO}             {MisTokens.add(new Tokens("DO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.DO, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {MATCH}          {MisTokens.add(new Tokens("MATCH",yytext(), yyline, yycolumn));
                                return new Symbol(sym.MATCH, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {DEFAULT}        {MisTokens.add(new Tokens("DEFAULT",yytext(), yyline, yycolumn));
                                return new Symbol(sym.DEFAULT, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {RETURN}         {MisTokens.add(new Tokens("RETURN",yytext(), yyline, yycolumn));
                                return new Symbol(sym.RETURN, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {BREAK}          {MisTokens.add(new Tokens("BREAK",yytext(), yyline, yycolumn));
                                return new Symbol(sym.BREAK, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {CONTINUE}       {MisTokens.add(new Tokens("CONTINUE",yytext(), yyline, yycolumn));
                                return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());
                             }

<YYINITIAL> {INT}            {MisTokens.add(new Tokens("INT",yytext(), yyline, yycolumn));
                                return new Symbol(sym.INT, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {DOUBLE}         {MisTokens.add(new Tokens("DOUBLE",yytext(), yyline, yycolumn));
                                return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {CHAR}           {MisTokens.add(new Tokens("CHAR",yytext(), yyline, yycolumn));
                                return new Symbol(sym.CHAR, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {STRING}         {MisTokens.add(new Tokens("STRING",yytext(), yyline, yycolumn));
                                return new Symbol(sym.STRING, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {BOOL}           {MisTokens.add(new Tokens("BOOLEANO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.BOOL, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {VOID}           {MisTokens.add(new Tokens("VOID",yytext(), yyline, yycolumn));
                                return new Symbol(sym.VOID, yyline, yycolumn, yytext());
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
 
<YYINITIAL> {CADENA}         {String cadena = yytext(); 
                             cadena=cadena.substring(1, cadena.length() - 1);
                             cadena = cadena.replace("\\n", "\n")
                                             .replace("\\t", "\t")
                                             .replace("\\\\", "\\\\")
                                             .replace("\\\"", "\"")
                                             .replace("\\'", "'");
                             MisTokens.add(new Tokens("CADENA",cadena, yyline, yycolumn));
                             return new Symbol(sym.CADENA, yyline, yycolumn, cadena);
                             }
<YYINITIAL> {CARACTER}       {String caracter = yytext(); 
                             caracter=caracter.substring(1, caracter.length() - 1);
                             MisTokens.add(new Tokens("CARACTER",caracter, yyline, yycolumn));
                             return new Symbol(sym.CARACTER, yyline, yycolumn, caracter);
                             }
<YYINITIAL> {ID}             {MisTokens.add(new Tokens("ID",yytext(), yyline, yycolumn));
                                return new Symbol(sym.ID, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {LKEY}           {MisTokens.add(new Tokens("LKEY",yytext(), yyline, yycolumn));
                              return new Symbol(sym.LKEY, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {RKEY}           {MisTokens.add(new Tokens("RKEY",yytext(), yyline, yycolumn));
                              return new Symbol(sym.RKEY, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {PAR1}           {MisTokens.add(new Tokens("PAR1",yytext(), yyline, yycolumn));
                              return new Symbol(sym.PAR1, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {PAR2}           {MisTokens.add(new Tokens("PAR2",yytext(), yyline, yycolumn));
                              return new Symbol(sym.PAR2, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {LBRACKET}       {MisTokens.add(new Tokens("LBRACKET",yytext(), yyline, yycolumn));
                              return new Symbol(sym.LBRACKET, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {RBRACKET}       {MisTokens.add(new Tokens("RBRACKET",yytext(), yyline, yycolumn));
                              return new Symbol(sym.RBRACKET, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {COMA}           {MisTokens.add(new Tokens("COMA",yytext(), yyline, yycolumn));
                              return new Symbol(sym.COMA, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {COLOM}          {MisTokens.add(new Tokens("COLOM",yytext(), yyline, yycolumn));
                              return new Symbol(sym.COLOM, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {FINCADENA}      {MisTokens.add(new Tokens("FINCADENA",yytext(), yyline, yycolumn));
                              return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {DOT}            {MisTokens.add(new Tokens("DOT",yytext(), yyline, yycolumn));
                              return new Symbol(sym.DOT, yyline, yycolumn, yytext());
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

<YYINITIAL> {DECREMENTO}     {MisTokens.add(new Tokens("DECREMENTO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.DECREMENTO, yyline, yycolumn, yytext());
                             }
<YYINITIAL> {INCREMENTO}     {MisTokens.add(new Tokens("INCREMENTO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.INCREMENTO, yyline, yycolumn, yytext());
                             }

<YYINITIAL> {TO}             {MisTokens.add(new Tokens("TO",yytext(), yyline, yycolumn));
                                return new Symbol(sym.TO, yyline, yycolumn, yytext());
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

<YYINITIAL> {IGUAL}          {MisTokens.add(new Tokens("IGUAL",yytext(), yyline, yycolumn));
                                return new Symbol(sym.IGUAL, yyline, yycolumn, yytext());
                             }

\/\/[^\n]*              { /* Ignorar comentarios de una línea */ }
\/\*([^*]|\*[^\/])*\*\/ { /* Ignorar comentarios de múltiples líneas */ }
<YYINITIAL>. {erroresLexicos.add(new Errores("LEXICO", "El caracter "+ yytext() + " no pertenece al lenguaje", yyline, yycolumn));}