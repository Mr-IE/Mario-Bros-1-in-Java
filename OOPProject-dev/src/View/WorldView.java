/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import control.WorldKeyListener;
import javax.swing.JFrame;

/**
 *
 * @author dan.taylor
 */
public class WorldView {
        JFrame frame = new JFrame();
        
        
        public WorldView(WorldPicture b, WorldKeyListener l){
            frame.add(b);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(858, 262);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setFocusable(true);
            frame.addKeyListener(l);
        }
}
