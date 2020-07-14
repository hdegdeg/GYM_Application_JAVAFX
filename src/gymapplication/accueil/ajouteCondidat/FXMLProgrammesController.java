/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.accueil.ajouteCondidat;

import gymapplication.program.*;
import com.jfoenix.controls.JFXTextField;
import gymapplication.DBConnection;
import gymapplication.Programme.list.ListeProgramme;
import gymapplication.accueil.FXMLAccueilController;
import gymapplication.accueil.*;
import gymapplication.listeCondidat.list.ListCondidat;
//import gymapplication.FXMLDocumentController;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
 * @author hdegd
 */
public class FXMLProgrammesController implements Initializable {

    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private Label fxEX1;

    @FXML
    private Label fxEX2;

    @FXML
    private Label fxEX3;

    @FXML
    private Label fxEX4;

    @FXML
    private Label fxEX5;

    @FXML
    private Label fxEX6;

    @FXML
    private Label fxEX7;

    @FXML
    private Label fxEX8;

    @FXML
    private Label fxEX9;

    @FXML
    private Label fxEX10;

    @FXML
    private JFXTextField tfSeries1;

    @FXML
    private JFXTextField tfRepet1;

    @FXML
    private JFXTextField tfSeries2;

    @FXML
    private JFXTextField tfRepet2;

    @FXML
    private JFXTextField tfSeries3;

    @FXML
    private JFXTextField tfRepet3;

    @FXML
    private JFXTextField tfSeries4;

    @FXML
    private JFXTextField tfRepet4;

    @FXML
    private JFXTextField tfSeries5;

    @FXML
    private JFXTextField tfRepet5;

    @FXML
    private JFXTextField tfSeries6;

    @FXML
    private JFXTextField tfRepet6;

    @FXML
    private JFXTextField tfSeries7;

    @FXML
    private JFXTextField tfRepet7;

    @FXML
    private JFXTextField tfSeries8;

    @FXML
    private JFXTextField tfRepet8;

    @FXML
    private JFXTextField tfSeries9;

    @FXML
    private JFXTextField tfRepet9;

    @FXML
    private JFXTextField tfSeries10;

    @FXML
    private JFXTextField tfRepet10;

    

    @FXML
    private JFXTextField tfNom1;

    @FXML
    private JFXTextField tfNom2;

    @FXML
    private JFXTextField tfNom3;

    @FXML
    private JFXTextField tfNom4;

    @FXML
    private JFXTextField tfNom5;

    @FXML
    private JFXTextField tfNom6;

    @FXML
    private JFXTextField tfNom7;

    @FXML
    private JFXTextField tfNom8;

    @FXML
    private JFXTextField tfNom9;

    @FXML
    private JFXTextField tfNom10;

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
    
    // Parent root;
     public static Stage s2=new Stage();
     private Stage stage = new Stage ();
    @FXML
    private AnchorPane AnchorPane;
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
      // scene.setFill(new Color(0,0,0,0));
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
             InterfaceProgramme.stageProgramme.setScene(InterfaceProgramme.sceneProgramme);
             
                FXMLConfermationModificationController.acess=false;
        } catch (IOException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
        /*
           
          ListeProgramme currentProgramme=(ListeProgramme)TableProg.getSelectionModel().getSelectedItem();
           currentIdProgramme=currentProgramme.getIdprog();
    
           
              try {
    
            
         Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLConfermationModification.fxml"));
         Scene scene1 = new Scene(root2);
          
         // GYMApplication.mainStage.hide();
        s2.setScene(scene1);
        s2.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLProgrammesController.class.getName()).log(Level.SEVERE, null, ex);
        }
            */ 
    
     
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
