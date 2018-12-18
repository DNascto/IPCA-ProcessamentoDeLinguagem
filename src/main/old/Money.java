package Old;

import java.io.PrintStream;

public class Money extends Command {
    double money;

    public Money(double money) {
        this.money = money;
    }

    public Money(int money) {
        this.money = money;
    }
    @Override
    public void addData(PrintStream file) {
        file.println("<td>" + money + "</td>");
    }
}
