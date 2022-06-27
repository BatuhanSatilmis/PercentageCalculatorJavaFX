/* 
 * File:   main.java
 * Author: 

 *
 * JavaFX app: Percentage Calculator JavaFX
 * JavaFX scene graph: Scene Builder
 *
 * This is the Layout container and can be used to allow for flexible and dynamic
 * arrangements of the UI controls within a scene graph of a JavaFX application.
 */

/* library import */
import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/* main class */
public class main extends Application implements EventHandler<WindowEvent> {
    
    /* method start():
     *
     * A Stage in JavaFX is a top-level container that hosts a Scene, which consists
     * of visual elements.
     * The Stage class in the javafx.stage package represents a stage in a JavaFX application.
     * The primary stage is created by the platform and passed to the start
     * (Stage stage) method of the Application class.
     *
     * You can create additional stages as needed. */
    @Override
    public void start(Stage stage) throws Exception {
        
    
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
   
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false); //sets the form state as fixed
        stage.setTitle("Percentage Calculator"); //sets the title of the form
        
        stage.setOnCloseRequest(this);
        stage.show(); //shows the main form
    }
 
    
  @Override
  public void handle(WindowEvent e) {
      

      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Percentage Calculator"); //sets the dialog title
      alert.setHeaderText("Confirmation Message"); //sets the dialog header
      alert.setContentText("Are you sure you want to quit ?"); //sets the dialog content
      
 
      Optional<ButtonType> confirm = alert.showAndWait();
      
      if(confirm.get() == ButtonType.OK)
      {
          System.exit(0);
      }
      else
      {

          alert.close();
          e.consume();
      }
  }    
}
