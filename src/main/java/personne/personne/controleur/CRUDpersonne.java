package personne.personne.controleur;

import personne.personne.modele.Connexion;

import java.sql.SQLException;


/**
 * Class de CRUD pour créer une personne
 */
public class CRUDpersonne {
    Connexion connexion = new Connexion();
    String bdd = "personne";
    String util = "root";
    String passwd = "";
    String jdbcUrl = "jdbc:mysql://localhost:3306/personne";


    public void test() throws SQLException {
        connexion.connect(jdbcUrl, util, passwd);
    }

    /**
     * Methode creerPersonne
     */
    public void creerPersonne(){

    }

}
