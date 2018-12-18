package Old;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewHour extends Command {
    SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
    Date completeHour;
    int hour, minute;

    public NewHour(int hora, int min) {
        hour = hora;
        minute = min;
        String formOfficial = hora + ":" + min + ":00";
        try {
            completeHour = form.parse(formOfficial);
        } catch (ParseException e) {
            System.err.println("Formato de hora não aceito!");
        }
    }

    @Override
    public void addData(PrintStream file) {
        file.println("<td>" + hour + ":" + minute + "</td>");
    }
}
