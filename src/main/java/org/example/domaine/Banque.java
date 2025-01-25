package org.example.domaine;

import java.util.ArrayList;
import java.util.List;

public class Banque {
    private String codebanque;
    private String nombanque;
    private List<Client> clients = new ArrayList<>();
    //  Attribut relationnel CLIENT

    public Banque(String codebanque, String nombanque) {
        this.codebanque = codebanque;
        this.nombanque = nombanque;
    }
    public Banque() {

    }

    public String getCodebanque() {
        return codebanque;
    }

    public void setCodebanque(String codebanque) {
        this.codebanque = codebanque;
    }

    public String getNombanque() {
        return nombanque;
    }

    public void setNombanque(String nombanque) {
        this.nombanque = nombanque;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void ajouterClient(Client client){
        this.clients.add(client);
    }

    @Override
    public String toString() {
        return "Nom: " + nombanque+
                " - Code: " + codebanque;
    }
}
