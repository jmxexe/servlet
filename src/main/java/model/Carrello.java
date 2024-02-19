package model;

import java.util.ArrayList;

public class Carrello {
    ArrayList<Prodotto> carrello = new ArrayList<>();


    public Carrello() {

    }
    public ArrayList<Prodotto> getCarrello() {
        return carrello;
    }

    public void setCarrello(ArrayList<Prodotto> carrello) {
        this.carrello = carrello;
    }

    public boolean aggiungiProdotto(Prodotto p) {
        for (Prodotto p1: carrello) {
            if(p1.getNome().equals(p.getNome())) {
                return false;
            }
        }
        return carrello.add(p);
    }

    public boolean eliminaProdotto(String nome) {
        for (Prodotto p: carrello) {
            if(p.getNome().equals(nome)) {
                return carrello.remove(p);
            }
        }
        return false;
    }


}
