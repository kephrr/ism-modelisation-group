package org.example.dao.implementations;

import org.example.dao.IBaseDonnee;
import org.example.domaine.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientBase implements IBaseDonnee<Client> {
    List<Client> clients = new ArrayList<Client>();
    public ClientBase() {
        clients.add(new Client("Martine", "SOW", "b354t"));
        clients.add(new Client("Kephren", "NZE", "bhf55"));
        clients.add(new Client("NN", "SOW", "FEijn"));
        clients.add(new Client("Maurice", "B", "HGVFZt"));
        clients.add(new Client("ABdoulaye", "DIOP", "yyyy"));
    }

    @Override
    public Client recuperer(String code) {
        for (Client c : clients) {
            if(Objects.equals(code, c.getCodeClient())){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Client> recupererTout() {
        return clients;
    }

    @Override
    public void sauvegarder(Client client) {
        clients.add(client);
    }

    @Override
    public void modifier(Client client, int index) {
        clients.set(index, client);
    }
}
