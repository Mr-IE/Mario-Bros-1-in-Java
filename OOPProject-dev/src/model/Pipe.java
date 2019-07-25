/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pipe extends AbstractNonMovingObject implements World {
    
    private int type; //1 = small (32x32), 2 = medium (32x48), 3 = tall (32x64)
    
    private final ImageIcon sp = new ImageIcon("img/backgroundStackShort.png");
    private final ImageIcon mp = new ImageIcon("img/backgroundStackMedium.png");
    private final ImageIcon tp = new ImageIcon("img/backgroundStackTall.png");
    
    public Pipe(String name, int tilesIn, int type) {
        this.setName(name);
        this.setX((tilesIn * 16) - 1);
        this.type = type;
        int tempHeight = 32;
        
        switch(type) {
            case 1:
                this.setGraphic(sp.getImage());
                break;
            case 2:
                this.setGraphic(mp.getImage());
                tempHeight = 48;
                break;
            case 3:
                this.setGraphic(tp.getImage());
                tempHeight = 64;
                break;
        }
        this.setSize(new Dimension(32, tempHeight));
        this.setY(262 - 54 - tempHeight);
    }
    
    //setters & getters
    public void setType(int type) {
        this.type = type;
    }
    
    public int getType() {
        return this.type;
    }
    
    //other methods
    @Override
    public void scroll() {
        this.setX(this.getX() - 2);
    }

    @Override
    public boolean collide(World o) {
        //System.out.println("Hit pipe " + this.getName());
        return true;
    }
    
}
