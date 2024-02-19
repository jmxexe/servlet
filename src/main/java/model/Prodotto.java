package model;

public class Prodotto {
    private String nome;
    private String descrizione;

    public Prodotto(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }
    public Prodotto(String nome) {
        this.nome = nome;
        this.descrizione = "descrizione vuota";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Prodotto: nome: " + nome + ", descrizione: " + descrizione;
    }
}
