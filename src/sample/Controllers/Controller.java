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
    public   TextField login_field;

    @FXML
    public PasswordField password_field;

    @FXML
    public Button loginSignUpButton;

    @FXML
    public Button loginSignInButton;



    @FXML
    void initialize(){

        loginSignInButton.setOnAction(event -> {
            String loginText=login_field.getText().trim();
            String loginPassword=password_field.getText().trim();

            if(loginText.equals("") || loginPassword.equals("")) {
                Shake userLoginAnim = new Shake(login_field);
                Shake passLoginAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                passLoginAnim.playAnim();
                System.out.println("Some fields are empty");


            }
            else {
                loginUser(loginText, loginPassword);
//                LibraryController lbControll = new LibraryController();
//
//
//                if (loginPassword != "1122" && loginText != "admin") {
//
//                     lbControll.ViewUsers.setVisible(false);
//                     lbControll.ActAddUser.setVisible(false);
//                     lbControll.ActAddBook.setVisible(false);
//                     lbControll.ActReturnBook.setVisible(false);
//
//
//
//                }
//                else{
//                    lbControll.ViewUsers.setVisible(true);
//                    lbControll.ActAddUser.setVisible(true);
//                    lbControll.ActAddBook.setVisible(true);
//                    lbControll.ActReturnBook.setVisible(true);
//
//                }

            }
        });

       loginSignUpButton.setOnAction(event -> {


           try {
               Main.setScene("/sample/Designs/SignUp.fxml");
           } catch (IOException e) {
               e.printStackTrace();
           }


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


            loginSignInButton.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Designs/Library.fxml"));
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
        }
        else  System.out.println("There is no User with such ID or Password,please check orthography or get new account!");

        Shake userLoginAnim =new Shake(login_field);
        Shake passLoginAnim =new Shake(password_field);
        userLoginAnim.playAnim();
        passLoginAnim.playAnim();
    }

}
