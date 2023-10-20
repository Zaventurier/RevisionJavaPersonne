package personne.personne.controleur;

import personne.personne.Connexion.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDvacataire {

    Connexion connexion = new Connexion();

    public CRUDvacataire(Connexion connexion){
        this.connexion = connexion;
    }

    public void readAllVacataire() throws SQLException {
        //
        connexion.connect();


        String sqlQuery = "SELECT personne.nom, nombreVacations FROM personne INNER JOIN vacataire ON vacataire.id = personne.id";

        PreparedStatement con = connexion.getConnection().prepareStatement(sqlQuery);

        // Exécution de la requête
        ResultSet resultSet = con.executeQuery(sqlQuery);

        // Parcourir les résultats et afficher les enregistrements
        while (resultSet.next()) {
            String nom = resultSet.getString("nom");
            int nbVacations = resultSet.getInt("nombreVacations");

            System.out.println("Nom: " + nom + ", NombreVacations: " + nbVacations);
        }
    }
}
