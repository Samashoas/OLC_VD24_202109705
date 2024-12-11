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
MENOS = "-"
POR = "*"
DIVISION = "/"
POTENCIA = "^"
RAIZ = "$"
MODULO = "%"
//Operadores Relacionales
IGUALACION = "=="
DIFERENCIA = "!="

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
<YYINITIAL> {IMPRIMIR}       {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());}

<YYINITIAL> {BOOLEANO}       {return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());}
<YYINITIAL> {DECIMAL}        {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}
<YYINITIAL> {ENTERO}         {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}

<YYINITIAL> {CARACTER}      {String caracter = yytext(); 
                            caracter=caracter.substring(1, caracter.length() - 1);
                            return new Symbol(sym.CARACTER, yyline, yycolumn, caracter);
                            }   
<YYINITIAL> {CADENA}        {String cadena = yytext(); 
                            cadena=cadena.substring(1, cadena.length() - 1);
                            return new Symbol(sym.CADENA, yyline, yycolumn, cadena);
                            }

<YYINITIAL> {PAR1}           {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());}
<YYINITIAL> {PAR2}           {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());}
<YYINITIAL> {FINCADENA}      {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}

<YYINITIAL> {MAS}            {return new Symbol(sym.MAS, yyline, yycolumn, yytext());}
<YYINITIAL> {MENOS}          {return new Symbol(sym.MENOS, yyline, yycolumn, yytext());}
<YYINITIAL> {POR}            {return new Symbol(sym.POR, yyline, yycolumn, yytext());}
<YYINITIAL> {DIVISION}       {return new Symbol(sym.DIVISION, yyline, yycolumn, yytext());}
<YYINITIAL> {POTENCIA}       {return new Symbol(sym.POTENCIA, yyline, yycolumn, yytext());}
<YYINITIAL> {RAIZ}           {return new Symbol(sym.RAIZ, yyline, yycolumn, yytext());}
<YYINITIAL> {MODULO}         {return new Symbol(sym.MODULO, yyline, yycolumn, yytext());}

<YYINITIAL> {IGUALACION}     {return new Symbol(sym.IGUALACION, yyline, yycolumn, yytext());}
<YYINITIAL> {DIFERENCIA}     {return new Symbol(sym.DIFERENCIA, yyline, yycolumn, yytext());}

. {System.out.println("Error Lexico en la linea " + yyline + " y columna " + yycolumn + ". No se esperaba el componente: " + yytext());}