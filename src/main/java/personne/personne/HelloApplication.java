package personne.personne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import personne.personne.controleur.CRUDpersonne;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        CRUDpersonne cruDoperation = new CRUDpersonne();
        try{
            cruDoperation.test();
            System.out.println("OK");
        }catch (SQLException e){
            System.out.println("Erreur");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}