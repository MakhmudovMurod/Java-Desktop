package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController{
    @FXML
    public Accordion MenuAcordeon;
    @FXML
    public Button ViewAllBooks;
    @FXML
    public Button ViewUsers;
    @FXML
    public Button ViewIssuedBooks;
    @FXML
    public Button ActAddUser;
    @FXML
    public Button ActAddBook;
    @FXML
    public Button ActReturnBook;
    @FXML
    public Button ActIssueBook;
    @FXML
    public Button ResetBtn;
    @FXML
    public TableColumn NameColumn;
    @FXML
    public TableColumn LastColumn;
    @FXML
    public TableColumn IdColumn;
    @FXML
    public TableColumn BooksColumn;



@FXML
public void initialize() {

        Controller control = new Controller();

//    if (!control.login_field.equals("1122") &&  !control.password_field.equals("admin")) {
//
//        ViewUsers.setVisible(false);
//        ActAddUser.setVisible(false);
//        ActAddBook.setVisible(false);
//        ActReturnBook.setVisible(false);
//
//
//
//    }
//    else{
//        ViewUsers.setVisible(true);
//        ActAddUser.setVisible(true);
//        ActAddBook.setVisible(true);
//        ActReturnBook.setVisible(true);
//
//    }



    }
}
