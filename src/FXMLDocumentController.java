/* 
 *
 * This is a simple program that calculates the net percentage of a
 * given number plus the total number (net percentage + initial number).
 */

/* library import */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnCalc;
    @FXML
    private Button btnClear;
    @FXML
    private TextField txtInit;
    @FXML
    private TextField txtPct;
    @FXML
    private TextField txtResult;
    @FXML
    private TextField txtNetPct;
    @FXML
    private Label lblInit;
    @FXML
    private Label lblPct;
    @FXML
    private Label lblNetPct;
    @FXML
    private Label lblResult;
    @FXML
    private AnchorPane apMain;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnCalc.setDisable(true);
        btnClear.setDisable(true);
        txtPct.setDisable(true);
        txtNetPct.setEditable(false);
        txtNetPct.setDisable(true);
        txtResult.setEditable(false);
        txtResult.setDisable(true);
        // TODO
    }

    @FXML
    private void handleAction_btnCalc(ActionEvent event) {
        

        float init, pct, netPct, result;
        
  
        init = Float.parseFloat(txtInit.getText());
        pct = Float.parseFloat(txtPct.getText());
        
        netPct = (init * pct) / 100;
        result = init + netPct;
        

        txtNetPct.setDisable(false);
        txtNetPct.setText(Float.toString(netPct));
        txtResult.setDisable(false);
        txtResult.setText(Float.toString(result));
        btnCalc.setDisable(true);
    }

    @FXML
    private void handleAction_btnClear(ActionEvent event) {

        txtInit.clear();
        txtPct.clear();
        txtPct.setDisable(true);
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        btnClear.setDisable(true);
    }
    
    @FXML
    private void handle_txtInit(KeyEvent event) {
        
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        

        txtInit.textProperty().addListener((observable, oldValue, newValue) -> { 
        
         if(newValue.isEmpty())
         {
             if(txtPct.getText().isEmpty()) //checks if a text field is empty or not
             {
                 txtPct.setDisable(true);
                 btnClear.setDisable(true);
             }            
             txtNetPct.clear();
             txtResult.clear();
             btnCalc.setDisable(true);
         }
         else if(newValue.length() != oldValue.length() && !txtPct.getText().isEmpty())
         {
             btnCalc.setDisable(false);
         }
         else
         {
             btnClear.setDisable(false);
             txtPct.setDisable(false);
         }
        });
    }

    @FXML
    private void handle_txtPct(KeyEvent event) {
        
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        
        txtPct.textProperty().addListener((observable, oldValue, newValue) -> { 
         
         if(newValue.isEmpty())
         {
             if(txtInit.getText().isEmpty())
             {
                 txtPct.setDisable(true);
                 btnClear.setDisable(true);
             }
             txtNetPct.clear();
             txtResult.clear();
             btnCalc.setDisable(true);
         }
         else if(newValue.length() != oldValue.length() && txtInit.getText().isEmpty())
         {
             btnCalc.setDisable(true);
         }
         else
         {
             btnCalc.setDisable(false);
             btnClear.setDisable(false);
         }
        });    
    }

    @FXML
    private void handle_txtResult(KeyEvent event) {
    }

    @FXML
    private void handle_txtNetPct(KeyEvent event) {
    }

}
