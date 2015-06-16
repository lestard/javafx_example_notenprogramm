package de.hszg.notenprogramm.frontend;

import de.hszg.notenprogramm.model.Fach;
import de.hszg.notenprogramm.model.Lehrplan;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class LehrplanView {

    @FXML
    public TextField bezeichnungInput;
    @FXML
    public Spinner<Integer> ectsInput;
    @FXML
    public ListView<String> faecherList;


    private Lehrplan lehrplan = new Lehrplan();


    public void initialize() {

        ectsInput.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, 5, 1));


    }

    public void fachAnlegen() {

        final String titel = bezeichnungInput.getText();

        if(titel != null && !titel.trim().isEmpty()) {
            if(lehrplan.isFachTitelBelegt(titel)) {
                System.out.println("Es existiert bereits ein Fach mit dem Titel \"" + titel + "\"");
                return;
            }

            lehrplan.addFach(new Fach(titel, ectsInput.getValue()));
            updateFaecherListe();
        }
    }

    private void updateFaecherListe() {
        faecherList.getItems().clear();

        lehrplan.getFaecher().stream()
                .map(fach -> fach.getTitel() + " (" + fach.getEctsPoints() + " ects)")
                .forEach(titel -> faecherList.getItems().add(titel));
    }
}
