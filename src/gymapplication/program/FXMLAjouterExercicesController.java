/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication.program;   


import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
                                    
public class FXMLAjouterExercicesController implements Initializable {


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
    FXMLAjouterProgrammeController InterfaceAjoutProgramme = new FXMLAjouterProgrammeController();
   
    
    MyThread thread;
    
    
    @FXML
    void quit(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        thread.setStoped(true);
        
        FXMLAjouterProgrammeController.ButtonExoActive=false;
        //ThreadProgramme.thread.setNotiffy();
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        thread = new MyThread();
        new Thread(thread).start();
        
           //     con=DBConnection.EtablirConnection();

    }    

public class MyThread implements Runnable{
    FXMLAjouterExercicesController prog = new FXMLAjouterExercicesController();
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

					 if(testChampVide(tfNom2.getText()))
           				 {       fxEX3.setTextFill(Color.BLUE);
               					 tfNom3.setDisable(false);
                                                 tfNom3.setUnFocusColor(Color.RED);

							if(testChampVide(tfNom3.getText()))
            						{   fxEX4.setTextFill(Color.BLUE);
             						   tfNom4.setDisable(false);
                                                           tfNom4.setUnFocusColor(Color.RED);

								 if(testChampVide(tfNom4.getText()))
          							  {     fxEX5.setTextFill(Color.BLUE);
         							       tfNom5.setDisable(false);
                                                                       tfNom5.setUnFocusColor(Color.RED);
						
									 if(testChampVide(tfNom5.getText()) )
           								 {  fxEX6.setTextFill(Color.BLUE);
              								    tfNom6.setDisable(false);
                                                                            tfNom6.setUnFocusColor(Color.RED);

										if(testChampVide(tfNom6.getText()))
           									 {  fxEX7.setTextFill(Color.BLUE);
           									     tfNom7.setDisable(false);
                                                                                     tfNom7.setUnFocusColor(Color.RED);

											if(testChampVide(tfNom7.getText())  )
          										  {     fxEX8.setTextFill(Color.BLUE);
         										       tfNom8.setDisable(false);
                                                                                               tfNom8.setUnFocusColor(Color.RED);
													  if(testChampVide(tfNom8.getText()))
           												  { 
                                                                                                              fxEX9.setTextFill(Color.BLUE);
          												      tfNom9.setDisable(false);
                                                                                                              tfNom9.setUnFocusColor(Color.RED);
														 if(testChampVide(tfNom9.getText()))
        													  {     fxEX10.setTextFill(Color.BLUE);
        													        tfNom10.setDisable(false);
                                                                                                                        tfNom10.setUnFocusColor(Color.RED);
        													  }
        													 else if(!testChampVide(tfNom9.getText()) )
          													 {          fxEX10.setTextFill(Color.BLACK);
              
            														   tfNom10.setDisable(true);
            													}
          												  }
         												  else if(!testChampVide(tfNom8.getText())  )
        												    {   fxEX9.setTextFill(Color.BLACK);
                                                                                                                fxEX10.setTextFill(Color.BLACK);
             
        												       tfNom9.setDisable(true);
           												       tfNom10.setDisable(true);
          												     }
            
            /////////////////////////////////7
            
           
         										   }
         										else   if(!testChampVide(tfNom7.getText()) )
        										    {   fxEX8.setTextFill(Color.BLACK);
                                                                                                fxEX9.setTextFill(Color.BLACK);
                                                                                                fxEX10.setTextFill(Color.BLACK);
              
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

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            