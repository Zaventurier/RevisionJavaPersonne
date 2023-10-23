package personne.personne.CRUD;

import personne.personne.Connexion.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDavocat {
    /**
     * CRUD -
     * Create : OK ; Verif : Non
     * Read : OK ; Vérif : Ok
     * Update : OK ; Verif : Non
     * Delete : OK ; Vérif : Non
     */

    Connexion connexion = new Connexion();


    /**
     * CRUDAvocat - Constructeur de la class
     * @param connexion
     * @return
     * @Author : PASCAIL Guillaume
     */
    public CRUDavocat(Connexion connexion){
        this.connexion = connexion;
    }


    /**
     * creerAvocat - Créer un Avocat
     * @param id
     * @param nombreAffaires
     * @param adresse
     * @throws SQLException
     * @return
     * @Author PASCAIL Guillaume
     */
    public void creerAvocat(int id, int nombreAffaires, String adresse) throws SQLException {
        connexion.connect();

        String insertQuery = "INSERT INTO avocat (id, nombreAffaires, adresseCabinet) VALUES (?,?,?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(insertQuery)) {
            con.setInt(1, id);
            con.setInt(2, nombreAffaires);
            con.setString(3, adresse);
            con.executeUpdate();
            System.out.println("Succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la personne : " + e.getMessage());
        }
    }


    /**
     * readAllAvocat - Récupère tout les avocats enregistrés
     * @throws SQLException
     * @return
     * @Authot PASCAIL Guillaume
     */
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


    /**
     * deleteAvocat - Supprime un avocat
     * @param id
     * @throws SQLException
     * @return
     * @Author PASCAIL Guillaume
     */
    public void deleteAvocat(int id) throws SQLException {
        connexion.connect();

        String delete = "DELETE FROM avocat WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, id);
            con.executeUpdate();
            System.out.println("Supression effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la personne : " + e.getMessage());
        }
    }


    /**
     * updateAvocat - Met à jour un avocat
     * @param id
     * @param nombreAffaires
     * @param adresse
     * @throws SQLException
     * @return
     * @Author PASCAIL Guillaume
     */
    public void updateAvocat(int id, int nombreAffaires, String adresse) throws SQLException {
        connexion.connect();

        String delete = "UPDATE avocat SET nombreAffaires = ?, adresse = ? WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, nombreAffaires);
            con.setString(2, adresse);
            con.setInt(3, id);
            con.executeUpdate();
            System.out.println("Modification effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de la personne : " + e.getMessage());
        }
    }
}