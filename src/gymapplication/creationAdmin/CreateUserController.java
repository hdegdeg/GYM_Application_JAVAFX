/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.creationAdmin;


import gymapplication.DBConnection;
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
public class CreateUserController implements Initializable {

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
    
    @FXML
    private void signUP(){
        try {
            String cin = this.cin.getText();
            String user = userName.getText();
            String full = fullName.getText();
            String pass = tPassword.getText();
           
            if(isValidCondition()){
                String sql ="insert into Login values(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, cin);
                ps.setString(2, user);
                ps.setString(3, pass);
                ps.setString(4, "admin");
                ps.setString(5, full);
                ps.setString(6, MacAddress.getText());
                ps.executeUpdate();
                ps.close();
                //addMagasin();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess :");
                alert.setHeaderText("Sucess");
                alert.setContentText("User " + user + " Added sucessfuly");
                alert.showAndWait();
                
                 Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Login Now");
            alert2.setHeaderText("Login now");
            alert2.setContentText("Votre compte administrateur a été créé avec succès \n pour vous connecter maintenant cliquez sur OK");
            Optional<ButtonType> result = alert2.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                createStage.close();
            }
            }  } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        
    }
     private boolean isValidCondition() throws SQLException {
         isEmpty.setText("");
        boolean registration = false;
        if (isEmpty() && passMatch() && isnewUser()) {
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
    private boolean isnewUser() throws SQLException{
        userExist.setText("");
        String sql ="select * from Login where User='"+userName.getText()+"'";
       ps = conn.prepareStatement(sql);
       rs = ps.executeQuery();
       while(rs.next())
       {
          userExist.setText("pseudo est deja existe!!!");
          userExist.setStyle("-fx-text-fill:red;");
          ps.close();
          rs.close();
          return false;
       }
       
       return true;
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
    
    

//    private void addMagasin() throws SQLException {
//        String nameM = magasinName.getText();
//        String addressM = magasinAddress.getText();
//        String sql = "insert into magasin values(?,?,?,?)";
//        ps = conn.prepareStatement(sql);
//        ps.setString(1, nameM);
//        ps.setString(2, addressM);
//        ps.setString(3, null);
//        ps.setString(4, magasinTel.getText());
//        ps.executeUpdate();
//        ps.close();
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            conn = DBConnection.EtablirConnection();
       
    }    

    
    

   
    
}
