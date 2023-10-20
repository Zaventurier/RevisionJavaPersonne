package personne.personne.controleur;

import personne.personne.Connexion.Connexion;

import java.sql.*;


/**
 * Class de CRUD pour créer une personne
 */
public class CRUDpersonne {
    Connexion connexion = new Connexion();


    public CRUDpersonne(Connexion connexion){
        this.connexion = connexion;
    }

    /**
     * Methode creerPersonne
     */
    public void creerPersonne(String nom, int numSecu) throws SQLException {
        connexion.connect();

        String insertQuery = "INSERT INTO personne (nom, numeroSecu) VALUES (?,?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(insertQuery)) {
            con.setString(1, nom);
            con.setInt(2, numSecu);
            con.executeUpdate();
            System.out.println("La personne " + nom + " à été inséré avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la personne : " + e.getMessage());
        }

    }

    public void readAllPersonne() throws SQLException {
        connexion.connect();


        String sqlQuery = "SELECT * FROM personne";

        PreparedStatement con = connexion.getConnection().prepareStatement(sqlQuery);

        // Exécution de la requête
        ResultSet resultSet = con.executeQuery(sqlQuery);

        // Parcourir les résultats et afficher les enregistrements
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            int numSecu = resultSet.getInt("numeroSecu");

            System.out.println("ID: " + id + ", Nom: " + nom + ", numSecu: " + numSecu);
        }
    }

    public void deletePersonne(int id) throws SQLException {
        connexion.connect();

        String delete = "DELETE FROM personne WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, id);
            con.executeUpdate();
            System.out.println("Supression effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la personne : " + e.getMessage());
        }
    }

    public void setPersonne(int id, String nom, int numSecu) throws SQLException {
        connexion.connect();

        String delete = "UPDATE personne SET nom = ?, numeroSecu = ? WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setString(1, nom);
            con.setInt(2, numSecu);
            con.setInt(3, id);
            con.executeUpdate();
            System.out.println("Modification effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de la personne : " + e.getMessage());
        }
    }

}
