package personne.personne.CRUD;

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


    public void creerVendeur(int id, int anciennete, String nomStand) throws SQLException {
        connexion.connect();

        String insertQuery = "INSERT INTO vendeur (id, anciennete, nomDuStand) VALUES (?,?,?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(insertQuery)) {
            con.setInt(1, id);
            con.setInt(2, anciennete);
            con.setString(3, nomStand);
            con.executeUpdate();
            System.out.println("Succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la personne : " + e.getMessage());
        }
    }

    public void deleteVendeur(int id) throws SQLException {
        connexion.connect();

        String delete = "DELETE FROM vendeur WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, id);
            con.executeUpdate();
            System.out.println("Supression effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la personne : " + e.getMessage());
        }
    }

    public void updateVendeur(int id, int anciennete, String nomStand) throws SQLException {
        connexion.connect();

        String delete = "UPDATE vendeur SET anciennete = ?, nomDuStand = ? WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, anciennete);
            con.setString(2, nomStand);
            con.setInt(3, id);
            con.executeUpdate();
            System.out.println("Modification effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de la personne : " + e.getMessage());
        }
    }
}
