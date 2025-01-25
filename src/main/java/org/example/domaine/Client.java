package org.example.domaine;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String codeClient;
    private String nomClient;
    private String prenomClient;
    private Banque banque;
    private List<Compte> comptes = new ArrayList<Compte>();

    public Client(String prenomClient, String nomClient, String codeClient) {
        this.prenomClient = prenomClient;
        this.nomClient = nomClient;
        this.codeClient = codeClient;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public void ajouterCompte(Compte compte) {
        this.comptes.add(compte);
    }

    @Override
    public String toString() {
        return "Prenom: " + prenomClient+
                " - Nom: " + nomClient+
                " - Code: " + codeClient;
    }
}
