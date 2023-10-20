package personne.personne.Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private String jdbcUrl;
    private String username;
    private String password;
    private Connection connection;

    public Connexion() {

    }

    public void connect() throws SQLException {
        //
        //"jdbc:mysql://chevalapersonne.mysql.db:3306/chevalapersonne", "chevalapersonne", "BvG9F7A2GIz0E6o"
        DriverManager.getConnection("jdbc:mysql://localhost:3306/personne", "root", "");
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }
//public class Connexion {
}
