package org.example.dao.implementations;

import org.example.dao.IBaseDonnee;
import org.example.domaine.Banque;
import org.example.domaine.CCourant;
import org.example.domaine.CEpargne;
import org.example.domaine.Compte;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompteBase implements IBaseDonnee<Compte> {
    private List<Compte> comptes = new ArrayList<Compte>();

    public CompteBase() {
        comptes.add(new CCourant("FE23424","Martine", 15000.0, 0.15));
        comptes.add(new CCourant("DE5345","bfhe", 50000.0, 0.01));
        comptes.add(new CEpargne("BG12324","Alb", 25000.0, 0.05));
        comptes.add(new CEpargne("BD2342","Klo", 3000.0, 0.01));
        comptes.add(new CCourant("KJ2324","Bob", 315000.0, 0.08));
    }

    @Override
    public Compte recuperer(String numeroCompte) {
        for (Compte compte : comptes) {
             if(compte instanceof CCourant) {
                 CCourant c = (CCourant) compte;
                 if(c.getNumeroCompte().equals(numeroCompte)) {
                     return compte;
                 }
             }
            if(compte instanceof CEpargne) {
                CEpargne ce = (CEpargne) compte;
                if(ce.getNumeroCompte().equals(numeroCompte)) {
                    return compte;
                }
            }
        }
        return null;
    }

    @Override
    public List<Compte> recupererTout() {
        return comptes;
    }

    @Override
    public void sauvegarder(Compte t) {
        comptes.add(t);
    }

    @Override
    public void modifier(Compte compte, int index) {
        comptes.set(index,compte);
    }

    public List<CEpargne> recupererToutEpargne() {
        List<CEpargne> comptesEpargne = new ArrayList<>();
        for(Compte c : comptes){
            if(c instanceof CEpargne) {
                comptesEpargne.add((CEpargne) c);
            }
        }
        return comptesEpargne;
    }


    public List<CCourant> recupererToutCourant() {
        List<CCourant> comptesEpargne = new ArrayList<>();
        for(Compte c : comptes){
            if(c instanceof CCourant) {
                comptesEpargne.add((CCourant) c);
            }
        }
        return comptesEpargne;
    }

}
