/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;

import com.jfoenix.controls.JFXTextField;
import gymapplication.accueil.FXMLAccueilController;
import gymapplication.accueil.*;
//import gymapplication.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();
    private int nombreExo;
    
    // Parent root;
     public static Stage s2=new Stage();
     private Stage stage = new Stage ();
    @FXML
    private AnchorPane AnchorPane;
    /**
     * Initializes the controller class.
     */
    
      
    
    
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
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage.initModality(Modality.APPLICATION_MODAL);
       stage.initStyle(StageStyle.TRANSPARENT);
    } 
}
