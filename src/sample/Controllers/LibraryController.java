package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Database.Const;
import sample.Database.DatabseHandler;
import sample.Database.ModelTable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LibraryController implements Initializable{
    @FXML
    public Accordion MenuAcordeon;
    @FXML
    public TableView<ModelTable> InfoTable;
    @FXML
    public TableView<String> ParentTable;
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
    public TableColumn<ModelTable,String> NameColumn;
    @FXML
    public TableColumn<ModelTable,String> LastColumn;
    @FXML
    public TableColumn<ModelTable,String> IdColumn;
    @FXML
    public TableColumn<ModelTable,String> BooksColumn;


    ObservableList<ModelTable>oblist1= FXCollections.observableArrayList();
    ObservableList<String> oblist2= FXCollections.observableArrayList();





    @FXML
    private AnchorPane parentPane;
    @FXML
    private Pane tableParent;


    @FXML
    public void changeTable() throws IOException {
        Parent parent;
        parent = FXMLLoader.load(getClass().getResource("/sample/Designs/test.fxml"));
        tableParent.getChildren().setAll(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final String book1="Where is Bella?";
        final String book2="Charly`s Dog";
        final String book3="War and Peace";
        final String book4="Programming";
        final String book5="Database";
        final String book6="Sherlock Holmes";

        oblist2.add(book1);
        oblist2.add(book2);
        oblist2.add(book3);
        oblist2.add(book4);
        oblist2.add(book5);
        oblist2.add(book6);



        try {
          Connection  con = DatabseHandler.TableConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from "+ Const.USER_TABLE);

            while (rs.next()){
                oblist1.add(new ModelTable(rs.getString("UserID"),rs.getString("FirstName"),
                        rs.getString("LastName"),rs.getString("Books")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        LastColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        BooksColumn.setCellValueFactory(new PropertyValueFactory<>("books"));

        InfoTable.setItems(oblist1);


                    ViewAllBooks.setOnAction(event -> {




                        try {
                            changeTable();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        InfoTable.getSelectionModel().clearSelection();
                        oblist1.clear();





                    });
    }
}
