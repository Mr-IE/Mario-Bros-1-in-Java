/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.AbstractNonMovingObject;
import model.Block;
import model.Coin;
import model.Floor;
import model.MovingObject;
import model.Pipe;
import model.Star;
import model.Goomba;

/**
 *
 * @author dan.taylor
 */
public class WorldBuilder {
    ArrayList<AbstractNonMovingObject> nonMoving = new ArrayList<>();
    ArrayList<MovingObject> moving = new ArrayList<>();
    private static WorldBuilder myBuilder;
    private final int tilesize = 16;
    private WorldBuilder() {
        
    }
    
    public static WorldBuilder getInstance() {
        if (myBuilder == null) myBuilder = new WorldBuilder();
        return myBuilder;
    } 
    
    public void BuildWorld() throws FileNotFoundException{
        Scanner levelInput = new Scanner(new File("test/1-1.txt"));
        int x = levelInput.nextInt();
        int y = levelInput.nextInt();
        int levelTileID = 00;
        if(levelInput.hasNextLine()){
            for(int i = 0; i< y ;i++){
                for(int j = 0;j< x;j++){
                    levelTileID = levelInput.nextInt();
                    addTile(levelTileID,i,j);
                }
            }
        
        }
    
    }
    
    private void addTile(int levelTileID,int y,int x) {
        switch(levelTileID){
            case 01://Floor Block
                nonMoving.add(new Floor("Floor",new Dimension(tilesize,tilesize),tilesize*x,tilesize*y));
                break;
            case 02://Brick Block
                nonMoving.add(new Block("Block",new Dimension(tilesize,tilesize),tilesize*x,tilesize*y,1));
                break;
             case 03://Question Block
                nonMoving.add(new Block("Block",new Dimension(tilesize,tilesize),tilesize*x,tilesize*y,2));
                break;
            case 04://Wall Block
                nonMoving.add(new Block("Block",new Dimension(tilesize,tilesize),tilesize*x,tilesize*y,3));
                break;
            case 05://Empty Block
                nonMoving.add(new Block("Block",new Dimension(tilesize,tilesize),tilesize*x,tilesize*y,0));
                break;
            default:
                break;
        
        
        }
        
        
    
        
    }
    public ArrayList<AbstractNonMovingObject> getNonMovables() {
        /*
        // Add the non moving objects directly from this code
        // 
        nonMoving.add(new Floor("First Floor", new Dimension(tilesize*69, tilesize), tilesize*0, tilesize*13));
        nonMoving.add(new Floor("Second Floor", new Dimension (tilesize*15, tilesize), tilesize*71, tilesize*13));
        nonMoving.add(new Floor("Third Floor", new Dimension (tilesize*64, tilesize), tilesize*89, tilesize*13));
        nonMoving.add(new Floor("Fourth Floor", new Dimension (tilesize*58, tilesize), tilesize*155, tilesize*13));
        nonMoving.add(new Block("B1", new Dimension (tilesize, tilesize), tilesize*20, tilesize*9,1));
        nonMoving.add(new Block("B2", new Dimension (tilesize, tilesize), tilesize*21, tilesize*9,2));
        nonMoving.add(new Block("B3", new Dimension (tilesize, tilesize), tilesize*22, tilesize*9,3));
        nonMoving.add(new Block("B4", new Dimension (tilesize, tilesize), tilesize*23, tilesize*8,0));
        //    W
        //   WW
        //  WWW
        // WWWW
       
        makeFowrardStaircase(nonMoving,134,12);
        makeBackwardStaircase(nonMoving,140,12);
        makeFowrardStaircase(nonMoving,148,12);
        nonMoving.add(new Block("B3", new Dimension (tilesize, tilesize), tilesize*152, tilesize*12,3));
        nonMoving.add(new Block("B3", new Dimension (tilesize, tilesize), tilesize*152, tilesize*11,3));
        nonMoving.add(new Block("B3", new Dimension (tilesize, tilesize), tilesize*152, tilesize*10,3));
        nonMoving.add(new Block("B3", new Dimension (tilesize, tilesize), tilesize*152, tilesize*9,3));
        makeBackwardStaircase(nonMoving,155,12);
        makeFowrardStaircase(nonMoving,181,12);
        makeFowrardStaircase(nonMoving,185,8);
        makeFowrardStaircase(nonMoving,186,8);
        makeFowrardStaircase(nonMoving,185,12);
        makeBackwardStaircase(nonMoving,185,12);
        makeFowrardStaircase(nonMoving,186,12);
        
        //pipes added:
        nonMoving.add(new Pipe("Pipe 1", 28, 1));
        nonMoving.add(new Pipe("Pipe 2", 38, 2));
        nonMoving.add(new Pipe("Pipe 3", 46, 3));
        nonMoving.add(new Pipe("Pipe 4", 57, 3));
        nonMoving.add(new Pipe("Pipe 5", 163, 1));
        nonMoving.add(new Pipe("Pipe 6", 179, 1));
        
        
        //*/
        return nonMoving;
        
    }
    
    public ArrayList<MovingObject> getMovables() {
        /*
        // add the moving objects directly here
        moving.add(new Coin("Coin 1", tilesize*20, tilesize*6));
        moving.add(new Goomba("Goomba 1", tilesize*15,tilesize*12));
        moving.add(new Goomba("Goomba 2",tilesize*20,tilesize*12));
        
        //*/
        return moving;
    }
    private void makeFowrardStaircase( ArrayList<AbstractNonMovingObject> nonMoving, int x, int y){
        nonMoving.add(new Block("Wall 1", new Dimension (tilesize, tilesize),tilesize*x,tilesize*y,3));
        nonMoving.add(new Block("Wall 2", new Dimension (tilesize, tilesize),tilesize*(x+1),tilesize*y,3));   
        nonMoving.add(new Block("Wall 3", new Dimension (tilesize, tilesize),tilesize*(x+2),tilesize*y,3));   
        nonMoving.add(new Block("Wall 4", new Dimension (tilesize, tilesize),tilesize*(x+3),tilesize*y,3));   
        nonMoving.add(new Block("Wall 5", new Dimension (tilesize, tilesize),tilesize*(x+1),tilesize*(y-1),3));   
        nonMoving.add(new Block("Wall 6", new Dimension (tilesize, tilesize),tilesize*(x+2),tilesize*(y-1),3));   
        nonMoving.add(new Block("Wall 7", new Dimension (tilesize, tilesize),tilesize*(x+3),tilesize*(y-1),3));
        nonMoving.add(new Block("Wall 8", new Dimension (tilesize, tilesize),tilesize*(x+2),tilesize*(y-2),3)); 
        nonMoving.add(new Block("Wall 9", new Dimension (tilesize, tilesize),tilesize*(x+3),tilesize*(y-2),3)); 
        nonMoving.add(new Block("Wall 10", new Dimension (tilesize, tilesize),tilesize*(x+3),tilesize*(y-3),3)); 
    }
    private void makeBackwardStaircase( ArrayList<AbstractNonMovingObject> nonMoving, int x, int y){
        nonMoving.add(new Block("Wall 1", new Dimension (tilesize, tilesize),tilesize*x,tilesize*y,3));
        nonMoving.add(new Block("Wall 2", new Dimension (tilesize, tilesize),tilesize*(x+1),tilesize*y,3));   
        nonMoving.add(new Block("Wall 3", new Dimension (tilesize, tilesize),tilesize*(x+2),tilesize*y,3));   
        nonMoving.add(new Block("Wall 4", new Dimension (tilesize, tilesize),tilesize*(x+3),tilesize*y,3));   
        nonMoving.add(new Block("Wall 5", new Dimension (tilesize, tilesize),tilesize*x,tilesize*(y-1),3));   
        nonMoving.add(new Block("Wall 6", new Dimension (tilesize, tilesize),tilesize*(x+1),tilesize*(y-1),3));   
        nonMoving.add(new Block("Wall 7", new Dimension (tilesize, tilesize),tilesize*(x+2),tilesize*(y-1),3));
        nonMoving.add(new Block("Wall 8", new Dimension (tilesize, tilesize),tilesize*x,tilesize*(y-2),3)); 
        nonMoving.add(new Block("Wall 9", new Dimension (tilesize, tilesize),tilesize*(x+1),tilesize*(y-2),3)); 
        nonMoving.add(new Block("Wall 10", new Dimension (tilesize, tilesize),tilesize*x,tilesize*(y-3),3)); 
    }

   

    
}
