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
 * @author Darrien 
 */
public abstract class Monsters extends MovingObject {
    public Monsters() {
        super();
    }

    public Monsters(String name, Dimension size, int xPosition, int yPosition, Image graphic, int speed)  {
        super(name, size, xPosition, yPosition, graphic ,speed);
    }
    
    @Override
    public void die(){
    
    }

    
    @Override
    public void movePattern(){
    
    }

    
}
