package sample.Controllers;

import javafx.fxml.FXML;
import  java.lang.String;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FieldNum {


    @FXML
    private Button O;
    @FXML
    public Text a;
    @FXML
    public Text p;



    @FXML
    void initialize(){
        p.setText("Your name should not contain numeric values.");
        a.setText("Wrong User-Info!");
        O.setOnAction(event -> {

            O.getScene().getWindow().hide();

        });


    }

}
