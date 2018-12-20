import java.util.ArrayList;

public class Extract {
    private String mesEmissao;
    private Client cliente;
    private ArrayList<Identifier> identifiers;
    private double total, totalIVA;

    public Extract() {
    }

    public Extract(String mesEmissao, Client cliente, ArrayList<Identifier> identifiers, String total, String totalIVA) {
        this.mesEmissao = mesEmissao;
        this.cliente = cliente;
        this.identifiers = identifiers;
        this.total = new Formata().Money(total);
        this.totalIVA = new Formata().Money(totalIVA);
    }

    public String getMesEmissao() {
        return mesEmissao;
    }

    public void setMesEmissao(String mesEmissao) {
        this.mesEmissao = mesEmissao;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(ArrayList<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalIVA() {
        return totalIVA;
    }

    public void setTotalIVA(double totalIVA) {
        this.totalIVA = totalIVA;
    }
}
