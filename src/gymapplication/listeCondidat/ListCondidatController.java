/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.listeCondidat;

import gymapplication.DBConnection;
import gymapplication.accueil.FXMLAccueilController;
//import gymapplication.FXMLDocumentController;
import gymapplication.accueil.ajouteCondidat.AjouteCondidatController;
import gymapplication.listeCondidat.list.ListCondidat;
import gymapplication.listeCondidat.list.ListCondidatStatic;
import static gymapplication.program.FXMLProgrammesController.s2;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private Stage stagesuppression = new Stage();
    private Stage stageModification = new Stage();
    public static Stage staticstageModification = new Stage();

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
    private TableColumn<ListCondidat, String> columnSexe;
    @FXML
    private TableColumn<ListCondidat, String> columnProgramme;

    ListCondidat CurrentCondidat = new ListCondidat();
    ListCondidatStatic CurrentCondidatStatic = new ListCondidatStatic();

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField fxRechercher;

    private Stage stageAjouter = new Stage();
    public static Stage staticstageAjouter = new Stage();

    @FXML
    private Button btnClose;

    String items = null;

    //public  Stage stage ;
    @FXML
    public void quit() {
        stageAjouter.close();
        stageModification.close();
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }

    private void initTable() {
        columnCIN.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("cin"));
        columnNom.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("nom"));
        columnAge.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("age"));
        columnTel.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("tel"));
        columnSexe.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("sexe"));
        columnProgramme.setCellValueFactory(new PropertyValueFactory<ListCondidat, String>("nomProgramme"));

    }

    private void selectCondidat() {

        CurrentCondidat = (ListCondidat) tableCondidat.getSelectionModel().getSelectedItem();
       
            CurrentCondidatStatic.setCin(CurrentCondidat.getCin());
            CurrentCondidatStatic.setNom(CurrentCondidat.getNom());
            CurrentCondidatStatic.setSexe(CurrentCondidat.getSexe());
            CurrentCondidatStatic.setAge(CurrentCondidat.getAge());
            CurrentCondidatStatic.setTel(CurrentCondidat.getTel());
            CurrentCondidatStatic.setNomProgramme(CurrentCondidat.getNomProgramme());
        
    }

    private void uploadTableCondidatWithOutProgram() throws SQLException {
        listC.clear();
        String sql = "select Condidat.idCondidat,Nom_Prenom,Age,Tele,Sexe,idProg from Condidat where idProg not in (select idProg from Condidat,Programme where Condidat.idProg= Programme.idProgramme)";

        tableCondidat.getItems().clear();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            ListCondidat condidat = new ListCondidat();
            condidat.setCin(rs.getString(1));
            condidat.setNom(rs.getString(2));
            condidat.setAge(rs.getString(3));
            condidat.setTel(rs.getString(4));
            condidat.setSexe(rs.getString(5));
            condidat.setNomProgramme(rs.getString(6));
            listC.add(condidat);
            tableCondidat.setItems(listC);
        }

        pst.close();
        rs.close();
    }

    private void uploadTableCondidatWithProgram() throws SQLException {

        String sql = "select Condidat.idCondidat,Nom_Prenom,Age,Tele,Sexe,Programme.Nom_Programme from Condidat,Programme where Condidat.idProg= Programme.idProgramme";

        // tableCondidat.getItems().clear();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            ListCondidat condidat = new ListCondidat();
            condidat.setCin(rs.getString(1));
            condidat.setNom(rs.getString(2));
            condidat.setAge(rs.getString(3));
            condidat.setTel(rs.getString(4));
            condidat.setSexe(rs.getString(5));
            condidat.setNomProgramme(rs.getString(6));
            listC.add(condidat);
            tableCondidat.setItems(listC);
        }

        pst.close();
        rs.close();
    }

    @FXML
    private void ajouteCondidat() throws IOException {
        try {

            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/listeCondidat/FXMLAjouteCondidat.fxml"));
            Scene scene1 = new Scene(root2);
            scene1.setFill(new Color(0, 0, 0, 0));
            // GYMApplication.mainStage.hide();
            stageAjouter.setScene(scene1);
            staticstageAjouter = stageAjouter;
            stageAjouter.show();

        } catch (IOException ex) {
            Logger.getLogger(ListCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifierCondidat() {
        try {
            
                selectCondidat();

                Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/listeCondidat/FXMLModifierCondidat.fxml"));
                Scene scene1 = new Scene(root2);
                scene1.setFill(new Color(0, 0, 0, 0));
                // GYMApplication.mainStage.hide();
                stageModification.setScene(scene1);
                staticstageModification = stageModification;
                stageModification.show();
           
        } catch (IOException ex) {
            Logger.getLogger(ListCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimerCondidat() {
        try {
            selectCondidat();

            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/listeCondidat/FXMLConfermationSuppression.fxml"));
            Scene scene1 = new Scene(root2);

            // GYMApplication.mainStage.hide();
            stagesuppression.setScene(scene1);
            stagesuppression.show();

        } catch (IOException ex) {
            Logger.getLogger(ListCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void RechercheCondidat() throws SQLException {

        if (fxRechercher == null || fxRechercher.getText().equals("")) {
            uploadTableCondidatWithOutProgram();
            uploadTableCondidatWithProgram();
        } else {
            listC.clear();
            RechercheCondidatWithOutProgram();
            RechercheCondidatWithProgram();

        }
    }

    @FXML
    public void RechercheCondidatWithOutProgram() throws SQLException {
        String ConditionSQL = "(select idProg from Condidat,Programme where Condidat.idProg= Programme.idProgramme)";

        String sql = "select Condidat.idCondidat,Nom_Prenom,Age,Tele,Sexe from Condidat where (Condidat.idProg not in " + ConditionSQL + ") and (Condidat.idCondidat like '%" + fxRechercher.getText().toLowerCase() + "%' OR lower(Condidat.Nom_Prenom) LIKE '" + fxRechercher.getText().toLowerCase() + "%' OR Condidat.Tele LIKE '%" + fxRechercher.getText().toLowerCase() + "%')";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ListCondidat condidat = new ListCondidat();
                condidat.setCin(rs.getString(1));
                condidat.setNom(rs.getString(2));
                condidat.setAge(rs.getString(3));
                condidat.setTel(rs.getString(4));
                condidat.setSexe(rs.getString(5));
                condidat.setNomProgramme("Aucun");
                listC.add(condidat);
                tableCondidat.setItems(listC);
            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void RechercheCondidatWithProgram() throws SQLException {
        String sql = "select Condidat.idCondidat,Nom_Prenom,Age,Tele,Sexe,Programme.Nom_Programme from Condidat,Programme where (Condidat.idProg= Programme.idProgramme) and (Condidat.idCondidat like '%" + fxRechercher.getText().toLowerCase() + "%' OR lower(Condidat.Nom_Prenom) LIKE '" + fxRechercher.getText().toLowerCase() + "%' OR Condidat.Tele LIKE '%" + fxRechercher.getText().toLowerCase() + "%')";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ListCondidat condidat = new ListCondidat();
                condidat.setCin(rs.getString(1));
                condidat.setNom(rs.getString(2));
                condidat.setAge(rs.getString(3));
                condidat.setTel(rs.getString(4));
                condidat.setSexe(rs.getString(5));
                condidat.setNomProgramme(rs.getString(6));
                listC.add(condidat);
                tableCondidat.setItems(listC);
            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageAjouter.initModality(Modality.APPLICATION_MODAL);
        stageAjouter.initStyle(StageStyle.TRANSPARENT);
        stageModification.initModality(Modality.APPLICATION_MODAL);
        stageModification.initStyle(StageStyle.TRANSPARENT);
        listC = FXCollections.observableArrayList();
        initTable();
        conn = DBConnection.EtablirConnection();
        try {
            uploadTableCondidatWithOutProgram();
            uploadTableCondidatWithProgram();
        } catch (SQLException ex) {
            Logger.getLogger(ListCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
