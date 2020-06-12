/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Abonnement;

import gymapplication.Abonnement.list.ListAbonnement;
import gymapplication.DBConnection;
import gymapplication.FXMLDocumentController;
import gymapplication.listeCondidat.list.ListCondidat;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
  
    
    @FXML
    private TableView<ListAbonnement> fxTbAbonnement;

    @FXML
    private TableColumn<ListAbonnement, String> fxIdAbon;

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


    
  
    private void initTable() {
      
        fxIdAbon.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("idAbonnement2"));
        
        fxDebut.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Date_Debut"));
        fxFin.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Date_Fin"));
        fxNombre.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Nombre_Mois"));
        fxType.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("Type"));
        
        fxCondidat.setCellValueFactory(new PropertyValueFactory<ListAbonnement, String>("idAbonnement"));

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
           
       
        try {
    
            
         Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLConfermationSuppression.fxml"));
         Scene scene1 = new Scene(root2);
          
         // GYMApplication.mainStage.hide();
        s2.setScene(scene1);
        s2.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    }
    
    
    
     public void recupererAbonnement() throws SQLException
    {
        Abonnement.clear();
        String sql1 ="select Abonnement.idAbonnement,Abonnement.Date_Debut,Date_Fin,Nombre_Mois,Type ,Abonnement.idCondidat  From Abonnement INNER JOIN Condidat ON Abonnement.idCondidat = Condidat.idCondidat ";

            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
                   

            while(rs.next())
            { 
                ListAbonnement M=new ListAbonnement();
                M.setidAbonnement(rs.getString(1));
                M.setDate_Debut(rs.getString(2));
                M.setDate_Fin(rs.getString(3));
                M.setNombre_Mois(rs.getString(4));
                M.setType(rs.getString(5));
                M.setidCondidat(rs.getString(6));
                
                Abonnement.add(M);
                fxTbAbonnement.setItems(Abonnement);
                System.out.println("gymapplication...recupererAbonnement()"+M.getidAbonnement()+M.getidCondidat());
                
                
            }
             pst.close();
           rs.close();
            

    }
    
}
