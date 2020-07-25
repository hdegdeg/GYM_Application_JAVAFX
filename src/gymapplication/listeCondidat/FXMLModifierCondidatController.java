/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.listeCondidat;

import gymapplication.accueil.ajouteCondidat.*;
import gymapplication.DBConnection;
import gymapplication.accueil.FXMLAccueilController;
import gymapplication.listeCondidat.list.ListCondidatStatic;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author gharbi abdelillah
 */
public class FXMLModifierCondidatController implements Initializable {
    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    @FXML
    public Label lblCaption;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfNumTel;
    @FXML
    private TextField tfSexe;
    @FXML
    private TextField tfProgramme;
    @FXML
    private ComboBox<String> comboAbonnement;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private Label lblFinDate;
    @FXML
    private TextField tfNbrMois;
    @FXML
    private Button btnClose;
    @FXML
    private TextField tfCIN;
    
    @FXML
    private ComboBox<String> comboType;
    
    String typeAbonnement;
    @FXML
    private Label lblFinAbonnement;
    @FXML
    private Label lblNbrMois;
    @FXML
    private Label lblType;
    @FXML
    private Label lblDateDebut;
    
    Stage stage = new Stage();
    public static String staticProgramme = "";
    ListCondidatStatic CurrentCondidatStatic = new ListCondidatStatic();
    FXMLAccueilController Accueil = new FXMLAccueilController();
    // @FXML
    // public Button btnModifier;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void quit() {
        ListCondidatController.staticstageModification.close();
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        
    }
    
    void initCondidat() throws SQLException {
        tfCIN.setText(CurrentCondidatStatic.getCin());
        tfNom.setText(CurrentCondidatStatic.getNom());
        tfAge.setText(CurrentCondidatStatic.getAge());
        tfNumTel.setText(CurrentCondidatStatic.getTel());
        tfSexe.setText(CurrentCondidatStatic.getSexe());
        tfProgramme.setText(CurrentCondidatStatic.getNomProgramme());
        
        String sql = "select idProg from Condidat where idCondidat='" + CurrentCondidatStatic.getCin() + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            staticProgramme = rs.getString(1);
        } else {
            staticProgramme = "1";
        }
        pst.close();
        rs.close();
    }
    
    void updateNomProgramme() throws SQLException {
        String sql = "select Nom_Programme from Programme where idProgramme='" + staticProgramme + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            tfProgramme.setText(rs.getString(1));
        }
        pst.close();
        rs.close();
    }
    
    @FXML
    void Programme() throws SQLException {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/ajouteCondidat/FXMLProgrammesCondidat.fxml"));
            Scene scene1 = new Scene(root);
            scene1.setFill(new Color(0, 0, 0, 0));
            stage.setScene(scene1);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateNomProgramme();
    }
    
    @FXML
    private void ModifierCondidat() {
        System.out.println("gymapplication.*********************" + staticProgramme);
        try {
            if (!isEmpty()) {
                String sql = "update Condidat  set  idCondidat=?, Nom_Prenom=? ,Age=? ,Tele=?,Sexe=?, idProg=?  where idCondidat= '" + CurrentCondidatStatic.getCin() + "'";
                pst = conn.prepareStatement(sql);
                pst.setString(1, tfCIN.getText());
                pst.setString(2, tfNom.getText());
                pst.setString(3, tfAge.getText());
                pst.setString(4, tfNumTel.getText());
                pst.setString(5, tfSexe.getText());
                pst.setString(6, staticProgramme);
                pst.executeUpdate();
                pst.close();
                rs.close();
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("Sucess :   ");
                alert.setContentText("le condidat :" + "  '" + tfNom.getText() + "' " + "a été Modifier avec succès");
                alert.showAndWait();
                quit();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur :   ");
                alert.setContentText("Vérifiez les données du condidat!!!");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
    }

    ///////////////    pour verifier les champ vide /////////////////
    private boolean isEmpty() {
        boolean isEmpty = false;
        System.out.println("id)" + tfCIN.getText() + "  nom" + tfNom.getText() + "  age" + tfAge.getText() + "  tel" + tfNumTel.getText() + "   sex" + tfSexe.getText());
        if (tfCIN.getText() == null || tfCIN.getText().toString().equals("")
                || tfNom.getText() == null || tfNom.getText().toString().equals("")
                || tfAge.getText() == null || tfAge.getText().toString().equals("")
                || tfNumTel.getText() == null || tfNumTel.getText().toString().equals("")
                || tfSexe.getText() == null || tfSexe.getText().toString().equals("")) {
            isEmpty = true;
        }        
        
        return isEmpty;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        
        conn = DBConnection.EtablirConnection();
        try {
            initCondidat();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLModifierCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
