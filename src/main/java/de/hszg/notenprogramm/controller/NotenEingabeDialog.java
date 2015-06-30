package de.hszg.notenprogramm.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class NotenEingabeDialog extends Dialog<Double>{


    public NotenEingabeDialog(Double previousNote) {
        this.setTitle("Noten Dialog");
        this.setHeaderText("Bitte die Note eingeben");

        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType delete = new ButtonType("Löschen", ButtonBar.ButtonData.OTHER);
        ButtonType cancel = new ButtonType("Abbrechen", ButtonBar.ButtonData.CANCEL_CLOSE);

        getDialogPane().getButtonTypes().addAll(ok, delete, cancel);

        setResizable(true);

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        Spinner<Double> spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 4.0, previousNote == null ? 2.0 : previousNote, 0.1));

        root.getChildren().add(spinner);

        getDialogPane().setContent(root);

        setOnShown(e -> spinner.requestFocus());


        setResultConverter(dialogButton -> {
            if(dialogButton == ok) {
                return spinner.getValue();
            }

            if(dialogButton == delete) {
                return -1.0;
            }

            if(dialogButton == cancel) {
                return previousNote;
            }

            return null;
        });

    }
}
