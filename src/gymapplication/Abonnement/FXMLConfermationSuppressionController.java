/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Abonnement;

import gymapplication.listeCondidat.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gymapplication.Abonnement.list.StaticListAbonnement;
import gymapplication.DBConnection;
import gymapplication.Programme.list.ListeExercice;
import gymapplication.Programme.list.ListeJours;
import gymapplication.accueil.FXMLAccueilController;
import gymapplication.listeCondidat.list.ListCondidatStatic;
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

    Stage stage = new Stage();

    StaticListAbonnement CurrentAbonnement = new StaticListAbonnement();
    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();
    FXMLAccueilController Accueil = new FXMLAccueilController();

    @FXML
    private void SupprimerAbonnement() {
        try {
            String sql = "delete  from Abonnement  where idAbonnement='" + CurrentAbonnement.getIdAbonnement2() + "'";
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
        SupprimerAbonnement();
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

   

    @FXML
    void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }

    private void actualiser() throws IOException {
        quit();
        Accueil.rootAbonnement = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLAbonnement.fxml"));
        Scene scene = new Scene(Accueil.rootAbonnement);
        Accueil.staticstageAbonnement.close();
        scene.setFill(new Color(0, 0, 0, 0));
        stage.setScene(scene);
        stage.showAndWait();

    }

    private void ConfermationSuppression() throws SQLException, IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Attention");
        alert.setHeaderText("Risque de Suppression des Données  !!!");
        alert.setContentText("Cette action va supprimer l'Abonnement N°(( " + CurrentAbonnement.getIdAbonnement2() + "))");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() != ButtonType.OK) {
        } else {
            Valider();
            actualiser();

            pst.close();
            rs.close();
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
                ConfermationSuppression();
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
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        conn = DBConnection.EtablirConnection();
    }

}
