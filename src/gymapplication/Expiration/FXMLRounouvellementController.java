/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Expiration;

import gymapplication.Abonnement.*;
import gymapplication.Abonnement.list.StaticListAbonnement;
import gymapplication.accueil.ajouteCondidat.*;
import gymapplication.DBConnection;
//import gymapplication.FXMLDocumentController;
import gymapplication.accueil.FXMLAccueilController;
import gymapplication.listeCondidat.list.ListCondidatStatic;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gharbi abdelillah
 */
public class FXMLRounouvellementController implements Initializable {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

     StaticListDate Labonnement= new  StaticListDate();
   
    public static  Stage s3=new Stage();
    
    FXMLExpirationController InterfaceExpiration= new FXMLExpirationController();
    FXMLAccueilController InterfaceAbonnement = new FXMLAccueilController();
    
    @FXML
    public Label lblCaption;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfNumTel;
    @FXML
    private ComboBox<String> comboAbonnement;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private Label lblFinDate;
    @FXML
    private TextField tfNbrMois;
    @FXML
    private Button btnClose;
    @FXML
    private TextField tfCIN;
    @FXML
    private Label isEmpty;
    @FXML
    private ComboBox<String> comboType;

    String typeAbonnement;
    @FXML
    private Label lblFinAbonnement;
    @FXML
    private Label lblNbrMois;
    @FXML
    private Label lblType;
    @FXML
    private Label lblDateDebut;
    @FXML
    public Button btnModifier;
    @FXML
    private TextField tfPrix;
  
    @FXML
    private void quit() {
        Labonnement.setidCondidat(null);
        Labonnement.setNomCondidat(null);
        Labonnement.setTelCondidat(null);
        Labonnement.setIdAbonnement(null);
        Labonnement.setType(null);
        Labonnement.setDateExp(null);

        
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        
      InterfaceExpiration.stageRounouvellement.close();
      InterfaceAbonnement.stageExpiration.close();
    }

    @FXML
    private void Valider(MouseEvent event) throws IOException {
         
    
        try {
            abonnement();
            //InterfaceAbonnement.abonnementExpire(event);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRounouvellementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Labonnement.setidCondidat(null);
        Labonnement.setNomCondidat(null);
        Labonnement.setTelCondidat(null);
        Labonnement.setIdAbonnement(null);
        Labonnement.setType(null);
        Labonnement.setDateExp(null);
    }
    
    
    private void initializeCondidat() 
    {
         String sql = "select idCondidat, Nom_Prenom, Age, Tele from Condidat where idCondidat='" + Labonnement.getidCondidat()+ "'";
      
          
        try {
            pst=conn.prepareStatement(sql);
             rs=pst.executeQuery();
            if(rs.next())
            {
                
             tfCIN.setText(rs.getString(1));
             tfNom.setText(rs.getString(2));
             tfAge.setText(rs.getString(3));
             tfNumTel.setText(rs.getString(4));
                
            }
            pst.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRounouvellementController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
   private void initializeQbonneéent() 
    {
         String sql = "select Date_Debut, Date_Fin, Nombre_Mois, Prix from Abonnement where idAbonnement='" + Labonnement.getIdAbonnement()+ "'";

        try {
            pst=conn.prepareStatement(sql);
             rs=pst.executeQuery();
            if(rs.next())
            {tfPrix.setText(rs.getString(4));}
            pst.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRounouvellementController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    //////////////////////  validé les condition du remplir les champ  //////////////

    private boolean isValidCondition() throws SQLException {
        isEmpty.setText("");
        boolean registration = false;
        if (isEmpty()==true) {
            System.out.println("Condition valid");
            registration = true;
            isEmpty.setText("done !!!");
            isEmpty.setStyle("-fx-text-fill:green;");

        } else {
            isEmpty.setText("SVP entrer tous les champs !!!");
            isEmpty.setStyle("-fx-text-fill:red;");

            System.out.println("Condition Invalid");
            registration = false;
        }

        return registration;

    }

    ///////////////    pour verifier les champ vide /////////////////
    private boolean isEmpty() {
        boolean isEmpty = false;
        if (tfCIN.getText().trim().isEmpty()
                || tfNom.getText().trim().isEmpty()
                || tfAge.getText().trim().isEmpty()
                || tfNumTel.getText().trim().isEmpty()
                ||tfNbrMois.getText().trim().isEmpty()
                || (comboAbonnement.getSelectionModel().isEmpty() && comboAbonnement.getPromptText().isEmpty())) {

            System.out.println("il y a un ou plusieur champs vide");
            isEmpty = false;
        } else {
            if (comboAbonnement.getValue().equals("abonnée")) {
                typeAbonnement = comboType.getValue().toString();
                if (tfNbrMois.getText().trim().isEmpty()
                        || dateDebut.getValue().equals(null)
                        || (comboType.getSelectionModel().isEmpty() && comboType.getPromptText().isEmpty())) {
                    isEmpty = false;
                }
            } else {
                typeAbonnement = comboAbonnement.getValue().toString();
            }
            System.out.println("donne");
            isEmpty = true;
        }
        return isEmpty;
    }

    /////////////////////   verifier si cette condidat est nouveau ou deja inscrit //////////
    private boolean isnewData() throws SQLException {

        String sql = "select * from Condidat where idCondidat='" + tfCIN.getText() + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            pst.close();
            rs.close();
            System.out.println("isn't new data");
            return false;

        }
        pst.close();
        rs.close();
        System.out.println("is new data");
        return true;
    }

    private void abonnement() throws SQLException {
        Object testDateDebut=dateDebut.getValue();
        if (comboAbonnement.getValue().toString().equals("non-abonnée") || comboType.getValue().toString().equals("")) {
            
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :   ");
                    alert.setContentText("vous avez pas selectionner le champ abonnement ");
                    alert.showAndWait();
                    
                   
            pst.close();
        } else {
          if( testDateDebut==null)
            {  
                                 Alert alert = new Alert(Alert.AlertType.ERROR);
                                 alert.setTitle("Erreur");
                                 alert.setHeaderText("Erreur :   ");
                                 alert.setContentText("SVP choisissez la date de début");
                                 alert.showAndWait();
            
            }else{
              
              if(isValidCondition() )
                    {
                             String sql="update Abonnement  set  Date_Debut=?, Date_Fin=? ,Nombre_Mois=? ,Type=?,Prix=?  where idAbonnement= '"+ Labonnement.getIdAbonnement()+"'";

                             typeAbonnement = comboType.getValue().toString();
                             pst = conn.prepareStatement(sql);
                             pst.setString(1, dateDebut.getValue().toString());
                             pst.setString(2, lblFinDate.getText());
                             pst.setString(3, tfNbrMois.getText());
                             pst.setString(4, typeAbonnement);
                             pst.setString(5, tfPrix.getText());
                             
                             pst.executeUpdate();
                             pst.close();
                             
                             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                 alert.setTitle("Modification");
                                 alert.setHeaderText("Modification :   ");
                                 alert.setContentText("L'Abonnement numéro : " + Labonnement.getIdAbonnement()+" du Condidat "+Labonnement.getNomCondidat()+" a été modifier avec succés");
                                 alert.showAndWait();
                                 quit();
                    }else {
                                 Alert alert = new Alert(Alert.AlertType.ERROR);
                                 alert.setTitle("Erreur");
                                 alert.setHeaderText("Erreur :   ");
                                 alert.setContentText("Vérifiez les données du condidat!!!");
                                 alert.showAndWait();
                           }
            }
          
        }
    }

   

    @FXML
    private void calculeFinDate() throws ParseException {

        Integer nbr = 0;
        if (tfNbrMois.equals(null)) {
            nbr = 0;
            tfNbrMois.setText("0");
        } else {
            nbr = Integer.parseInt(tfNbrMois.getText());
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateDebut.getValue().toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, nbr);
        calendar.add(Calendar.DATE, -1);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        lblFinDate.setText(sdf.format(calendar.getTime()));

    }

    @FXML
    private void testAbonnement() {
        if (!comboAbonnement.getSelectionModel().isEmpty()) {
            if (comboAbonnement.getValue().toString().equals("non-abonnée")) {
                System.out.println("ksjlkjkljlkjlkjkjlkllllkkllddlkjlkjkdldkljlkzajlka");
                comboType.setVisible(false);
                lblType.setVisible(false);
                lblDateDebut.setVisible(false);
                dateDebut.setVisible(false);
                lblNbrMois.setVisible(false);
                tfNbrMois.setVisible(false);
                lblFinAbonnement.setVisible(false);
                lblFinDate.setVisible(false);
                tfPrix.setVisible(false);

            } else {
                System.out.println(comboAbonnement.getValue().toString());
                comboType.setVisible(true);
                lblType.setVisible(true);
                lblDateDebut.setVisible(true);
                dateDebut.setVisible(true);
                lblNbrMois.setVisible(true);
                tfNbrMois.setVisible(true);
                lblFinAbonnement.setVisible(true);
                lblFinDate.setVisible(true);
                tfPrix.setVisible(true);
            }
        }
    }

  
    
      @FXML
    void ListCondidat(MouseEvent event) {
           
       
        try {
    
            
         Parent root2 = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLlistCondidat.fxml"));
         Scene scene1 = new Scene(root2);
          
         // GYMApplication.mainStage.hide();
        s3.setScene(scene1);
        s3.show();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLRounouvellementController.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboAbonnement.getItems().addAll("abonnée", "non-abonnée");
        comboAbonnement.setValue("abonnée");
        
        comboType.getItems().addAll("Gym", "Natation", "Cardio", "Zomba", "Street");
        comboType.setValue(Labonnement.getType());

        
        conn = DBConnection.EtablirConnection();
            initializeCondidat();
            initializeQbonneéent();
        
         
       
        
    }
    
    

}
