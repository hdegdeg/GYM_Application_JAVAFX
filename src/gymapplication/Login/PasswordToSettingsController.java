/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Login;

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
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import gymapplication.DBConnection;
import gymapplication.GYMApplication;
import static gymapplication.Login.loginController.anchor2;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
        
/**
 * FXML Controller class
 *
 * @author abdelillah gharbi
 */
public class PasswordToSettingsController implements Initializable {

    Stage stage = new Stage();
    Connection conn ;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    @FXML
    private PasswordField passWord;
    @FXML
    private Label incorrect;
    String MacAddress;
    
        private String getMacAddress() throws UnknownHostException, SocketException{
        InetAddress address = InetAddress.getLocalHost();
        
        NetworkInterface ni =NetworkInterface.getByInetAddress(address);
        byte[] mac= ni.getHardwareAddress();
        
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
        }
        
        MacAddress=sb.toString();
            
        return MacAddress;
    }
     @FXML
    private void verifier() throws SQLException, IOException {
        String mdp = passWord.getText();
        String sql = "select User,MacAddress from Login where etat = 'admin' and Password='"+mdp+"'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        if(rs.next())
        {
            
            if(getMacAddress().equals(rs.getString(2)))
            {
                
                 anchor2.setOpacity(0.4);
                Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/creationUtilisateurNonAdmin/createUserNonAdmin.fxml"));
                Scene scene = new Scene(root);
                scene.setFill(new Color(0,0,0,0));
                stage.setScene(scene);
                stage.centerOnScreen();
                //stage.getIcons().add(new Image(GYMApplication.class.getResourceAsStream("logoCompany.jpg")));
                ps.close();
                 rs.close();
                stage.show();
                     loginController.createStage.close();
                anchor2.setOpacity(1);
            } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Erreur ");
                            alert.setHeaderText("Droit d'utilisation   ");
                            
                            alert.setContentText("Vous n'avez pas le droit pour utiliser ce produit !!! \n "+
                            "S'il vous plait contacter le responsable: \n \n "+
                            "Tel:0558 80 53 27 // 0668 50 20 50 \n "+   
                            "Gmail: dgsoftware1334@gmail.com \n "+
                            "Facebook: www.facebook.com/DGSoftware "     
                            );
                           
                            alert.showAndWait();
                     }
        
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR :");
            alert.setHeaderText("Contactez l'Admin SVP!!!");
            alert.showAndWait();
            incorrect.setText("incorrect");
            passWord.setText("");
        }
       ps.close();
        rs.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage.initModality(Modality.APPLICATION_MODAL);
       stage.initStyle(StageStyle.TRANSPARENT);
            conn = DBConnection.EtablirConnection();
            
        
    }    

   
    
}
