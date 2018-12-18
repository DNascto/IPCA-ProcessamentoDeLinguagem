import java.io.PrintStream;

public class Text extends Command {
    String text;

    public Text(String text) {
        this.text = text;
    }

    public Text(String text, String text2) {
        this.text = text+text2;
    }

    @Override
    public void addData(PrintStream file) {
        file.println("<td>" + text + "</td>");
    }
}
