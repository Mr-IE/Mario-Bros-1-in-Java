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
 * @author Jim
 */
public class Star extends Colectables {

    //Constructor
    // name, int x int y naem inage 
    // super command speed = 0;
    public Star (String name, int xPosition, int yPosition) {
        super(name, xPosition, yPosition, (new ImageIcon("img/Star.png")).getImage() , 2);
        
    }
    
    @Override
    public void movePattern() {
        // leave blank
    }

    @Override
    public boolean collide(World o) {
        System.out.println("hit the star");
        return true;
    }
    
}
