/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Login;

//import BDConnection.ConnectionSQLITE;
//import gestionDeStock.main;
import gymapplication.DBConnection;
import gymapplication.GYMApplication;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class loginController implements Initializable {

    public static Stage accueilStage;
    public static Stage createStage;

    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Stage stage = new Stage();

    public static AnchorPane anchor2;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField userPassword;
    @FXML
    private AnchorPane apDesignPane;

    @FXML
    private void logIn() throws ParseException {

        if (userPassword.getText().equals("") || userName.getText().equals("")) {

            errorPassword(0);
            userPassword.clear();
        } else if (!userPassword.getText().equals("") && !userName.getText().equals("")) {

            try {
                String sql = "select * from Login where User = ? and Password = ?";

                ps = conn.prepareStatement(sql);
                ps.setString(1, userName.getText());
                ps.setString(2, userPassword.getText());

                rs = ps.executeQuery();
                while (rs.next()) {
                    newStage();
                    ps.close();
                    rs.close();

                    return;
                }

                errorPassword(1);
                ps.close();
                rs.close();
            } catch (SQLException ex) {

                ex.printStackTrace();
            } catch (ParseException ex) {

                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void errorPassword(int tmp) {
        if (tmp == 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur :   ");
            alert.setContentText("Le mot de passe ou l'utilisateur sont incorrect!!!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur :   ");
            alert.setContentText("Il faut de remplir tous les champs!!!");
            alert.showAndWait();

        }
    }

    private void newStage() throws ParseException, SQLException {
        try {
            userPassword.clear();
            Stage adminStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/FXMLAccueil.fxml"));
            Scene scene = new Scene(root);
            adminStage.setMaximized(true);
            // adminStage.getIcons().add(new Image(GYMApplication.class.getResourceAsStream("logoCompany.jpg")));
            adminStage.setTitle("Accueil");
            GYMApplication.logStage.hide();
            accueilStage = adminStage;
            adminStage.setScene(scene);
            adminStage.show();

        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.ALL, null, ex);
        }

    }

//        private void cleanTextField()
//        {
//            userName.setText("");
//        }
//        private void cleanPasswordField()
//        {
//            userPassword.clear();
//        }  
    @FXML
    private void close() {
        GYMApplication.logStage.close();
    }

    @FXML
    private void createAccount() throws SQLException, IOException {
        String sql = "select * from Login ";
        anchor2 = anchorPane;
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            anchorPane.setOpacity(0.5);
            Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/Login/passwordToSettings.fxml"));
        Scene scene = new Scene(root);
        createStage = stage;
        stage.setMaximized(false);
        //  stage.getIcons().add(new Image(main.class.getResourceAsStream("logoCompany.png")));

        stage.setScene(scene);
        stage.showAndWait();
            
            ps.close();
            rs.close();
            anchorPane.setOpacity(1);
            return;
        }
        anchor2 = anchorPane;
        anchorPane.setOpacity(0.5);
        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/creationAdmin/createUser.fxml"));
        Scene scene = new Scene(root);
        createStage = stage;
        stage.setMaximized(false);
        //  stage.getIcons().add(new Image(main.class.getResourceAsStream("logoCompany.png")));

        stage.setScene(scene);
        stage.showAndWait();
        anchorPane.setOpacity(1);
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
