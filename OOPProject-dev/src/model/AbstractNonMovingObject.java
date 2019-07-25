/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author Chris
 */
public abstract class AbstractNonMovingObject implements World { //all classes extending this class must define World functions (scroll and collide)

    private String name;
    private Dimension size; //Dimension(int width, int height)
    private int xPosition;
    private int yPosition;
    private Image graphic; //graphic url
    private World containedObject;
    private boolean breakable;

    //constructors
    public AbstractNonMovingObject() {

    }

    public AbstractNonMovingObject(String name, Dimension size, int x, int y, Image im, boolean breakable, World containedObject) {
        this.name = name;
        this.size = size;
        xPosition = x;
        yPosition = y;
        graphic = im;
        this.breakable = breakable;
        this.containedObject = containedObject;
    }

    //getters & setters
    @Override
    public int getX() {
        return xPosition;
    }

    @Override
    public int getY() {
        return yPosition;
    }
    
    public void setX(int x) {
        xPosition = x;
    }
    
    public void setY(int y) {
        yPosition = y;
    }

    @Override
    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public World getcontainedObject() {
        return containedObject;
    }

    public void setcontainedObject(World containedObject) {
        this.containedObject = containedObject;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    public Image getGraphic() {
        return graphic;
    }

    public void setGraphic(Image im) {
        graphic = im;
    }

    //NonMovingObject methods
    public void breakObject() {
        if (breakable) {
            //break/destroy this thing

            spawnContaining();
        }
    }

    public void spawnContaining() {
        if (containedObject != null) {
            //spawn contained object
        }
    }

    //abstract methods
    // cant think of any methods each NonMovingObject will need to implement.
}
