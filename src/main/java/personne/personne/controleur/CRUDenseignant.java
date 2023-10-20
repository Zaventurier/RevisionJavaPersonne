package personne.personne.controleur;

import personne.personne.Connexion.Connexion;

import java.sql.*;

public class CRUDenseignant {
    /**
     * CRUD -
     * Create : OUI ; Verif : Non
     * Read : OK ; Vérif : Ok
     * Update : NON ; Verif : Non
     * Delete : NON ; Vérif : Non
     */

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

    public void creerEnseignant(int id, int nombreCours, String specialite) throws SQLException {
        connexion.connect();

        String insertQuery = "INSERT INTO enseignant (id, nombreCours, specialite) VALUES (?,?,?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(insertQuery)) {
            con.setInt(1, id);
            con.setInt(2, nombreCours);
            con.setString(3, specialite);
            con.executeUpdate();
            System.out.println("Succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la personne : " + e.getMessage());
        }
    }

    public void deleteEnseignant(int id) throws SQLException {
        connexion.connect();

        String delete = "DELETE FROM enseignant WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, id);
            con.executeUpdate();
            System.out.println("Supression effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la personne : " + e.getMessage());
        }
    }

    public void updateEnseignant(int id, int nombreCours, String specialite) throws SQLException {
        connexion.connect();

        String delete = "UPDATE enseignant SET nombreCours = ?, specialite = ? WHERE id = (?)";
        try (PreparedStatement con = connexion.getConnection().prepareStatement(delete)) {
            con.setInt(1, nombreCours);
            con.setString(2, specialite);
            con.setInt(3, id);
            con.executeUpdate();
            System.out.println("Modification effectué avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de la personne : " + e.getMessage());
        }
    }
}
