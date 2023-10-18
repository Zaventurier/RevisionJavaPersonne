package personne.personne.vue;

import java.sql.*;
import java.util.Scanner;

import personne.personne.Connexion.Connexion;
import personne.personne.controleur.CRUDpersonne;

public class main {
    public static void main(String[] args) throws SQLException {
        /**
         * Ce fichier me permet de tester les CRUD
         */

        Scanner sc = new Scanner(System.in);
        Connexion connector = new Connexion();
        CRUDpersonne personne = new CRUDpersonne(connector);

        /*System.out.println("Création d'une personne -");

        System.out.println("Saisir son nom :");
        String nom = sc.nextLine();

        System.out.println("NumSécu : ");
        int numsecu = sc.nextInt();

        personne.creerPersonne(nom, numsecu);*/

        //personne.readAllPersonne();

        personne.deletePersonne(3);

    }
}
