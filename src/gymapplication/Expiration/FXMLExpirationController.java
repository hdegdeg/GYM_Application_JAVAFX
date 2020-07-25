/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Expiration;


import gymapplication.Abonnement.list.ListAbonnement;
import gymapplication.DBConnection;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import gymapplication.Abonnement.list.ListAbonnement;
import gymapplication.Abonnement.list.StaticListAbonnement;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLExpirationController implements Initializable {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
        @FXML
    private TableView<listDate> fxTableExpiration;

    @FXML
    private TableColumn<listDate, String> fxIdAbon;

    @FXML
    private TableColumn<listDate, String> fxTypeAbon;

    @FXML
    private TableColumn<listDate, String> fxExpAbon;

    @FXML
    private TableColumn<listDate, String> fxNomCondidat;

    @FXML
    private TableColumn<listDate, String> fxTelCondidat;
    
     public ObservableList<listDate> listD;
    @FXML
    private Button btnClose;
    @FXML
    private TextField fxRechercher;

    private Stage stageRounouvellement = new Stage();
    public static Stage staticstageRounouvellement = new Stage();
     listDate Labonnement= new  listDate();
    
    StaticListDate StaticLabonnement = new StaticListDate();
    
        private void initTable() {

        fxNomCondidat.setCellValueFactory(new PropertyValueFactory<listDate, String>("nomCondidat"));
        fxTelCondidat.setCellValueFactory(new PropertyValueFactory<listDate, String>("telCondidat"));
        fxIdAbon.setCellValueFactory(new PropertyValueFactory<listDate, String>("idAbonnement"));
        fxTypeAbon.setCellValueFactory(new PropertyValueFactory<listDate, String>("type"));
        fxExpAbon.setCellValueFactory(new PropertyValueFactory<listDate, String>("dateExp"));
    }
        
        
      public void ConnectionDB() throws ParseException, SQLException{
       
            con = DBConnection.EtablirConnection();
            initTable();
            listD = FXCollections.observableArrayList();
            uploadProduitEX();

        }
        
     @FXML
    private void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    
                @FXML
      public void RechercheCondidat() throws SQLException, ParseException
    {

        
        if(fxRechercher==null || fxRechercher.getText().equals(""))
        {
            uploadProduitEX();
        }else{
        listD.clear();
        
        String dt = LocalDate.now().toString();  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(c.getTime());
        String sql="select Condidat.idCondidat,Nom_Prenom,Tele,Abonnement.idAbonnement,Type,Date_Fin from Condidat  INNER JOIN Abonnement ON Condidat.idCondidat = Abonnement.idCondidat and (Abonnement.Date_Fin <= '" + dt + "') and (Condidat.idCondidat like '%"+fxRechercher.getText()+"%' OR lower(Condidat.Nom_Prenom) LIKE '%"+fxRechercher.getText().toLowerCase()+"%' OR Condidat.Tele LIKE '%"+fxRechercher.getText()+"%')";
            
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
            listDate date = new listDate();
            date.setidCondidat(rs.getString(1));
            date.setNomCondidat(rs.getString(2));
            date.setTelCondidat(rs.getString(3));
            date.setIdAbonnement(rs.getString(4));
            date.setType(rs.getString(5));
            date.setDateExp(rs.getString(6));

            listD.add(date);
            fxTableExpiration.setItems(listD);
            }
             pst.close();
           rs.close();
          
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLExpirationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
        }
    }
    
    private void selectionnerAbonnement(){
                    
           Labonnement=(listDate)fxTableExpiration.getSelectionModel().getSelectedItem();

           StaticLabonnement.setidCondidat(Labonnement.getidCondidat());
           StaticLabonnement.setDateExp(Labonnement.getDateExp());
           StaticLabonnement.setNomCondidat(Labonnement.getNomCondidat());
           StaticLabonnement.setTelCondidat(Labonnement.getTelCondidat());
           StaticLabonnement.setIdAbonnement(Labonnement.getIdAbonnement());
            StaticLabonnement.setType(Labonnement.getType());

     }
    
    private void uploadProduitEX() throws ParseException, SQLException {
            
        String dt = LocalDate.now().toString();  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(c.getTime());
        System.out.println("--------------" + dt + "------------------");

        String sql = "select Condidat.idCondidat,Nom_Prenom,Tele,Abonnement.idAbonnement,Type,Date_Fin from Condidat  INNER JOIN Abonnement ON Condidat.idCondidat = Abonnement.idCondidat and Abonnement.Date_Fin <= '" + dt + "'";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            listDate date = new listDate();
            date.setidCondidat(rs.getString(1));
            date.setNomCondidat(rs.getString(2));
            date.setTelCondidat(rs.getString(3));
            date.setIdAbonnement(rs.getString(4));
            date.setType(rs.getString(5));
            date.setDateExp(rs.getString(6));

            listD.add(date);
            fxTableExpiration.setItems(listD);
        }
        pst.close();
        rs.close();
    }
   
         @FXML
    public void Rounouvellement(MouseEvent event) throws IOException {

        selectionnerAbonnement();
        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/Expiration/FXMLRounouvellementAbonnement.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(new Color(0, 0, 0, 0));
        stageRounouvellement.setScene(scene);
        staticstageRounouvellement = stageRounouvellement;
        stageRounouvellement.showAndWait();


    } 
        
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         stageRounouvellement.initModality(Modality.APPLICATION_MODAL);
        stageRounouvellement.initStyle(StageStyle.TRANSPARENT);
        try {
            ConnectionDB();
        } catch (ParseException ex) {
            Logger.getLogger(FXMLExpirationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLExpirationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
