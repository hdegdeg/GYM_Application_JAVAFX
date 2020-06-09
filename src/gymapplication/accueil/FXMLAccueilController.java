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
    public static Stage s2 = new Stage();
    @FXML
    private AnchorPane AnchorPane;
    private Stage stage = new Stage();
    

    /**
     * Initializes the controller class.
     */

    
    @FXML
    void Programme(MouseEvent event) {

        try {

            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(root2);

            // GYMApplication.mainStage.hide();
            s2.setScene(scene1);
            s2.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void ajouteCondidat(ActionEvent event) throws IOException {
        AnchorPane.setOpacity(0.4);
       Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/ajouteCondidat/ajouteCondidat.fxml"));
       Scene scene = new Scene(root);
       scene.setFill(new Color(0,0,0,0));
       stage.setScene(scene);
       stage.showAndWait();
       AnchorPane.setOpacity(1);
    }

    @FXML
    private void listCondidats(ActionEvent event) {
    }

    @FXML
    private void abonnementExpire(ActionEvent event) {
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
