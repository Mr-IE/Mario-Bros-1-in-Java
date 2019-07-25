package model;

import java.awt.Dimension;

/*
 *
 */

/**
 *
 * @author Jim
 */
public interface World {
    
    public abstract void scroll(); 
    public abstract boolean collide(World o);
    public abstract int getX();
    public abstract int getY();
    public abstract Dimension getSize();
    
}
