package de.hszg.notenprogramm.frontend;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotenEingabeDialog {



    public static double show(double previousNote) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Spinner<Double> spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 4.0, previousNote, 0.1));


        Button okButton = new Button("OK");
        root.getChildren().addAll(spinner, okButton);

        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(root));

        okButton.setOnAction(event -> {
            dialogStage.close();
        });

        dialogStage.showAndWait();



        return spinner.getValue();
    }

    public static double show() {
        return show(1.0);
    }

}
