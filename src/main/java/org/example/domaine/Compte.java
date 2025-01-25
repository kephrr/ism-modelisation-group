package org.example.domaine;

public abstract class Compte {
    protected String numeroCompte;
    protected String titulaireCompte;
    protected double solde;
    protected Client client;

    public abstract int debiter(double montant);
    public abstract int crediter(double montant);
    public abstract String getNumeroCompte();
    public abstract String getTitulaireCompte();
}