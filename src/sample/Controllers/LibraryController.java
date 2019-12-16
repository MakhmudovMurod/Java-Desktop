package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;

import javax.swing.table.TableColumn;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
