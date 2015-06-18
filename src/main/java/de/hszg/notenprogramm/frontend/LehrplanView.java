package de.hszg.notenprogramm.frontend;

import de.hszg.notenprogramm.model.Fach;
import de.hszg.notenprogramm.model.Lehrplan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LehrplanView {

    @FXML
    public TableView<Fach> faecherTable;
    @FXML
    public TableColumn<Fach, String> fachColumn;
    @FXML
    public TableColumn<Fach, Integer> semesterColumn;
    @FXML
    public TableColumn<Fach, Integer> noteColumn;
    @FXML
    public TableColumn<Fach, Integer> ectsColumn;

    private Lehrplan lehrplan = Lehrplan.getInstance();

    private ObservableList<Fach> faecherList = FXCollections.observableArrayList();

    public void initialize() {
        faecherTable.setItems(faecherList);
        updateFaecherListe();


        fachColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));
        semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        ectsColumn.setCellValueFactory(new PropertyValueFactory<>("ectsPoints"));

    }

    public void fachAnlegen() throws IOException {

        final URL resource = this.getClass().getResource("/fxml/FachEditDialog.fxml");
        if(resource != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(resource);

            Stage dialogStage = new Stage();

            fxmlLoader.load();
            final Parent root = fxmlLoader.getRoot();

            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();

            updateFaecherListe();
        }
    }

    private void updateFaecherListe() {
        faecherList.setAll(lehrplan.getFaecher());
    }
}
