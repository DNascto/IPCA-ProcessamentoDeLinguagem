import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formata {
    private SimpleDateFormat formDay = new SimpleDateFormat("dd/MM/yyyy");
    private Date date;

    public Date NewDay(String dia) {
        String[] aux = dia.split("-");
        String formOfficial = aux[0] + "/" + aux[1] + "/" + aux[2];
        try {
            date = formDay.parse(formOfficial);
            return date;
        } catch (ParseException e) {
            System.err.println("Formato de data não aceito!");
        }
        return null;
    }

    private SimpleDateFormat formHour = new SimpleDateFormat("HH:mm:ss");
    private Date hour;

    public Date NewHour(String dia) {
        String[] aux = dia.split("-");
        String formOfficial = aux[0] + ":" + aux[1] + ":00";
        try {
            hour = formHour.parse(formOfficial);
            return hour;
        } catch (ParseException e) {
            System.err.println("Formato de hora não aceito!");
        }
        return null;
    }

    public double Money(String money) {
        return Double.parseDouble(money);
    }

}
