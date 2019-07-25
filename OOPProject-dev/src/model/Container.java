/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wah-211
 */
public class Container extends AbstractNonMovingObject  {
    
    //Initialize the Variables
    
    //Constructors
    public Container() {
        
    }
    
    public Container(String name) {
 
    }
    
    //Getters And Setters 
    
    @Override
    public void scroll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean collide(World o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
