import java.io.PrintStream;
import java.util.ArrayList;

public class Transaction extends Command {
    ArrayList<Command> transactions;

    public Transaction(ArrayList<Command> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void addData(PrintStream file) {
        file.println("<th>DATA_ENTRADA</th>\n" +
                "<th>HORA_ENTRADA</th>\n" +
                "<th>ENTRADA</th>\n" +
                "<th>DATA_SAIDA</th>\n" +
                "<th>HORA_SAIDA</th>\n" +
                "<th>SAIDA</th>\n" +
                "<th>IMPORTANCIA</th>\n" +
                "<th>VALOR_DESCONTO</th>\n" +
                "<th>TAXA_IVA</th>\n" +
                "<th>OPERADOR</th>\n" +
                "<th>TIPO</th>\n" +
                "<th>DATA_DEBITO</th>\n" +
                "<th>CARTAO</th>\n"+
                "<tr>\n" );
        for (Command c: transactions) {
            c.addData(file);
        }
        file.println("</tr>");
    }
}
