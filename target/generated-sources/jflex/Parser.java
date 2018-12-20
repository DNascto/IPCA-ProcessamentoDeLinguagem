//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "src/main/jflex/Parser.byaccj"
    import java.io.*;
    import java.util.ArrayList;
//#line 20 "target/generated-sources/jflex/Parser.java"




public class Parser
             implements ParserTokens
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    1,    5,    2,    6,    7,    8,    9,   10,
    3,    3,   11,   11,   12,   13,    4,   14,   14,   15,
   16,   17,   18,   19,   20,   21,   22,   23,   24,   25,
   26,   27,   28,
};
final static short yylen[] = {                            2,
    0,    5,    3,    3,    5,    3,    3,    3,    3,    3,
    0,    2,    0,    4,    3,    3,    3,    0,    2,   13,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,   11,    0,    3,    0,    0,
    0,    0,    6,    0,    0,    0,   12,    0,    0,    0,
    0,    0,    0,    0,    2,    0,   18,    7,    0,    0,
    0,   15,   17,    0,    0,    0,    8,    0,    0,    5,
    4,   16,    0,   14,   19,    0,    9,    0,    0,    0,
    0,   10,   21,    0,    0,    0,   22,    0,    0,    0,
   23,    0,    0,    0,   24,    0,    0,    0,   25,    0,
    0,    0,   26,    0,    0,    0,   27,    0,    0,    0,
   28,    0,    0,    0,   29,    0,    0,    0,   30,    0,
    0,    0,   31,    0,    0,   20,   32,    0,   33,
};
final static short yydgoto[] = {                          2,
    3,    6,   10,   16,   25,    7,   12,   21,   31,   40,
   17,   18,   27,   36,   45,   46,   51,   56,   60,   64,
   68,   72,   76,   80,   84,   88,   92,   96,
};
final static short yysindex[] = {                      -290,
 -301,    0, -295, -289, -299,    0, -293,    0, -298, -283,
 -294, -292,    0, -291, -288, -281,    0, -272, -287, -286,
 -285, -273, -274, -282,    0, -280,    0,    0, -279, -278,
 -284,    0,    0, -275, -265, -257,    0, -277, -271,    0,
    0,    0, -270,    0,    0, -232,    0, -269, -242, -268,
 -228,    0,    0, -239, -267, -224,    0, -233, -264, -221,
    0, -230, -261, -217,    0, -227, -259, -215,    0, -226,
 -255, -213,    0, -223, -253, -211,    0, -222, -249, -209,
    0, -220, -246, -207,    0, -218, -243, -205,    0, -216,
 -240, -203,    0, -214, -237,    0,    0, -212,    0,
};
final static short yyrindex[] = {                        69,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,    0,    0,   35,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=71;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         43,
   14,    1,   15,    4,    5,    9,    8,   11,   13,   20,
   19,   24,   26,   22,   32,   33,   23,   30,   29,   39,
   28,   41,   34,   42,   35,   50,   38,   53,   15,   37,
   55,   57,   47,   48,   49,   59,   54,   58,   61,   63,
   62,   52,   65,   66,   67,   70,   69,   71,   73,   74,
   75,   78,   77,   79,   81,   82,   83,   85,   86,   87,
   89,   90,   91,   93,   94,   95,   97,   98,    1,   99,
   44,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                        257,
  284,  292,  286,  305,  300,  305,  296,  301,  307,  302,
  305,  293,  285,  305,  288,  290,  305,  303,  305,  304,
  308,  297,  305,  289,  305,  258,  305,  270,  286,  309,
  259,  271,  310,  305,  305,  260,  305,  305,  272,  261,
  305,  311,  273,  305,  262,  305,  274,  263,  275,  305,
  264,  305,  276,  265,  277,  305,  266,  278,  305,  267,
  279,  305,  268,  280,  305,  269,  281,  305,    0,  282,
   36,
};
}
final static short YYFINAL=2;
final static short YYMAXTOKEN=311;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"O_DATA_ENTRADA","O_HORA_ENTRADA","O_ENTRADA","O_DATA_SAIDA",
"O_HORA_SAIDA","O_SAIDA","O_IMPORTANCIA","O_VALOR_DESCONTO","O_TAXA_IVA",
"O_OPERADOR","O_TIPO","O_DATA_DEBITO","O_CARTAO","C_DATA_ENTRADA",
"C_HORA_ENTRADA","C_ENTRADA","C_DATA_SAIDA","C_HORA_SAIDA","C_SAIDA",
"C_IMPORTANCIA","C_VALOR_DESCONTO","C_TAXA_IVA","C_OPERADOR","C_TIPO",
"C_DATA_DEBITO","C_CARTAO","O_TRANSACCAO","O_MATRICULA","O_REF_PAGAMENTO",
"O_TOTAL","C_TRANSACCAO","C_MATRICULA","C_REF_PAGAMENTO","C_TOTAL","O_EXTRACTO",
"O_MES_EMISSAO","O_TOTAL_IVA","O_IDENTIFICADOR","C_EXTRACTO","C_MES_EMISSAO",
"C_TOTAL_IVA","C_IDENTIFICADOR","O_CLIENTE","O_NIF","O_NOME","O_MORADA",
"O_LOCALIDADE","O_CODIGO_POSTAL","TEXT","C_CLIENTE","C_NIF","C_NOME","C_MORADA",
"C_LOCALIDADE","C_CODIGO_POSTAL",
};
final static String yyrule[] = {
"$accept : extract",
"extract :",
"extract : mes_emissao cliente identifiers total total_iva",
"mes_emissao : O_MES_EMISSAO TEXT C_MES_EMISSAO",
"total_iva : O_TOTAL_IVA TEXT C_TOTAL_IVA",
"cliente : nif nome morada localidade codigo_postal",
"nif : O_NIF TEXT C_NIF",
"nome : O_NOME TEXT C_NOME",
"morada : O_MORADA TEXT C_MORADA",
"localidade : O_LOCALIDADE TEXT C_LOCALIDADE",
"codigo_postal : O_CODIGO_POSTAL TEXT C_CODIGO_POSTAL",
"identifiers :",
"identifiers : identifiers identifier",
"identifier :",
"identifier : matricula ref_pag transactions total",
"matricula : O_MATRICULA TEXT C_MATRICULA",
"ref_pag : O_REF_PAGAMENTO TEXT C_REF_PAGAMENTO",
"total : O_TOTAL TEXT C_TOTAL",
"transactions :",
"transactions : transactions transacao",
"transacao : dt_entrada hr_entrada entrada dt_saida hr_saida saida importancia valor_desc taxa_iva operador tipo dt_debito cartao",
"dt_entrada : O_DATA_ENTRADA TEXT C_DATA_ENTRADA",
"hr_entrada : O_HORA_ENTRADA TEXT C_HORA_ENTRADA",
"entrada : O_ENTRADA TEXT C_ENTRADA",
"dt_saida : O_DATA_SAIDA TEXT C_DATA_SAIDA",
"hr_saida : O_HORA_SAIDA TEXT C_HORA_SAIDA",
"saida : O_SAIDA TEXT C_SAIDA",
"importancia : O_IMPORTANCIA TEXT C_IMPORTANCIA",
"valor_desc : O_VALOR_DESCONTO TEXT C_VALOR_DESCONTO",
"taxa_iva : O_TAXA_IVA TEXT C_TAXA_IVA",
"operador : O_OPERADOR TEXT C_OPERADOR",
"tipo : O_TIPO TEXT C_TIPO",
"dt_debito : O_DATA_DEBITO TEXT C_DATA_DEBITO",
"cartao : O_CARTAO TEXT C_CARTAO",
};

//#line 68 "src/main/jflex/Parser.byaccj"

private Lexer lexer;
public Extract extract;

public Parser(Reader r){
    lexer = new Lexer(r,this);
    extract = new Extract();
    }

public void yyerror(String error){
    System.err.println("***ERRO*** " + error);
}

private int yylex(){
    int returnValue = -1;

    try{
        return lexer.yylex();
    }
    catch(IOException e){
        System.err.println("***IO ERROR " + e);
    }
    return returnValue;
}
//#line 325 "target/generated-sources/jflex/Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 16 "src/main/jflex/Parser.byaccj"
{yyval = new ParserVal(new Extract());}
break;
case 2:
//#line 17 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(4); yyval = val_peek(3); yyval = val_peek(2); yyval = val_peek(1); yyval = val_peek(0);}
break;
case 3:
//#line 20 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 4:
//#line 21 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 5:
//#line 23 "src/main/jflex/Parser.byaccj"
{ new Client(val_peek(4).sval, val_peek(3).sval, val_peek(2).sval, val_peek(1).sval, val_peek(0).sval); }
break;
case 6:
//#line 25 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 7:
//#line 26 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 8:
//#line 27 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 9:
//#line 28 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 10:
//#line 29 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 11:
//#line 31 "src/main/jflex/Parser.byaccj"
{ yyval = new ParserVal(new ArrayList<Identifier>()); }
break;
case 12:
//#line 32 "src/main/jflex/Parser.byaccj"
{((ArrayList<Identifier>)val_peek(1).obj).add((Identifier)val_peek(0).obj); yyval = val_peek(1); }
break;
case 13:
//#line 35 "src/main/jflex/Parser.byaccj"
{ yyval = new ParserVal(new ArrayList<Identifier>()); }
break;
case 14:
//#line 36 "src/main/jflex/Parser.byaccj"
{ yyval = new ParserVal(new Identifier(val_peek(3).sval, val_peek(2).sval, (ArrayList<Transaction>)val_peek(1).obj, val_peek(0).sval)); }
break;
case 15:
//#line 38 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 16:
//#line 39 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 17:
//#line 40 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 18:
//#line 42 "src/main/jflex/Parser.byaccj"
{ yyval = new ParserVal(new ArrayList<Transaction>()); }
break;
case 19:
//#line 43 "src/main/jflex/Parser.byaccj"
{ ((ArrayList<Transaction>)val_peek(1).obj).add((Transaction)val_peek(0).obj); yyval = val_peek(1); }
break;
case 20:
//#line 47 "src/main/jflex/Parser.byaccj"
{new Transaction(val_peek(12).sval, val_peek(11).sval, val_peek(10).sval, val_peek(9).sval, val_peek(8).sval, val_peek(7).sval, val_peek(6).sval, val_peek(5).sval, val_peek(4).sval, val_peek(3).sval, val_peek(2).sval, val_peek(1).sval, val_peek(0).sval); }
break;
case 21:
//#line 51 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 22:
//#line 52 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 23:
//#line 53 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 24:
//#line 54 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 25:
//#line 55 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 26:
//#line 56 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 27:
//#line 57 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 28:
//#line 58 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 29:
//#line 59 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 30:
//#line 60 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 31:
//#line 61 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 32:
//#line 62 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
case 33:
//#line 63 "src/main/jflex/Parser.byaccj"
{ yyval = val_peek(1); }
break;
//#line 606 "target/generated-sources/jflex/Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
