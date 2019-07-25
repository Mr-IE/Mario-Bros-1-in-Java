package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Colectables extends MovingObject {
        
    // constructor must get name, int x, int y, Image, int speed
    public Colectables(String name, int xPosition, int yPosition, Image graphic, int speed) {
        super(name, new Dimension(16, 16), xPosition, yPosition, graphic, speed);
        // new Dimension(16, 16) 
                
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
//    @Override
//    public void scroll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
