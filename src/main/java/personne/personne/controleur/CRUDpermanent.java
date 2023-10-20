package personne.personne.controleur;

import personne.personne.Connexion.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDpermanent {

    Connexion connexion = new Connexion();

    public CRUDpermanent(Connexion connexion){
        this.connexion = connexion;
    }

    public void readAllPermanent() throws SQLException {
        //
        connexion.connect();


        String sqlQuery = "SELECT personne.nom, numeroBureau FROM personne INNER JOIN permanent ON permanent.id = personne.id";

        PreparedStatement con = connexion.getConnection().prepareStatement(sqlQuery);

        // Exécution de la requête
        ResultSet resultSet = con.executeQuery(sqlQuery);

        // Parcourir les résultats et afficher les enregistrements
        while (resultSet.next()) {
            String nom = resultSet.getString("nom");
            int numBureau = resultSet.getInt("numeroBureau");

            System.out.println("Nom: " + nom + ", NuméroBureau: " + numBureau);
        }
    }
}
