/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.accueil.ajouteCondidat;

import java.net.URL;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gharbi abdelillah
 */
public class AjouteCondidatController implements Initializable {

    @FXML
    private Label lblCaption;
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

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
   private void quit(){
       Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
   }
    
    
    @FXML
    private void AjouteCondidat(ActionEvent event) {
    }

    @FXML
    private void AjouteProgramme(ActionEvent event) {
    }
    
     @FXML
    private void calculeFinDate() throws ParseException {
//        tfNbrMois.setText("0668502050");
        Integer nbr = 0 ;
        if(tfNbrMois.equals(null)){
           nbr = 0;
           tfNbrMois.setText("0");
        } 
        else{
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      comboAbonnement.getItems().addAll("abonnée","non-abonnée");
      dateDebut.setValue(LocalDate.now()); 
      tfNbrMois.setText("01");
        try {
            calculeFinDate();
        } catch (ParseException ex) {
            Logger.getLogger(AjouteCondidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

   

    
}
