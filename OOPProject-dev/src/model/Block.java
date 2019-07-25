/*
 * Question mark brick - character can land on top. Displays coin if character bumps from bottom.
 * How about we just make all of the bricks/boxes/walls the same object, but just change what it does with a number
 * 1- prize box, 2 - brick, 3- wall, anyother number is empty
 */
package model;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jwall
 */
public class Block extends AbstractNonMovingObject {
    
    
    
    // sprites/images for the player
    private final ImageIcon qb = new ImageIcon("img/Level-Items/spr_world_PrizeBox.png");
    private final ImageIcon nb = new ImageIcon("img/Level-Items/spr_world_Brick.png");
    private final ImageIcon bn = new ImageIcon("img/Level-Items/spr_world_Box.png");
    private final ImageIcon wb = new ImageIcon("img/Level-Items/spr_world_Wall.png");
    
    

    
    public Block(String name, Dimension size, int x, int y, int BlockType) {
        super(name, size, x, y, null, false, null);
        switch (BlockType) {
            case 1:
                setGraphic(qb.getImage());
                break;
            case 2:
                setGraphic(nb.getImage());
                break;
            case 3:
                setGraphic(wb.getImage());
                break;
            default:
                setGraphic(bn.getImage());
                break;
        }
        
    }

    @Override
    public void scroll() {
        setX(getX() - 2);
    }

    @Override
    public boolean collide(World o) {
        //System.out.println("Hit the brick" + getName());
        return true;
    }
    
}
