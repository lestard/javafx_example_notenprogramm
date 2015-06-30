package de.hszg.notenprogramm.controller;

import de.hszg.notenprogramm.model.Fach;
import de.hszg.notenprogramm.model.Lehrplan;
import de.hszg.notenprogramm.util.PubSub;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.util.ArrayList;
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
    public AreaChart<Number, Number> durchschnittChart;

    private XYChart.Series<Number, Number> bestCaseSeries = new XYChart.Series<>();
    private XYChart.Series<Number, Number> worstCaseSeries = new XYChart.Series<>();

    private Lehrplan lehrplan = Lehrplan.getInstance();


    public void initialize() {

        PubSub.subscribe("UPDATE_NOTES", this::update);

        bestCaseSeries.setName("Best Case");
        worstCaseSeries.setName("Worst Case");

        durchschnittChart.getData().add(bestCaseSeries);
        durchschnittChart.getData().add(worstCaseSeries);

        update();
    }

    private void update() {
        updateMean();

        final long size = lehrplan.getFaecher()
                .stream()
                .filter(fach -> fach.getNote() != null)
                .count();

        if(size > 0) {
            double bestCaseMean = calcCharts(bestCaseSeries, 1.0);
            double worstCaseMean = calcCharts(worstCaseSeries, 4.0);

            bestCase.setText(formatMean(bestCaseMean));
            worstCase.setText(formatMean(worstCaseMean));
        }
    }

    private double calcCharts(XYChart.Series<Number, Number> series, double defaultValue) {
        series.getData().clear();

        List<Fach> tmp = new ArrayList<>();

        int i=0;

        double result = defaultValue;

        for (Fach fach : lehrplan.getFaecher()) {
            i++;

            if(fach.getNote() == null) {
                final Fach tmpFach = new Fach(fach.getTitel(), fach.getEctsPoints(), fach.getSemester());
                tmpFach.setNote(defaultValue);
                tmp.add(tmpFach);
            } else {
                tmp.add(fach);
            }

            result = calcMean(tmp);

            series.getData().add(new XYChart.Data<>(i, result));
        }

        return result;
    }

    private void updateMean() {
        final List<Fach> facherMitNoten = lehrplan.getFaecher().stream()
                .filter(fach -> fach.getNote() != null)
                .collect(Collectors.toList());

        double mean = calcMean(facherMitNoten);

        if(Double.isNaN(mean)) {
            aktuell.setText("");
        } else {
            aktuell.setText(formatMean(mean));
        }
    }


    private double calcMean(List<Fach> faecher) {
        final double weightedSum = faecher.stream()
                .mapToDouble(fach -> fach.getNote() * fach.getEctsPoints())
                .sum();

        final int ectsSum = faecher.stream()
                .mapToInt(Fach::getEctsPoints)
                .sum();

        return weightedSum / ectsSum;
    }


    private String formatMean(double mean) {
        return String.format("%.1f", mean);
    }
}
