package personne.personne.CRUD;

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


    public void creerPermanent(int id, int numeroBureau) throws SQLException {
        connexion.connect();

        String insertQuery = "INSERT INTO permanent (id, numeroBureau) VALUES (?,?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(insertQuery)) {
            con.setInt(1, id);
            con.setInt(2, numeroBureau);
            con.executeUpdate();
            System.out.println("Succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la personne : " + e.getMessage());
        }
    }

    public void deletePermanent(int id) throws SQLException {
        connexion.connect();

        String delete = "DELETE FROM permanent WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, id);
            con.executeUpdate();
            System.out.println("Supression effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la personne : " + e.getMessage());
        }
    }

    public void updatePermanent(int id, int numBureau) throws SQLException {
        connexion.connect();

        String delete = "UPDATE permament SET numBureau = ? WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, numBureau);
            con.setInt(2, id);
            con.executeUpdate();
            System.out.println("Modification effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de la personne : " + e.getMessage());
        }
    }
}
