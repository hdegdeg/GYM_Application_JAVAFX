/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.listeCondidat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author gharbi abdelillah
 */
public class ListCondidatController implements Initializable {

    @FXML
    private TableView<?> tableCondidat;
    @FXML
    private TableColumn<?, ?> columnCIN;
    @FXML
    private TableColumn<?, ?> columnNom;
    @FXML
    private TableColumn<?, ?> columnAge;
    @FXML
    private TableColumn<?, ?> columnTel;
    @FXML
    private TableColumn<?, ?> columnAbonnement;
    @FXML
    private TableColumn<?, ?> column;
    @FXML
    private AnchorPane AnchorPane;

    private Stage stage = new Stage();

    /**
     * Initializes the controller class.
     */
    @FXML
    private void ajouteCondidat(ActionEvent event) throws IOException {
        AnchorPane.setOpacity(0.4);
        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/ajouteCondidat/ajouteCondidat.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(new Color(0, 0, 0, 0));
        stage.setScene(scene);
        stage.showAndWait();
        AnchorPane.setOpacity(1);
    }

    @FXML
    private void modifierCondidat(ActionEvent event) {
    }

    @FXML
    private void supprimerCondidat(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
    }

}
