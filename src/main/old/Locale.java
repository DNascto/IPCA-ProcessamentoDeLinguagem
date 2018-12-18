package Old;

import java.io.PrintStream;

public class Locale extends Command {
    String locale;

    public Locale(String locale) {
        this.locale = locale;
    }

    @Override
    public void addData(PrintStream file) {
        file.println("<td>" + locale + "</td>");
    }
}
