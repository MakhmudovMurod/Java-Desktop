package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private  TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private Button loginSiginButton;



    @FXML
    void initialize(){
        loginSignUpButton.setOnAction(event -> {
            String loginText=login_field.getText().trim();
            String loginPassword=password_field.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText,loginPassword);
            else
                System.out.println("Some fields are empty");

        });
       loginSignUpButton.setOnAction(event -> {

           loginSignUpButton.getScene().getWindow().hide();

           FXMLLoader loader=new FXMLLoader();
           loader.setLocation(getClass().getResource("/sample/Designs/SignUp.fxml"));

           try{
               loader.load();
           }
           catch(IOException e){
               e.printStackTrace();
           }

           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.showAndWait();
        });

    }

    private void loginUser(String loginText, String loginPassword) {

    }

}
