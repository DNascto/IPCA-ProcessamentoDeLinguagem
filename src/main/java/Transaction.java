import java.io.PrintStream;
import java.util.ArrayList;

public class Transaction extends Command {
    ArrayList<Command> transactions;

    public Transaction(ArrayList<Command> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void addData(PrintStream file) {
        file.println("<tr>");
        for (Command c: transactions) {
            c.addData(file);
        }
        file.println("</tr>");
    }
}
