import java.io.FileInputStream;
import java.io.*;

public class Main {

    public static void main(String args[]){
        Parser parser = null;
        try {
            parser = new Parser(new InputStreamReader(new FileInputStream("src/test/test.logo")));
        }catch(FileNotFoundException e){
            System.err.println("File imput not found");
            System.exit(1);
        }
        parser.yyparse();

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
    }
}