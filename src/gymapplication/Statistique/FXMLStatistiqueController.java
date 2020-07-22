/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.Statistique;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import gymapplication.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author unknown
 */
public class FXMLStatistiqueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private StackedBarChart<?, ?> fxidBarchar;

    @FXML
    private CategoryAxis fxidcategorie;

    @FXML
    private NumberAxis fxidNumber;
    
   

    @FXML
    private JFXTextField fxidNombreJour;

    @FXML
    private JFXTextField fxidTotalesCons;

    @FXML
    private JFXTextField fxidBenificeJour;

    @FXML
    private JFXTextField fxidBenificeMois;

    @FXML
    private JFXTextField fxidTotalesBenifice;

    @FXML
    private JFXTextField fxidNombreMois;
    
    
    @FXML
    private JFXButton fxidRecherche;

    @FXML
    private JFXTextField fxidAnne;
    
        private final DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        private final DateTimeFormatter formatterJOUR =DateTimeFormatter.ofPattern("dd");

        private final DateTimeFormatter formatterMOIS =DateTimeFormatter.ofPattern("MM");
         private final DateTimeFormatter formatterANS =DateTimeFormatter.ofPattern("yyyy");
     
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        ConnectionDB();
   }    
    
    
    
         
    @FXML
    void Recherche() {
        
           
       fxidBarchar.getData().clear();
        XYChart.Series setl= new XYChart.Series<>();
       
        int i=0;
        i=Integer.parseInt(fxidAnne.getText());
        if(i==0)
        {
        }
        else
        {
       
         String sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-01-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
        
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Janvier",  Integer.parseInt(rs.getString(1)))); }
            
            
            sql="select count(idAbonnement) from Abonnement where  Date_Debut LIKE '%-02-%' and  Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Février",  Integer.parseInt(rs.getString(1)))); }
           
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-03-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
          
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Mars",  Integer.parseInt(rs.getString(1)))); }
           
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-04-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Avril",  Integer.parseInt(rs.getString(1)))); }
           
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-05-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Mai",  Integer.parseInt(rs.getString(1)))); }
           
            
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-6-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Juin",  Integer.parseInt(rs.getString(1)))); }
           
            
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-07-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Juillet",  Integer.parseInt(rs.getString(1)))); }
           
            
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-08-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Aout",  Integer.parseInt(rs.getString(1)))); }
           
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-09-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Septembre",  Integer.parseInt(rs.getString(1)))); }
           
            
            
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-10-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Octobre",  Integer.parseInt(rs.getString(1)))); }
           
            
          
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-11-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Novembre",  Integer.parseInt(rs.getString(1)))); }
           
             
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-12-%' and Date_Debut LIKE '%"+fxidAnne.getText()+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  setl.getData().add(new XYChart.Data("Décembre",  Integer.parseInt(rs.getString(1)))); }
           

            
             sql=  "select count(idAbonnement) from Abonnement where  Date_Debut Like '%-"+formatterJOUR.format(LocalDate.now())+"'  and  Date_Debut LIKE '%-"+formatterMOIS.format(LocalDate.now())+"-%' and Date_Debut LIKE '%"+formatterANS.format(LocalDate.now())+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  fxidNombreJour.setText(rs.getString(1)); }
                                    System.out.println("recheerch");

            sql=  "select SUM(Prix)  from Abonnement where  Date_Debut Like '%-"+formatterJOUR.format(LocalDate.now())+"' and  Date_Debut LIKE '%-"+formatterMOIS.format(LocalDate.now())+"-%' and Date_Debut LIKE '%"+formatterANS.format(LocalDate.now())+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  fxidBenificeJour.setText(rs.getString(1)); }
            
              
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%-"+formatterMOIS.format(LocalDate.now())+"-%' and Date_Debut LIKE '%"+formatterANS.format(LocalDate.now())+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  fxidNombreMois.setText(rs.getString(1)); }
           
            
                sql="select SUM(Prix) from Abonnement where  Date_Debut Like '%-"+formatterMOIS.format(LocalDate.now())+"-%' and Date_Debut LIKE '%"+formatterANS.format(LocalDate.now())+"-%'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  fxidBenificeMois.setText(rs.getString(1)); }
            
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%"+formatterANS.format(LocalDate.now())+"-%'";       
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  fxidTotalesCons.setText(rs.getString(1)); }
            
            sql="select count(idAbonnement) from Abonnement where  Date_Debut Like '%"+formatterANS.format(LocalDate.now())+"-%'";        
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  fxidTotalesCons.setText(rs.getString(1)); }
            
             sql="select SUM(Prix) from Abonnement where  Date_Debut Like '%"+formatterANS.format(LocalDate.now())+"-%'";    
             pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  fxidTotalesBenifice.setText(rs.getString(1)); }
            
            
            pst.close();
           rs.close();
 
            
        } catch (SQLException ex) {
           
        }
        
        
       
        fxidBarchar.getData().addAll(setl);
        
      

        }

    }
    
     public void ConnectionDB()
        {con=DBConnection.EtablirConnection(); }
    
     
     
}
