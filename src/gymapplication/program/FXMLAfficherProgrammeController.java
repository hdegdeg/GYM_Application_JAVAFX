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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @FXML
    private Button btnClose;

    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();

    FXMLProgrammesController currentProgramme= new FXMLProgrammesController();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        System.out.println("gymapplication.program.:"+currentProgramme.currentIdProgramme);
       ConnectionDB();
       uploadTableProgramme();
       
    }    

        public void ConnectionDB(){
            
              conn=DBConnection.EtablirConnection();
        }
     private void uploadTableProgramme()  {
        try {
            ListeProgramme Programme;
           String currentText;
               String sql = "select Nom_Programme from Programme where idProgramme=' "+currentProgramme.currentIdProgramme+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
            nomProg.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            }
           
             sql = "select muscles from Jour where idProgramme=' "+currentProgramme.currentIdProgramme+"' and NomJ='Jour 1'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
            textFJrs1.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            
            sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' "+currentProgramme.currentIdProgramme+"' and idJour='Jour 1'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while (rs.next()) {
                  currentText=FxListeExo1.getText();
                  FxListeExo1.setText(currentText+"Exo: "+rs.getString(1)+", "+rs.getString(3)+" Series,"+" "+ rs.getString(2)+" Rep \n");
              }
            pst.close();
            rs.close();
            }
          ///////////////////////////////////////////////////////////////////////////////////////////////////  
            sql = "select muscles from Jour where idProgramme=' "+currentProgramme.currentIdProgramme+"' and NomJ='Jour 2'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
            textFJrs2.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            
            sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' "+currentProgramme.currentIdProgramme+"' and idJour='Jour 2'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while (rs.next()) {
                  currentText=FxListeExo2.getText();
                  FxListeExo2.setText(currentText+"Exo: "+rs.getString(1)+", "+rs.getString(3)+" Series,"+" "+ rs.getString(2)+" Rep \n");
              }
            pst.close();
            rs.close();
            }
            
            ///////////////////////////////////////////////////////
            sql = "select muscles from Jour where idProgramme=' "+currentProgramme.currentIdProgramme+"' and NomJ='Jour 3'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
           if(rs.next()){
            textFJrs3.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            
            sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' "+currentProgramme.currentIdProgramme+"' and idJour='Jour 3'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while (rs.next()) {
                  currentText=FxListeExo3.getText();
                  FxListeExo3.setText(currentText+"Exo: "+rs.getString(1)+", "+rs.getString(3)+" Series,"+" "+ rs.getString(2)+" Rep \n");
              }
            pst.close();
            rs.close();
           }
           
           ///////////////////////////////////////////////////////////////////////////////////////////
            sql = "select muscles from Jour where idProgramme=' "+currentProgramme.currentIdProgramme+"' and NomJ='Jour 4'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
           if(rs.next()){
            textFJrs4.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            
           sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' "+currentProgramme.currentIdProgramme+"' and idJour='Jour 4'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while (rs.next()) {
                  currentText=FxListeExo4.getText();
                  FxListeExo4.setText(currentText+"Exo: "+rs.getString(1)+", "+rs.getString(3)+" Series,"+" "+ rs.getString(2)+" Rep \n");
              }
            pst.close();
            rs.close();
           }
           ///////////////////////////////////////////////////////////////////////////////////////
           
            sql = "select muscles from Jour where idProgramme=' "+currentProgramme.currentIdProgramme+"' and NomJ='Jour 5'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
            textFJrs5.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            
            sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' "+currentProgramme.currentIdProgramme+"' and idJour='Jour 5'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while (rs.next()) {
                  currentText=FxListeExo5.getText();
                  FxListeExo5.setText(currentText+"Exo: "+rs.getString(1)+", "+rs.getString(3)+" Series,"+" "+ rs.getString(2)+" Rep \n");
              }
            pst.close();
            rs.close();
            }
            
            /////////////////////////////////////////////////////////////////////////////////
            
            
            sql = "select muscles from Jour where idProgramme=' "+currentProgramme.currentIdProgramme+"' and NomJ='Jour 6'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
            textFJrs6.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            
             sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' "+currentProgramme.currentIdProgramme+"' and idJour='Jour 6'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while (rs.next()) {
                  currentText=FxListeExo6.getText();
                  FxListeExo6.setText(currentText+"Exo: "+rs.getString(1)+", "+rs.getString(3)+" Series,"+" "+ rs.getString(2)+" Rep \n");
              }
            pst.close();
            rs.close();
            }
            
            sql = "select muscles from Jour where idProgramme=' "+currentProgramme.currentIdProgramme+"' and NomJ='Jour 7'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
            textFJrs7.setText(rs.getString(1)); 
            pst.close();
            rs.close();
            
            sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' "+currentProgramme.currentIdProgramme+"' and idJour='Jour 7'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while (rs.next()) {
                  currentText=FxListeExo7.getText();
                  FxListeExo7.setText(currentText+"Exo: "+rs.getString(1)+", "+rs.getString(3)+" Series,"+" "+ rs.getString(2)+" Rep \n");
              }
            pst.close();
            rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void Retour(MouseEvent event) {
        
              try {
            
            
            InterfaceProgramme.rootProgramme = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(InterfaceProgramme.rootProgramme);
          
            stageProgramme.setScene(scene1);
            stageProgramme.show();
            
             
            
        } catch (IOException ex) {
            System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
         }
    }

    @FXML
    private void Valider(MouseEvent event) {
    }

    @FXML
    private void quit(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
  }
    
}
