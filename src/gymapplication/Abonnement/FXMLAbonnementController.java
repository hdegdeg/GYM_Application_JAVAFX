/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Abonnement;

import gymapplication.Abonnement.list.ListAbonnement;
import gymapplication.Abonnement.list.StaticListAbonnement;
import gymapplication.DBConnection;

//import gymapplication.FXMLDocumentController;
import gymapplication.listeCondidat.list.ListCondidat;
import gymapplication.listeCondidat.list.ListCondidatStatic;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLAbonnementController implements Initializable {

    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public ObservableList <ListAbonnement> Abonnement;
  
    public static Stage s2 = new Stage();
    
    @FXML
    private TableView<ListAbonnement> fxTbAbonnement;

    @FXML
    private TableColumn<ListAbonnement, String> fxIdAbon;

    @FXML
    private TableColumn<ListAbonnement, String> fxAbonnee;
    
    @FXML
    private TableColumn<ListAbonnement, String> fxDebut;

    @FXML
    private TableColumn<ListAbonnement, String> fxFin;

    @FXML
    private TableColumn<ListAbonnement, String> fxNombre;

    @FXML
    private TableColumn<ListAbonnement, String> fxType;

    @FXML
    private TableColumn<ListAbonnement, String> fxCondidat;

   //  @FXML
    // public AnchorPane AnchorPaneAbonnement;
     ListAbonnement Labonnement= new  ListAbonnement();
    
    StaticListAbonnement StaticLabonnement = new StaticListAbonnement();
    @FXML
    private AnchorPane AnchorPaneAbonnement;
    @FXML
    private Button btnClose;
    
  @FXML
    private void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    private void initTable() {
      
        fxIdAbon.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("idAbonnement2"));
        fxAbonnee.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Namebonnée"));
        fxDebut.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Date_Debut"));
        fxFin.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Date_Fin"));
        fxNombre.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Nombre_Mois"));
        fxType.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Type"));
                                                                            
        fxCondidat.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("idCondidat"));

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConnectionDB();
        initTable();
        try {
            recupererAbonnement();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
     public void ConnectionDB()
        {
            
              con=DBConnection.EtablirConnection();
              Abonnement=FXCollections.observableArrayList();
        }
     
     
    @FXML
    void supprimer(MouseEvent event) {
           
        Labonnement=(ListAbonnement)fxTbAbonnement.getSelectionModel().getSelectedItem();
           
           //FXMLRounouvellementController.s3.close();
          
           StaticLabonnement.setIdAbonnement2(Labonnement.getIdAbonnement2());
           StaticLabonnement.setDate_Debut(Labonnement.getDate_Debut());
           StaticLabonnement.setDate_Fin(Labonnement.getDate_Fin());
           StaticLabonnement.setNombre_Mois(Labonnement.getNombre_Mois());
           StaticLabonnement.setType(Labonnement.getType());
           StaticLabonnement.setIdCondidat(Labonnement.getIdCondidat());
           
           
        try {
    
         //   AnchorPane.setOpacity(0.4);
          //  AnchorPane.setDisable(true);
            
            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLSupprimerAbonnement.fxml"));
             Scene scene1 = new Scene(root2);
          //  scene1.setFill(new Color(0,0,0,0));

            s2.setScene(scene1);
            s2.show();
        
        
          //  AnchorPane.setOpacity(1);
          //  AnchorPane.setDisable(false);
        
        
             

    }   catch (IOException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @FXML
    void Rounouvellement(MouseEvent event) {
           
       
        try {
    
            
       //      AnchorPaneAbonnement.setOpacity(0.4);
            // AnchorPane.setDisable(true);
            
             Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLRounouvellement.fxml"));
             Scene scene1 = new Scene(root2);
            // scene1.setFill(new Color(0,0,0,0));

             s2.setScene(scene1);
             s2.show();
        
        
           //  AnchorPaneAbonnement.setOpacity(1);
             //AnchorPane.setDisable(false);
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    }
     public void recupererAbonnement() throws SQLException
    {
        Abonnement.clear();
        String sql1 ="select Abonnement.idAbonnement,Abonnement.Date_Debut,Date_Fin,Nombre_Mois,Type ,Abonnement.idCondidat , Condidat.Nom_Prenom  From Abonnement INNER JOIN Condidat ON Abonnement.idCondidat = Condidat.idCondidat ";

            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
                   

            while(rs.next())
            { 
                ListAbonnement M=new ListAbonnement();
                M.setIdAbonnement2(rs.getString(1));
                M.setDate_Debut(rs.getString(2));
                M.setDate_Fin(rs.getString(3));
                M.setNombre_Mois(rs.getString(4));
                M.setType(rs.getString(5));
                M.setIdCondidat(rs.getString(6));
                M.setNamebonnée(rs.getString(7));
                
                Abonnement.add(M);
                fxTbAbonnement.setItems(Abonnement);
               
                
                System.out.println("gymapplication...recupererAbonnement()"+M.getIdAbonnement2()+M.getIdCondidat());
                
                
            }
             pst.close();
           rs.close();
            

    }
     
     
     
      @FXML
    private void modifierCondidat(MouseEvent event) {
        
           
           Labonnement=(ListAbonnement)fxTbAbonnement.getSelectionModel().getSelectedItem();
           
           //FXMLRounouvellementController.s3.close();
          
           StaticLabonnement.setIdAbonnement2(Labonnement.getIdAbonnement2());
           StaticLabonnement.setDate_Debut(Labonnement.getDate_Debut());
           StaticLabonnement.setDate_Fin(Labonnement.getDate_Fin());
           StaticLabonnement.setNombre_Mois(Labonnement.getNombre_Mois());
           StaticLabonnement.setType(Labonnement.getType());
           StaticLabonnement.setIdCondidat(Labonnement.getIdCondidat());
         
         try {
    
            
            // AnchorPane.setOpacity(0.4);
            // AnchorPane.setDisable(true);
            
             Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLModifierAbonnement.fxml"));
             Scene scene1 = new Scene(root2);
             //scene1.setFill(new Color(0,0,0,0));

             s2.setScene(scene1);
             s2.show();
        
        
          //   AnchorPane.setOpacity(1);
             
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
