/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author hdegd
 */
public class GYMApplication extends Application {
    
    public static Stage logStage;
    
    @Override
    public void start(Stage stage) throws Exception {

       try {
              //Parent root = FXMLLoader.load(getClass().getResource("/Login/login.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/gymapplication/Login/login.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(new Color(0, 0, 0, 0));
            logStage = stage;
            
           // stage.getIcons().add(new Image(main.class.getResourceAsStream("logoCompany.png")));
            stage.setMinHeight(500.0);
            stage.setMinWidth(850.0);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
           
            stage.show();
            
//             PauseTransition delay = new PauseTransition(Duration.seconds(5));
//            delay.setOnFinished( event -> stage.close() );
//             delay.play();
//            
         
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
                        
    }
    
}
