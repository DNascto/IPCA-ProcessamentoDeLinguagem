import java.util.ArrayList;

public class Client {
    private String nome, morada, localidade, codigoPostal;
    private int nif, id;

    public Client(String nome, String morada, String localidade, String codigoPostal, String nif) {
        this.nome = nome;
        this.morada = morada;
        this.localidade = localidade;
        this.codigoPostal = codigoPostal;
        this.nif = Integer.parseInt(nif);
        //this.id = Integer.parseInt(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
