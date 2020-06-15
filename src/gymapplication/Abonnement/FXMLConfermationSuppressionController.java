/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Abonnement;

/*
import ListeMalades.LMalade;
import cabinetmedical1.CabinetMedical1;
import cabinetmedical1.DBConnection;
import cabinetmedical1.FXMLDocumentController;
import static cabinetmedical1.FXMLDocumentController.stage;
import static cabinetmedical1.malades.FXMLGestionDesMaladesController.s1;

*/
import gymapplication.program.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author unknown
 */
public class FXMLConfermationSuppressionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private JFXTextField Nom_utilisateur;

    @FXML
    private JFXPasswordField mot_passe;

    @FXML
    private JFXButton connecter;
    
    
        Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
           //     con=DBConnection.EtablirConnection();

    }    
    
    
    
    
    
      @FXML
    void Confermer(MouseEvent event) {
      
        
      
        /*
        
        FXMLGestionDesMaladesController SuppModif=new FXMLGestionDesMaladesController();
        
        
        try {
            String sql="select * from IDENTIFICATION where ID_USER= ? and MDP= ?";
            
            pst =con.prepareStatement(sql);
            
            pst.setString(1,Nom_utilisateur.getText());
            pst.setString(2,mot_passe.getText());
            rs=pst.executeQuery();
            
            if(rs.next())
            {
     
                
                if(SuppModif.getSuppModif()==1)
        {
                try {
                   Parent root = FXMLLoader.load(getClass().getResource("/cabinetmedical1/malades/FXMLModifierMalade.fxml"));
            Scene scene = new Scene(root);
          
 
        s1.setScene(scene);
        s1.show();
        
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        }else{
                       
                    
                       try {
                sql="delete  from MALADES   where ID_MALADE= ?";
                
                pst=con.prepareStatement(sql);
                pst.setString(1, SuppModif.getNumMadeUpdate());
                 pst.executeUpdate();
                
                pst.close();
                rs.close();
 
                
               SuppModif.Accueil(event);
           
            } catch (SQLException ex) {
                      
            JOptionPane.showMessageDialog(null, ex);
                        }
                    
                    
                        }
            
           
            
                
            }else{
              
                    Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
           alert.setHeaderText("Erreur :   ");
           alert.setContentText("Le mot de passe ou l'utilisateur sont incorrect!!!");
           alert.showAndWait();
                
            }
           
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
          
*/
    }
    
    
    
}
