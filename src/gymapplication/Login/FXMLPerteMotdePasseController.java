/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Login;

import gymapplication.Abonnement.*;
import gymapplication.listeCondidat.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gymapplication.Abonnement.list.StaticListAbonnement;
import gymapplication.DBConnection;
import gymapplication.Programme.list.ListeExercice;
import gymapplication.Programme.list.ListeJours;
import gymapplication.accueil.FXMLAccueilController;
import static gymapplication.accueil.FXMLAccueilController.stageCondidat;
import static gymapplication.accueil.FXMLAccueilController.stageProgramme;
import gymapplication.listeCondidat.list.ListCondidatStatic;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author unknown
 */
public class FXMLPerteMotdePasseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
   
    @FXML
    private JFXComboBox<String> Gmail;

    @FXML
    private JFXPasswordField mot_passe;

    @FXML
    private Button btnClose;
    

    private String CurrentPassword= "";
    private String CurrentName= "";
    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();
    FXMLAccueilController Accueil = new FXMLAccueilController();


        @FXML
    private void sendMail() throws SQLException{
        getPassword();
    String username=Gmail.getValue().toString();
    String password=mot_passe.getText();
    String fromEmail=Gmail.getValue().toString();
    String toEmail=Gmail.getValue().toString();
      Properties props = new Properties();
    //props.put("mail.smtp.host", "587");
    		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                
    Session session = Session.getInstance(props, new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
    });

    try {
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(fromEmail));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        
        msg.setSubject("Password Oublier");
       // msg.setSentDate(new Date());
        msg.setText("DGSoftware \n Bonjour Monsieur "+CurrentName+" \n voici votre mot de passe actuel :" +CurrentPassword +"\n Bonne Journée ");
        Transport.send(msg);
    } catch (MessagingException mex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur :   ");
                alert.setContentText("Le mot de passe du compte Gmail que vous avez introduit est incorrect vérefie votre mot de passe et réessayer!!!");
                alert.showAndWait();
    }
    }
    
    
    @FXML
    void Valider() throws SQLException {
        sendMail();
        quiter();
    }

    @FXML
    void quiter() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        conn = DBConnection.EtablirConnection();
        try {
            initialisation();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLPerteMotdePasseController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPerteMotdePasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    
    
    void initialisation() throws SQLException, IOException {

        try {
            String sql = "select gmail from Login";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
              
                 Gmail.getItems().addAll(rs.getString(1));

            }        
} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        pst.close();
        rs.close();

    }
    
    
void getPassword() throws SQLException {

        try {
            String sql = "select Password,fullName,gmail from Login where gmail='"+Gmail.getValue().toString()+"'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                 CurrentPassword= rs.getString(1);
                 CurrentName= rs.getString(2);

            }        
} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        pst.close();
        rs.close();

    }

}

