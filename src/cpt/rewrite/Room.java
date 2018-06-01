package cpt.rewrite;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Room {

    private static final int ROOM_W = 1000;
    private static final int ROOM_H = 800;
    private static double spawnX;
    private static double spawnY;

    private ArrayList<Rectangle> walls = new ArrayList<>();
    private Group wallsGroup;

    private Player player = new Player();
    //private Player player = new Player(200, 200, true, 30, 40);

    // Daniel's code requires?
    private Group root = new Group();
    private Scene scene; //= new Scene(root, 1000, 800); // normal code requires this too
    private Character character;

    public Room() {

        player = new Player(100, 100, true, 40, 40);

        root.getChildren().add(player);

        scene = new Scene(root, 1000, 800);

        setKeyHandlers();

    }

    public void spawnPlayer() {
        player.setTranslateX(spawnX);
        player.setTranslateY(spawnY);
    }

    public void spawnPlayer(double x, double y) {
        player.setTranslateX(x);
        player.setTranslateY(y);
        root.getChildren().add(player);
    }

//    public abstract void goToNextRoom();
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

//    public void update() {
    public void setKeyHandlers() {

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    player.setSpeedX(-1 * player.getSpeed());
                    break;
                case RIGHT:
                    player.setSpeedX(player.getSpeed());
                    break;
                case UP:
                    player.setSpeedY(-1 * player.getSpeed());
                    break;
                case DOWN:
                    player.setSpeedY(player.getSpeed());
                    break;
                default:
            }
            player.update();
        });

        scene.setOnKeyReleased(e -> {
            switch(e.getCode()){
                case LEFT:
                case RIGHT:
                    player.setSpeedX(0);
                    break;
                case UP:
                case DOWN:
                    player.setSpeedY(0);
                    break;
            }
            player.update();
        });

//        scene.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.LEFT) {
//                character.setTranslateX(character.getTranslateX() - 10);
//
//                for (int i = 0; i < root.getChildren().size() - 1; i++) {
//                    Shape shape = (Shape) root.getChildren().get(i);
//                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
//                        character.setTranslateX(character.getTranslateX() + 10);
//                    }
//                }
//
//            } else if (e.getCode() == KeyCode.RIGHT) {
//                character.setTranslateX(character.getTranslateX() + 10);
//
//                for (int i = 0; i < root.getChildren().size() - 1; i++) {
//                    Shape shape = (Shape) root.getChildren().get(i);
//                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
//                        character.setTranslateX(character.getTranslateX() - 10);
//                    }
//                }
//            } else if (e.getCode() == KeyCode.DOWN) {
//                character.setTranslateY(character.getTranslateY() + 10);
//
//                for (int i = 0; i < root.getChildren().size() - 1; i++) {
//                    Shape shape = (Shape) root.getChildren().get(i);
//                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
//                        character.setTranslateY(character.getTranslateY() - 10);
//                    }
//                }
//            } else if (e.getCode() == KeyCode.UP) {
//                character.setTranslateY(character.getTranslateY() - 10);
//
//                for (int i = 0; i < root.getChildren().size() - 1; i++) {
//                    Shape shape = (Shape) root.getChildren().get(i);
//                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
//                        character.setTranslateY(character.getTranslateY() + 10);
//                    }
//                }
//            }
//        });
    }

}
