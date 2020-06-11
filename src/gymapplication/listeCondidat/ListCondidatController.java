/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.listeCondidat;

import gymapplication.DBConnection;
import gymapplication.accueil.ajouteCondidat.AjouteCondidatController;
import gymapplication.listeCondidat.list.ListCondidat;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private ObservableList<ListCondidat> listC;

    @FXML
    private TableView<ListCondidat> tableCondidat;
    @FXML
    private TableColumn<ListCondidat, String> columnCIN;
    @FXML
    private TableColumn<ListCondidat, String> columnNom;
    @FXML
    private TableColumn<ListCondidat, String> columnAge;
    @FXML
    private TableColumn<ListCondidat, String> columnTel;
    @FXML
    private TableColumn<ListCondidat, String> columnAbonnement;
    @FXML
    private TableColumn<ListCondidat, String> columnDebut;
    @FXML
    private TableColumn<ListCondidat, String> columnFin;
    @FXML
    private AnchorPane AnchorPane;

    private Stage stage = new Stage();

    /**
     * Initializes the controller class.
     */
    private void initTable() {
        columnCIN.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("cin"));
        columnNom.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("nom"));
        columnAge.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("age"));
        columnTel.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("tel"));
        columnAbonnement.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("abonnement"));
        columnDebut.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("debut"));
        columnFin.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("fin"));

    }

    private void uploadTableCondidat() throws SQLException {
        String sql = "select Condidat.idCondidat,Nom_Prenom,Age,Tele,Type,Date_Debut,Date_Fin from Condidat INNER JOIN Abonnement ON Condidat.idCondidat = Abonnement.idCondidat order by Nom_Prenom asc";
        tableCondidat.getItems().clear();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            ListCondidat condidat = new ListCondidat();
            condidat.setCin(rs.getString(1));
            condidat.setNom(rs.getString(2));
            condidat.setAge(rs.getString(3));
            condidat.setTel(rs.getString(4));
            condidat.setAbonnement(rs.getString(5));
            condidat.setDebut(rs.getString(6));
            condidat.setFin(rs.getString(7));
            listC.add(condidat);
            tableCondidat.setItems(listC);
        }

        pst.close();
        rs.close();
    }

    @FXML
    private void ajouteCondidat(ActionEvent event) throws IOException {
        AjouteCondidatController condidat;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/gymapplication/accueil/ajouteCondidat/ajouteCondidat.fxml"));
        AnchorPane.setOpacity(0.4);
        Parent root = fxmlLoader.load();
        condidat = fxmlLoader.getController();
        condidat.lblCaption.setText("Modifier un Condidat");
        condidat.btnModifier.setVisible(true);
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

        listC = FXCollections.observableArrayList();
        initTable();
        conn = DBConnection.EtablirConnection();
        try {
            uploadTableCondidat();
        } catch (SQLException ex) {
            Logger.getLogger(ListCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
