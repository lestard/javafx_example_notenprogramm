package de.hszg.notenprogramm;

import de.hszg.notenprogramm.model.TestDataGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class App extends Application {

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        TestDataGenerator.generate();

        String path = "/fxml/LehrplanView.fxml";

        final URL resource = this.getClass().getResource(path);
        if(resource == null) {
            throw new IllegalStateException("Kann fxml datei \"" + path + "\" nicht finden");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        fxmlLoader.load();

        Parent root = fxmlLoader.getRoot();


        stage.setScene(new Scene(root));
        stage.show();
    }
}
