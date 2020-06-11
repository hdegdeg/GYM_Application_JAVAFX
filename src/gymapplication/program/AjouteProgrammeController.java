/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gharbi abdelillah
 */
public class AjouteProgrammeController implements Initializable {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private Label lblCaption;

    @FXML
    private JFXTextField tfNom;

    @FXML
    private Label lblType;

    @FXML
    private Label lblType1;

    @FXML
    private Label lblType11;

    @FXML
    private Label lblType12;

    @FXML
    private Label lblType13;

    @FXML
    private Label lblType14;

    @FXML
    private Label lblType15;

    @FXML
    private Label lblType16;

    @FXML
    private Label lblType17;

    @FXML
    private Label lblType18;

    @FXML
    private Label lblType19;

    @FXML
    private Label lblType110;

    @FXML
    private Label lblType2;

    @FXML
    private JFXTextField tfNom1;

    @FXML
    private JFXTextField tfNom2;

    @FXML
    private JFXTextField tfNom3;

    @FXML
    private JFXTextField tfNom4;

    @FXML
    private JFXTextField tfNom5;

    @FXML
    private JFXTextField tfNom6;

    @FXML
    private JFXTextField tfNom7;

    @FXML
    private JFXTextField tfNom8;

    @FXML
    private JFXTextField tfNom9;

    @FXML
    private JFXTextField tfNom10;

    @FXML
    private JFXTextField tfNom11;

    @FXML
    private JFXTextField tfNom12;

    @FXML
    private JFXTextField tfNom13;

    @FXML
    private JFXTextField tfNom14;

    @FXML
    private JFXTextField tfNom15;

    @FXML
    private JFXTextField tfNom16;

    @FXML
    private JFXTextField tfNom17;

    @FXML
    private JFXTextField tfNom18;

    @FXML
    private JFXTextField tfNom19;

    @FXML
    private JFXTextField tfNom20;

    @FXML
    private Button btnClose;

    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @FXML
    void quit(ActionEvent event) {
         Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }
}
