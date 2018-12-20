import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        Parser parser = null;
        try {
            parser = new Parser(new InputStreamReader(new FileInputStream("src/test/full.logo")));
        }catch(FileNotFoundException e){
            System.err.println("File input not found");
            System.exit(1);
        }
        parser.yyparse();

        Extract extract = parser.extract;
        for (Transaction t: extract.getIdentifiers().get(0).getTransactions()) {
            System.out.println(t.getSaida());
        }
        System.out.println("Ok");


        /*for (int i = 0; i < t.trans.size(); i++) {
            System.out.println(t.trans.get(i));
        }*/
/*
        PrintStream file = null;
        try{
            file = new PrintStream("target/output.html");
        }catch(FileNotFoundException e){
            System.err.println("Error creating output file");
            System.exit(1);
        }

        file.println("<html>\n<body>\n<table>");
        for(Command c: parser.commands){
            c.addData(file);
        }
        file.println("</table>\n</body>\n</html>");
        */
    }
}