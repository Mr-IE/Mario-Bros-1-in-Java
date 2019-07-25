/*
 * Abstract class: Moving_Object, part of OOP 2018 class final project
 * @author Athena
 */
package model;

import java.awt.Dimension; //Dimension(int width, int height)
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class MovingObject implements World {

    //members:
    private String name;
    private Dimension size;
    private int xPosition;
    private int yPosition;
    private Image graphic;
    private ImageIcon img;
    private int speed;

    //constructors:
    public MovingObject() {

    }

    public MovingObject(String name, Dimension size, int xPosition, int yPosition, Image graphic, int speed) {
        this.name = name;
        this.size = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.graphic = graphic;
        this.speed = speed;
    }

    //setters & getters:
    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setGraphic(Image graphic) {
        this.graphic = graphic;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public Dimension getSize() {
        return size;
    }

    @Override
    public int getX() {
        return xPosition;
    }
    public void setX(int x){
        xPosition = x;
    }

    @Override
    public int getY() {
        return yPosition;
    }
    public void setY(int y){
        yPosition = y;
    }

    @Override
    public void scroll() {
        setXPosition(getX() - 2);
    }

    public Image getGraphic() {
        return graphic;
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        xPosition -= speed;
    }

    //other methods:
    public void moveLeft() {
        xPosition -= speed;
    }

    public void moveRight() {
        xPosition += speed;
    }

    public void moveUp() {
        yPosition -= speed;
    }

    public void moveDown() {
        yPosition += speed;
    }

    public void moveLeft(int move) {
        xPosition -= move;
    }

    public void moveRight(int move) {
        xPosition += move;
    }

    public void moveUp(int move) {
        yPosition -= move;
    }

    public void moveDown(int move) {
        yPosition += move;
    }

    //abstract methods:
    public abstract void die();

    public abstract void movePattern();

    //keep in mind: scroll & collide are both inherited from World
    //-> any classes extended from here must include these as well.
}
