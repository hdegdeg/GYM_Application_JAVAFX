/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.accueil;

import gymapplication.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class FXMLAccueilController implements Initializable {

    // Parent root;
    public static Stage stageProgramme = new Stage();
    public static Stage stageExpiration = new Stage();
   public static Stage stageAbonnement = new Stage();
   
   public Scene sceneProgramme;
    @FXML
    public AnchorPane AnchorPane;
    private Stage stage = new Stage();
    private Stage stage2 = new Stage();
    public Parent rootProgramme;
    
    /**
     * Initializes the controller class.
     */

    
    @FXML
    void Programme(MouseEvent event) {

        try {
            AnchorPane.setOpacity(0.4);
            AnchorPane.setDisable(true);
            
            rootProgramme = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(rootProgramme);
          ///  scene1.setFill(new Color(0,0,0,0));

            // GYMApplication.mainStage.hide();
            stageProgramme.setScene(scene1);
            stageProgramme.show();
            
             
            
            AnchorPane.setOpacity(1);
            AnchorPane.setDisable(false);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
    
     @FXML
  public  void Abonnement(MouseEvent event) {

        try {
            AnchorPane.setOpacity(0.4);
            AnchorPane.setDisable(true);
            
            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLAbonnement.fxml"));
            Scene scene1 = new Scene(root2);
            //scene1.setFill(new Color(0,0,0,0));
            // GYMApplication.mainStage.hide();
            stageAbonnement.setScene(scene1);
            stageAbonnement.showAndWait();
            AnchorPane.setOpacity(1);
            AnchorPane.setDisable(false);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void ajouteCondidat(ActionEvent event) throws IOException {
        
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);
        
       Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/ajouteCondidat/ajouteCondidat.fxml"));
       Scene scene = new Scene(root);
       
      // scene.setFill(new Color(0,0,0,0));
       stage.setScene(scene);
       stage.showAndWait();
       
       AnchorPane.setDisable(false);
       AnchorPane.setOpacity(1);
    }

    @FXML
    private void listCondidats(ActionEvent event) throws IOException {
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);
        
       Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/listeCondidat/listCondidat.fxml"));
       Scene scene = new Scene(root);
       
       //scene.setFill(new Color(0,0,0,0));
       stage2.setScene(scene);
       stage2.showAndWait();
       
       AnchorPane.setDisable(false);
       AnchorPane.setOpacity(1);
    }

    @FXML
    private void abonnementExpire(ActionEvent event) {
        
        
        try {
            AnchorPane.setOpacity(0.4);
            AnchorPane.setDisable(true);
            
            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Expiration/FXMLExpiration.fxml"));
            sceneProgramme = new Scene(root2);
            
           // scene1.setFill(new Color(0,0,0,0));
            // GYMApplication.mainStage.hide();
            stageExpiration.setScene(sceneProgramme);
            stageExpiration.showAndWait();
            
            AnchorPane.setDisable(false);
           AnchorPane.setOpacity(1);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void renouvellement(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       stage.initModality(Modality.APPLICATION_MODAL);
       stage.initStyle(StageStyle.TRANSPARENT);
    }

}
