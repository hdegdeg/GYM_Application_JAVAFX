/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;

import com.jfoenix.controls.JFXTextField;
import gymapplication.DBConnection;
import gymapplication.Programme.list.ListeProgramme;
import gymapplication.accueil.FXMLAccueilController;
import gymapplication.accueil.*;
import gymapplication.listeCondidat.list.ListCondidat;
import java.io.File;
//import gymapplication.FXMLDocumentController;
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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
public class FXMLProgrammesController implements Initializable {

    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private ObservableList<ListeProgramme> listProg;
    @FXML
    private TableView<ListeProgramme> TableProg;

    @FXML
    private TableColumn<ListeProgramme, String> columnIdProg;

    @FXML
    private TableColumn<ListeProgramme, String> columnNomProg;

    @FXML
    private TableColumn<ListeProgramme, String> columnNombreJ;
    
    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();
    private int nombreExo;
    
    public static String currentIdProgramme;
    JRDataSource datasource;
    JasperReport jpsr;
    JasperPrint jsprPrint;
    // Parent root;
     public static Stage s2=new Stage();
     private Stage stage = new Stage ();
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button btnClose;
    @FXML
    private TextField fxRechercher;
    
    
    
    
    @FXML
    private void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
     
    /**
     * Initializes the controller class.
     */
    
      
    
    private void initTable() {
        columnIdProg.setCellValueFactory(new PropertyValueFactory<ListeProgramme, String>("idprog"));
        columnNomProg.setCellValueFactory(new PropertyValueFactory<ListeProgramme, String>("nomprog"));
        columnNombreJ.setCellValueFactory(new PropertyValueFactory<ListeProgramme, String>("nbjourprog"));

    }


      public void ConnectionDB(){
            
              conn=DBConnection.EtablirConnection();
              listProg=FXCollections.observableArrayList();
        }
      
      
    @FXML
    public void RechercheCondidat() throws SQLException
    {

        
        if(fxRechercher==null || fxRechercher.getText().equals(""))
        {
            uploadTableProgramme();
        }else{
        listProg.clear();
        String sql="select idProgramme,Nom_Programme,Nombre_Jours from Programme where (idProgramme like '%"+fxRechercher.getText().toLowerCase()+"%' OR lower(Nom_Programme) LIKE '%"+fxRechercher.getText().toLowerCase()+"%' OR Nombre_Jours LIKE '%"+fxRechercher.getText().toLowerCase()+"%')";
            
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                ListeProgramme Programme = new ListeProgramme();
                Programme.setIdprog(rs.getString(1));
                Programme.setNomprog(rs.getString(2));
                Programme.setNbjourprog(rs.getString(3));
               listProg.add(Programme);
               TableProg.setItems(listProg);
            }
             pst.close();
           rs.close();
          
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
        }
    }
     private void uploadTableProgramme()  {
        try {
            ListeProgramme Programme;
           
            
            TableProg.getItems().clear();
             String sql = "select idProgramme,Nom_Programme,Nombre_Jours from Programme ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
               if(!rs.getString(1).equals("1"))
               {
                Programme = new ListeProgramme();
                Programme.setIdprog(rs.getString(1));
                Programme.setNomprog(rs.getString(2));
                Programme.setNbjourprog(rs.getString(3));
                System.out.println("gymapplication: "+Programme.getIdprog()+""+Programme.getNomprog()+""+Programme.getNbjourprog());
               listProg.add(Programme);
                TableProg.setItems(listProg);
               }
            }
            
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @FXML
    void supprimer(MouseEvent event) {
           
       
        try {
    
            
         Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLConfermationSuppression.fxml"));
         Scene scene1 = new Scene(root2);
         //scene1.setFill(new Color(0, 0, 0, 0));
         // GYMApplication.mainStage.hide();
        s2.setScene(scene1);
        s2.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    }
    
    @FXML
    void AjouterProgramme(MouseEvent event) throws IOException {
           
           AnchorPane.setOpacity(0.4);
       Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouterProgramme.fxml"));
       InterfaceProgramme.sceneProgramme = new Scene(root);
       InterfaceProgramme.sceneProgramme.setFill(new Color(0,0,0,0));
       InterfaceProgramme.stageProgramme.setScene(InterfaceProgramme.sceneProgramme);
       //InterfaceProgramme.stageProgramme.showAndWait();
      // AnchorPane.setOpacity(1);
       

    }
    
    @FXML
    private void AfficherProgramme() {
        
           
          ListeProgramme currentProgramme=(ListeProgramme)TableProg.getSelectionModel().getSelectedItem();
           currentIdProgramme=currentProgramme.getIdprog();
    
         try {

             Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAfficherProgramme.fxml"));
              InterfaceProgramme.sceneProgramme  = new Scene(root2);
              InterfaceProgramme.sceneProgramme.setFill(new Color(0,0,0,0));
              InterfaceProgramme.stageProgramme.setScene(InterfaceProgramme.sceneProgramme);

        } catch (IOException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    @FXML
    private void ModifierProgramme() {
                ListeProgramme currentProgramme=(ListeProgramme)TableProg.getSelectionModel().getSelectedItem();
           currentIdProgramme=currentProgramme.getIdprog();
           if(!currentIdProgramme.equals("") && !currentIdProgramme.equals(null))
           {
                 try {

             Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierProgramme.fxml"));
              InterfaceProgramme.sceneProgramme  = new Scene(root2);
              InterfaceProgramme.sceneProgramme.setFill(new Color(0,0,0,0));
              InterfaceProgramme.stageProgramme.setScene(InterfaceProgramme.sceneProgramme);
             
                FXMLConfermationModificationController.acess=false;
        } catch (IOException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
           }

    }
    
    
        private void SelectionnerTableProgramme() throws SQLException, JRException {
        
            
            ListeProgramme currentProgramme=(ListeProgramme)TableProg.getSelectionModel().getSelectedItem();
           currentIdProgramme=currentProgramme.getIdprog();
           
           
                jpsr= JasperCompileManager.compileReport("E:\\degdeg\\DEGDEG\\NetBeansProjects\\GYMApplication\\src\\gymapplication\\FicheProgramme.jrxml");
                JRDataSource datasource=new JREmptyDataSource();
                Map<String,Object> parametre=new HashMap<String, Object>();
               
                
            String currentText="";
            String sql = "select Nom_Programme from Programme where idProgramme=' " + currentProgramme.getIdprog() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("NOM",rs.getString(1));
                pst.close();
                rs.close();
            }

            currentText="";
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.getIdprog() + "' and NomJ='Jour 1'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("M1" ,rs.getString(1));
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.getIdprog() + "' and idJour='Jour 1'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = currentText+"Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n";
                    parametre.put("X1" ,currentText);
                }
                pst.close();
                rs.close();
            }else{parametre.put("M1" ,"Repos");}
            ///////////////////////////////////////////////////////////////////////////////////////////////////  
            currentText="";
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.getIdprog() + "' and NomJ='Jour 2'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("M2" ,rs.getString(1));
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.getIdprog() + "' and idJour='Jour 2'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = currentText+"Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n";
                    parametre.put("X2" ,currentText);}
                pst.close();
                rs.close();
            }else{parametre.put("M2" ,"Repos");}

            ///////////////////////////////////////////////////////
            currentText="";
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.getIdprog() + "' and NomJ='Jour 3'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("M3" ,rs.getString(1));
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.getIdprog() + "' and idJour='Jour 3'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = currentText+"Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n";
                    parametre.put("X3" ,currentText);}
                pst.close();
                rs.close();
            }else{parametre.put("M3" ,"Repos");}

            ///////////////////////////////////////////////////////////////////////////////////////////
            currentText="";
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.getIdprog() + "' and NomJ='Jour 4'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("M4" ,rs.getString(1));
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.getIdprog() + "' and idJour='Jour 4'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = currentText+"Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n";
                    parametre.put("X4" ,currentText);}
                pst.close();
                rs.close();
            }else{parametre.put("M4" ,"Repos");}
            
            ///////////////////////////////////////////////////////////////////////////////////////
            currentText="";
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.getIdprog() + "' and NomJ='Jour 5'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("M5" ,rs.getString(1));
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.getIdprog() + "' and idJour='Jour 5'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = currentText+"Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n";
                    parametre.put("X5" ,currentText);}
                pst.close();
                rs.close();
            }else{parametre.put("M5" ,"Repos");}
            
            /////////////////////////////////////////////////////////////////////////////////
            currentText="";
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.getIdprog() + "' and NomJ='Jour 6'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("M6" ,rs.getString(1));
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.getIdprog() + "' and idJour='Jour 6'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = currentText+"Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n";
                    parametre.put("X6" ,currentText);}
                pst.close();
                rs.close();
            }else{parametre.put("M6" ,"Repos");}
            
            ////////////////////////////////////////////////////////////////////////////////////////
            currentText="";
            sql = "select muscles from Jour where idProgramme=' " + currentProgramme.getIdprog() + "' and NomJ='Jour 7'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                parametre.put("M7" ,rs.getString(1));
                pst.close();
                rs.close();

                sql = "select Nom_Exo,Nombre_Repetition,Nombre_Series from Exercice where idProgramme=' " + currentProgramme.getIdprog() + "' and idJour='Jour 7'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    currentText = currentText+"Exo: " + rs.getString(1) + ", " + rs.getString(3) + " Series," + " " + rs.getString(2) + " Rep \n";
                    parametre.put("X7" ,currentText);}
                pst.close();
                rs.close();
            }else{parametre.put("M1" ,"Repos");}
       
        pst.close();
        rs.close();
    }
        
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage.initModality(Modality.APPLICATION_MODAL);
       stage.initStyle(StageStyle.TRANSPARENT);
       
       ConnectionDB();
        initTable() ;
       uploadTableProgramme();
    } 
}
