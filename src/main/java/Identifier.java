import java.util.ArrayList;

public class Identifier {
    private String matricula;
    private int ref_pag;
    private ArrayList<Transaction> transactions;
    private double total;

    public Identifier(String matricula, String ref_pag, ArrayList<Transaction> transactions, String total) {
        this.matricula = matricula;
        this.ref_pag = Integer.parseInt(ref_pag);
        this.transactions = transactions;
        this.total = new Formata().Money(total);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getRef_pag() {
        return ref_pag;
    }

    public void setRef_pag(int ref_pag) {
        this.ref_pag = ref_pag;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
