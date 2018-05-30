/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Payam
 */
public abstract class Room {

    private static final int ROOM_W = 1000;
    private static final int ROOM_H = 800;
    private static double spawnX;
    private static double spawnY;
    
    private ArrayList<Rectangle> walls = new ArrayList<>();
    private Group wallsGroup;
    
    private KeyFrame frame;
    
    private Player player = new Player();

    private Scene scene;

    public Room() {
        scene = new Scene(createContent());
        
    }
    
    public void spawnPlayer () {
        player.setTranslateX(spawnX);
        player.setTranslateY(spawnY);
    }
    
    public void spawnPlayer(double x, double y) {
        player.setTranslateX(x);
        player.setTranslateY(y);
    }

    public abstract Parent createContent();
    
    public abstract void goToNextRoom();

    public KeyFrame getFrame() {
        return frame;
    }

    public static int getROOM_W() {
        return ROOM_W;
    }

    public static int getROOM_H() {
        return ROOM_H;
    }

    public static double getSpawnX() {
        return spawnX;
    }

    public static double getSpawnY() {
        return spawnY;
    }

    public Player getPlayer() {
        return player;
    }

    public Scene getScene() {
        return scene;
    }

    public static void setSpawnX(double spawnX) {
        Room.spawnX = spawnX;
    }

    public static void setSpawnY(double spawnY) {
        Room.spawnY = spawnY;
    }

    public void setFrame(KeyFrame frame) {
        this.frame = frame;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setWalls(ArrayList<Rectangle> walls) {
        this.walls = walls;
        wallsGroup.getChildren().addAll(walls);
    }

    public ArrayList<Rectangle> getWalls() {
        return walls;
    }
    
    
    
    

}
