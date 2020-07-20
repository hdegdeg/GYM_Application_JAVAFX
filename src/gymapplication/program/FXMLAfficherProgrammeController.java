/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import gymapplication.DBConnection;
import gymapplication.Programme.list.ListeProgramme;
import gymapplication.accueil.FXMLAccueilController;
import static gymapplication.accueil.FXMLAccueilController.stageProgramme;
import static gymapplication.program.FXMLProgrammesController.currentIdProgramme;
import static gymapplication.program.FXMLProgrammesController.s2;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLAfficherProgrammeController implements Initializable {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private JFXTextField nomProg;
    @FXML
    private Label jrs1;
    @FXML
    private Label jrs2;
    @FXML
    private Label jrs3;
    @FXML
    private Label jrs4;
    @FXML
    private Label jrs5;
    @FXML
    private Label jrs6;
    @FXML
    private Label jrs7;
    @FXML
    private JFXTextField textFJrs1;
    @FXML
    private JFXTextField textFJrs2;
    @FXML
    private JFXTextField textFJrs6;
    @FXML
    private JFXTextField textFJrs5;
    @FXML
    private JFXTextField textFJrs4;
    @FXML
    private JFXTextField textFJrs3;
    @FXML
    private JFXTextField textFJrs7;
    @FXML
    private JFXButton buttonValider;

    @FXML
    private JFXTextArea FxListeExo1;

    @FXML
    private JFXTextArea FxListeExo7;

    @FXML
    private JFXTextArea FxListeExo6;

    @FXML
    private JFXTextArea FxListeExo5;

    @FXML
    private JFXTextArea FxListeExo4;

    @FXML
    private JFXTextArea FxListeExo3;

    @FXML
    private JFXTextArea FxListeExo2;
    
    private String Nombre="";
    @FXML
    private Button btnClose;
    JRDataSource datasource;
    JasperReport jpsr;
    JasperPrint jsprPrint;

    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();

    FXMLProgrammesController currentProgramme = new FXMLProgrammesController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        initaliseChamps();
        ConnectionDB();
        try {
            uploadTableProgramme();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficherProgrammeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    private void initaliseChamps(){
        textFJrs1.setText("Repos");
        textFJrs2.setText("Repos");
        textFJrs6.setText("Repos");
        textFJrs5.setText("Repos");
        textFJrs4.setText("Repos");
        textFJrs3.setText("Repos");
        textFJrs7.setText("Repos");
        FxListeExo1.setText("Repos");
        FxListeExo7.setText("Repos");
        FxListeExo6.setText("Repos");
        FxListeExo5.setText("Repos");
        FxListeExo4.setText("Repos");
        FxListeExo3.setText("Repos");
        FxListeExo2.setText("Repos");
    }
    public void ConnectionDB() {

        conn = DBConnection.EtablirConnection();
    }

    private void uploadTableProgramme() throws SQLException {
        
            ListeProgramme Programme;
            String currentText;
            String sql = "select Nom_Programme,Nombre_Jours from Programme where idProgramme=' " + currentProgramme.currentIdProgramme + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                nomProg.setText(rs.getString(1));
                Nombre=rs.getString(2);
                pst.close();
                rs.close();
            }

            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 1'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                textFJrs1.setText(rs.getString(1));
                FxListeExo1.setText("");
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.currentIdProgramme + "' and idJour='Jour 1'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    
                    currentText = FxListeExo1.getText();
                    FxListeExo1.setText(currentText + "Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n");
                }
                pst.close();
                rs.close();
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////  
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 2'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                textFJrs2.setText(rs.getString(1));
                FxListeExo2.setText("");
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.currentIdProgramme + "' and idJour='Jour 2'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = FxListeExo2.getText();
                    FxListeExo2.setText(currentText + "Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n");
                }
                pst.close();
                rs.close();
            }

            ///////////////////////////////////////////////////////
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 3'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                textFJrs3.setText(rs.getString(1));
                FxListeExo3.setText("");
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.currentIdProgramme + "' and idJour='Jour 3'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = FxListeExo3.getText();
                    FxListeExo3.setText(currentText + "Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n");
                }
                pst.close();
                rs.close();
            }

            ///////////////////////////////////////////////////////////////////////////////////////////
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 4'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                textFJrs4.setText(rs.getString(1));
                FxListeExo4.setText("");
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.currentIdProgramme + "' and idJour='Jour 4'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = FxListeExo4.getText();
                    FxListeExo4.setText(currentText + "Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n");
                }
                pst.close();
                rs.close();
            }
            ///////////////////////////////////////////////////////////////////////////////////////

            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 5'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                textFJrs5.setText(rs.getString(1));
                FxListeExo5.setText("");
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.currentIdProgramme + "' and idJour='Jour 5'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = FxListeExo5.getText();
                    FxListeExo5.setText(currentText + "Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n");
                }
                pst.close();
                rs.close();
            }

            /////////////////////////////////////////////////////////////////////////////////
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 6'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                textFJrs6.setText(rs.getString(1));
                FxListeExo6.setText("");
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.currentIdProgramme + "' and idJour='Jour 6'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = FxListeExo6.getText();
                    FxListeExo6.setText(currentText + "Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n");
                }
                pst.close();
                rs.close();
            }

            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 7'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                textFJrs7.setText(rs.getString(1));
                FxListeExo7.setText("");
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.currentIdProgramme + "' and idJour='Jour 7'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = FxListeExo7.getText();
                    FxListeExo7.setText(currentText + "Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n");
                }
                pst.close();
                rs.close();
            }
       
        pst.close();
        rs.close();
    }

    
     public File save(){              

              FileChooser fileChooser=new FileChooser();
                  fileChooser.setInitialDirectory(new File("C:\\"));
                  
                    
                  
                  fileChooser.getExtensionFilters().addAll(
                          new FileChooser.ExtensionFilter("PDF Files","*")
                  );
                  
                  
                  File f=fileChooser.showSaveDialog(s2);
                  
         
         return f;
         }
         
             @FXML
    void ImprimerProgramme() {
               File f=save();

            try {
                SelectionnerProgramme();
                JasperExportManager.exportReportToPdfFile(jsprPrint,f.getPath()+".pdf");
                
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucess");
                    alert.setHeaderText("Sucess :   ");
                    alert.setContentText("Votre Programme a été enregistré avec succès vous le trouverez dans ce chemain :  "+f.getPath());
                    alert.showAndWait();
                    
            } catch (JRException ex) {
                Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
     

    }
        
    private void SelectionnerProgramme() throws JRException {

                jpsr= JasperCompileManager.compileReport("E:/degdeg/DEGDEG/NetBeansProjects/GYMApplication/src/gymapplication/Imprime.jrxml");
                JRDataSource Data=new JREmptyDataSource();
                     
                Map<String,Object> parametre=new HashMap<String, Object>();
                
                parametre.put("NOM",nomProg.getText());
                parametre.put("NOMBRE",Nombre);
                
                parametre.put("M1" ,textFJrs1.getText());
                parametre.put("X1" , FxListeExo1.getText());
                
                parametre.put("M2",textFJrs2.getText());
                parametre.put("X2",FxListeExo2.getText());
                
                parametre.put("M3",textFJrs3.getText());
                parametre.put("X3",FxListeExo3.getText());
                
                parametre.put("M4",textFJrs4.getText());
                parametre.put("X4",FxListeExo4.getText());
                
                parametre.put("M5",textFJrs5.getText());
                parametre.put("X5",FxListeExo5.getText());
                
                parametre.put("M6",textFJrs6.getText());
                parametre.put("X6",FxListeExo6.getText());
                
                parametre.put("M7",textFJrs7.getText()); 
                parametre.put("X7",FxListeExo7.getText());
                
                

            
                jsprPrint= JasperFillManager.fillReport(jpsr, parametre,Data);

     
    }
    
    
    @FXML
    private void Retour() {

        try {

            InterfaceProgramme.rootProgramme = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(InterfaceProgramme.rootProgramme);
            scene1.setFill(new Color(0, 0, 0, 0));

            stageProgramme.setScene(scene1);
            stageProgramme.show();

        } catch (IOException ex) {
            System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
        }
    }

    @FXML
    private void Valider() {
    }

    @FXML
    private void quit(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

}
