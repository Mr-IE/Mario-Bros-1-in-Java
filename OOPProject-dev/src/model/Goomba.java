/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Chris Dahl
 */
public class Goomba extends MovingObject {

    private boolean isDead = false;

    public Goomba(String name) {
        super(name, new Dimension(16, 16), 192, 192, (new ImageIcon("img/spr_Enemy_Chesnut.gif")).getImage(), 1);
    }

    public Goomba(String name, int xPosition) {
        super(name, new Dimension(16, 16), xPosition, 192, (new ImageIcon("img/spr_Enemy_Chesnut.gif")).getImage(), 1);
    }

    public Goomba(String name, int xPosition, int yPosition) {
        super(name, new Dimension(16, 16), xPosition, yPosition, (new ImageIcon("img/spr_Enemy_Chesnut.gif")).getImage(), 1);
    }

    public Goomba(String name, int xPosition, int yPosition, ImageIcon img) {
        super(name, new Dimension(16, 16), xPosition, yPosition, (img).getImage(), 1);
    }

    @Override
    public void die() {
        this.setGraphic((new ImageIcon("img/Enemys/spr_Enemy_Chesnut_Dead.gif")).getImage());
        this.setSize(new Dimension(16, 5));
        this.setSpeed(0);
        this.setY(this.getY() + 11);
        isDead = true;
        //setX(-20);
    }

    @Override
    public void movePattern() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean collide(World o) {
        if (o instanceof Player) {

            if (((Player) o).getY() > getY() - 1) {
                if (isDead) {
                } else {
                    ((Player) o).die();
                }
            } else {
                if (isDead) {
                } else {
                    die();
                }
            }
        }
        //System.out.println("hit enemy " + this.getName());
        return true;
    }

}
