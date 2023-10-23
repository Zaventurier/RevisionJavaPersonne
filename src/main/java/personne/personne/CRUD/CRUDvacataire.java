package personne.personne.CRUD;

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


    public void creerVacataire(int id, int nombreVacations) throws SQLException {
        connexion.connect();

        String insertQuery = "INSERT INTO vacataire (id, nombreVacations) VALUES (?,?,?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(insertQuery)) {
            con.setInt(1, id);
            con.setInt(2, nombreVacations);
            con.executeUpdate();
            System.out.println("Succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la personne : " + e.getMessage());
        }
    }

    public void deleteVacataire(int id) throws SQLException {
        connexion.connect();

        String delete = "DELETE FROM vacataire WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, id);
            con.executeUpdate();
            System.out.println("Supression effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la personne : " + e.getMessage());
        }
    }

    public void updateVacataire(int id, int nombreVacations) throws SQLException {
        connexion.connect();

        String delete = "UPDATE vacataire SET nombreVacations = ? WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, nombreVacations);
            con.setInt(2, id);
            con.executeUpdate();
            System.out.println("Modification effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de la personne : " + e.getMessage());
        }
    }
}
