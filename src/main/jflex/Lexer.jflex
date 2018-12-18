%%
%class Lexer
%byaccj

%{
    private Parser yyparser;

    /*Constructor que associa o Parser ao Lexer*/
    public Lexer(java.io.Reader r, Parser yyparser){
        this(r);
        this.yyparser = yyparser;
    }
%}
%%

\<DATA_ENTRADA\>        { return ParserTokens.O_DATA_ENTRADA; }
\<\/DATA_ENTRADA\>      { return ParserTokens.C_DATA_ENTRADA; }
\<HORA_ENTRADA\>        { return ParserTokens.O_HORA_ENTRADA; }
\<\/HORA_ENTRADA\>      { return ParserTokens.C_HORA_ENTRADA; }
\<ENTRADA\>             { return ParserTokens.O_ENTRADA; }
\<\/ENTRADA\>           { return ParserTokens.C_ENTRADA; }
\<DATA_SAIDA\>          { return ParserTokens.O_DATA_SAIDA; }
\<\/DATA_SAIDA\>        { return ParserTokens.C_DATA_SAIDA; }
\<HORA_SAIDA\>          { return ParserTokens.O_HORA_SAIDA; }
\<\/HORA_SAIDA\>        { return ParserTokens.C_HORA_SAIDA; }
\<SAIDA\>               { return ParserTokens.O_SAIDA; }
\<\/SAIDA\>             { return ParserTokens.C_SAIDA; }
\<IMPORTANCIA\>         { return ParserTokens.O_IMPORTANCIA; }
\<\/IMPORTANCIA\>       { return ParserTokens.C_IMPORTANCIA; }
\<VALOR_DESCONTO\>      { return ParserTokens.O_VALOR_DESCONTO; }
\<\/VALOR_DESCONTO\>    { return ParserTokens.C_VALOR_DESCONTO; }
\<TAXA_IVA\>            { return ParserTokens.O_TAXA_IVA; }
\<\/TAXA_IVA\>          { return ParserTokens.C_TAXA_IVA; }
\<OPERADOR\>            { return ParserTokens.O_OPERADOR; }
\<\/OPERADOR\>          { return ParserTokens.C_OPERADOR; }
\<TIPO\>                { return ParserTokens.O_TIPO; }
\<\/TIPO\>              { return ParserTokens.C_TIPO; }
\<DATA_DEBITO\>         { return ParserTokens.O_DATA_DEBITO; }
\<\/DATA_DEBITO\>       { return ParserTokens.C_DATA_DEBITO; }
\<CARTAO\>              { return ParserTokens.O_CARTAO; }
\<\/CARTAO\>            { return ParserTokens.C_CARTAO; }

\<TRANSACCAO\>          { return ParserTokens.O_TRANSACCAO; }
\<\/TRANSACCAO\>        { return ParserTokens.C_TRANSACCAO; }


[ \n\r]+         { /* ignore */ }

[^<]+               { yyparser.yylval = new ParserVal(yytext());
                       return ParserTokens.TEXT; }

\<\?[^>]+\>         { /* ignore */ }
.                   { return 1; }

