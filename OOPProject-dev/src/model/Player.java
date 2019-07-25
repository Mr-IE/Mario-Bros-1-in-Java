/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author wah-211
 */
public class Player extends MovingObject {
    private Image still;
    private int x, dx;
    private int y, dy;
    private static final int VX = 2;
    private static final int VY = 8;
    private static final Dimension SIZE = new Dimension(16, 16);
    private Floor floor;
    public int startX,startY;
    private boolean died = false;
    // sprites/images for the player
    private final ImageIcon sl = new ImageIcon("img/Player/spr_player_Still_Left.png");
    private final ImageIcon sr = new ImageIcon("img/Player/spr_player_Still_Right.png");
    private final ImageIcon jr = new ImageIcon("img/Player/spr_player_Jump_Right.png");
    private final ImageIcon jl = new ImageIcon("img/Player/spr_player_Jump_Left.png");
    private final ImageIcon l = new ImageIcon("img/Player/spr_player_Walk_Left.gif");
    private final ImageIcon r = new ImageIcon("img/Player/spr_player_Walk_Right.gif");
    private final ImageIcon d = new ImageIcon("img/Player/spr_player_die.gif");
    
    
    public Player(int x,int y) {
        still = sr.getImage();
        this.x = x; //10
        this.y = y; // 186
        this.startX = x;
        this.startY = y;
    }
    
    @Override
    public void move() {
        x += dx;
        y += dy;
        
    }
    public void drawPlayerMovements(){
        
            if (dy >= VY) {//checks to see if the player is jumping up
                if (dx == VX) {//checks to see if the player is going right
                    still = jr.getImage();
                } 
                else if (dx == -VX) {//checks to see if the player is going left
                    still = jl.getImage();
                } 
                // Code to correct the sprite/image for falling
                else if (still == sr.getImage() || still == r.getImage()) {//checks for the wrong right sprite/image
                    still = jr.getImage();
                }
                else if (still == sl.getImage() || still == l.getImage()) {//checks for the wrong left sprite/image
                    still = jl.getImage();
                }


            } else if (dy <= -VY) {//checks to see if the player is falling
                if (dx >= VX) {//checks to see if the player is moving right
                    still = jr.getImage();
                } else if (dx <= -VY) {//checks to see if the player is moving left
                    still = jl.getImage();
                } 
                // Code to correct the sprite/image for falling
                else if (still == sr.getImage() || still == r.getImage()) {//checks for the wrong right sprite/image
                    still = jr.getImage();
                } else if (still == sl.getImage() || still == l.getImage()) {//checks for the wrong left sprite/image
                    still = jl.getImage();
                }
            } else if (dx >= VX) {//check to see if the player is moving right
                still = r.getImage();
            } else if (dx <= -VX) {//check to see if the player is moving left
                still = l.getImage();
            } else if (dx == 0) {//checks to see if the player is not moving
                if (still == r.getImage() || still == jr.getImage()) {//checks to see which way the player if facing
                    still = sr.getImage();
                } else if (still == l.getImage() || still == jl.getImage()) {//checks to see which way the player if facing
                    still = sl.getImage();
                }
            }
        }

    
    
    @Override
    public void scroll() {
        x-=2;
    }
    
    @Override
    public void moveLeft() {
        dx = -VX;
        
    }
    
    @Override
    public void moveRight() {
        dx = VX;
        
    }
    
    @Override
    public void moveUp() {
        dy = -VY;
            if (y < 0) y = 0;
    }
    
    @Override
    public void moveDown() {
        y+=3;
        if (y > 16*15) {die();}
    }
            
        
    
    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return still;
    }

    

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    public void pauseLeft() {
        dx = 0;
    }

    public void pauseRight() {
        dx = 0;
    }

    public void pauseUp() {
        dy = 0;
    }

    @Override
    public void die() {
        setGraphic(d.getImage());
        setY(startX);
        setY(startY);

       
        
        System.out.println("Player Dies");
        
        died = true;

    }

    @Override
    public void movePattern() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean collide(World o) {
        if (!died){
        if (o instanceof AbstractNonMovingObject) {
            y = ((AbstractNonMovingObject) o).getY() - 16;
        }
        }
        
        return true;
    }
    @Override
    public Dimension getSize() {
        return SIZE;
    }

    public void restart() {
        died = false;
        setX(startX);
        setY(startY);
        
    }
    public boolean isDead(){
     return died;   
    }

}
