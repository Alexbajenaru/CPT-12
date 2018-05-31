/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author Daniel Bassani
 */
public class CPT extends Application {

    static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);

        runStage1(primaryStage);
    }

    public static void runStage1(Stage primaryStage) {
        Scene1 room1 = new Scene1();
        primaryStage.setScene(room1.getScene());
        primaryStage.show();
        Rectangle rect = new Rectangle(100, 0, 100, 50);
        //Rectangle door = new Rectangle(480, 420, 20, 80);
        
        room1.getRoot().getChildren().addAll(rect, room1.getCharacter());

        room1.update();
    }

    public static void runStage2(Stage primaryStage) {
        Scene2 room2 = new Scene2();
        primaryStage.setScene(room2.getScene());
        primaryStage.show();
        
        room2.getRoot().getChildren().addAll(room2.getCharacter());
        
        room2.update();
    }

    public static void runStage3(Stage primaryStage) {
        //Room room3 = new Room();
       // primaryStage.setScene(room3.getScene());
        primaryStage.show();
        
        //room3.getRoot().getChildren().addAll(room3.getCharacter());
    } 

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        CPT.primaryStage = primaryStage;
    }

    
    
    
    
    
}
