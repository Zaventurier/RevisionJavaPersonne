package personne.personne.controleur;

import personne.personne.Connexion.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDavocat {

    Connexion connexion = new Connexion();

    public CRUDavocat(Connexion connexion){
        this.connexion = connexion;
    }

    public void readAllAvocat() throws SQLException {
        //
        connexion.connect();


        String sqlQuery = "SELECT personne.nom, nombreAffaires, adresseCabinet FROM personne INNER JOIN avocat ON avocat.id = personne.id";

        PreparedStatement con = connexion.getConnection().prepareStatement(sqlQuery);

        // Exécution de la requête
        ResultSet resultSet = con.executeQuery(sqlQuery);

        // Parcourir les résultats et afficher les enregistrements
        while (resultSet.next()) {
            String nom = resultSet.getString("nom");
            int nbAffaires = resultSet.getInt("nombreAffaires");
            String adresse = resultSet.getString("adresseCabinet");

            System.out.println("Nom: " + nom + ", NombreAffaires: " + nbAffaires + ", Adresse: " + adresse);
        }
    }
}
