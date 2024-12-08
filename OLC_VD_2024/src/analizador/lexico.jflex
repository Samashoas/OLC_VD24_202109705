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
//Imprensión en consola
IMPRIMIR = "console.log"

// ------>OPERACIONES<------
//Operadores aritmeticos
MAS = "+"

// ------>SIMBOLOS<------
PAR1 = "("
PAR2 = ")"
FINCADENA = ";"

// ------>Expresiones regulares<------
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CADENA = \"([^\"]|[\t]|[\n]|[\r]|[ ])*\" 

WHITESPACE = [ \t\r\f]+

// retorno de expresiones regulares
%%
<YYINITIAL> {IMPRIMIR}       {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());}

<YYINITIAL> {DECIMAL}        {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}
<YYINITIAL> {ENTERO}         {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}

<YYINITIAL> {CADENA} {String cadena = yytext(); 
                        cadena=cadena.substring(1, cadena.length() - 1);
                        return new Symbol(sym.CADENA, yyline, yycolumn, cadena);
                    }

<YYINITIAL> {PAR1}           {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());}
<YYINITIAL> {PAR2}           {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());}
<YYINITIAL> {FINCADENA}      {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}

<YYINITIAL> {WHITESPACE}     {}
<YYINITIAL> {MAS}            {return new Symbol(sym.MAS, yyline, yycolumn, yytext());}
. {System.out.println("Error Lexico en la linea " + yyline + " y columna " + yycolumn + ". No se esperaba el componente: " + yytext());}