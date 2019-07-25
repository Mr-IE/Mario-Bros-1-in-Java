/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import javax.swing.ImageIcon;


/**
 *
 * @author Matt
 */
public class Coin extends Colectables {

    //Constructor
    // name, int x int y naem inage 
    // super command speed = 0;
    public Coin (String name, int xPosition, int yPosition) {
        super(name, xPosition, yPosition, (new ImageIcon("img/Coin.png")).getImage() , 0);
        
    }
    
    @Override
    public void movePattern() {
        // leave blank
    }

    @Override
    public boolean collide(World o) {
        setX(-20);
        //System.out.println("hit the coin");
        return true;
    }
    
}
