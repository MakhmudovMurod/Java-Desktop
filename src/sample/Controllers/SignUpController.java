package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sample.Database.DatabseHandler;
import sample.Database.User;

import java.io.IOException;

public class SignUpController extends userExists{
    @FXML
    private Circle nameCheck;
    @FXML
    private Circle lastCheck;
    @FXML
    private Circle idCheck;
    @FXML
    private Circle passCheck;

    @FXML
    private  TextField SignUpName;

    @FXML
    private PasswordField SignUpPassword;

    @FXML
    private Button authSignUpButton;

    @FXML
    private Button SignUpBackButton;

    @FXML
    private  TextField SignUpLast;

    @FXML
    private  TextField SignUpID;

    @FXML
    void initialize(){

        nameCheck.setVisible(false);
        lastCheck.setVisible(false);
        idCheck.setVisible(false);
        passCheck.setVisible(false);


        SignUpBackButton.setOnAction(event -> {

//            SignUpBackButton.getScene().getWindow().hide();
            Stage closeStage=(Stage) SignUpBackButton.getScene().getWindow();

            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(getClass().getResource("/sample/Designs/sample.fxml"));
            try{
                loader3.load();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            Parent root = loader3.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            closeStage.close();
            stage.showAndWait();

        });



        authSignUpButton.setOnAction(event -> {

///-------------------------VALIDATION CHECK!-----------------------
           if (SignUpPassword.getText().isEmpty()|| SignUpID.getText().isEmpty()|| SignUpLast.getText().isEmpty()
           ||SignUpName.getText().isEmpty()){
               if (SignUpName.getText().isEmpty()){
                   //SHOWS WHETHER THE FIELDS ARE EMPTY OR NOT
                   nameCheck.setVisible(true);
                   lastCheck.setVisible(false);
                   idCheck.setVisible(false);
                   passCheck.setVisible(false);
                   orNot();
               }
               else{
                   nameCheck.setVisible(false);
                   if (SignUpLast.getText().isEmpty()){
                       //SHOWS WHETHER THE FIELDS ARE EMPTY OR NOT
                       lastCheck.setVisible(true);
                       nameCheck.setVisible(false);
                       idCheck.setVisible(false);
                       passCheck.setVisible(false);
                       orNot();
                   }
                   else{
                       lastCheck.setVisible(false);


                       if (SignUpID.getText().isEmpty()){
                           //SHOWS WHETHER THE FIELDS ARE EMPTY OR NOT
                           idCheck.setVisible(true);
                           nameCheck.setVisible(false);
                           lastCheck.setVisible(false);
                           passCheck.setVisible(false);
                           orNot();
                       }
                       else {
                           idCheck.setVisible(false);
                           if (SignUpPassword.getText().isEmpty()){
                               //SHOWS WHETHER THE FIELDS ARE EMPTY OR NOT
                               passCheck.setVisible(true);
                               nameCheck.setVisible(false);
                               lastCheck.setVisible(false);
                               idCheck.setVisible(false);
                               orNot();
                           }
                           else {
                               passCheck.setVisible(false);
                               NumChecker();
                           }
                       }
                   }
               }


           }
           else{
               nameCheck.setVisible(false);
               lastCheck.setVisible(false);
               idCheck.setVisible(false);
               passCheck.setVisible(false);

               NumChecker();

           }

//---------------------------------------------------------------
        });

    }

    private void orNot2() {
        FXMLLoader loader2=new FXMLLoader();
        loader2.setLocation(getClass().getResource("/sample/Designs/FieldNum.fxml"));
        try{
            loader2.load();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        Parent root = loader2.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void orNot() {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Designs/UserExists.fxml"));
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

    private void signUpNewUser() {
        DatabseHandler dbHandler = new DatabseHandler();

        String firstName=SignUpName.getText();
        String lastName=SignUpLast.getText();
        String userId=SignUpID.getText();
        String password=SignUpPassword.getText();


        User user =new User(firstName,lastName,userId,password);
        dbHandler.signUpUser(user);
    }

    public void NumChecker(){
        String plus = String.join(SignUpLast.getText(),SignUpName.getText(),SignUpLast.getText());
        String numOnly = plus.replaceAll("\\p{Alpha}","");
        try{
            double numVal=Double.valueOf(numOnly);
            System.out.println(plus+"  Contains number!");
            nameCheck.setVisible(true);
            lastCheck.setVisible(true);

            orNot2();

        }catch(NumberFormatException e) {
            System.out.println(plus + "  Doesnt Contain numbers!");
            signUpNewUser();
        }
        plus=null;

    }

}
