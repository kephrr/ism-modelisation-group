package org.example.dao.implementations;

import org.example.dao.IBaseDonnee;
import org.example.domaine.Banque;
import org.example.domaine.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BanqueBase implements IBaseDonnee<Banque> {
    private List<Banque> banques = new ArrayList<Banque>();

    public BanqueBase() {
        banques.add(new Banque("B1","UBA"));
        banques.add(new Banque("B2","BOA"));
        banques.add(new Banque("B3","CA"));
        banques.add(new Banque("B4","N26"));
        banques.add(new Banque("B5","Ora Bank"));
    }

    @Override
    public Banque recuperer(String code) {
        for(Banque banque : banques) {
            if(banque.getCodebanque().equals(code)) {
                return banque;
            }
        }
        return null;
    }

    @Override
    public List<Banque> recupererTout() {
        return banques;
    }

    @Override
    public void sauvegarder(Banque t) {
        banques.add(t);
    }

    @Override
    public void modifier(Banque banque, int index) {
        banques.set(index,banque);
    }
}
