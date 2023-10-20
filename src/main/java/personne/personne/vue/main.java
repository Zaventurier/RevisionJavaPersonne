package personne.personne.vue;

import java.sql.*;
import java.util.Scanner;

import personne.personne.Connexion.Connexion;
import personne.personne.controleur.CRUDpersonne;
import personne.personne.controleur.CRUDenseignant;
import personne.personne.controleur.CRUDpermanent;
import personne.personne.controleur.CRUDavocat;
import personne.personne.controleur.CRUDvacataire;
import personne.personne.controleur.CRUDvendeur;

public class main {
    public static void main(String[] args) throws SQLException {
        /**
         * Ce fichier me permet de tester les CRUD
         */

        Scanner sc = new Scanner(System.in);
        Connexion connector = new Connexion();
        CRUDpersonne personne = new CRUDpersonne(connector);
        CRUDenseignant enseignant = new CRUDenseignant(connector);
        CRUDpermanent permanent = new CRUDpermanent(connector);
        CRUDavocat avocat = new CRUDavocat(connector);
        CRUDvacataire vacataire = new CRUDvacataire(connector);
        CRUDvendeur vendeur = new CRUDvendeur(connector);

        enseignant.readAllEnseignant();
        permanent.readAllPermanent();
        avocat.readAllAvocat();
        vacataire.readAllVacataire();
        vendeur.readAllVendeur();

        /*System.out.println("Création d'une personne -");

        System.out.println("Saisir son nom :");
        String nom = sc.nextLine();

        System.out.println("NumSécu : ");
        int numsecu = sc.nextInt();*/

        //personne.creerPersonne(nom, numsecu);

        //personne.readAllPersonne();

        //personne.deletePersonne(3);

        //personne.setPersonne(4, "aaaaa", 789456123);

    }
}
