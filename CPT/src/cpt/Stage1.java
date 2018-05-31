/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Daniel Bassani
 */
public class Stage1 extends Room {

    private Group root = this.getRoot();
    private Scene scene = this.getScene();
    private Character character = this.getCharacter();
    private Rectangle nextDoor = new Rectangle(480, 420, 20, 80);
    //private Rectangle previousDoor = this.previousDoor;

    @Override
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
                    if(character.getBoundsInParent().intersects(nextDoor.getBoundsInParent())){
                        
                    }
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
