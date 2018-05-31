package cpt;

import javafx.scene.shape.Shape;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public abstract class Room {

    private Group root = new Group();
    private Scene scene = new Scene(root, 500, 500);
    private Character character = new Character(200, 200, true, 30, 40);
    private Rectangle nextDoor = new Rectangle(20, 80);
    private Rectangle previousDoor = new Rectangle(20, 80);

    public Room() {  
    }

    public Character getCharacter() {
        return character;
    }

    public Group getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void update() {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                character.setTranslateX(character.getTranslateX() - 10);

                for (int i = 0; i < root.getChildren().size() - 1; i++) {
                    Shape shape = (Shape) root.getChildren().get(i);
                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
                        character.setTranslateX(character.getTranslateX() + 10);
                    }
                }

            } else if (e.getCode() == KeyCode.RIGHT) {
                character.setTranslateX(character.getTranslateX() + 10);

                for (int i = 0; i < root.getChildren().size() - 1; i++) {
                    Shape shape = (Shape) root.getChildren().get(i);
                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
                        character.setTranslateX(character.getTranslateX() - 10);
                    }
                }
            } else if (e.getCode() == KeyCode.DOWN) {
                character.setTranslateY(character.getTranslateY() + 10);

                for (int i = 0; i < root.getChildren().size() - 1; i++) {
                    Shape shape = (Shape) root.getChildren().get(i);
                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
                        character.setTranslateY(character.getTranslateY() - 10);
                    }
                }
            } else if (e.getCode() == KeyCode.UP) {
                character.setTranslateY(character.getTranslateY() - 10);

                for (int i = 0; i < root.getChildren().size() - 1; i++) {
                    Shape shape = (Shape) root.getChildren().get(i);
                    if (character.getBoundsInParent().intersects(shape.getBoundsInParent())) {
                        character.setTranslateY(character.getTranslateY() + 10);
                    }
                }
            }
        });
    }
}
