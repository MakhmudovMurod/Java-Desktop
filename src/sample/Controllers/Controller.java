package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Animation.Shake;
import sample.Database.DatabseHandler;
import sample.Database.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    @FXML
    private  TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private Button loginSignInButton;



    @FXML
    void initialize(){
        loginSignInButton.setOnAction(event -> {
            String loginText=login_field.getText().trim();
            String loginPassword=password_field.getText().trim();

            if(loginText.equals("") || loginPassword.equals("")) {
                System.out.println("Some fields are empty");
                Shake userLoginAnim = new Shake(login_field);
                Shake passLoginAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                passLoginAnim.playAnim();
            }
            else
            loginUser(loginText,loginPassword);


        });
       loginSignUpButton.setOnAction(event -> {


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

        DatabseHandler dbHandler=new DatabseHandler();
        User user = new User();
        user.setUserId(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter =0;

        try {
            while(result.next()){
            counter++;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (counter>=1){
            System.out.println("Success!");
        }
        else  System.out.println("There is no User with such ID or Password,please check orthography or get new account!");

        Shake userLoginAnim =new Shake(login_field);
        Shake passLoginAnim =new Shake(password_field);
        userLoginAnim.playAnim();
        passLoginAnim.playAnim();
    }

}
