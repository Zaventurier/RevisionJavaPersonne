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
        DriverManager.getConnection("jdbc:mysql://localhost:3306/personne", "root", "root");
    }


    public void close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }

    }

    public Connection getConnection() {
        return this.connection;
    }
}
