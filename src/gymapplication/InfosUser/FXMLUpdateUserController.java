/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.InfosUser;


import gymapplication.creationAdmin.*;
import gymapplication.DBConnection;
import static gymapplication.Login.loginController.CurrentIdUser;
import static gymapplication.Login.loginController.createStage;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abdelillah gharbi
 */
public class FXMLUpdateUserController implements Initializable {

    PreparedStatement ps = null;
    ResultSet rs = null;    
    Connection conn; 
    
    @FXML
    private TextField userName;
    @FXML
    private TextField fullName;
    @FXML
    private TextField MacAddress;    
    @FXML
    private PasswordField tPassword;
    @FXML
    private PasswordField rtPassword;
    @FXML
    private Label match;
    @FXML
    private Label userExist;
    @FXML
    private Label isEmpty;
    @FXML
    private Button btnClose;
    @FXML
    private TextField cin;
    
    

    
         @FXML
    private void pfKeyTyped(KeyEvent event) {
        if (tPassword.getText().matches(rtPassword.getText())) {
           match.setText("Match");
           match.setStyle(" -fx-text-fill: green;");
        } else {
           match.setText("Not Match");
             match.setStyle(" -fx-text-fill: red;");
        }
    }
    
    private void downlaodDataUser() throws SQLException{
              String sql = "select User,Password,MacAddress,fullName,idUser from Login where idUser = '"+CurrentIdUser+"'";
               ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                       userName.setText(rs.getString(1));
                       tPassword.setText(rs.getString(2));
                       rtPassword.setText(rs.getString(2));
                       MacAddress.setText(rs.getString(3));
                       fullName.setText(rs.getString(4));
                       cin.setText(rs.getString(5));
                }
                 ps.close();
                 rs.close();
    }
    
    @FXML
    private void signUP(){
        try {
            String cin = this.cin.getText();
            String user = userName.getText();
            String full = fullName.getText();
            String pass = tPassword.getText();
           
            if(isValidCondition()){
                
                 String sql="update Login  set  User=?, Password=? ,fullName=?  where idUser = '"+CurrentIdUser+"'";

                ps = conn.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, pass);
                ps.setString(3, full);
                ps.executeUpdate();
                ps.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess :");
                alert.setHeaderText("Sucess");
                alert.setContentText("L'utilisateur " + user + " a été bien modifier");
                alert.showAndWait();
                quit();
            }  } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        
    }
     private boolean isValidCondition() throws SQLException {
         isEmpty.setText("");
        boolean registration = false;
        if (isEmpty() && passMatch()) {
            System.out.println("Condition valid");
            registration = true;
        } else {
            if(!isEmpty())
        {
            isEmpty.setText("SVP entrer tous les champs !!!");
        }
            System.out.println("Condition Invalid");
            registration = false;
        }
        
        return registration;
        
    }

    

    private boolean isEmpty() {
        boolean isEmpty = false;
        if (userName.getText().trim().isEmpty()
                || fullName.getText().trim().isEmpty()
                || cin.getText().trim().isEmpty()
                ||MacAddress.getText().trim().isEmpty()
                || tPassword.getText().isEmpty()
                || rtPassword.getText().isEmpty()) {

            System.out.println("Empty user Name");
            isEmpty = false;
        } else {
            System.out.println("User Name not Empty");
            isEmpty = true;
        }
        return isEmpty;
    }
     private boolean passMatch() {
        boolean passMatch = false;
        String password = tPassword.getText();
        String rePass = rtPassword.getText();

        if (password.matches(rePass)) {
            System.out.println("Password Match");
            passMatch = true;

        } else {
            System.out.println("Password Not Match");
            passMatch = false;
        }
        return passMatch;

    }
     @FXML
   private void quit(){
       Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
   }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            conn = DBConnection.EtablirConnection();
       
        try {
            downlaodDataUser();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLUpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
    

   
    
}
