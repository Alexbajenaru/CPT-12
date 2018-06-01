package cpt.rewrite;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CPTRewrite extends Application {

    @Override
    public void start(Stage primaryStage) {

        //HealthBar healthBar = new HealthBar();
         
        //Scene scene = new Scene(root, 1000, 800);
        
        Room room = new Room();

        Scene scene = room.getScene();

        primaryStage.setTitle("Room 1!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Player player = new Player();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
