/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.AlertDate;

//import BDConnection.ConnectionSQLITE;
//import dashboard.ClientDetailController;
import gymapplication.DBConnection;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abdelillah gharbi
 */
public class AlertDateController implements Initializable {

    Connection conn;
    PreparedStatement ps = null;


    ResultSet rs = null;

    public ObservableList<listDate> listD;
    String idProduit;

    @FXML
    private AnchorPane apContent;

   @FXML
    private Button btnClose;
    @FXML
    private TableView<listDate> tableExpirationClient;
    @FXML
    private TableColumn<listDate, String> columnCIN;
    @FXML
    private TableColumn<listDate, String> columnName;
    @FXML
    private TableColumn<listDate, String> columnDateExp;
    @FXML
    private TableColumn<listDate, String> columnType;

    /**
     * Initializes the controller class.
     */
    private void initTable() {

        /////////////////////////////////// produit expiré //////////////////////////
        columnCIN.setCellValueFactory(new PropertyValueFactory<listDate, String>("cin"));
        columnName.setCellValueFactory(new PropertyValueFactory<listDate, String>("name"));
        columnType.setCellValueFactory(new PropertyValueFactory<listDate, String>("type"));
        columnDateExp.setCellValueFactory(new PropertyValueFactory<listDate, String>("dateExp"));

       
    }

    private void uploadProduitEX() throws ParseException, SQLException {
        String dt = LocalDate.now().toString();  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(c.getTime());
        System.out.println("--------------" + dt + "------------------");

        String sql = "select Condidat.idCondidat,Nom_Prenom,Type,Date_Fin from Condidat  INNER JOIN Abonnement ON Condidat.idCondidat = Abonnement.idCondidat and Abonnement.Date_Fin <= '" + dt + "' order by Nom_Prenom asc";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            listDate date = new listDate();
            date.setCin(rs.getString(1));
            date.setName(rs.getString(2));
            date.setType(rs.getString(3));
            date.setDateExp(rs.getString(4));

            listD.add(date);
            tableExpirationClient.setItems(listD);
        }
        ps.close();
        rs.close();
    }

    

    @FXML
    private void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void getClick(MouseEvent event) throws IOException, SQLException {
//        int c = event.getClickCount();
//        if (c == 2) {
//            showClientDetail();
//        }
    }

//    private void showClientDetail() throws IOException, SQLException {
//        listDate list = tableExpirationClient.getSelectionModel().getSelectedItem();
//
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("/dashboard/clientDetail.fxml"));
//        fxmlLoader.load();
//        Parent parent = fxmlLoader.getRoot();
//        Scene scene = new Scene(parent);
//        scene.setFill(new Color(0, 0, 0, 0));
//
////        ClientDetailController clientDetail = fxmlLoader.getController();
////        clientDetail.cinLB.setText(list.getCin());
////        clientDetail.btnConfirmé.setVisible(true);
////        clientDetail.versementMoisTF.setVisible(true);
////        clientDetail.nameClientLB.setText(list.getName());
////        getTotal_PremierVersement(clientDetail);
////        getProduit(clientDetail);
////        clientDetail.telClientLB.setText(getInfoClientDetail());
////        getDateOfVersement(clientDetail);
////        getVersementClient(clientDetail);
////        
//
//        Stage nStage = new Stage();
//        nStage.setScene(scene);
//        nStage.initModality(Modality.APPLICATION_MODAL);
//        nStage.initStyle(StageStyle.TRANSPARENT);
//        nStage.showAndWait();
//
//    }

//    private String getInfoClientDetail() throws SQLException {
//        String tel;
//        listDate list = tableExpirationClient.getSelectionModel().getSelectedItem();
//        String sql = "select * from employ where cin ='" + list.getCin() + "'";
//        ps = conn.prepareStatement(sql);
//        rs = ps.executeQuery();
//        if (rs.next()) {
//            tel=rs.getString("tel");
//            ps.close();
//            rs.close();
//            return tel;
//        }
//        ps.close();
//        rs.close();
//        return null;
//    }

//    private void getDateOfVersement(ClientDetailController clientDetail) throws SQLException {
//        listDate list = tableExpirationClient.getSelectionModel().getSelectedItem();
//        String sql = "select * from clientDetail where cin='" + list.getCin() + "'";
//        ps3 = conn3.prepareStatement(sql);
//        rs = ps3.executeQuery();
//        if (rs.next()) {
//            clientDetail.mois1.setText(rs.getString("mois1"));
//            clientDetail.mois2.setText(rs.getString("mois2"));
//            clientDetail.mois3.setText(rs.getString("mois3"));
//            clientDetail.mois4.setText(rs.getString("mois4"));
//            clientDetail.mois5.setText(rs.getString("mois5"));
//            clientDetail.mois6.setText(rs.getString("mois6"));
//            clientDetail.nbMois.setText(rs.getString(2));
//        }
//        ps3.close();
//        rs.close();
//    }

////    private void getVersementClient(ClientDetailController clientDetail) throws SQLException {
////        listDate list = tableExpirationClient.getSelectionModel().getSelectedItem();
////        String sql = "select * from versementClient where cin='" + list.getCin() + "'";
////        ps3 = conn3.prepareStatement(sql);
////        rs = ps3.executeQuery();
////        if (rs.next()) {
////            clientDetail.versement1.setText(rs.getString("versement1"));
////            clientDetail.versement2.setText(rs.getString("versement2"));
////            clientDetail.versement3.setText(rs.getString("versement3"));
////            clientDetail.versement4.setText(rs.getString("versement4"));
////            clientDetail.versement5.setText(rs.getString("versement5"));
////            clientDetail.versement6.setText(rs.getString("versement6"));
////        }
////        ps3.close();
////        rs.close();
////    }
////
////    private void getTotal_PremierVersement(ClientDetailController clientDetail) throws SQLException {
////        listDate list = tableExpirationClient.getSelectionModel().getSelectedItem();
////        String sql = "select * from dateVersement where cin='" + list.getCin() + "'";
////        ps3 = conn3.prepareStatement(sql);
////        rs = ps3.executeQuery();
////        if (rs.next()) {
////            clientDetail.sommeTotalLB.setText(rs.getString(6));
////            clientDetail.premierVersementLB.setText(rs.getString(12));
////            clientDetail.versement = rs.getString(7);
////            clientDetail.dateProchainVersement = rs.getString(3);
////            idProduit = rs.getString(5);
////        }
////        ps3.close();
////        rs.close();
////    }

//    private void getProduit(ClientDetailController clientDetail) throws SQLException {
//        String sql = "select * from produitVendu where idvente='" + idProduit + "'";
//        ps3 = conn3.prepareStatement(sql);
//        rs = ps3.executeQuery();
//        if (rs.next()) {
//            clientDetail.produitLB.setText(rs.getString(2));
//        }
//        ps3.close();
//        rs.close();
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DBConnection.EtablirConnection();
            initTable();
            listD = FXCollections.observableArrayList();
            uploadProduitEX();
        } catch (SQLException ex) {
            Logger.getLogger(AlertDateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AlertDateController.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }

}
