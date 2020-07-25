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
import gymapplication.program.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gymapplication.Abonnement.list.StaticListAbonnement;
import gymapplication.DBConnection;
import gymapplication.accueil.FXMLAccueilController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author unknown
 */
public class FXMLConfermationModificationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
   
    @FXML
    private JFXTextField Nom_utilisateur;

    @FXML
    private JFXPasswordField mot_passe;

    @FXML
    private Button btnClose;

    StaticListAbonnement CurrentAbonnement= new  StaticListAbonnement();
    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();
    FXMLAccueilController Accueil = new FXMLAccueilController();
    private Stage stageRounouvellement = new Stage();


    @FXML
    void Valider() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stageRounouvellement.initModality(Modality.APPLICATION_MODAL);
        stageRounouvellement.initStyle(StageStyle.TRANSPARENT);
        conn = DBConnection.EtablirConnection();
    }

    @FXML
    void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }


   
   
    private void ConfermationModification(){
    try {

             Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLModifierAbonnement.fxml"));
             Scene scene1 = new Scene(root2);
             scene1.setFill(new Color(0, 0, 0, 0));
             stageRounouvellement.setScene(scene1);
             stageRounouvellement.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    @FXML
    void Confermer(MouseEvent event) throws SQLException, IOException {

        try {
            String sql = "select User,Password from Login where User= ? and Password= ?";

            pst = conn.prepareStatement(sql);

            pst.setString(1, Nom_utilisateur.getText());
            pst.setString(2, mot_passe.getText());
            rs = pst.executeQuery();

            if (rs.next()) { 
                quit();
                ConfermationModification();}
            
            else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur :   ");
                alert.setContentText("Le mot de passe ou l'utilisateur sont incorrect!!!");
                alert.showAndWait();

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        pst.close();
        rs.close();

    }

}
