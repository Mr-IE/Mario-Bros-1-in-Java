/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *
 * @author dan.taylor
 */
public class WorldKeyListener extends KeyAdapter {
    
    Player player;
    
    public WorldKeyListener(Player mb) {
        player = mb;
    }
    
    
    @Override
        public void keyReleased(KeyEvent e) {
            
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    player.pauseLeft();
                    break;
                case KeyEvent.VK_RIGHT :
                    player.pauseRight();
                    break;
                case KeyEvent.VK_UP :
                    player.pauseUp();
                    break;
                default:
                    break;
            }
        }

        
    @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    player.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT :
                    player.moveRight();
                    break;
                case KeyEvent.VK_UP :
                    player.moveUp();
                    break;
                default:
                    break;
            }
        }
        

   
}
