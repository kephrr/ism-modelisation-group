package org.example.presentation;
import org.example.dao.implementations.BanqueBase;
import org.example.dao.implementations.ClientBase;
import org.example.dao.implementations.CompteBase;
import org.example.domaine.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
// On ne ferra pas ENSEMBLE : 7-8-9-10-12
/*
1-Créer une banque
2-Lister les banques
3-Créer un client
4-Rattacher un client à une banque
5-Créer un compte d’épargne
6-Rattacher un compte d’épargne à un client
7-Créer un compte courant
8-Rattacher un compte courant à un client
9-Lister les comptes courants
10- Lister les comptes d’épargne
11- Créditer un compte courant d’un montant
donné
12- Débiter un compte d’épargne d’un montant
donné
13- Déterminer pour chaque banque, le nombre
de clients, le nombre de comptes d’épargne et le
nombre de comptes courants
14- Sortie*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Bases de données (DAO)
        BanqueBase banqueBase = new BanqueBase();
        ClientBase clientBase = new ClientBase();
        CompteBase compteBase = new CompteBase();

        // Variables utilisées
        String nomBanque, codeBanque, nomClient, prenomClient, codeClient,
        numeroCompte, titulaireCompte;
        double plafond, solde, montant;
        Client client;
        CEpargne compteEpargne;
        Banque banque;
        int choix, clientChoix, banqueChoix, compteChoix;
        List<Client> clients = new ArrayList<>();
        List<CEpargne> comptesEpargne = new ArrayList<>();
        List<Banque> banques = new ArrayList<>();

        // Boucle
        do{
            choix = menu(sc);
            switch (choix){
                case 1:
                    System.out.println("Veuillez entrer le nom de la banque");
                    nomBanque = sc.nextLine();
                    System.out.println("Veuillez entrer le code de la banque");
                    codeBanque = sc.nextLine();
                    banque = new Banque(codeBanque, nomBanque);
                    banqueBase.sauvegarder(banque);
                    System.out.println("Banque créee avec succès !! ");
                    continuer(sc);
                    break;
                case 2:
                    /*
                    List<Banque> banques = banqueBase.recupererTout();
                    for(Banque b : banques){
                        System.out.println(b.getNombanque()+" "+b.getCodebanque());
                    }
                    */
                    banqueBase.recupererTout().forEach(System.out::println);
                    continuer(sc);
                    break;
                case 3:
                    System.out.println("Veuillez entrer le nom du client");
                    nomClient = sc.nextLine();
                    System.out.println("Veuillez entrer le prenom du client");
                    prenomClient = sc.nextLine();
                    System.out.println("Veuillez entrer le code du client");
                    codeClient = sc.nextLine();
                    client = new Client(prenomClient, nomClient, codeClient);
                    clientBase.sauvegarder(client);
                    System.out.println("Client crée avec succès !!\n");
                    clientBase.recupererTout().forEach(System.out::println);
                    continuer(sc);
                    break;
                case 4:
                    clients = clientBase.recupererTout();
                    clientChoix = selectionner(sc, clients);
                    client = clients.get(clientChoix-1);

                    banques = banqueBase.recupererTout();
                    banqueChoix = selectionner(sc, banques);
                    banque = banques.get(banqueChoix-1);

                    client.setBanque(banque);
                    banque.ajouterClient(client);

                    banqueBase.modifier(banque, banqueChoix-1);
                    clientBase.modifier(client, clientChoix-1);
                    continuer(sc);
                    break;
                case 5:
                    // Le numéro de compte est généré automatiquement
                    // numero de compte = Les 3 premières lettres du titulaire + plafond + La date
                    System.out.println("Veuillez entrer le nom du titulaire du compte");
                    titulaireCompte = sc.nextLine();
                    System.out.println("Veuillez entrer le plafond du compte");
                    plafond = Double.parseDouble(sc.nextLine());
                    System.out.println("Veuillez entrer le solde");
                    solde = Double.parseDouble(sc.nextLine());
                    compteEpargne = new CEpargne("", titulaireCompte, solde, plafond);
                    numeroCompte = genererNumeroCompte(compteEpargne);
                    compteEpargne.setNumeroCompte(numeroCompte);
                    compteBase.sauvegarder(compteEpargne);
                    System.out.println("Compte crée avec succès !!");
                    continuer(sc);
                    break;
                case 6:
                    clients = clientBase.recupererTout();
                    clientChoix = selectionner(sc, clients);
                    client = clients.get(clientChoix-1);

                    comptesEpargne = compteBase.recupererToutEpargne();
                    compteChoix =  selectionner(sc, comptesEpargne);
                    compteEpargne = comptesEpargne.get(compteChoix-1);

                    client.ajouterCompte(compteEpargne);
                    compteEpargne.setClient(client);

                    compteBase.modifier(compteEpargne, compteChoix-1);
                    clientBase.modifier(client, clientChoix-1);
                    continuer(sc);
                    break;
                case 7:
                    // IDEM case 5
                    break;
                case 8:
                    // IDEM case 6
                    break;
                case 9:
                    compteBase.recupererToutCourant().forEach(System.out::println);
                    continuer(sc);
                    break;
                case 10:
                    // IDEM case 10
                    break;
                case 11:
                    // IDEM case 12
                    break;
                case 12:
                    comptesEpargne = compteBase.recupererToutEpargne();
                    compteChoix =  selectionner(sc, comptesEpargne);
                    compteEpargne = comptesEpargne.get(compteChoix-1);

                    System.out.println("Veuillez entrer le motant à créditer");
                    montant = sc.nextDouble();
                    compteEpargne.debiter(montant);
                    compteBase.modifier(compteEpargne, compteChoix-1);
                    continuer(sc);
                    break;
                case 13:
                    banques = banqueBase.recupererTout();
                    clients = clientBase.recupererTout();
                    for(Banque banque1 : banques){
                        String numeroCmpte = banque1.getCodebanque();
                        int nbreClient = 0, nbreCompteEpargne = 0, nbreCompteCourants = 0;
                        for(Client cl : clients){
                            if(cl.getBanque()!=null && Objects.equals(cl.getBanque().getCodebanque(), numeroCmpte)){
                                nbreClient++;
                                for(Compte account : cl.getComptes()){
                                    if(account instanceof CEpargne) nbreCompteEpargne++;
                                    if(account instanceof CCourant) nbreCompteCourants++;
                                }
                            }
                        }
                        System.out.println(
                                banque1.getNombanque()+
                                        "\n- Clients: "+ nbreClient
                                        +" - Comptes courants: "+ nbreCompteCourants
                                        +" - Comptes épargne: "+ nbreCompteEpargne);
                    }
                    continuer(sc);
                    break;
            }
        }while(choix!=14);
        System.out.println("Fermeture...");
    }

    public static int menu(Scanner sc){
        int choix;
        do{
            System.out.println("\n*** Menu ***\n");
            System.out.println("1-Créer une banque\n" +
                    "2-Lister les banques\n" +
                    "3-Créer un client\n" +
                    "4-Rattacher un client à une banque\n" +
                    "5-Créer un compte d’épargne\n" +
                    "6-Rattacher un compte d’épargne à un client\n" +
                    "7-Créer un compte courant\n" +
                    "8-Rattacher un compte courant à un client\n" +
                    "9-Lister les comptes courants\n" +
                    "10- Lister les comptes d’épargne\n" +
                    "11- Créditer un compte courant d’un montant \n" +
                    "donné\n" +
                    "12- Débiter un compte d’épargne d’un montant \n" +
                    "donné\n" +
                    "13- Déterminer pour chaque banque, le nombre \n" +
                    "de clients, le nombre de comptes d’épargne et le \n" +
                    "nombre de comptes courants\n" +
                    "14- Sortie");
            System.out.println("Veuillez faire votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
        }while(choix>14 || choix<1);
        return choix;
    }

    public static void continuer(Scanner sc){
        System.out.println("\nAppuyer sur la touche entrer pour continuer");
        sc.nextLine();
    }

    public static <T> int selectionner(Scanner sc, List<T> liste){
        int choix;
        do{
            for(int i=1; i<liste.size(); i++){
                System.out.println(i+" "+liste.get(i-1).toString());
            }
            System.out.println("Veuillez faire votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
        }while(choix<1 || choix>liste.size());
        return choix;
    }

    // Le numéro de compte est généré automatiquement
    // Exemple : CKe25012025-1443
    // numero de compte = Les 2 premières lettres du titulaire + E/C + La date
    public static String genererNumeroCompte(Compte compte) {
        LocalDateTime dateTime = LocalDateTime.now();
        /* ddMMyyyyHHmm = 25012025-1443 */
        DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("ddMMyyyy-HHmm");

        String number="";
        if (compte instanceof CEpargne) number +="E";
        if (compte instanceof CCourant) number +="C";
        number+= compte.getTitulaireCompte().substring(0,2);
        number+=dateTime.format(dateTimePattern);
        return number;
    }
}