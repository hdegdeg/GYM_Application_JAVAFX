/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.accueil;

//import gymapplication.FXMLDocumentController;
import gymapplication.DBConnection;
import gymapplication.GYMApplication;
import gymapplication.Login.loginController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class FXMLAccueilController implements Initializable {

    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null ;
    
    
    
    
    // Parent root;
    public static Stage stageProgramme = new Stage();
    public static Stage stageExpiration = new Stage();
   public static Stage stageAbonnement = new Stage();
   
   public Scene sceneProgramme;
    @FXML
    public AnchorPane AnchorPane;
    private Stage stage = new Stage();
    private Stage stage2 = new Stage();
<<<<<<< HEAD
    public Parent rootProgramme;
=======
    private Stage stage3 = new Stage();
>>>>>>> 2b7cdf90998cd7cba5e6da7bd6770170661adfc4
    
    /**
     * Initializes the controller class.
     */

    
    @FXML
    void Programme(MouseEvent event) {

        try {
            AnchorPane.setOpacity(0.4);
            AnchorPane.setDisable(true);
            
            rootProgramme = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(rootProgramme);
          ///  scene1.setFill(new Color(0,0,0,0));

            // GYMApplication.mainStage.hide();
            stageProgramme.setScene(scene1);
            stageProgramme.show();
            
             
            
            AnchorPane.setOpacity(1);
            AnchorPane.setDisable(false);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
    
     @FXML
  public  void Abonnement(MouseEvent event) {

        try {
            AnchorPane.setOpacity(0.4);
            AnchorPane.setDisable(true);
            
            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLAbonnement.fxml"));
            Scene scene1 = new Scene(root2);
            //scene1.setFill(new Color(0,0,0,0));
            // GYMApplication.mainStage.hide();
            stageAbonnement.setScene(scene1);
            stageAbonnement.showAndWait();
            AnchorPane.setOpacity(1);
            AnchorPane.setDisable(false);

        } catch (IOException ex) {
            Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void ajouteCondidat(ActionEvent event) throws IOException {
        
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);
        
       Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/ajouteCondidat/ajouteCondidat.fxml"));
       Scene scene = new Scene(root);
       
      // scene.setFill(new Color(0,0,0,0));
       stage.setScene(scene);
       stage.showAndWait();
       
       AnchorPane.setDisable(false);
       AnchorPane.setOpacity(1);
    }

    @FXML
    private void listCondidats(ActionEvent event) throws IOException {
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);
        
       Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/listeCondidat/listCondidat.fxml"));
       Scene scene = new Scene(root);
       
       //scene.setFill(new Color(0,0,0,0));
       stage2.setScene(scene);
       stage2.showAndWait();
       
       AnchorPane.setDisable(false);
       AnchorPane.setOpacity(1);
    }

    @FXML
    private void abonnementExpire(ActionEvent event) {
        
        
        try {
            AnchorPane.setOpacity(0.4);
            AnchorPane.setDisable(true);
            
            Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Expiration/FXMLExpiration.fxml"));
            sceneProgramme = new Scene(root2);
            
           // scene1.setFill(new Color(0,0,0,0));
            // GYMApplication.mainStage.hide();
            stageExpiration.setScene(sceneProgramme);
            stageExpiration.showAndWait();
            
            AnchorPane.setDisable(false);
           AnchorPane.setOpacity(1);

        } catch (IOException ex) {
            Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void renouvellement(ActionEvent event) {
    }

    @FXML
    private void deconnection(){
        loginController.accueilStage.close();
        GYMApplication.logStage.show();
    }
    private void alertDate() throws ParseException, SQLException,  IOException{
             String dt = LocalDate.now().toString();  // Start date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dt));
            c.add(Calendar.DATE, 1);  // number of days to add
            dt = sdf.format(c.getTime());
        String sql = "select Condidat.idCondidat,Nom_Prenom,Type,Date_Fin from Condidat  INNER JOIN Abonnement ON Condidat.idCondidat = Abonnement.idCondidat and Abonnement.Date_Fin <= '" + dt + "' order by Nom_Prenom asc";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
        ps.close();
        rs.close();
       
       Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/AlertDate/alertDate.fxml"));
       
       Scene scene = new Scene(root);
       scene.setFill(new Color(0,0,0,0));
       stage3.setScene(scene);
       stage3.show();

   }
        ps.close();
        rs.close();
       
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage3.initModality(Modality.APPLICATION_MODAL);
        stage3.initStyle(StageStyle.TRANSPARENT);
       stage.initModality(Modality.APPLICATION_MODAL);
       stage.initStyle(StageStyle.TRANSPARENT);
       conn = DBConnection.EtablirConnection();
        try {
            alertDate();
        } catch (ParseException ex) {
            Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
