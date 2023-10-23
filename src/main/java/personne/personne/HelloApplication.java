package personne.personne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import personne.personne.Connexion.Connexion;
import personne.personne.CRUD.CRUDpersonne;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Connexion con = new Connexion();
        CRUDpersonne cruDoperation = new CRUDpersonne(con);

    }

    public static void main(String[] args) {
        launch();
    }
}