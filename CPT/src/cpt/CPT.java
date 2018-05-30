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

    //ArrayList<Item> inventory = new ArrayList<>();
    static Rectangle character = new Rectangle(40, 450, 30, 40);
    static Rectangle door = new Rectangle(480, 220, 20, 80);
    static Rectangle rect = new Rectangle(100, 0, 100, 50);
    static Rectangle rect2 = new Rectangle(0, 125, 50, 100);
    static Rectangle rect3 = new Rectangle(250, 425, 150, 75);
    static Rectangle floor = new Rectangle(0, 0, 500, 500);
    static Rectangle table = new Rectangle(175, 200, 150, 100);
    Image wood;
    ImagePattern ip;
    static Group root2 = new Group();

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Scene scene = new Scene(root, 500, 500);
        Scene scene2 = new Scene(root2, 500, 500);

        try {
            wood = new Image(new FileInputStream("src/Resources/wood_floor.jpg"), 100, 100, true, true);
        } catch (IOException e) {
            System.out.println("Broke");
        }

        ip = new ImagePattern(wood);
        floor.setFill(ip);

        root.getChildren().addAll(floor, rect, rect2, rect3, table, door, character);

        primaryStage.setScene(scene);
        primaryStage.show();

        //section of code for player movement and interaction with objects on screen
        primaryStage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                //blocks player from going off screen to the left
                if (character.getTranslateX() > -40) {
                    character.setTranslateX(character.getTranslateX() - 10);
                } else {

                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(table.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    //sets character position on NEXT room
                    character.setTranslateX(-20);
                    character.setTranslateY(-400);
                    door = new Rectangle(480, 420,20, 80);
                    //adds objects to next room
                    root2.getChildren().addAll(rect3, rect, rect2, door, character);
                    //goes to method to display and run room 2
                    runScene2(primaryStage, scene2);
                }
            } else if (e.getCode() == KeyCode.RIGHT) {
                //blocks player from going off screen to the right
                if (character.getTranslateX() < 430) {
                    character.setTranslateX(character.getTranslateX() + 10);
                } else {

                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(table.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    //sets character position on NEXT room
                    character.setTranslateX(-20);
                    character.setTranslateY(-400);
                    door = new Rectangle(480, 420,20, 80);
                    //adds objects to next room
                    root2.getChildren().addAll(rect3, rect, rect2, door, character);
                    //goes to method to display and run room 2
                    runScene2(primaryStage, scene2);
                }
            } else if (e.getCode() == KeyCode.DOWN) {
                //blocks player from going off screen down
                if (character.getTranslateY() < 10) {
                    character.setTranslateY(character.getTranslateY() + 10);
                } else {
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(table.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() - 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    //sets character position on NEXT room
                    character.setTranslateX(-20);
                    character.setTranslateY(-400);
                    door = new Rectangle(480, 420,20, 80);
                    //adds objects to next room
                    root2.getChildren().addAll(rect3, rect, rect2, door, character);
                    //goes to method to display and run room 2
                    runScene2(primaryStage, scene2);
                }
            } else if (e.getCode() == KeyCode.UP) {
                //blocks player from going off screen up
                if (character.getTranslateY() > -450) {
                    character.setTranslateY(character.getTranslateY() - 10);
                } else {

                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(table.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() + 10);
                }
                //checks for intersection between 2 objects, allows for collsion
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    //sets character position on NEXT room
                    character.setTranslateX(-20);
                    character.setTranslateY(-400);
                    door = new Rectangle(480, 420,20, 80);
//                    door.setTranslateX();
//                    door.setTranslateY();
                    //adds objects to next room
                    root2.getChildren().addAll(rect3, rect, rect2, door, character);
                    //goes to method to display and run room 2
                    runScene2(primaryStage, scene2);
                }
            }
        });
    }

    
    //ROOM 2
    public static void runScene2(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                if (character.getTranslateX() > -40) {
                    character.setTranslateX(character.getTranslateX() - 10);
                } else {

                }
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() + 10);
                }
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() + 10);
                }
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() + 10);
                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    character.setTranslateX(190);
                    character.setTranslateY(-10);
                    Group root3 = new Group();
                    Scene scene3 = new Scene(root3, 500, 500);
                    root3.getChildren().addAll(door, character);
                    runScene3(primaryStage, scene3);
                }
            } else if (e.getCode() == KeyCode.RIGHT) {
                if (character.getTranslateX() < 430) {
                    character.setTranslateX(character.getTranslateX() + 10);
                } else {

                }
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() - 10);
                }
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() - 10);
                }
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateX(character.getTranslateX() - 10);
                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    character.setTranslateX(190);
                    character.setTranslateY(-10);
                    Group root3 = new Group();
                    Scene scene3 = new Scene(root3, 500, 500);
                    root3.getChildren().addAll(door, character);
                    runScene3(primaryStage, scene3);
                }
            } else if (e.getCode() == KeyCode.DOWN) {
                if (character.getTranslateY() < 10) {
                    character.setTranslateY(character.getTranslateY() + 10);
                } else {
                }
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() - 10);
                }
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() - 10);
                }
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() - 10);
                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    character.setTranslateX(190);
                    character.setTranslateY(-10);
                    Group root3 = new Group();
                    Scene scene3 = new Scene(root3, 500, 500);
                    root3.getChildren().addAll(door, character);
                    runScene3(primaryStage, scene3);
                }
            } else if (e.getCode() == KeyCode.UP) {
                if (character.getTranslateY() > -450) {
                    character.setTranslateY(character.getTranslateY() - 10);
                } else {

                }
                if (character.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() + 10);
                }
                if (character.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() + 10);
                }
                if (character.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    character.setTranslateY(character.getTranslateY() + 10);
                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    character.setTranslateX(190);
                    character.setTranslateY(-10);
                    Group root3 = new Group();
                    Scene scene3 = new Scene(root3, 500, 500);
                    root3.getChildren().addAll(door, character);
                    runScene3(primaryStage, scene3);
                }
            }
        });
    }

    
    //ROOM 3
    public static void runScene3(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                if (character.getTranslateX() > -40) {
                    character.setTranslateX(character.getTranslateX() - 10);
                } else {

                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    Group root4 = new Group();
                    Scene scene4 = new Scene(root4, 500, 500);
                    root4.getChildren().addAll(door, character);
                    runScene4(primaryStage, scene4);
                }
            } else if (e.getCode() == KeyCode.RIGHT) {
                if (character.getTranslateX() < 440) {
                    character.setTranslateX(character.getTranslateX() + 10);
                } else {

                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    Group root4 = new Group();
                    Scene scene4 = new Scene(root4, 500, 500);
                    root4.getChildren().addAll(door, character);
                    runScene4(primaryStage, scene4);
                }
            } else if (e.getCode() == KeyCode.DOWN) {
                if (character.getTranslateY() < 30) {
                    character.setTranslateY(character.getTranslateY() + 10);
                } else {
                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    Group root4 = new Group();
                    Scene scene4 = new Scene(root4, 500, 500);
                    root4.getChildren().addAll(door, character);
                    runScene4(primaryStage, scene4);
                }
            } else if (e.getCode() == KeyCode.UP) {
                if (character.getTranslateY() > -430) {
                    character.setTranslateY(character.getTranslateY() - 10);
                } else {

                }
                if (character.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    Group root4 = new Group();
                    Scene scene4 = new Scene(root4, 500, 500);
                    root4.getChildren().addAll(door, character);
                    runScene4(primaryStage, scene4);
                }
            }
        });
    }

    
    //ROOM 4
    public static void runScene4(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    //ROOM 5
    public static void runScene5(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    //ROOM 6
    public static void runScene6(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    //ROOM 7
    public static void runScene7(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    //ROOM 8
    public static void runScene8(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    //ROOM 9
    public static void runScene9(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
