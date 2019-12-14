package sample.Controllers;

import javafx.fxml.FXML;
import  java.lang.String;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class userExists {


    @FXML
    private Button OK;
    @FXML
    public Text at;
    @FXML
    public Text pl;



    @FXML
    void initialize(){
        OK.setOnAction(event -> {

            OK.getScene().getWindow().hide();

        });


        }

    }

