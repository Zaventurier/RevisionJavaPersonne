package personne.personne.controleur;

import personne.personne.Connexion.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDvendeur {

    Connexion connexion = new Connexion();

    public CRUDvendeur(Connexion connexion){
        this.connexion = connexion;
    }

    public void readAllVendeur() throws SQLException {
        //
        connexion.connect();


        String sqlQuery = "SELECT personne.nom, anciennete, nomDuStand FROM personne INNER JOIN vendeur ON vendeur.id = personne.id";

        PreparedStatement con = connexion.getConnection().prepareStatement(sqlQuery);

        // Exécution de la requête
        ResultSet resultSet = con.executeQuery(sqlQuery);

        // Parcourir les résultats et afficher les enregistrements
        while (resultSet.next()) {
            String nom = resultSet.getString("nom");
            int anciennete = resultSet.getInt("anciennete");
            String nomDuStand = resultSet.getString("nomDuStand");

            System.out.println("Nom: " + nom + ", Ancienneté: " + anciennete + " NomduStand:" + nomDuStand);
        }
    }
}
