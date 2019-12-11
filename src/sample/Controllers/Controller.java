package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private  TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSiginButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize(){
        authSiginButton.setOnAction(event -> {
            System.out.println("LOG IN button pressed!!!");


        });

    }

}
