package de.hszg.notenprogramm.frontend;

import de.hszg.notenprogramm.model.Fach;
import de.hszg.notenprogramm.model.Lehrplan;
import de.hszg.notenprogramm.util.PubSub;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;

import java.util.List;
import java.util.stream.Collectors;

public class DurchschnittController {

    @FXML
    public Label aktuell;
    @FXML
    public Label bestCase;
    @FXML
    public Label worstCase;
    @FXML
    public LineChart durchschnittChart;

    private Lehrplan lehrplan = Lehrplan.getInstance();


    public void initialize() {
        PubSub.subscribe("UPDATE_NOTES", this::update);
    }

    private void update() {
        calcMean();
    }

    private void calcMean() {
        final List<Fach> facherMitNoten = lehrplan.getFaecher().stream()
                .filter(fach -> fach.getNote() != null)
                .collect(Collectors.toList());

        final double weightedSum = facherMitNoten.stream()
                .mapToDouble(fach -> fach.getNote() * fach.getEctsPoints())
                .sum();

        final int ectsSum = facherMitNoten.stream()
                .mapToInt(Fach::getEctsPoints)
                .sum();

        double mean =  weightedSum / ectsSum;

        aktuell.setText(String.format("%.1f", mean));
    }
}
