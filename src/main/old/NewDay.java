package Old;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NewDay extends Command {
    SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
    Date date;
    int day, month, year;

    public NewDay(int dia, int  mes, int ano) {
        this.day = dia;
        this.month = mes;
        this.year = ano;
        String formOfficial = dia + "/" + mes + "/" + ano;
        try {
            date = form.parse(formOfficial);
        } catch (ParseException e) {
            System.err.println("Formato de data não aceito!");
        }
    }

    @Override
    public void addData(PrintStream file) {
        file.println("<td>" + day + "/" + month + "/" + year + "</td>");
    }
}
