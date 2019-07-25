/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.EventQueue;

/**
 *
 * @author dan.taylor
 */
public class WorldStart {
    
    private WorldStart() {
       throw new IllegalStateException();
   }
        
        /**
         * This is the main driver for the G program. It will call the GUI
         * and start it.
         * 
         * @param theArgs command line promps
         */
        public static void main(final String[] theArgs) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    final WorldControl test = new WorldControl();
                    test.start();
                }
            });

        }
    
    
}
