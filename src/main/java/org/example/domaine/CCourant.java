package org.example.domaine;

public class CCourant extends Compte{
    private double tauxAgios;

    @Override
    public int debiter(double montant) {
        if(montant<=solde){
            solde-=montant;
            return 1;
        }
        return 0;
    }

    @Override
    public int crediter(double montant) {
        solde = solde + (montant - montant*tauxAgios);
        return 1;
    }

    public CCourant(String numero, String titulaire, double solde, double tauxAgios) {
        this.numeroCompte = numero;
        this.titulaireCompte = titulaire;
        this.solde = solde;
        this.client = client;
        this.tauxAgios = tauxAgios;
    }

    public double getTauxAgios() {
        return tauxAgios;
    }

    public void setTauxAgios(double tauxAgios) {
        this.tauxAgios = tauxAgios;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getTitulaireCompte() {
        return titulaireCompte;
    }

    public void setTitulaireCompte(String titulaireCompte) {
        this.titulaireCompte = titulaireCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Numero : "+numeroCompte+" - "+titulaireCompte+"\nSolde:"+solde+"\nTauxAgios: "+tauxAgios+"\n";
    }
}