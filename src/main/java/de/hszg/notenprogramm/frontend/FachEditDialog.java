package de.hszg.notenprogramm.frontend;

import de.hszg.notenprogramm.model.Fach;
import de.hszg.notenprogramm.model.Lehrplan;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class FachEditDialog {
    @FXML
    public TextField bezeichnungInput;
    @FXML
    public Spinner<Integer> ectsInput;
    @FXML
    public Spinner<Integer> semesterInput;

    public void initialize() {
        ectsInput.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, 5, 1));
        semesterInput.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 1, 1));


        Platform.runLater(bezeichnungInput::requestFocus);

    }

    public void cancel() {
        bezeichnungInput.getScene().getWindow().hide();
    }

    public void ok() {
        final String titel = bezeichnungInput.getText();

        final Lehrplan lehrplan = Lehrplan.getInstance();

        if(titel != null && !titel.trim().isEmpty()) {
            if(lehrplan.isFachTitelBelegt(titel)) {
                System.out.println("Es existiert bereits ein Fach mit dem Titel \"" + titel + "\"");
                return;
            }

            lehrplan.addFach(new Fach(titel, ectsInput.getValue(), semesterInput.getValue()));
        }

        bezeichnungInput.getScene().getWindow().hide();
    }
}
