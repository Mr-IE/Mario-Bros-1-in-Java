/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author dan.taylor
 */
public class Floor extends AbstractNonMovingObject {
    private final ImageIcon im = new ImageIcon("img/Level-Items/spr_world_ground.png");
    
    public Floor(String name, Dimension size, int x, int y) {
        super(name, size, x, y, null, false, null);
        this.setGraphic(im.getImage());
    }

    @Override
    public void scroll() {
        setX(getX() - 2);
    }

    @Override
    public boolean collide(World o) {
        //System.out.println("Hit the floor" + getName());
        return true;
    }

}
