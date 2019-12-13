package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private  TextField SignUpName;

    @FXML
    private PasswordField SignUpPassword;

    @FXML
    private Button authSignUpButton;

    @FXML
    private  TextField SignUpLast;

    @FXML
    private  TextField SignUpID;

    @FXML
    void initialize(){
        authSignUpButton.setOnAction(event -> {
            System.out.println("LOG IN button pressed!!!");



        });

    }

}
