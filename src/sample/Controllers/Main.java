package sample.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("/sample/Designs/sample.fxml"));
        stage.setTitle("SupaLib");
        stage.setScene(new Scene(root, 700, 400));
        stage.setResizable(false);
        stage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void setScene(String fileName) throws IOException {
        root = FXMLLoader.load(Main.class.getResource(fileName));
        scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.show();
    }
}