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
import static gymapplication.Login.loginController.TypeUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLAccueilController implements Initializable {

    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Parent root;
    public static Stage stageProgramme = new Stage();
    public static Stage stageCondidat = new Stage();
    public static Stage stageExpiration = new Stage();
    public static Stage stageAbonnement = new Stage();
    public static Stage stageStatistique = new Stage();
    public static Stage modificationUser = new Stage();
    public Scene sceneProgramme;
    @FXML
    public   AnchorPane AnchorPane;
    
    @FXML
    public  VBox fenetreStatic;
    private Stage stage = new Stage();
 
    public Parent rootProgramme;
    public Parent rootCondidat;
    public Parent rootAbonnement;
    private Stage stage3 = new Stage();
    private Stage save;

    /**
     * Initializes the controller class.
     */
    
    private boolean  testAdminOrNot(){
       
        if(TypeUser.equals("admin")){
            fenetreStatic.setVisible(true); return true;
        }
        else {
            fenetreStatic.setVisible(false);
            return false;
        }
   }
    
    @FXML
    void Programme(MouseEvent event) throws IOException {
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);

        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/program/FXMLProgrammes.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(new Color(0, 0, 0, 0));
        stageProgramme.setScene(scene);
        stageProgramme.showAndWait();

        AnchorPane.setDisable(false);
        AnchorPane.setOpacity(1);
       

    }

    @FXML
    public void Abonnement() throws IOException {
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);

        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/Abonnement/FXMLAbonnement.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(new Color(0, 0, 0, 0));
        stageAbonnement.setScene(scene);
        stageAbonnement.showAndWait();

        AnchorPane.setDisable(false);
        AnchorPane.setOpacity(1);

    }

    @FXML
    private void ajouteCondidat() throws IOException {

        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);

        rootAbonnement = FXMLLoader.load(getClass().getResource("/gymapplication/accueil/ajouteCondidat/ajouteCondidat.fxml"));
        Scene scene = new Scene(rootAbonnement);

        scene.setFill(new Color(0, 0, 0, 0));
        stage.setScene(scene);
        stage.showAndWait();

        AnchorPane.setDisable(false);
        AnchorPane.setOpacity(1);
    }

    @FXML
    public void listCondidats() throws IOException {

       
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);

         rootCondidat = FXMLLoader.load(getClass().getResource("/gymapplication/listeCondidat/listCondidat.fxml"));
        Scene scene = new Scene(rootCondidat);

        scene.setFill(new Color(0, 0, 0, 0));
        stageCondidat.setScene(scene);
        stageCondidat.showAndWait();

        AnchorPane.setDisable(false);
        AnchorPane.setOpacity(1);
    }

    @FXML
    public void abonnementExpire(MouseEvent event) throws IOException {
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);

        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/Expiration/FXMLExpiration.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(new Color(0, 0, 0, 0));
        stageExpiration.setScene(scene);
        stageExpiration.show();

        AnchorPane.setDisable(false);
        AnchorPane.setOpacity(1);

    }

    @FXML
    private void renouvellement(ActionEvent event) {
    }

    
    @FXML
    private void Statistique(MouseEvent event) throws IOException {
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);

        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/Statistique/FXMLStatistique.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(new Color(0, 0, 0, 0));
        stageStatistique.setScene(scene);
        stageStatistique.show();

        AnchorPane.setDisable(false);
        AnchorPane.setOpacity(1);

    }
    
    @FXML
    private void ModificationInfoUser() throws IOException {
        AnchorPane.setOpacity(0.4);
        AnchorPane.setDisable(true);

        Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/InfosUser/FXMLUpdateUser.fxml"));
        Scene scene = new Scene(root);

        scene.setFill(new Color(0, 0, 0, 0));
        modificationUser.setScene(scene);
        modificationUser.show();

        AnchorPane.setDisable(false);
        AnchorPane.setOpacity(1);

    }
    public File save() {              

              FileChooser fileChooser=new FileChooser();
                  fileChooser.setInitialDirectory(new File("C:\\"));
                  
                    
                  
                  fileChooser.getExtensionFilters().addAll(
                          new FileChooser.ExtensionFilter("Excel Files","*")
                  );
                  
                  
                  File f=fileChooser.showSaveDialog(save);
                  
         
         return f;
         }
         
         
         
    public File Import() {              

              FileChooser fileChooser=new FileChooser();
                  fileChooser.setInitialDirectory(new File("C:\\"));
                  
                    
                  
                  fileChooser.getExtensionFilters().addAll(
                          new FileChooser.ExtensionFilter("Excel Files","*")
                  );
                  
                  
                  File f=fileChooser.showOpenDialog(save);
                  
         
         return f;
         }
         
         
    @FXML
    public void ExportDonnee(){
           File f=save();
                  

        try {
            
            String sql = "select Condidat.idCondidat,Nom_Prenom,Age,Tele,Sexe,Condidat.idProg from Condidat" ;

                
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
        
               XSSFWorkbook wb=new XSSFWorkbook();
                XSSFSheet   sheet= wb.createSheet("Liste_CONDIDAT");
                XSSFRow headr= sheet.createRow(0);
                
                headr.createCell(0).setCellValue("ID_CONDIDAT");
                 headr.createCell(1).setCellValue("NOM & PRENOM");
                  headr.createCell(2).setCellValue("AGE");
                   headr.createCell(3).setCellValue("TEL");
                    headr.createCell(4).setCellValue("SEX");
                     headr.createCell(5).setCellValue("PROGRAMME");

                     sheet.autoSizeColumn(1);
                     sheet.autoSizeColumn(2);
                     sheet.autoSizeColumn(3);
                     sheet.autoSizeColumn(4);
                     sheet.autoSizeColumn(5);
                     int index=0;
            while(rs.next())
            {
                  XSSFRow row= sheet.createRow(index);
                  
                  row.createCell(0).setCellValue(rs.getString(1));
                  row.createCell(1).setCellValue(rs.getString(2));
                  row.createCell(2).setCellValue(rs.getString(3));
                  row.createCell(3).setCellValue(rs.getString(4));
                  row.createCell(4).setCellValue(rs.getString(5));
                  row.createCell(5).setCellValue(rs.getString(6));
        
                index++;
             
       }
               try (FileOutputStream fileoutMed = new FileOutputStream(f.getPath()+"Condidat.xlsx")) {
                        wb.write(fileoutMed);
                    }
               
               
               ////////////////////////////////////////Liste Abonnement/////////////////////////////////
               
               sql = "select * from Abonnement" ;

                
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
        
               XSSFWorkbook wbAbon=new XSSFWorkbook();
                XSSFSheet   sheetAbon= wbAbon.createSheet("Liste_ABONNEMENTS");
                XSSFRow headrAbon= sheetAbon.createRow(0);
                
                headrAbon.createCell(0).setCellValue("ID_ABONNEMENT");
                 headrAbon.createCell(1).setCellValue("DATE_DEBUT");
                  headrAbon.createCell(2).setCellValue("DATE_FIN");
                   headrAbon.createCell(3).setCellValue("NOMBRE_MOIS");
                    headrAbon.createCell(4).setCellValue("TYPE");
                     headrAbon.createCell(5).setCellValue("PRIX");
                       headrAbon.createCell(6).setCellValue("ID_CONDIDAT");
                     sheetAbon.autoSizeColumn(1);
                     sheetAbon.autoSizeColumn(2);
                     sheetAbon.autoSizeColumn(3);
                     sheetAbon.autoSizeColumn(4);
                     sheetAbon.autoSizeColumn(5);
                     sheetAbon.autoSizeColumn(6);
                      index=0;
            while(rs.next())
            {
                  XSSFRow row= sheetAbon.createRow(index);
                  
                  row.createCell(0).setCellValue(rs.getString(1));
                  row.createCell(1).setCellValue(rs.getString(2));
                  row.createCell(2).setCellValue(rs.getString(3));
                  row.createCell(3).setCellValue(rs.getString(4));
                  row.createCell(4).setCellValue(rs.getString(5));
                  row.createCell(5).setCellValue(rs.getString(6));
                  row.createCell(5).setCellValue(rs.getString(7));
                index++;
             
       }
               try (FileOutputStream fileoutMed = new FileOutputStream(f.getPath()+"Abonnement.xlsx")) {
                        wbAbon.write(fileoutMed);
                    }
               
               
                              ////////////////////////////////////////Liste EXERCICE/////////////////////////////////

                                             
               sql = "select * from Exercice" ;

                
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
        
               XSSFWorkbook wbExo=new XSSFWorkbook();
                XSSFSheet   sheetExo= wbExo.createSheet("Liste_Exercices");
                XSSFRow headrExo= sheetExo.createRow(0);
                
                headrExo.createCell(0).setCellValue("ID_EXERCICE");
                 headrExo.createCell(1).setCellValue("NOM_EXO");
                  headrExo.createCell(2).setCellValue("NOMBRE_REPETITION");
                   headrExo.createCell(3).setCellValue("NOMBRE_SERIES");
                    headrExo.createCell(4).setCellValue("ID_PROGRAMME");
                     headrExo.createCell(5).setCellValue("ID_JOUR");
                      
                     sheetExo.autoSizeColumn(1);
                     sheetExo.autoSizeColumn(2);
                     sheetExo.autoSizeColumn(3);
                     sheetExo.autoSizeColumn(4);
                     sheetExo.autoSizeColumn(5);
                    
                      index=0;
            while(rs.next())
            {
                  XSSFRow row= sheetExo.createRow(index);
                  
                  row.createCell(0).setCellValue(rs.getString(1));
                  row.createCell(1).setCellValue(rs.getString(2));
                  row.createCell(2).setCellValue(rs.getString(3));
                  row.createCell(3).setCellValue(rs.getString(4));
                  row.createCell(4).setCellValue(rs.getString(5));
                  
                index++;
             
       }
               try (FileOutputStream fileoutMed = new FileOutputStream(f.getPath()+"Exercice.xlsx")) {
                        wbExo.write(fileoutMed);
                    }
                ////////////////////////////////////////Liste JOURS/////////////////////////////////

                                             
               sql = "select * from Jour" ;

                
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
        
               XSSFWorkbook wbJour=new XSSFWorkbook();
                XSSFSheet   sheetJour= wbJour.createSheet("Liste_Jours");
                XSSFRow headrJour= sheetJour.createRow(0);
                
                headrJour.createCell(0).setCellValue("ID_JOUR");
                 headrJour.createCell(1).setCellValue("ID_PROGRAMME");
                  headrJour.createCell(2).setCellValue("MUSCLE");
          
                     sheetJour.autoSizeColumn(1);
                     sheetJour.autoSizeColumn(2);
                     sheetJour.autoSizeColumn(3);
               
                      index=0;
            while(rs.next())
            {
                  XSSFRow row= sheetJour.createRow(index);
                  
                  row.createCell(0).setCellValue(rs.getString(1));
                  row.createCell(1).setCellValue(rs.getString(2));
                  row.createCell(2).setCellValue(rs.getString(3));
              
                index++;
             
       }
               try (FileOutputStream fileoutMed = new FileOutputStream(f.getPath()+"Jours.xlsx")) {
                        wbJour.write(fileoutMed);
                    }
                             ////////////////////////////////////////Liste PROGRAMME/////////////////////////////////
               
               sql = "select * from Programme" ;

                
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
        
               XSSFWorkbook wbProg=new XSSFWorkbook();
                XSSFSheet   sheetProg= wbProg.createSheet("Liste_Programme");
                XSSFRow headrProg= sheetProg.createRow(0);
                
                headrProg.createCell(0).setCellValue("ID_PROGRAMME");
                 headrProg.createCell(1).setCellValue("NOM");
                  headrProg.createCell(2).setCellValue("NOMBRE_JOUR");
                
                     sheetProg.autoSizeColumn(1);
                     sheetProg.autoSizeColumn(2);
                     sheetProg.autoSizeColumn(3);
                    
                      index=0;
            while(rs.next())
            {
                  XSSFRow row= sheetProg.createRow(index);
                  
                  row.createCell(0).setCellValue(rs.getString(1));
                  row.createCell(1).setCellValue(rs.getString(2));
                  row.createCell(2).setCellValue(rs.getString(3));
                
                index++;
             
       }
               try (FileOutputStream fileoutMed = new FileOutputStream(f.getPath()+"Programme.xlsx")) {
                        wbProg.write(fileoutMed);
                    }
                             
                             
                             //////////////////////////////////////////////////////////////////////////////////////
                 } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
     
    @FXML
    public void ImportDonneeCondidat(){
             
               File f=Import();
               
               String sql = "insert into Condidat values(?,?,?,?,?,?)";
            try {
                ps=conn.prepareStatement(sql);
                
                
                FileInputStream fileIn = new FileInputStream(new File(f.getPath()));
               XSSFWorkbook wb=new XSSFWorkbook(fileIn);
                XSSFSheet   sheet= wb.getSheetAt(0);
                Row row;
                
                for(int i=0;i<=sheet.getLastRowNum();i++)
                {
                    row=sheet.getRow(i);
                    
                    System.out.println("**************"+row.getCell(0).getStringCellValue()+row.getCell(1).getStringCellValue()+row.getCell(2).getStringCellValue()+row.getCell(3).getStringCellValue()+row.getCell(4).getStringCellValue()+row.getCell(5).getStringCellValue());
                 
                    ps.setObject(1,row.getCell(0).getStringCellValue());
                    
                    ps.setString(2,row.getCell(1).getStringCellValue());
                    
                    ps.setString(3,row.getCell(2).getStringCellValue());
                    
                    ps.setString(4,row.getCell(3).getStringCellValue());
                    
                    
                    ps.setString(5,row.getCell(4).getStringCellValue());
                   
                   
                    ps.setString(6,row.getCell(5).getStringCellValue());
                   
                    
                    ps.execute();
                }
                
                wb.close();
                fileIn.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
         }
    
    
    @FXML
    public void ImportDonneeAbonnement(){

               File f=Import();
               
               String sql = "insert into Abonnement values(?,?,?,?,?,?,?)";
            try {
                ps=conn.prepareStatement(sql);
                
                
                FileInputStream fileIn = new FileInputStream(new File(f.getPath()));
               XSSFWorkbook wb=new XSSFWorkbook(fileIn);
                XSSFSheet   sheet= wb.getSheetAt(0);
                Row row;
                
                for(int i=0;i<=sheet.getLastRowNum();i++)
                {
                    row=sheet.getRow(i);
                                     
                    ps.setObject(1,row.getCell(0).getStringCellValue());
                    
                    ps.setString(2,row.getCell(1).getStringCellValue());
                    
                    ps.setString(3,row.getCell(2).getStringCellValue());
                    
                    ps.setString(4,row.getCell(3).getStringCellValue());
                    
                    
                    ps.setString(5,row.getCell(4).getStringCellValue());
                   
                   
                    ps.setString(6,row.getCell(5).getStringCellValue());
                   
                    ps.setString(7,row.getCell(6).getStringCellValue());
                    
                    ps.execute();
                }
                
                wb.close();
                fileIn.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
 
         }
         
    @FXML
    public void ImportDonneeProgramme(){

               File f=Import();
               
               String sql = "insert into Programme (idProgramme,Nom_Programme,Nombre_Jours) values(?,?,?)";
            try {
                ps=conn.prepareStatement(sql);
                
                
                FileInputStream fileIn = new FileInputStream(new File(f.getPath()));
               XSSFWorkbook wb=new XSSFWorkbook(fileIn);
                XSSFSheet   sheet= wb.getSheetAt(0);
                Row row;
                
                for(int i=0;i<=sheet.getLastRowNum();i++)
                {
                    row=sheet.getRow(i);
                                     
                    ps.setObject(1,row.getCell(0).getStringCellValue());
                    
                    ps.setString(2,row.getCell(1).getStringCellValue());
                    
                    ps.setString(3,row.getCell(2).getStringCellValue());

                    ps.execute();
                }
                
                wb.close();
                fileIn.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
         }
    
    
    @FXML
    public void ImportDonneeJour(){

               File f=Import();
               
               String sql = "insert into Jour (NomJ,idProgramme,Muscles) values(?,?,?)";
            try {
                ps=conn.prepareStatement(sql);
                
                
                FileInputStream fileIn = new FileInputStream(new File(f.getPath()));
               XSSFWorkbook wb=new XSSFWorkbook(fileIn);
                XSSFSheet   sheet= wb.getSheetAt(0);
                Row row;
                
                for(int i=0;i<=sheet.getLastRowNum();i++)
                {
                    row=sheet.getRow(i);
                                     
                    ps.setObject(1,row.getCell(0).getStringCellValue());
                    
                    ps.setString(2,row.getCell(1).getStringCellValue());
                    
                    ps.setString(3,row.getCell(2).getStringCellValue());

                    ps.execute();
                }
                
                wb.close();
                fileIn.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
         }
         
    @FXML
    public void ImportDonneeExercice(){

               File f=Import();
               
               String sql = "insert into Exercice (idExercice,Nom_Exo,Nombre_Repetition,Nombre_Series,idJour,idProgramme) values(?,?,?,?,?,?)";

            try {
                ps=conn.prepareStatement(sql);
                
                
                FileInputStream fileIn = new FileInputStream(new File(f.getPath()));
               XSSFWorkbook wb=new XSSFWorkbook(fileIn);
                XSSFSheet   sheet= wb.getSheetAt(0);
                Row row;
                
                for(int i=0;i<=sheet.getLastRowNum();i++)
                {
                    row=sheet.getRow(i);
                                     
                    ps.setObject(1,row.getCell(0).getStringCellValue());
                    
                    ps.setString(2,row.getCell(1).getStringCellValue());
                    
                    ps.setString(3,row.getCell(2).getStringCellValue());
                    
                    ps.setString(4,row.getCell(3).getStringCellValue());
                    ps.execute();
                }
                
                wb.close();
                fileIn.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
         }
    @FXML
    private void deconnection() {
        loginController.accueilStage.close();
        GYMApplication.logStage.show();
    }

    private void alertDate() throws ParseException, SQLException, IOException {
        String dt = LocalDate.now().toString();  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(c.getTime());
        String sql = "select Condidat.idCondidat,Nom_Prenom,Type,Date_Fin from Condidat  INNER JOIN Abonnement ON Condidat.idCondidat = Abonnement.idCondidat and Abonnement.Date_Fin <= '" + dt + "' order by Nom_Prenom asc";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            ps.close();
            rs.close();

            Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/AlertDate/alertDate.fxml"));

            Scene scene = new Scene(root);
            scene.setFill(new Color(0, 0, 0, 0));
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
        stageExpiration.initModality(Modality.APPLICATION_MODAL);
        stageExpiration.initStyle(StageStyle.TRANSPARENT);
        stageAbonnement.initModality(Modality.APPLICATION_MODAL);
        stageAbonnement.initStyle(StageStyle.TRANSPARENT);
        stageProgramme.initModality(Modality.APPLICATION_MODAL);
        stageProgramme.initStyle(StageStyle.TRANSPARENT);
        stageCondidat.initModality(Modality.APPLICATION_MODAL);
        stageCondidat.initStyle(StageStyle.TRANSPARENT);
        modificationUser.initStyle(StageStyle.TRANSPARENT);
        conn = DBConnection.EtablirConnection();
        testAdminOrNot();
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
