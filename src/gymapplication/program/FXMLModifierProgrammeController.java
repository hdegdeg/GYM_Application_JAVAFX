/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import gymapplication.DBConnection;
import gymapplication.Programme.list.ListeExercice;
import gymapplication.Programme.list.ListeJours;
import gymapplication.Programme.list.ListeProgramme;
import gymapplication.accueil.FXMLAccueilController;
import static gymapplication.accueil.FXMLAccueilController.stageProgramme;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLModifierProgrammeController implements Initializable {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private JFXTextField nomProg2;
    @FXML
    private JFXTextField numProg;

    @FXML
    private JFXTextField nbJours;
    @FXML
    private Label jrs1;

    @FXML
    private Label jrs2;

    @FXML
    private Label jrs3;

    @FXML
    private Label jrs4;

    @FXML
    private Label jrs5;

    @FXML
    private Label jrs6;

    @FXML
    private Label jrs7;

    @FXML
    private JFXTextField textFJrs1;

    @FXML
    private Button ButtonJrs1;

    @FXML
    private Button ButtonJrs7;

    @FXML
    private Button ButtonJrs6;

    @FXML
    private Button ButtonJrs5;

    @FXML
    private Button ButtonJrs4;

    @FXML
    private Button ButtonJrs3;

    @FXML
    private Button ButtonJrs2;

    @FXML
    private JFXTextField textFJrs2;

    @FXML
    private JFXTextField textFJrs6;

    @FXML
    private JFXTextField textFJrs5;

    @FXML
    private JFXTextField textFJrs4;

    @FXML
    private JFXTextField textFJrs3;

    @FXML
    private JFXTextField textFJrs7;

    @FXML
    private Button btnClose;
    @FXML
    private JFXButton buttonValider;

    private Stage stageExercice = new Stage();

    // private String idProg;
    public static String idJours = "";
    public static String currentMuscle = "";
    public static boolean ButtonExoActive = false;
    public MyThread thread;
    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();
    FXMLProgrammesController currentProgramme = new FXMLProgrammesController();

    private static ArrayList<ListeJours> listeJours = new ArrayList<>();
    private ArrayList<ListeExercice> listeExo = new ArrayList<ListeExercice>();

    public void addJourEntrainnement(ListeJours j) {

        listeJours.add(j);
    }


    private void uploadTableProgramme() throws SQLException {

        ListeProgramme Programme;
        String currentText;
        String sql = "select idProgramme,Nom_Programme,Nombre_Jours from Programme where idProgramme=' " + currentProgramme.currentIdProgramme + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            numProg.setText(rs.getString(1));
            nomProg2.setText(rs.getString(2));
            nbJours.setText(rs.getString(3));
            pst.close();
            rs.close();
        }

        sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 1'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            textFJrs1.setText(rs.getString(1));
            pst.close();
            rs.close();

        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////  
        sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 2'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            textFJrs2.setText(rs.getString(1));
            pst.close();
            rs.close();

        }

        ///////////////////////////////////////////////////////
        sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 3'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            textFJrs3.setText(rs.getString(1));
            pst.close();
            rs.close();

        }

        ///////////////////////////////////////////////////////////////////////////////////////////
        sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 4'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            textFJrs4.setText(rs.getString(1));
            pst.close();
            rs.close();

        }
        ///////////////////////////////////////////////////////////////////////////////////////

        sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 5'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        if (rs.next()) {
            textFJrs5.setText(rs.getString(1));
            pst.close();
            rs.close();

        }

        /////////////////////////////////////////////////////////////////////////////////
        sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 6'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            textFJrs6.setText(rs.getString(1));
            pst.close();
            rs.close();

        }

        sql = "select muscles from Jour where idProgramme=' " + currentProgramme.currentIdProgramme + "' and NomJ='Jour 7'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            textFJrs7.setText(rs.getString(1));
            pst.close();
            rs.close();

        }
        pst.close();
        rs.close();

    }

    @FXML
    private void AjouterExo() throws SQLException {
       
            System.out.println("Debut Exo");


            String sql = "SELECT rowid from Programme order by ROWID DESC limit 1";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            String idProg = rs.getString(1);

            for (ListeJours var : listeJours) {

                listeExo = var.ReturnListe();

                for (ListeExercice exo : listeExo) {
                    System.out.println("idP:" + currentProgramme.currentIdProgramme + "idExo:" + exo.getIdJour());
                    sql = "delete  from Exercice  where idProgramme='" + currentProgramme.currentIdProgramme + "' and idJour='" + exo.getIdJour() + "'";
                    pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                    pst.close();
                    rs.close();
                    sql = "insert into Exercice (Nom_Exo,Nombre_Repetition,Nombre_Series,idJour,idProgramme) values(?,?,?,?,?)";
                    System.out.println("idP:" + exo.getNom_Exo() + "//" + exo.getIdJour() + "//" + exo.getNombre_Repetition() + "//" + exo.getNombre_Series());
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, exo.getNom_Exo());
                    pst.setString(2, exo.getNombre_Repetition());
                    pst.setString(3, exo.getNombre_Series());
                    pst.setString(4, exo.getIdJour());
                    pst.setString(5, idProg);
                    pst.executeUpdate();
                    pst.close();
                    rs.close();
                }

            }

        
    }

    @FXML
    private void AjouterJour() {
        try {
            System.out.println("Debut Jour");

            String sql = "SELECT rowid from Programme order by ROWID DESC limit 1";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            for (ListeJours var : listeJours) {

                sql = "delete  from Jour  where idProgramme='" + currentProgramme.currentIdProgramme + "' and NomJ='" + var.getNomJ() + "'";
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                pst.close();
                rs.close();
                // sql = "insert into Jour (NomJ,idProgramme,Muscles) values(?,?,?)";
                System.out.println("Update Jour");
                sql = "insert into Jour (NomJ,idProgramme,Muscles) values(?,?,?)";
                //  sql="update Jour  set  NomJ=?, idProgramme=? ,Muscles=?  where idProgramme='"+var.getIdProgramme()+"' and NomJ='"+var.getNomJ()+"'";

                pst = conn.prepareStatement(sql);
                pst.setString(1, var.getNomJ());
                pst.setString(2, currentProgramme.currentIdProgramme);
                pst.setString(3, var.getMuscles());
                pst.executeUpdate();
                pst.close();
                rs.close();

                listeExo = var.ReturnListe();
                for (ListeExercice exo : listeExo) {

                    System.out.println("Nom_Exo:" + exo.getNom_Exo() + " Nombre_Series:" + exo.getNombre_Series() + " Nombre_Repetition:" + exo.getNombre_Repetition() + " idJour:" + exo.getIdJour());
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void AjouterProgramme() {
        try {
            System.out.println("Debut Programme");

            Object nombreJoursINT = listeJours.size();
            String nombreJours = nombreJoursINT.toString();

            String sql = "update Programme  set  Nom_Programme=?, Nombre_Jours=?  where idProgramme='" + currentProgramme.currentIdProgramme + "'";
            pst = conn.prepareStatement(sql);
            pst.setString(1, nomProg2.getText());
            pst.setString(2, nombreJours);
            pst.executeUpdate();
            pst.close();


        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    void Valider(MouseEvent event) throws SQLException {
        thread.setStoped(true);

        AjouterProgramme();
        AjouterJour();
        AjouterExo();

        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();


        FXMLModifierProgrammeController.ButtonExoActive = false;
    }

    @FXML
    void Retour(MouseEvent event) {
        
        
        
        FXMLModifierProgrammeController.ButtonExoActive=false;
        currentProgramme.currentIdProgramme="";
     
         try {

            thread.setStoped(true);

            InterfaceProgramme.rootProgramme = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(InterfaceProgramme.rootProgramme);
            scene1.setFill(new Color(0, 0, 0, 0));

            stageProgramme.setScene(scene1);
            stageProgramme.show();

        } catch (IOException ex) {
            System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
        }
    }

    @FXML
    void Exercice1(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer tout les Anciens Exo de {{ " + textFJrs1.getText() + "}} s'il Existe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {
                System.out.println("gymapplication.program.FXMLModifierProgrammeController.Exercice7()");
            } else {
                ButtonExoActive = true;
                idJours = "Jour 1";
                currentMuscle = textFJrs1.getText();
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierExercices.fxml"));
                    Scene scene1 = new Scene(root1);
                    //GYMApplication.mainStage.hide();
                    stageExercice.setScene(scene1);
                    stageExercice.show();

                } catch (IOException ex) {
                    System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Attention !!!");
            alert.setContentText("Une Fenetre d'exercices est déja active dans votre système");
            alert.showAndWait();
        }

    }

    @FXML
    void Exercice2(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer tout les Anciens Exo de {{ " + textFJrs2.getText() + "}} s'il Existe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {
                System.out.println("gymapplication.program.FXMLModifierProgrammeController.Exercice7()");
            } else {
                ButtonExoActive = true;
                idJours = "Jour 2";
                currentMuscle = textFJrs2.getText();
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierExercices.fxml"));
                    Scene scene1 = new Scene(root1);
                    //GYMApplication.mainStage.hide();
                    stageExercice.setScene(scene1);
                    stageExercice.show();

                } catch (IOException ex) {
                    System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Attention !!!");
            alert.setContentText("Une Fenetre d'exercices est déja active dans votre système");
            alert.showAndWait();
        }

    }

    @FXML
    void Exercice3(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer tout les Anciens Exo de {{ " + textFJrs3.getText() + "}} s'il Existe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {
                System.out.println("gymapplication.program.FXMLModifierProgrammeController.Exercice7()");
            } else {
                ButtonExoActive = true;
                idJours = "Jour 3";
                currentMuscle = textFJrs3.getText();
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierExercices.fxml"));
                    Scene scene1 = new Scene(root1);
                    //GYMApplication.mainStage.hide();
                    stageExercice.setScene(scene1);
                    stageExercice.show();

                } catch (IOException ex) {
                    System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Attention !!!");
            alert.setContentText("Une Fenetre d'exercices est déja active dans votre système");
            alert.showAndWait();
        }

    }

    @FXML
    void Exercice4(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer tout les Anciens Exo de {{ " + textFJrs4.getText() + "}} s'il Existe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {
                System.out.println("gymapplication.program.FXMLModifierProgrammeController.Exercice7()");
            } else {
                ButtonExoActive = true;
                idJours = "Jour 4";
                currentMuscle = textFJrs4.getText();
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierExercices.fxml"));
                    Scene scene1 = new Scene(root1);
                    //GYMApplication.mainStage.hide();
                    stageExercice.setScene(scene1);
                    stageExercice.show();

                } catch (IOException ex) {
                    System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Attention !!!");
            alert.setContentText("Une Fenetre d'exercices est déja active dans votre système");
            alert.showAndWait();
        }

    }

    @FXML
    void Exercice5(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer tout les Anciens Exo de {{ " + textFJrs5.getText() + "}} s'il Existe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {
                System.out.println("gymapplication.program.FXMLModifierProgrammeController.Exercice7()");
            } else {
                ButtonExoActive = true;
                idJours = "Jour 5";
                currentMuscle = textFJrs5.getText();
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierExercices.fxml"));
                    Scene scene1 = new Scene(root1);
                    //GYMApplication.mainStage.hide();
                    stageExercice.setScene(scene1);
                    stageExercice.show();

                } catch (IOException ex) {
                    System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Attention !!!");
            alert.setContentText("Une Fenetre d'exercices est déja active dans votre système");
            alert.showAndWait();
        }

    }

    @FXML
    void Exercice6(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer tout les Anciens Exo de {{ " + textFJrs6.getText() + "}} s'il Existe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {
                System.out.println("gymapplication.program.FXMLModifierProgrammeController.Exercice7()");
            } else {
                ButtonExoActive = true;
                idJours = "Jour 6";
                currentMuscle = textFJrs6.getText();
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierExercices.fxml"));
                    Scene scene1 = new Scene(root1);
                    //GYMApplication.mainStage.hide();
                    stageExercice.setScene(scene1);
                    stageExercice.show();

                } catch (IOException ex) {
                    System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Attention !!!");
            alert.setContentText("Une Fenetre d'exercices est déja active dans votre système");
            alert.showAndWait();
        }

    }

    @FXML
    void Exercice7(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer tout les Anciens Exo de {{ " + textFJrs7.getText() + "}} s'il Existe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {
                System.out.println("gymapplication.program.FXMLModifierProgrammeController.Exercice7()");
            } else {
                ButtonExoActive = true;
                idJours = "Jour 7";
                currentMuscle = textFJrs7.getText();
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLModifierExercices.fxml"));
                    Scene scene1 = new Scene(root1);
                    //GYMApplication.mainStage.hide();
                    stageExercice.setScene(scene1);
                    stageExercice.show();

                } catch (IOException ex) {
                    System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Attention !!!");
            alert.setContentText("Une Fenetre d'exercices est déja active dans votre système");
            alert.showAndWait();
        }

    }

    @FXML
    void quit() {
        thread.setStoped(true);
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        
        
        FXMLModifierProgrammeController.ButtonExoActive=false;
        currentProgramme.currentIdProgramme="";

        //ThreadProgramme.thread.setNotiffy();
    }

    public void initThread() {
        thread = new MyThread();
        new Thread(thread).start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("gymapplication.program.FXMLModifierProgrammeController.initialize()");
        conn = DBConnection.EtablirConnection();
        try {
            uploadTableProgramme();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLModifierProgrammeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initThread();

    }

    public class MyThread implements Runnable {

        FXMLAjouterExercicesController prog = new FXMLAjouterExercicesController();
        private boolean isStopped = false;
        private int i = 0;

        public synchronized void setStoped(boolean b) {
            isStopped = b;
        }

        public synchronized void setWait() throws InterruptedException {
            wait();
        }

        public synchronized void setNotiffy() {
            notifyAll();
        }

        public synchronized boolean testChampVide(String champ) {
            if (champ.equals("")) {
                return false;
            } else if (champ == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public void run() {

            while (isStopped == false) {

                System.out.println("**************************************************");
                if (isStopped == true) {
                    System.out.println("Server Stopped.");
                    return;
                }

                if (testChampVide(textFJrs1.getText())) {
                    ButtonJrs1.setDisable(false);
                    ButtonJrs1.setStyle("-fx-background-color: #41af3a");
                    jrs1.setTextFill(Color.BLUE);

                } else if (!testChampVide(textFJrs1.getText())) {
                    ButtonJrs1.setDisable(true);
                    ButtonJrs1.setStyle("-fx-background-color: WHITE");
                    jrs1.setTextFill(Color.GREEN);
                }
                //////////////////////////////////

                if (testChampVide(textFJrs2.getText())) {
                    ButtonJrs2.setDisable(false);
                    ButtonJrs2.setStyle("-fx-background-color: #41af3a");
                    jrs2.setTextFill(Color.BLUE);

                } else if (!testChampVide(textFJrs2.getText())) {
                    ButtonJrs2.setDisable(true);
                    ButtonJrs2.setStyle("-fx-background-color: WHITE");
                    jrs2.setTextFill(Color.GREEN);
                }
                //////////////////////////////////

                if (testChampVide(textFJrs3.getText())) {
                    ButtonJrs3.setDisable(false);
                    ButtonJrs3.setStyle("-fx-background-color: #41af3a");
                    jrs3.setTextFill(Color.BLUE);

                } else if (!testChampVide(textFJrs3.getText())) {
                    ButtonJrs3.setDisable(true);
                    ButtonJrs3.setStyle("-fx-background-color: WHITE");
                    jrs3.setTextFill(Color.GREEN);
                }
                //////////////////////////////////

                /*  if(testChampVide(textFJrs1.getText()))
            {
                ButtonJrs1.setDisable(false);
                ButtonJrs1.setStyle("-fx-background-color: #41af3a");
                jrs1.setTextFill(Color.BLUE);
                
            }
            else if(!testChampVide(textFJrs1.getText()))
            {
               ButtonJrs1.setDisable(true);
                jrs1.setTextFill(Color.GREEN);
            }*/
                //////////////////////////////////
                if (testChampVide(textFJrs4.getText())) {
                    ButtonJrs4.setDisable(false);
                    ButtonJrs4.setStyle("-fx-background-color: #41af3a");
                    jrs4.setTextFill(Color.BLUE);

                } else if (!testChampVide(textFJrs4.getText())) {
                    ButtonJrs4.setDisable(true);
                    ButtonJrs4.setStyle("-fx-background-color: WHITE");
                    jrs4.setTextFill(Color.GREEN);
                }
                //////////////////////////////////

                if (testChampVide(textFJrs5.getText())) {
                    ButtonJrs5.setDisable(false);
                    ButtonJrs5.setStyle("-fx-background-color: #41af3a");
                    jrs5.setTextFill(Color.BLUE);

                } else if (!testChampVide(textFJrs5.getText())) {
                    ButtonJrs5.setDisable(true);
                    ButtonJrs5.setStyle("-fx-background-color: WHITE");
                    jrs5.setTextFill(Color.GREEN);
                }
                //////////////////////////////////

                if (testChampVide(textFJrs6.getText())) {
                    ButtonJrs6.setDisable(false);
                    ButtonJrs6.setStyle("-fx-background-color: #41af3a");
                    jrs6.setTextFill(Color.BLUE);

                } else if (!testChampVide(textFJrs6.getText())) {
                    ButtonJrs6.setDisable(true);
                    ButtonJrs6.setStyle("-fx-background-color: WHITE");
                    jrs6.setTextFill(Color.GREEN);
                }
                //////////////////////////////////

                if (testChampVide(textFJrs7.getText())) {
                    ButtonJrs7.setDisable(false);
                    ButtonJrs7.setStyle("-fx-background-color: #41af3a");
                    jrs7.setTextFill(Color.BLUE);

                } else if (!testChampVide(textFJrs7.getText())) {
                    ButtonJrs7.setDisable(true);
                    ButtonJrs7.setStyle("-fx-background-color: WHITE");
                    jrs7.setTextFill(Color.GREEN);
                }
                //////////////////////////////////
                /////////////////////////////////////////

                if ((testChampVide(textFJrs1.getText()) || testChampVide(textFJrs2.getText()) || testChampVide(textFJrs3.getText()) || testChampVide(textFJrs4.getText()) || testChampVide(textFJrs5.getText()) || testChampVide(textFJrs6.getText()) || testChampVide(textFJrs7.getText()))) {
                    buttonValider.setDisable(false);
                    buttonValider.setStyle("-fx-background-color: #41af3a");
                    jrs7.setTextFill(Color.BLUE);

                } else {
                    buttonValider.setDisable(true);
                    buttonValider.setStyle("-fx-background-color: WHITE");

                }

            }

        }

    }

}
