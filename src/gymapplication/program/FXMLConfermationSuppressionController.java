/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;

/*
import ListeMalades.LMalade;
import cabinetmedical1.CabinetMedical1;
import cabinetmedical1.DBConnection;
import cabinetmedical1.FXMLDocumentController;
import static cabinetmedical1.FXMLDocumentController.stage;
import static cabinetmedical1.malades.FXMLGestionDesMaladesController.s1;

 */
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gymapplication.DBConnection;
import gymapplication.Programme.list.ListeExercice;
import gymapplication.Programme.list.ListeJours;
import gymapplication.accueil.FXMLAccueilController;
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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private JFXTextField Nom_utilisateur;

    @FXML
    private JFXPasswordField mot_passe;

    @FXML
    private Button btnClose;

    FXMLProgrammesController currentProgramme = new FXMLProgrammesController();
    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();

    @FXML
    private void SupprimerExo() {
        try {
            System.out.println("Debut Exo");

            String sql = "delete  from Exercice  where idProgramme='" + currentProgramme.currentIdProgramme + "'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void SupprimerJour() {
        try {
            System.out.println("Debut Jour");

            String sql = "delete  from Jour  where idProgramme='" + currentProgramme.currentIdProgramme + "'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void SupprimerProgramme() {
        try {
            System.out.println("Debut Programme");

            String sql = "delete  from Programme  where idProgramme='" + currentProgramme.currentIdProgramme + "'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    void Valider() {

        SupprimerExo();
        SupprimerJour();
        SupprimerProgramme();

        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void Retour() {

        try {

            InterfaceProgramme.rootProgramme = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(InterfaceProgramme.rootProgramme);

            FXMLAccueilController.staticStageProgram.setScene(scene1);
            FXMLAccueilController.staticStageProgram.show();

        } catch (IOException ex) {
            System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        conn = DBConnection.EtablirConnection();
    }

    @FXML
    void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void Confermer(MouseEvent event) throws SQLException {

        try {
            String sql = "select User,Password from Login where User= ? and Password= ?";

            pst = conn.prepareStatement(sql);

            pst.setString(1, Nom_utilisateur.getText());
            pst.setString(2, mot_passe.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                Valider();
                Retour();

                pst.close();
                rs.close();
            } else {

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
