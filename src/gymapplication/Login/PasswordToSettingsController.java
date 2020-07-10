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

    
     @FXML
    private void verifier() throws SQLException, IOException {
        String mdp = passWord.getText();
        String sql = "select * from Login where etat = 'admin' and Password='"+mdp+"'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        if(rs.next()){
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
