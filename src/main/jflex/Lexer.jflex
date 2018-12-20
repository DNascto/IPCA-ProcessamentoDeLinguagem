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


\<IDENTIFICADOR\>       { return ParserTokens.O_IDENTIFICADOR; }
\<\/IDENTIFICADOR\>     { return ParserTokens.C_IDENTIFICADOR; }
\<MATRICULA\>           { return ParserTokens.O_MATRICULA; }
\<\/MATRICULA\>         { return ParserTokens.C_MATRICULA; }
\<REF_PAGAMENTO\>       { return ParserTokens.O_REF_PAGAMENTO; }
\<\/REF_PAGAMENTO\>     { return ParserTokens.C_REF_PAGAMENTO; }
\<TRANSACCAO\>          { return ParserTokens.O_TRANSACCAO; }
\<\/TRANSACCAO\>        { return ParserTokens.C_TRANSACCAO; }


\<CLIENTE\>             { return ParserTokens.O_CLIENTE; }
\<\/CLIENTE\>           { return ParserTokens.C_CLIENTE; }
\<NIF\>                 { return ParserTokens.O_NIF; }
\<\/NIF\>               { return ParserTokens.C_NIF; }
\<NOME\>                { return ParserTokens.O_NOME; }
\<\/NOME\>              { return ParserTokens.C_NOME; }
\<MORADA\>              { return ParserTokens.O_MORADA; }
\<\/MORADA\>            { return ParserTokens.C_MORADA; }
\<LOCALIDADE\>          { return ParserTokens.O_LOCALIDADE; }
\<\/LOCALIDADE\>        { return ParserTokens.C_LOCALIDADE; }
\<CODIGO_POSTAL\>       { return ParserTokens.O_CODIGO_POSTAL; }
\<\/CODIGO_POSTAL\>     { return ParserTokens.C_CODIGO_POSTAL; }


\<EXTRACTO\>            { return ParserTokens.O_EXTRACTO; }
\<\/EXTRACTO\>          { return ParserTokens.C_EXTRACTO; }
\<MES_EMISSAO\>         { return ParserTokens.O_MES_EMISSAO; }
\<\/MES_EMISSAO\>       { return ParserTokens.C_MES_EMISSAO; }
\<TOTAL_IVA\>           { return ParserTokens.O_TOTAL_IVA; }
\<\/TOTAL_IVA\>         { return ParserTokens.C_TOTAL_IVA; }




[ \n\r]+         { /* ignore */ }

[^<]+               { yyparser.yylval = new ParserVal(yytext());
                       return ParserTokens.TEXT; }

\<\?[^>]+\>         { /* ignore */ }
.                   { return 1; }

