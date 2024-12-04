package analizador;

// importaciones
import java_cup.runtime.Symbol;

%%

// codigo de usuario
%{
    //String cadena = "";
%}

// inicializacion
%init{
    yyline = 1;
    yycolumn = 1;
%init}

// declaracion de caracteristicas de jflex
%cup
%class scanner //nombre de la clase
%public 
%line //conteo de lineas
%char //conteo de caracteres
%column //conteo de columnas
%full // reconocimiento de caracteres
%ignorecase //ignorar mayusculas y minusculas

// Creacion de estados, si fuese necesario
%state CADENA

// definir simbolos del sistema

// ------>PALABRAS RESERVADAS<------
//Mutabilidad de variables
LET = "let"
CONST = "const"
//Tipos de datos
INT = "int"
DOUBLE = "double"
BOOL = "bool"
CHAR = "char"
STRING = "string"
//booleanos
TRUE = "true"
FALSE = "false"
//Sentencias de control de control
IF = "if"
ELSE = "else"
SWITCH = "switch"
CASE = "case"
//Sentencias ciclicas
WHILE = "while"
DO = "do"
FOR = "for"
//Sentencias de transferencia
BREAK = "break"
CONTINUE = "continue"
//Imprensión en consola
print = "console.log"

// ------>OPERACIONES<------
//Operadores aritmeticos
SUMA = "+"
RESTA = "-"
MULTIPLICACION = "*"
DIVICION = "/"
POTENCIA = "^"
RAIZ = "$"
MODULO = "%"
//Operadores relacionales
MAYOR = ">"
MENOR = "<"
MAYORIGUAL = ">="
MENORIGUAL = "<="
IGUAL = "=="
DIFERENTE = "!="
//Operadores logicos
AND = "&&"
OR = "||"
NOT = "!"

// ------>SIMBOLOS<------
COLOM = ":"
LBRACE = "{"
RBRACE = "}"
LPAR = "("
RPAR = ")"
FINCADENA = ";"
DOT = "."

// ------>Expresiones regulares<------
ID = [a-zA-Z_][a-zA-Z0-9_+]* 
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CADENA = \"([^\"]|[\t]|[\n]|[\r]|[ ])*\" 
CARACTER = \'([^\']|[\t]|[\n]|[\r]|[ ])\'

COMMENT = \/\/[^\n]*
MCOMMENT = \/\*([^*]|\*[^\/])*\*\/

WHITESPACE = [ \t\r\f]+

// retorno de expresiones regulares
%%

<YYINITIAL> {LET}        {return new Symbol(sym.LET, yyline, yycolumn, yytext());}
<YYINITIAL> {CONST}      {return new Symbol(sym.CONST, yyline, yycolumn, yytext());}

<YYINITIAL> {INT}        {return new Symbol(sym.INT, yyline, yycolumn, yytext());}
<YYINITIAL> {DOUBLE}     {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
<YYINITIAL> {BOOL}       {return new Symbol(sym.BOOL, yyline, yycolumn, yytext());}
<YYINITIAL> {CHAR}       {return new Symbol(sym.CHAR, yyline, yycolumn, yytext());}
<YYINITIAL> {STRING}     {return new Symbol(sym.STRING, yyline, yycolumn, yytext());}

<YYINITIAL> {TRUE}       {return new Symbol(sym.TRUE, yyline, yycolumn, yytext());}
<YYINITIAL> {FALSE}      {return new Symbol(sym.FALSE, yyline, yycolumn, yytext());}

<YYINITIAL> {IF}         {return new Symbol(sym.IF, yyline, yycolumn, yytext());}
<YYINITIAL> {ELSE}       {return new Symbol(sym.ELSE, yyline, yycolumn, yytext());}
<YYINITIAL> {SWITCH}     {return new Symbol(sym.SWITCH, yyline, yycolumn, yytext());}
<YYINITIAL> {CASE}       {return new Symbol(sym.CASE, yyline, yycolumn, yytext());}

<YYINITIAL> {WHILE}      {return new Symbol(sym.WHILE, yyline, yycolumn, yytext());}
<YYINITIAL> {DO}         {return new Symbol(sym.DO, yyline, yycolumn, yytext());}
<YYINITIAL> {FOR}        {return new Symbol(sym.FOR, yyline, yycolumn, yytext());}

<YYINITIAL> {BREAK}      {return new Symbol(sym.BREAK, yyline, yycolumn, yytext());}
<YYINITIAL> {CONTINUE}   {return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());}

<YYINITIAL> {DECIMAL}    {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}
<YYINITIAL> {ENTERO}     {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}
<YYINITIAL> {CARACTER}   {return new Symbol(sym.CARACTER, yyline, yycolumn, yytext());}//Agregar secuencia de escape
<YYINITIAL> {CADENA}     {return new Symbol(sym.ELEMENT, yyline, yycolumn, yytext());}//Agregar secuencia de escape
<YYINITIAL> {ID}         {return new Symbol(sym.ID, yyline, yycolumn, yytext());}

<YYINITIAL> {COMMENT} {/* ignorar comentarios */}
<YYINITIAL> {MCOMMENT} {/* ignorar comentarios */}

<YYINITIAL> {WHITESPACE}      {}

. {System.out.println("Error Lexico en la linea " + yyline + " y columna " + yycolumn + ". No se esperaba el componente: " + yytext());}