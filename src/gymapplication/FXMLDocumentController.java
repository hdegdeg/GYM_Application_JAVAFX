/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author hdegd
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    Connection con=null;
    public static Stage s1=new Stage();
    @FXML
    private void handleButtonAction(ActionEvent event) {
          try {
    
            
           Parent   root = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/FXMLAccueil.fxml"));
         Scene scene = new Scene(root);
          
          GYMApplication.mainStage.hide();
        s1.setScene(scene);
        s1.show();
        
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          con=DBConnection.EtablirConnection();
    }    
    
}
