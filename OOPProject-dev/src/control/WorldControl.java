/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.ModelBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import View.WorldPicture;
import View.WorldView;
import java.io.FileNotFoundException;

/**
 *
 * @author dan.taylor
 */
public class WorldControl implements ActionListener {
    
    private ModelBoard myBoard;
    private WorldView myView;
    private WorldPicture myImage;
    private Timer time;
    private WorldKeyListener listener;
    
    public WorldControl() throws FileNotFoundException {
        myBoard = new ModelBoard();
        myImage = new WorldPicture();
        listener = new WorldKeyListener(myBoard.getPlayer());
        myView = new WorldView(myImage, listener);
        time = new Timer(20, this);
        myBoard.addObserver(myImage);
        
        
    }

    void start() {
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!myBoard.play()) time.stop();
    }
}
