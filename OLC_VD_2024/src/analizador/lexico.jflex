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
/*Mutabilidad de variables
LET = "let"
CONST = "const"
*/

/*Casteos
CAST = "cast"
AS = "as"*/

/*Tipos de datos
INT = "int"
DOUBLE = "double"
BOOL = "bool"
CHAR = "char"
STRING = "string"
*/

/*booleanos
TRUE = "true"
FALSE = "false"
*/

/*Sentencias de control de control
IF = "if"
ELSE = "else"
MATCH = "match"
DEFAULT = "default"
*/

/*Sentencias ciclicas
WHILE = "while"
DO = "do"
FOR = "for"
*/

/*Sentencias de transferencia
BREAK = "break"
CONTINUE = "continue"
*/

//Imprensión en consola
PRINT = "console.log"

// ------>OPERACIONES<------
/*INCREMENTOS Y DECREMENTOS
INCREMENTO = "++"
DECREMENTOS = "--"
*/
//Operadores aritmeticos
SUMA = "+"
/*
RESTA = "-"
MULTIPLICACION = "*"
DIVICION = "/"
POTENCIA = "^"
RAIZ = "$"
MODULO = "%"
*/
/*Operadores relacionales
MAYOR = ">"
MENOR = "<"
MAYORIGUAL = ">="
MENORIGUAL = "<="
IGUAL = "=="
DIFERENTE = "!="
*/
/*Operadores logicos
AND = "&&"
OR = "||"
NOT = "!"
*/

// ------>SIMBOLOS<------
//COLOM = ":"
//LBRACE = "{"
//RBRACE = "}"
PAR1 = "("
PAR2 = ")"
FINCADENA = ";"
//DOT = "."

// ------>Expresiones regulares<------
//ID = [a-zA-Z_][a-zA-Z0-9_+]* 
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CADENA = \"([^\"]|[\t]|[\n]|[\r]|[ ])*\" 
//CARACTER = \'([^\']|[\t]|[\n]|[\r]|[ ])\'

//COMMENT = \/\/[^\n]*
//MCOMMENT = \/\*([^*]|\*[^\/])*\*\/

WHITESPACE = [ \t\r\f]+

// retorno de expresiones regulares
%%
<YYINITIAL> {PRINT}          {return new Symbol(sym.PRINT, yyline, yycolumn, yytext());}
<YYINITIAL> {DECIMAL}        {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}
<YYINITIAL> {ENTERO}         {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}

<YYINITIAL> {CADENA} {String cadena = yytext(); 
                        cadena=cadena.substring(1, cadena.length() - 1);
                        return new Symbol(sym.CADENA, yyline, yycolumn, cadena);
                    }

<YYINITIAL> {PAR1}           {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());}
<YYINITIAL> {PAR2}           {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());}
<YYINITIAL> {FINCADENA}      {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}

<YYINITIAL> {SUMA}           {return new Symbol(sym.SUMA, yyline, yycolumn, yytext());}

<YYINITIAL> {WHITESPACE}     {}
. {System.out.println("Error Lexico en la linea " + yyline + " y columna " + yycolumn + ". No se esperaba el componente: " + yytext());}