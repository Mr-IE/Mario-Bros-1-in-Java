package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sawyer Ubbink
 */

public class PlayerTest /*extends MovableObject*/ {
   
    //Variables
    private int lives;
   
    //Constructors
    public PlayerTest(){
       
    }
   
    public PlayerTest(int lives){
        this.lives = lives;
    }
   
    //Getters & Setters
    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
   
    //Methods
    public void addLives(int lives) {
        this.lives = this.lives + lives;
    }
           
}//Player Class End