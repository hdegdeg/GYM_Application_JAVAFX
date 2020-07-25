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
import javafx.scene.control.TextField;
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
  
    private  Stage s2 = new Stage();
    public static Stage stageforPublic = new Stage();
    
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
    
     @FXML
    private TableColumn<ListAbonnement, String> fxPrix;

   //  @FXML
    // public AnchorPane AnchorPaneAbonnement;
     ListAbonnement Labonnement= new  ListAbonnement();
    
    StaticListAbonnement StaticLabonnement = new StaticListAbonnement();
    @FXML
    private AnchorPane AnchorPaneAbonnement;
    @FXML
    private Button btnClose;
     @FXML
    private TextField fxRechercher;
    
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
        fxPrix.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Prix"));                                                                 
        fxCondidat.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("idCondidat"));

    }
    

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
     
     private void selectionnerAbonnement(){
                    
           Labonnement=(ListAbonnement)fxTbAbonnement.getSelectionModel().getSelectedItem();

           StaticLabonnement.setIdAbonnement2(Labonnement.getIdAbonnement2());
           StaticLabonnement.setDate_Debut(Labonnement.getDate_Debut());
           StaticLabonnement.setDate_Fin(Labonnement.getDate_Fin());
           StaticLabonnement.setNombre_Mois(Labonnement.getNombre_Mois());
           StaticLabonnement.setType(Labonnement.getType());
            StaticLabonnement.setPrix(Labonnement.getPrix());
           StaticLabonnement.setIdCondidat(Labonnement.getIdCondidat());
     }
     
     
                 @FXML
      public void RechercheCondidat() throws SQLException
    {

        
        if(fxRechercher==null || fxRechercher.getText().equals(""))
        {
            recupererAbonnement();
        }else{
        Abonnement.clear();
        String sql="select Abonnement.idAbonnement,Abonnement.Date_Debut,Date_Fin,Nombre_Mois,Type,Prix ,Abonnement.idCondidat , Condidat.Nom_Prenom  From Abonnement,Condidat where (Abonnement.idCondidat = Condidat.idCondidat)  and  (Abonnement.idCondidat like '"+fxRechercher.getText().toLowerCase()+"%' OR lower(Condidat.Nom_Prenom) LIKE '%"+fxRechercher.getText().toLowerCase()+"%' )";
            
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                ListAbonnement M=new ListAbonnement();
                M.setIdAbonnement2(rs.getString(1));
                M.setDate_Debut(rs.getString(2));
                M.setDate_Fin(rs.getString(3));
                M.setNombre_Mois(rs.getString(4));
                M.setType(rs.getString(5));
                M.setPrix(rs.getString(6));
                M.setIdCondidat(rs.getString(7));
                M.setNamebonnée(rs.getString(8));
                
                Abonnement.add(M);
                fxTbAbonnement.setItems(Abonnement);
            }
             pst.close();
           rs.close();
          
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
        }
    }
    @FXML
    void supprimer(MouseEvent event) {
           
     selectionnerAbonnement();
           
        try {

            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLConfermationSuppression.fxml"));
             Scene scene1 = new Scene(root2);

            s2.setScene(scene1);
            stageforPublic = s2;
            s2.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void Rounouvellement(MouseEvent event) {

        try {

             Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLConfermationRounouvellement.fxml"));
             Scene scene1 = new Scene(root2);

             s2.setScene(scene1);
             s2.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    }
     public void recupererAbonnement() throws SQLException
    {
        Abonnement.clear();
        String sql1 ="select Abonnement.idAbonnement,Abonnement.Date_Debut,Date_Fin,Nombre_Mois,Type,Prix ,Abonnement.idCondidat , Condidat.Nom_Prenom  From Abonnement INNER JOIN Condidat ON Abonnement.idCondidat = Condidat.idCondidat ";

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
                M.setPrix(rs.getString(6));
                M.setIdCondidat(rs.getString(7));
                M.setNamebonnée(rs.getString(8));
                
                Abonnement.add(M);
                fxTbAbonnement.setItems(Abonnement);
               
  
            }
             pst.close();
           rs.close();
            

    }
     
     
     
      @FXML
    private void modifierCondidat(MouseEvent event) {
                selectionnerAbonnement();
         
         try {

             Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLConfermationModification.fxml"));
             Scene scene1 = new Scene(root2);

             s2.setScene(scene1);
             s2.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
