/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Login;

//import BDConnection.ConnectionSQLITE;
//import gestionDeStock.main;

import com.sun.mail.util.logging.MailHandler;
import gymapplication.DBConnection;
import gymapplication.GYMApplication;
import javax.mail.PasswordAuthentication;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class loginController implements Initializable {

    public static Stage accueilStage;
    public static Stage createStage;

    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Stage stage = new Stage();
    private Stage stage2 = new Stage();

    public static AnchorPane anchor2;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField userPassword;
    @FXML
    private AnchorPane apDesignPane;
    
    public static String TypeUser;
    public static String CurrentIdUser;
    
    String MacAddress;
    static String format = "%02X"; // To get 2 char output.
    String addressMAC = "";

    @FXML
    private void logIn() throws ParseException, UnknownHostException, SocketException, Exception {
        addressMAC ="";
        getMAC();
        System.out.println(" address MAc = "+ addressMAC.trim());
//            getMacAddress();
        if (userPassword.getText().equals("") || userName.getText().equals("")) {

            errorPassword(0);
            userPassword.clear();
        } else if (!userPassword.getText().equals("") && !userName.getText().equals("")) {

            try {
                String sql = "select idUser,User,Password,etat from Login where User = ? and Password = ?";

                ps = conn.prepareStatement(sql);
                ps.setString(1, userName.getText());
                ps.setString(2, userPassword.getText());

                rs = ps.executeQuery();
                while (rs.next()) {
                    //80-A5-89-8C-5D-4F
                    //34-DE-1A-63-84-40 degdeg
                     if (addressMAC.trim().equals("80-A5-89-8C-5D-4F")) {
                         TypeUser=rs.getString(4);
                         CurrentIdUser=rs.getString(1);
                         newStage();
                     }
                     else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Erreur ");
                            alert.setHeaderText("Droit d'utilisation   ");
                            
                            alert.setContentText("Vous n'avez pas le droit pour utiliser ce produit !!! \n "+
                            "S'il vous plait contacter le responsable: \n \n "+
                            "Tel:0558 80 53 27 // 0668 50 20 50 \n "+   
                            "Gmail: dgsoftware1334@gmail.com \n "+
                            "Facebook: www.facebook.com/DGSoftware "     
                            );
                           
                            alert.showAndWait();
                     }
                    
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
    //////////////////////////////// this is gharbi abdelillah new update for the @MAC ////////////////////////
//     private static String[] getPhysicalAddress() throws Exception {
//        try {
//            // DHCP Enabled - InterfaceMetric
//            Set<String> macs = new LinkedHashSet<String>();
//
//            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
//            System.out.println(" nis = "+nis.toString());
//            while (nis.hasMoreElements()) {
//                NetworkInterface ni = nis.nextElement();
//                byte mac[] = ni.getHardwareAddress(); // Physical Address (MAC - Medium Access Control)
//                if (mac != null) {
//                    final StringBuilder macAddress = new StringBuilder();
//                    for (int i = 0; i < mac.length; i++) {
////                        macAddress.append(String.format("%s" + format, (i == 0) ? "" : ":", mac[i]));
//                       macAddress.append(String.format(format+"%s", mac[i], (i < mac.length - 1) ? ":" : ""));
//                    }
//                    System.out.println(macAddress.toString());
//                    macs.add(macAddress.toString());
//                }
//            }
//            return macs.toArray(new String[0]);
//        } catch (Exception ex) {
//            System.err.println("Exception:: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//        return new String[0];
//    }
    private void getMAC() throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("Host/System Name : " + localHost.getHostName());
        System.out.println("Host IP Address  : " + localHost.getHostAddress());

        String macs2 = getMacAddress();
        addressMAC = macs2;
//        for (String mac : macs2) {
//            addressMAC = addressMAC + "" + mac;
//
//        }
    }


    private String getMacAddress() throws UnknownHostException, SocketException{
        InetAddress address = InetAddress.getLocalHost();
        
        NetworkInterface ni =NetworkInterface.getByInetAddress(address);
        byte[] mac= ni.getHardwareAddress();
        
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
        }
        
        MacAddress=sb.toString();
            
        return MacAddress;
    }
    

        @FXML
    public void ForgetPassword() throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/Login/FXMLPerteMotdePasse.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(new Color(0, 0, 0, 0));
        stage2.setScene(scene);
        stage2.showAndWait();



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
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);

        conn = DBConnection.EtablirConnection();
        
    }

}
