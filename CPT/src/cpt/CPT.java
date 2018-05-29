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

    static Circle circle = new Circle(0, 0, 20, Color.BLUE);
    static Rectangle door = new Rectangle(480, 250, 40, 40);
    static Rectangle rect = new Rectangle(50, 0, 100, 50);
    static Rectangle rect2 = new Rectangle(400, 200, 50, 100);
    static Rectangle rect3 = new Rectangle(50, 50, 50, 100);
    static Rectangle floor = new Rectangle(0, 0, 500, 500);
    Image wood; 
    ImagePattern ip;
    static Group root2 = new Group();

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Hi");
        System.out.println("Hi2.0");
        System.out.println("Hi 3.0");
        ArrayList<Shape> obj = new ArrayList<>();
        
        System.out.println("yes");

        Group root = new Group();

        Scene scene = new Scene(root, 500, 500);
        Scene scene2 = new Scene(root2, 500, 500);

        obj.add(circle);
        obj.add(door);
        obj.add(rect);
        obj.add(rect2);
        obj.add(rect3);
        
        try {
            wood = new Image(new FileInputStream("src/Resources/wood_floor.jpg"), 100, 100, true, true);
        } catch (IOException e) {
            System.out.println("Broke");
        }
        
        ip = new ImagePattern(wood);
        floor.setFill(ip);

        root.getChildren().addAll(floor, rect, rect2, door, circle);

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                if (circle.getTranslateX() > 20) {
                    circle.setTranslateX(circle.getTranslateX() - 10);
                } else {

                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() + 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() + 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {

                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);
                    runScene2(primaryStage, scene2, obj);
                }
            } else if (e.getCode() == KeyCode.RIGHT) {
                if (circle.getTranslateX() < 480) {
                    circle.setTranslateX(circle.getTranslateX() + 10);
                } else {

                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);
                    runScene2(primaryStage, scene2, obj);
                }
            } else if (e.getCode() == KeyCode.DOWN) {
                if (circle.getTranslateY() < 480) {
                    circle.setTranslateY(circle.getTranslateY() + 10);
                } else {
                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() - 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() - 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {

                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);
                    runScene2(primaryStage, scene2, obj);
                }
            } else if (e.getCode() == KeyCode.UP) {
                if (circle.getTranslateY() > 20) {
                    circle.setTranslateY(circle.getTranslateY() - 10);
                } else {

                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() + 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() + 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);
                    runScene2(primaryStage, scene2, obj);
                }
            }
        });
    }

    public static void runScene2(Stage primaryStage, Scene scene, ArrayList obj) {
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                if (circle.getTranslateX() > 20) {
                    circle.setTranslateX(circle.getTranslateX() - 10);
                } else {

                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() + 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() + 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {

                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);

                }
            } else if (e.getCode() == KeyCode.RIGHT) {
                if (circle.getTranslateX() < 480) {
                    circle.setTranslateX(circle.getTranslateX() + 10);
                } else {

                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);

                }
            } else if (e.getCode() == KeyCode.DOWN) {
                if (circle.getTranslateY() < 480) {
                    circle.setTranslateY(circle.getTranslateY() + 10);
                } else {
                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() - 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() - 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {

                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);

                }
            } else if (e.getCode() == KeyCode.UP) {
                if (circle.getTranslateY() > 20) {
                    circle.setTranslateY(circle.getTranslateY() - 10);
                } else {

                }
                if (circle.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() + 10);
                }
                if (circle.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                    circle.setTranslateY(circle.getTranslateY() + 10);
                }
                if (circle.getBoundsInParent().intersects(door.getBoundsInParent())) {
                    circle.setTranslateX(circle.getTranslateX() - 150);
                    circle.setTranslateY(circle.getTranslateY() + 20);
                    root2.getChildren().addAll(rect3, rect, rect2, door, circle);

                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
