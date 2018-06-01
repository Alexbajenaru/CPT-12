package cpt.rewrite;

import javafx.scene.shape.Rectangle;

public class Character extends Rectangle {

    //private int x, y;
    private boolean alive;
    private int speed;

    private int speedX, speedY;

    private Bullet gun;

    characterAction action = characterAction.NONE;

    public Character(int x, int y, boolean alive, double width, double height) {
        super(width, height);
        //this.x = x;
        //this.y = y;
        this.setX(x);
        this.setY(y);
        //this.setWidth(width);
        //this.setHeight(height);
        this.alive = alive;
        this.speed = 10;
        this.speedX = 0;
        this.speedY = 0;

    }

    public void setAction(characterAction action) {
        this.action = action;
    }

    public characterAction getAction() {
        return action;
    }

    public void setX(int x) {
        //this.x = x;
        super.setX(x);
    }

    public void setY(int y) {
        //this.y = y;
        super.setY(y);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSpeedX(int speed) {
        this.speedX = speed;
    }

    public void setSpeedY(int speed) {
        this.speedY = speed;
    }

    public void update() {   
        setTranslateX(getTranslateX() + speedX);
        setTranslateY(getTranslateY() + speedY);
    }

}
