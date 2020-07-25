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
import gymapplication.accueil.FXMLAccueilController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLAjouterProgrammeController implements Initializable {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private JFXTextField nomProg;

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

    public static String idJours = "";
    public static String currentMuscle = "";
    public static boolean ButtonExoActive = false;
    public MyThread thread;
    FXMLAccueilController InterfaceProgramme = new FXMLAccueilController();

    private static ArrayList<ListeJours> listeJours = new ArrayList<>();
    private ArrayList<ListeExercice> listeExo = new ArrayList<ListeExercice>();

    public void addJourEntrainnement(ListeJours j) {

        listeJours.add(j);
    }

    @FXML
    private void AjouterExo() {
        try {

            String sql = "SELECT rowid from Programme order by ROWID DESC limit 1";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            String idProg = rs.getString(1);

            for (ListeJours var : listeJours) {
                listeExo = var.ReturnListe();

                for (ListeExercice exo : listeExo) {

                    sql = "insert into Exercice (Nom_Exo,Nombre_Repetition,Nombre_Series,idJour,idProgramme) values(?,?,?,?,?)";
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
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void AjouterJour() {
        try {

            String sql = "SELECT rowid from Programme order by ROWID DESC limit 1";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            String idProg = rs.getString(1);

            for (ListeJours var : listeJours) {

                sql = "insert into Jour (NomJ,idProgramme,Muscles) values(?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, var.getNomJ());
                pst.setString(2, idProg);
                pst.setString(3, var.getMuscles());
                pst.executeUpdate();
                pst.close();
                rs.close();

                listeExo = var.ReturnListe();
                for (ListeExercice exo : listeExo) {

                    System.out.println("Nom_Exo:" + exo.getNom_Exo() + " Nombre_Series:" + exo.getNombre_Series() + " Nombre_Repetition:" + exo.getNombre_Repetition() + " idJour:" + exo.getIdJour());
                }

            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void AjouterProgramme() throws SQLException {

        Object nombreJoursINT = listeJours.size();
        String nombreJours = nombreJoursINT.toString();

        String sql = "insert into Programme (Nom_Programme,Nombre_Jours) values(?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nomProg.getText());
        pst.setString(2, nombreJours);
        pst.executeUpdate();
        pst.close();

    }

    @FXML
    void Valider(MouseEvent event) throws SQLException {
        thread.setStoped(true);

        AjouterProgramme();
        AjouterJour();
        AjouterExo();

        quit();
    }

    @FXML
    void Retour(MouseEvent event) {

        FXMLAjouterProgrammeController.ButtonExoActive = false;

        try {
            thread.setStoped(true);

            InterfaceProgramme.rootProgramme = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
            Scene scene1 = new Scene(InterfaceProgramme.rootProgramme);
            scene1.setFill(new Color(0, 0, 0, 0));

            FXMLAccueilController.staticStageProgram.setScene(scene1);
            FXMLAccueilController.staticStageProgram.show();

        } catch (IOException ex) {
            System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
        }
    }

    @FXML
    void Exercice1(MouseEvent event) throws InterruptedException {
        if (!ButtonExoActive) {
            ButtonExoActive = true;
            idJours = "Jour 1";
            currentMuscle = textFJrs1.getText();
            try {

                Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouteExercices.fxml"));
                Scene scene1 = new Scene(root1);
                scene1.setFill(new Color(0, 0, 0, 0));
                stageExercice.setScene(scene1);
                stageExercice.show();

            } catch (IOException ex) {
                System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
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
            ButtonExoActive = true;
            idJours = "Jour 2";
            currentMuscle = textFJrs2.getText();
            try {

                Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouteExercices.fxml"));
                Scene scene1 = new Scene(root1);
                scene1.setFill(new Color(0, 0, 0, 0));
                stageExercice.setScene(scene1);
                stageExercice.show();

            } catch (IOException ex) {
                System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
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
            ButtonExoActive = true;
            idJours = "Jour 3";
            currentMuscle = textFJrs3.getText();
            try {

                Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouteExercices.fxml"));
                Scene scene1 = new Scene(root1);
                scene1.setFill(new Color(0, 0, 0, 0));
                stageExercice.setScene(scene1);
                stageExercice.show();

            } catch (IOException ex) {
                System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
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
            ButtonExoActive = true;
            idJours = "Jour 4";
            currentMuscle = textFJrs4.getText();
            try {

                Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouteExercices.fxml"));
                Scene scene1 = new Scene(root1);
                scene1.setFill(new Color(0, 0, 0, 0));
                stageExercice.setScene(scene1);
                stageExercice.show();

            } catch (IOException ex) {
                System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
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
            ButtonExoActive = true;
            idJours = "Jour 5";
            currentMuscle = textFJrs5.getText();
            try {

                Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouteExercices.fxml"));
                Scene scene1 = new Scene(root1);
                scene1.setFill(new Color(0, 0, 0, 0));
                stageExercice.setScene(scene1);
                stageExercice.show();

            } catch (IOException ex) {
                System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
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
            ButtonExoActive = true;
            idJours = "Jour 6";
            currentMuscle = textFJrs6.getText();
            try {

                Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouteExercices.fxml"));
                Scene scene1 = new Scene(root1);
                scene1.setFill(new Color(0, 0, 0, 0));
                stageExercice.setScene(scene1);
                stageExercice.show();

            } catch (IOException ex) {
                System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
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
            ButtonExoActive = true;
            idJours = "Jour 7";
            currentMuscle = textFJrs7.getText();
            try {

                Parent root1 = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLAjouteExercices.fxml"));
                Scene scene1 = new Scene(root1);
                scene1.setFill(new Color(0, 0, 0, 0));
                stageExercice.setScene(scene1);
                stageExercice.show();

            } catch (IOException ex) {
                System.out.println("gymapplication.program.FXMLAjouterProgrammeController.Retour()");
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

        FXMLAjouterProgrammeController.ButtonExoActive = false;
        //ThreadProgramme.thread.setNotiffy();
    }

    public void initThread() {
        thread = new MyThread();
        new Thread(thread).start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stageExercice.initStyle(StageStyle.TRANSPARENT);
        initThread();
        conn = DBConnection.EtablirConnection();

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

                if (testChampVide(nomProg.getText()) && (testChampVide(textFJrs1.getText()) || testChampVide(textFJrs2.getText()) || testChampVide(textFJrs3.getText()) || testChampVide(textFJrs4.getText()) || testChampVide(textFJrs5.getText()) || testChampVide(textFJrs6.getText()) || testChampVide(textFJrs7.getText()))) {
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
