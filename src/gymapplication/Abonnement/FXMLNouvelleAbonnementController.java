/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Abonnement;

import gymapplication.accueil.ajouteCondidat.*;
import gymapplication.DBConnection;
//import gymapplication.FXMLDocumentController;
import gymapplication.accueil.FXMLAccueilController;
import gymapplication.listeCondidat.list.ListCondidatStatic;
import static gymapplication.program.FXMLProgrammesController.s2;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author gharbi abdelillah
 */
public class FXMLNouvelleAbonnementController extends Thread implements Initializable  {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

     ListCondidatStatic Lcondidat= new  ListCondidatStatic();
   
    public static  Stage s3=new Stage();
    
    FXMLAbonnementController InterfaceRounouvellement= new FXMLAbonnementController();
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
    private TextField tfPrix;
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

    /**
     * Initializes the controller class.
     */
    @FXML
    private void quit() {
          Lcondidat.setCin(null);
        Lcondidat.setNom(null);
        Lcondidat.setAge(null);
        Lcondidat.setTel(null);
        
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    
    
    @FXML
    private void Valider(MouseEvent event) throws IOException {
         
        Lcondidat.setCin(null);
        Lcondidat.setNom(null);
        Lcondidat.setAge(null);
        Lcondidat.setTel(null);
       
        
        try {
            abonnement();

             InterfaceRounouvellement.s2.close();
             InterfaceAbonnement.stageAbonnement.close();
             InterfaceAbonnement.Abonnement(event);


        } catch (SQLException ex) {
            Logger.getLogger(FXMLNouvelleAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void initializeCondidat()
    {
        tfCIN.setText(Lcondidat.getCin());
        tfNom.setText(Lcondidat.getNom());
        tfAge.setText(Lcondidat.getAge());
        tfNumTel.setText(Lcondidat.getTel());
    }
    
    
    @FXML
    private void AjouteCondidat(ActionEvent event) {
        try {
            if (isValidCondition()) {
                if (isnewData()) {
                    String sql = "insert into Condidat values(?,?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, tfCIN.getText());
                    pst.setString(2, tfNom.getText());
                    pst.setString(3, tfAge.getText());
                    pst.setString(4, tfNumTel.getText());
                    pst.setString(5, "1");
                    pst.executeUpdate();
                    pst.close();
                    abonnement();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucess");
                    alert.setHeaderText("Sucess :   ");
                    alert.setContentText("le condidat :" + "  '" + tfNom.getText() + "' " + "a été ajouté avec succès");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :   ");
                    alert.setContentText("cette données est deja existe!!!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur :   ");
                alert.setContentText("Vérifiez les données du condidat!!!");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    //////////////////////  validé les condition du remplir les champ  //////////////

    private boolean isValidCondition() throws SQLException {
        isEmpty.setText("");
        boolean registration = false;
        if (isEmpty()) {
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
                || (comboAbonnement.getSelectionModel().isEmpty() && comboAbonnement.getPromptText().isEmpty())) {

            System.out.println("il y a un ou plusieur champs vide");
            isEmpty = false;
        } else {
            if (comboAbonnement.getValue().equals("abonnée")) {
                typeAbonnement = comboType.getValue().toString();
                if (tfNbrMois.getText().trim().isEmpty()
                        || !dateDebut.getValue().equals(null)
                        || (comboType.getSelectionModel().isEmpty() && comboType.getPromptText().isEmpty())) {
                    System.out.println("il y a un ou plusieur champs vide");
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
        
        Object testValueType=comboType.getValue();
        if (comboAbonnement.getValue().toString().equals("non-abonnée") || testValueType==null) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :   ");
                    alert.setContentText("Il y a un ou plusieurs champs vide ");
                    alert.showAndWait();
                   
            pst.close();
        } else {
            typeAbonnement = comboType.getValue().toString();
            String sql = "insert into Abonnement values(?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2, dateDebut.getValue().toString());
            pst.setString(3, lblFinDate.getText());
            pst.setString(4, tfNbrMois.getText());
            pst.setString(5, typeAbonnement);
            pst.setString(6,tfPrix.getText());
            pst.setString(7, tfCIN.getText());
            pst.executeUpdate();
            pst.close();
        }
    }

    @FXML
    private void AjouteProgramme(ActionEvent event) {
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
    private void ModifierCondidat(ActionEvent event) {
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
            Logger.getLogger(FXMLNouvelleAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

        comboAbonnement.getItems().addAll("abonnée", "non-abonnée");
        comboType.getItems().addAll("Gym", "Natation", "Cardio", "Zomba", "Street");
        dateDebut.setValue(LocalDate.now());
        tfNbrMois.setText("01");
        tfPrix.setText("00");
        
        initializeCondidat();
        
        try {
            calculeFinDate();
        } catch (ParseException ex) {
            Logger.getLogger(FXMLNouvelleAbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn = DBConnection.EtablirConnection();
       // AnchorPaneAbonnement.setDisable(true);
       
        
    }
    
    

}
