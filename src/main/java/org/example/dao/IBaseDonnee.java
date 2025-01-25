package org.example.dao;

import java.util.List;

public interface IBaseDonnee<Type> {
    Type recuperer(String code);
    List<Type> recupererTout();
    void sauvegarder(Type t);
    void modifier(Type t, int index);
}
