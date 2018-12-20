import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private Date dt_entrada, hr_entrada;
    private Date dt_saida, hr_saida, dt_debito;
    private String  entrada,saida;
    private String operador, tipo;
    private double importancia, valor_desc;
    private int cartao, taxa_iva;

    public Transaction(String dt_entrada, String hr_entrada, String entrada, String dt_saida, String hr_saida,
                       String saida, String importancia, String valor_desc, String taxa_iva, String operador,
                       String tipo, String dt_debito, String cartao) {
        this.dt_entrada = new Formata().NewDay(dt_entrada);
        this.hr_entrada = new Formata().NewHour(hr_entrada);
        this.entrada = entrada;
        this.dt_saida = new Formata().NewDay(dt_saida);
        this.hr_saida = new Formata().NewHour(hr_saida);
        this.saida = saida;
        this.importancia = new Formata().Money(importancia);
        this.valor_desc = new Formata().Money(valor_desc);
        this.taxa_iva = Integer.parseInt(taxa_iva);
        this.operador = operador;
        this.tipo = tipo;
        this.dt_debito = new Formata().NewDay(dt_debito);
        this.cartao = Integer.parseInt(cartao);
    }

    public Date getDt_entrada() {
        return dt_entrada;
    }

    public void setDt_entrada(Date dt_entrada) {
        this.dt_entrada = dt_entrada;
    }

    public Date getHr_entrada() {
        return hr_entrada;
    }

    public void setHr_entrada(Date hr_entrada) {
        this.hr_entrada = hr_entrada;
    }

    public Date getDt_saida() {
        return dt_saida;
    }

    public void setDt_saida(Date dt_saida) {
        this.dt_saida = dt_saida;
    }

    public Date getHr_saida() {
        return hr_saida;
    }

    public void setHr_saida(Date hr_saida) {
        this.hr_saida = hr_saida;
    }

    public Date getDt_debito() {
        return dt_debito;
    }

    public void setDt_debito(Date dt_debito) {
        this.dt_debito = dt_debito;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getImportancia() {
        return importancia;
    }

    public void setImportancia(double importancia) {
        this.importancia = importancia;
    }

    public double getValor_desc() {
        return valor_desc;
    }

    public void setValor_desc(double valor_desc) {
        this.valor_desc = valor_desc;
    }

    public int getCartao() {
        return cartao;
    }

    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

    public int getTaxa_iva() {
        return taxa_iva;
    }

    public void setTaxa_iva(int taxa_iva) {
        this.taxa_iva = taxa_iva;
    }
}
