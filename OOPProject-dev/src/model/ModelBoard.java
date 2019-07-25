/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.WorldBuilder;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dan.taylor
 */
public final class ModelBoard extends Observable {

    private final Player player;
    private int pixelPosition;
    private ArrayList<AbstractNonMovingObject> myNonMovables;
    private ArrayList<MovingObject> myMovables;
    private final int tilesize = 16;
    private final Timer time = new Timer();

    /**
     * The floor in pixels
     *
     * 1st floor 2nd floor 3rd floor 4th floor 0-1104 1136-1376 1424-2448
     * 2480-3384
     *
     * @throws java.io.FileNotFoundException
     */
    public ModelBoard() throws FileNotFoundException {
        player = new Player(tilesize * 2, tilesize * 13);
        myNonMovables = new ArrayList<>();
        myMovables = new ArrayList<>();
        restart();

    }

    public boolean play() throws FileNotFoundException {
        boolean results = true;
        if (player.isDead() == true) {
            pixelPosition = 0;
           

                    restart();

                    player.restart();
                
           

        }
        player.moveDown();
        for (int i = 0; i < myNonMovables.size(); i++) {
            if (checkCollision(player, myNonMovables.get(i))) {
                player.collide(myNonMovables.get(i));
                myNonMovables.get(i).collide(player);

            }

        }
        for (int i = 0; i < myMovables.size(); i++) {
            if (checkCollision(player, myMovables.get(i))) {
                player.collide(myMovables.get(i));
                myMovables.get(i).collide(player);
            }
            myMovables.get(i).move();
        }
        // need to add similar code for the movables here 
        player.move();
        player.drawPlayerMovements();

        if (player.getX() > tilesize * 25 && pixelPosition < 2530) {
            player.scroll();
            for (int i = 0; i < myNonMovables.size(); i++) {
                myNonMovables.get(i).scroll();
            }
            for (int i = 0; i < myMovables.size(); i++) {
                myMovables.get(i).scroll();
            }

            pixelPosition += 2;

        }
        if (player.getX() > 734) {
            results = false;
        }
        if (player.getX() < 0) {
            player.setX(1);
        }
        if (player.getY() < 0) {
            player.setY(1);
        }

        setChanged();
        notifyObservers();
        return results;
    }

    public int getPosition() {
        return pixelPosition;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<AbstractNonMovingObject> getNonMovables() {
        return myNonMovables;
    }

    public ArrayList<MovingObject> getMovingObject() {
        return myMovables;
    }

    private boolean checkCollision(World a, World b) {
        // Check to see if these two world objects collide.
        return b.getY() - a.getY() < a.getSize().getHeight()
                && a.getX() < b.getSize().getWidth() + b.getX()
                && a.getX() + a.getSize().getWidth() > b.getX()
                && a.getY() - b.getY() < b.getSize().getHeight();

    }

    private void restart() {
        pixelPosition = 0;
        myNonMovables.clear();
        myMovables.clear();
        
        try {
            WorldBuilder.getInstance().BuildWorld();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        myNonMovables.addAll(WorldBuilder.getInstance().getNonMovables());
        myMovables.addAll(WorldBuilder.getInstance().getMovables());
    }
}
