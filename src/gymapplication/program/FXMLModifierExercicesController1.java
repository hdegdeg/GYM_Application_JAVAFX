/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;   


import com.jfoenix.controls.JFXTextField;
import gymapplication.Programme.list.ListeExercice;
import gymapplication.Programme.list.ListeJours;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
                                    
public class FXMLModifierExercicesController1 implements Initializable {


@FXML
    private Label lblCaption;

    @FXML
    private JFXTextField tfNomprog;

    @FXML
    private Label lblType;

    @FXML
    private Label lblType1;

    @FXML
    private Label fxEX1;

    @FXML
    private Label fxEX2;

    @FXML
    private Label fxEX3;

    @FXML
    private Label fxEX4;

    @FXML
    private Label fxEX5;

    @FXML
    private Label fxEX6;

    @FXML
    private Label fxEX7;

    @FXML
    private Label fxEX8;

    @FXML
    private Label fxEX9;

    @FXML
    private Label fxEX10;

    @FXML
    private JFXTextField tfSeries1;

    @FXML
    private JFXTextField tfRepet1;

    @FXML
    private JFXTextField tfSeries2;

    @FXML
    private JFXTextField tfRepet2;

    @FXML
    private JFXTextField tfSeries3;

    @FXML
    private JFXTextField tfRepet3;

    @FXML
    private JFXTextField tfSeries4;

    @FXML
    private JFXTextField tfRepet4;

    @FXML
    private JFXTextField tfSeries5;

    @FXML
    private JFXTextField tfRepet5;

    @FXML
    private JFXTextField tfSeries6;

    @FXML
    private JFXTextField tfRepet6;

    @FXML
    private JFXTextField tfSeries7;

    @FXML
    private JFXTextField tfRepet7;

    @FXML
    private JFXTextField tfSeries8;

    @FXML
    private JFXTextField tfRepet8;

    @FXML
    private JFXTextField tfSeries9;

    @FXML
    private JFXTextField tfRepet9;

    @FXML
    private JFXTextField tfSeries10;

    @FXML
    private JFXTextField tfRepet10;

    @FXML
    private Label lblType3;

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
    private Button btnClose;
   
    FXMLModifierProgrammeController programme = new FXMLModifierProgrammeController();
    MyThread thread;
    
    ListeJours newJours = new ListeJours();
    
    @FXML
    void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        thread.setStoped(true);
        
        FXMLModifierProgrammeController.ButtonExoActive=false;
        //ThreadProgramme.thread.setNotiffy();
    }

    @FXML
    void addExo(){
       if(testChampVide(tfNom1.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom1.getText());
        newExo.setNombre_Repetition(tfRepet1.getText());
        newExo.setNombre_Series(tfSeries1.getText());
        newJours.setListeExo(newExo);
                
       }
       
         if(testChampVide(tfNom2.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom2.getText());
        newExo.setNombre_Repetition(tfRepet2.getText());
        newExo.setNombre_Series(tfSeries2.getText());
        newJours.setListeExo(newExo);
                
       }
         
           if(testChampVide(tfNom3.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom3.getText());
        newExo.setNombre_Repetition(tfRepet3.getText());
        newExo.setNombre_Series(tfSeries3.getText());
        newJours.setListeExo(newExo);
                
       }
          if(testChampVide(tfNom4.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom4.getText());
        newExo.setNombre_Repetition(tfRepet4.getText());
        newExo.setNombre_Series(tfSeries4.getText());
        newJours.setListeExo(newExo);
                
       }
          
            if(testChampVide(tfNom5.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom5.getText());
        newExo.setNombre_Repetition(tfRepet5.getText());
        newExo.setNombre_Series(tfSeries5.getText());
        newJours.setListeExo(newExo);
                
       }
            
              if(testChampVide(tfNom6.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom6.getText());
        newExo.setNombre_Repetition(tfRepet6.getText());
        newExo.setNombre_Series(tfSeries6.getText());
        newJours.setListeExo(newExo);
                
       }
              
                if(testChampVide(tfNom7.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom7.getText());
        newExo.setNombre_Repetition(tfRepet7.getText());
        newExo.setNombre_Series(tfSeries7.getText());
        newJours.setListeExo(newExo);
                
       }
                
                  if(testChampVide(tfNom8.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom8.getText());
        newExo.setNombre_Repetition(tfRepet8.getText());
        newExo.setNombre_Series(tfSeries8.getText());
        newJours.setListeExo(newExo);
                
       }
          if(testChampVide(tfNom9.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom9.getText());
        newExo.setNombre_Repetition(tfRepet9.getText());
        newExo.setNombre_Series(tfSeries9.getText());
        newJours.setListeExo(newExo);
                
       }
            if(testChampVide(tfNom10.getText())){
        ListeExercice newExo= new ListeExercice();
        newExo.setIdJour(programme.idJours);
        newExo.setNom_Exo(tfNom10.getText());
        newExo.setNombre_Repetition(tfRepet10.getText());
        newExo.setNombre_Series(tfSeries10.getText());
        newJours.setListeExo(newExo);
        
                
       }
            
            newJours.setNomJ(programme.idJours);
            newJours.setMuscles(programme.currentMuscle);
            programme.addJourEntrainnement(newJours);
            programme.idJours="";
            programme.currentMuscle="";
            quit();
            
    }

    public  boolean testChampVide(String champ)
      {
          if(champ.equals(""))
                  {
                      return false;
                  }else if(champ==null){
                      return false;
                  }
             else {return true;}
      }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        thread = new MyThread();
        new Thread(thread).start();
        
           //     con=DBConnection.EtablirConnection();

    }    

public class MyThread implements Runnable{
    FXMLModifierExercicesController1 prog = new FXMLModifierExercicesController1();
     private  boolean isStopped=false;
    private int i=0;
     public synchronized void setStoped(boolean b)
     {
         isStopped=b;
     }
      public synchronized boolean testChampVide(String champ)
      {
          if(champ.equals(""))
                  {
                      return false;
                  }else if(champ==null){
                      return false;
                  }
             else {return true;}
      }
    @Override
     public void run() 
    { 
        
        fxEX1.setTextFill(Color.BLUE);
          while( isStopped==false){
  
        System.out.println("##################################################") ;
            if(isStopped==true) {
                System.out.println("Server Stopped.") ;
                return;
            }
           
            if(testChampVide(tfNom1.getText()))
            {   fxEX2.setTextFill(Color.BLUE);
                tfNom2.setDisable(false);
                tfNom2.setUnFocusColor(Color.RED);
                 tfRepet2.setDisable(false);
                tfRepet2.setUnFocusColor(Color.RED);
                 tfSeries2.setDisable(false);
                tfSeries2.setUnFocusColor(Color.RED);

					 if(testChampVide(tfNom2.getText()))
           				 {       fxEX3.setTextFill(Color.BLUE);
               					 tfNom3.setDisable(false);
                                                 tfNom3.setUnFocusColor(Color.RED);
                                                 tfRepet3.setDisable(false);
                                                 tfRepet3.setUnFocusColor(Color.RED);
                                                 tfSeries3.setDisable(false);
                                                 tfSeries3.setUnFocusColor(Color.RED);

							if(testChampVide(tfNom3.getText()))
            						{   fxEX4.setTextFill(Color.BLUE);
             						   tfNom4.setDisable(false);
                                                           tfNom4.setUnFocusColor(Color.RED);
                                                           tfRepet4.setDisable(false);
                                                           tfRepet4.setUnFocusColor(Color.RED);
                                                           tfSeries4.setDisable(false);
                                                           tfSeries4.setUnFocusColor(Color.RED);                                                           

								 if(testChampVide(tfNom4.getText()))
          							  {     fxEX5.setTextFill(Color.BLUE);
         							       tfNom5.setDisable(false);
                                                                       tfNom5.setUnFocusColor(Color.RED);
                                                                       tfRepet5.setDisable(false);
                                                                       tfRepet5.setUnFocusColor(Color.RED);
                                                                       tfSeries5.setDisable(false);
                                                                       tfSeries5.setUnFocusColor(Color.RED);						
									 if(testChampVide(tfNom5.getText()) )
           								 {  fxEX6.setTextFill(Color.BLUE);
              								    tfNom6.setDisable(false);
                                                                            tfNom6.setUnFocusColor(Color.RED);
                                                                            tfRepet6.setDisable(false);
                                                                            tfRepet6.setUnFocusColor(Color.RED);
                                                                            tfSeries6.setDisable(false);
                                                                            tfSeries6.setUnFocusColor(Color.RED);
										if(testChampVide(tfNom6.getText()))
           									 {  fxEX7.setTextFill(Color.BLUE);
           									     tfNom7.setDisable(false);
                                                                                     tfNom7.setUnFocusColor(Color.RED);
                                                                                     tfRepet7.setDisable(false);
                                                                                     tfRepet7.setUnFocusColor(Color.RED);
                                                                                     tfSeries7.setDisable(false);
                                                                                     tfSeries7.setUnFocusColor(Color.RED);
											if(testChampVide(tfNom7.getText())  )
          										  {    fxEX8.setTextFill(Color.BLUE);
         										       tfNom8.setDisable(false);
                                                                                               tfNom8.setUnFocusColor(Color.RED);
                                                                                               tfRepet8.setDisable(false);
                                                                                               tfRepet8.setUnFocusColor(Color.RED);
                                                                                               tfSeries8.setDisable(false);
                                                                                               tfSeries8.setUnFocusColor(Color.RED);
													  if(testChampVide(tfNom8.getText()))
           												  { 
                                                                                                              fxEX9.setTextFill(Color.BLUE);
          												      tfNom9.setDisable(false);
                                                                                                              tfNom9.setUnFocusColor(Color.RED);
                                                                                                              tfRepet9.setDisable(false);
                                                                                                              tfRepet9.setUnFocusColor(Color.RED);
                                                                                                              tfSeries9.setDisable(false);
                                                                                                              tfSeries9.setUnFocusColor(Color.RED); 
                                                                                                              if(testChampVide(tfNom9.getText()))
        													  {     fxEX10.setTextFill(Color.BLUE);
        													        tfNom10.setDisable(false);
                                                                                                                        tfNom10.setUnFocusColor(Color.RED);
                                                                                                                        tfRepet10.setDisable(false);
                                                                                                                        tfRepet10.setUnFocusColor(Color.RED);
                                                                                                                        tfSeries10.setDisable(false);
                                                                                                                        tfSeries10.setUnFocusColor(Color.RED);
        													  }
        													 else if(!testChampVide(tfNom9.getText()) )
          													 {          fxEX10.setTextFill(Color.BLACK);
                                                                                                                             tfRepet10.setDisable(true);
                                                                                                                             tfSeries10.setDisable(true);
              
            														   tfNom10.setDisable(true);
            													}
          												  }
         												  else if(!testChampVide(tfNom8.getText())  )
        												    {   fxEX9.setTextFill(Color.BLACK);
                                                                                                                fxEX10.setTextFill(Color.BLACK);
             
                                                                                                                tfRepet10.setDisable(true);
                                                                                                                tfSeries10.setDisable(true);
                                                                                                                tfRepet9.setDisable(true);
                                                                                                               tfSeries9.setDisable(true);
        												       tfNom9.setDisable(true);
           												       tfNom10.setDisable(true);
          												     }
            
            /////////////////////////////////7
            
           
         										   }
         										else   if(!testChampVide(tfNom7.getText()) )
        										    {   fxEX8.setTextFill(Color.BLACK);
                                                                                                fxEX9.setTextFill(Color.BLACK);
                                                                                                fxEX10.setTextFill(Color.BLACK);
                                                                                                
                                                                                                tfRepet10.setDisable(true);
                                                                                                tfSeries10.setDisable(true);
                                                                                                tfRepet9.setDisable(true);
                                                                                                tfSeries9.setDisable(true);
                                                                                                tfRepet8.setDisable(true);
                                                                                                tfSeries8.setDisable(true);
                                                                                                tfNom8.setDisable(true);
         										      tfNom9.setDisable(true);
          										      tfNom10.setDisable(true);
         										    }
            
            ////////////////////////////////6
            
          
          									  }
         									 else  if(!testChampVide(tfNom6.getText())  )
          									  { fxEX7.setTextFill(Color.BLACK);
                                                                                    fxEX8.setTextFill(Color.BLACK);
                                                                                    fxEX9.setTextFill(Color.BLACK);
                                                                                    fxEX10.setTextFill(Color.BLACK);
               
          									    tfRepet10.setDisable(true);
                                                                                    tfSeries10.setDisable(true);
                                                                                    tfRepet9.setDisable(true);
                                                                                    tfSeries9.setDisable(true);
                                                                                    tfRepet8.setDisable(true);
                                                                                    tfSeries8.setDisable(true);
                                                                                    tfRepet7.setDisable(true);
                                                                                    tfSeries7.setDisable(true);
                                                                                    tfNom8.setDisable(true); 
                                                                                     tfNom7.setDisable(true);
           									     tfNom8.setDisable(true);
           									     tfNom9.setDisable(true);
           									     tfNom10.setDisable(true);
          									  }
            
            ///////////////////////////////5
            
            
           								 }
          								  else if(!testChampVide(tfNom5.getText()) )
          								  { fxEX6.setTextFill(Color.BLACK);
                                                                            fxEX7.setTextFill(Color.BLACK);
                                                                            fxEX8.setTextFill(Color.BLACK);
                                                                            fxEX9.setTextFill(Color.BLACK);
                                                                            fxEX10.setTextFill(Color.BLACK);
               
                                                                            tfRepet10.setDisable(true);
                                                                            tfSeries10.setDisable(true);
                                                                            tfRepet9.setDisable(true);
                                                                            tfSeries9.setDisable(true);
                                                                            tfRepet8.setDisable(true);
                                                                            tfSeries8.setDisable(true);
                                                                            tfRepet7.setDisable(true);
                                                                            tfSeries7.setDisable(true);
                                                                            tfRepet6.setDisable(true);
                                                                            tfSeries6.setDisable(true);
                                                                            tfNom6.setDisable(true);
            								   tfNom7.setDisable(true);
            								   tfNom8.setDisable(true);
            								   tfNom9.setDisable(true);
            								   tfNom10.setDisable(true);
           								 }
           //////////////////////////////////////////////4
           
           
          							  }
           							else if(!testChampVide(tfNom4.getText())  )
          							  { fxEX5.setTextFill(Color.BLACK);
                                                                    fxEX6.setTextFill(Color.BLACK);
                                                                    fxEX7.setTextFill(Color.BLACK);
                                                                    fxEX8.setTextFill(Color.BLACK);
                                                                    fxEX9.setTextFill(Color.BLACK);
                                                                    fxEX10.setTextFill(Color.BLACK);
               
                                                                    tfRepet10.setDisable(true);
                                                                    tfSeries10.setDisable(true);
                                                                    tfRepet9.setDisable(true);
                                                                    tfSeries9.setDisable(true);
                                                                    tfRepet8.setDisable(true);
                                                                    tfSeries8.setDisable(true);
                                                                    tfRepet7.setDisable(true);
                                                                    tfSeries7.setDisable(true);
                                                                    tfRepet6.setDisable(true);
                                                                    tfSeries6.setDisable(true);
           							    tfRepet5.setDisable(true);
                                                                    tfSeries5.setDisable(true);
                                                                    tfNom5.setDisable(true);
             							    tfNom6.setDisable(true);
              							    tfNom7.setDisable(true);
             							    tfNom8.setDisable(true);
             							    tfNom9.setDisable(true);
             							    tfNom10.setDisable(true);
           							 }
            
            ////////////////////////////////////////////////////33
            
           
         					        }
          						  else if(!testChampVide(tfNom3.getText()) )
           						 {  fxEX4.setTextFill(Color.BLACK);
                                                            fxEX5.setTextFill(Color.BLACK);
                                                            fxEX6.setTextFill(Color.BLACK);
                                                            fxEX7.setTextFill(Color.BLACK);
                                                            fxEX8.setTextFill(Color.BLACK);
                                                            fxEX9.setTextFill(Color.BLACK);
                                                            fxEX10.setTextFill(Color.BLACK);
              
                                                                tfRepet10.setDisable(true);
                                                                tfSeries10.setDisable(true);
                                                                tfRepet9.setDisable(true);
                                                                tfSeries9.setDisable(true);
                                                                tfRepet8.setDisable(true);
                                                                tfSeries8.setDisable(true);
                                                                tfRepet7.setDisable(true);
                                                                tfSeries7.setDisable(true);
                                                                tfRepet6.setDisable(true);
                                                                tfSeries6.setDisable(true);
                                                                tfRepet5.setDisable(true);
                                                                tfSeries5.setDisable(true);
               							tfRepet4.setDisable(true);
                                                                tfSeries4.setDisable(true);
                                                                tfNom4.setDisable(true);
              							tfNom5.setDisable(true);
            							tfNom6.setDisable(true);
            							tfNom7.setDisable(true);
           							tfNom8.setDisable(true);
           							tfNom9.setDisable(true);
             							tfNom10.setDisable(true);
            						}
            
            //////////////////////////////////22
           
           				 }
           				 else if(!testChampVide(tfNom2.getText()) )
           				 {       fxEX3.setTextFill(Color.BLACK);    
                                                 fxEX4.setTextFill(Color.BLACK);
                                                 fxEX5.setTextFill(Color.BLACK);
                                                 fxEX6.setTextFill(Color.BLACK);
                                                 fxEX7.setTextFill(Color.BLACK);
                                                 fxEX8.setTextFill(Color.BLACK);
                                                 fxEX9.setTextFill(Color.BLACK);
                                                 fxEX10.setTextFill(Color.BLACK);
                                                            
                                                 
                                                 tfRepet10.setDisable(true);
                                                 tfSeries10.setDisable(true);
                                                 tfRepet9.setDisable(true);
                                                 tfSeries9.setDisable(true);
                                                 tfRepet8.setDisable(true);
                                                 tfSeries8.setDisable(true);
                                                 tfRepet7.setDisable(true);
                                                 tfSeries7.setDisable(true);
                                                 tfRepet6.setDisable(true);
                                                 tfSeries6.setDisable(true);
                                                 tfRepet5.setDisable(true);
                                                 tfSeries5.setDisable(true);
                                                 tfRepet4.setDisable(true);
                                                 tfSeries4.setDisable(true);
                                                 tfRepet3.setDisable(true);
                                                 tfSeries3.setDisable(true);
              					 tfNom3.setDisable(true);
              					 tfNom4.setDisable(true);
              					 tfNom5.setDisable(true);
             					 tfNom6.setDisable(true);
              					 tfNom7.setDisable(true);
              					 tfNom8.setDisable(true);
             					 tfNom9.setDisable(true);
             					 tfNom10.setDisable(true);
            				}
            
            ////////////////////////
            
            
            }
            else if(!testChampVide(tfNom1.getText()))
            {  fxEX2.setTextFill(Color.BLACK);
               fxEX3.setTextFill(Color.BLACK);    
               fxEX4.setTextFill(Color.BLACK);
               fxEX5.setTextFill(Color.BLACK);
               fxEX6.setTextFill(Color.BLACK);
               fxEX7.setTextFill(Color.BLACK);
               fxEX8.setTextFill(Color.BLACK);
               fxEX9.setTextFill(Color.BLACK);
               fxEX10.setTextFill(Color.BLACK); 
                
               
               tfRepet10.setDisable(true);
               tfSeries10.setDisable(true);
               tfRepet9.setDisable(true);
               tfSeries9.setDisable(true);
               tfRepet8.setDisable(true);
               tfSeries8.setDisable(true);
               tfRepet7.setDisable(true);
               tfSeries7.setDisable(true);
               tfRepet6.setDisable(true);
               tfSeries6.setDisable(true);
               tfRepet5.setDisable(true);
               tfSeries5.setDisable(true);
               tfRepet4.setDisable(true);
               tfSeries4.setDisable(true);
               tfRepet3.setDisable(true);
               tfSeries3.setDisable(true);
               tfRepet2.setDisable(true);
               tfSeries2.setDisable(true);
               tfNom2.setDisable(true);
               tfNom3.setDisable(true);
               tfNom4.setDisable(true);
               tfNom5.setDisable(true);
               tfNom6.setDisable(true);
               tfNom7.setDisable(true);
               tfNom8.setDisable(true);
               tfNom9.setDisable(true);
               tfNom10.setDisable(true);
            }
            //////////////////////////////////
            
           
            
            /////////////////////////////////////////
            
           
            
           }
            
            
            
            
        }
        
        
        
        
        
  
    } 
}

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            