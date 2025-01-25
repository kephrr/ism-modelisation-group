package org.example.domaine;

public class CEpargne extends Compte{
    private double plafondCompte;

    @Override
    public int debiter(double montant) {
        if(montant<=solde && montant<=plafondCompte){
            solde-=montant;
            return 1;
        }
        return 0;
    }
    @Override
    public int crediter(double montant) {
        solde += montant;
        return 1;
    }

    public CEpargne(String numero, String titulaire, double solde, double plafond) {
        this.numeroCompte = numero;
        this.titulaireCompte = titulaire;
        this.solde = solde;
        this.plafondCompte = plafond;
    }

    public double getPlafondCompte() {
        return plafondCompte;
    }

    public void setPlafondCompte(double plafondCompte) {
        this.plafondCompte = plafondCompte;
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
        return "Numero : "+numeroCompte+" - "+titulaireCompte+"\nSolde:"+solde+"\nPlafond: "+plafondCompte+"\n";
    }
}
