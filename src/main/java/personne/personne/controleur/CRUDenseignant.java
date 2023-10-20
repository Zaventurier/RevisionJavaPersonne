package personne.personne.controleur;

import personne.personne.Connexion.Connexion;

import java.sql.*;

public class CRUDenseignant {

    Connexion connexion = new Connexion();

    public CRUDenseignant(Connexion connexion){
        this.connexion = connexion;
    }

    public void readAllEnseignant() throws SQLException{
        //
        connexion.connect();


        String sqlQuery = "SELECT personne.nom, nombreCours, specialite FROM personne INNER JOIN enseignant ON enseignant.id = personne.id";

        PreparedStatement con = connexion.getConnection().prepareStatement(sqlQuery);

        // Exécution de la requête
        ResultSet resultSet = con.executeQuery(sqlQuery);

        // Parcourir les résultats et afficher les enregistrements
        while (resultSet.next()) {
            String nom = resultSet.getString("nom");
            int nbCours = resultSet.getInt("nombreCours");
            String spe = resultSet.getString("specialite");

            System.out.println("Nom: " + nom + ", NombreCours: " + nbCours + ", Spécialité: " + spe);
        }
    }
}
