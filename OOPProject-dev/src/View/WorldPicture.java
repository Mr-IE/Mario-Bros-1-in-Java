/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Frame;
import model.Player;
import model.ModelBoard;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.AbstractNonMovingObject;
import model.MovingObject;

/**
 *
 * @author dan.taylor
 */
public class WorldPicture extends JPanel implements Observer {

    private final Image img;
    private final ImageIcon bg = new ImageIcon("img/Level-1-1/spr_bg_level-1-1.gif");
    private final ImageIcon backgound = new ImageIcon("img/Level-1-1/spr_bg_color.gif");
    private final ImageIcon srl1 = new ImageIcon("img/Level-1-1/spr_bg_level-1-1_clouds.gif");//unused clouds image, for older scrolling
    private final ImageIcon floor = new ImageIcon("img/Level-1-1/spr_bg_level-1-1_floor.gif");
    private final ImageIcon Mnt = new ImageIcon("img/Level-1-1/spr_bg_level-1-1_mountains.gif");
    private final ImageIcon cloud_sm = new ImageIcon("img/level-Items/spr_background_CloudSingle.png");
    private final ImageIcon cloud_ml = new ImageIcon("img/level-Items/spr_background_CloudDouble.png");
    private final ImageIcon cloud_lg = new ImageIcon("img/level-Items/spr_background_CloudTriple.png");
    private int position;
    private double prlx1;

    private final ArrayList<ImageStore> myImages;
    private final ArrayList<ImageStore> Clouds;

    public WorldPicture() {
        img = bg.getImage();// gets the background
        myImages = new ArrayList<>();
        Clouds = new ArrayList<>();
        startClouds();
    }

    @Override
    public void update(Observable o, Object arg) {
        myImages.clear();
        ModelBoard board = (ModelBoard) o;
        position = board.getPosition();
        ArrayList<AbstractNonMovingObject> nonMovables = board.getNonMovables();
        for (int i = 0; i < nonMovables.size();i++) {
            myImages.add(new ImageStore(nonMovables.get(i).getX(), nonMovables.get(i).getY(),
                            nonMovables.get(i).getGraphic() ));
        }
        ArrayList<MovingObject> myMovables = board.getMovingObject();
        for (int i = 0; i < myMovables.size(); i++) {
            myImages.add(new ImageStore(myMovables.get(i).getX(), myMovables.get(i).getY(),
                            myMovables.get(i).getGraphic() ));
        }
        
        
        Player player = board.getPlayer();
        myImages.add(new ImageStore(player.getX(), player.getY(), player.getImage()));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawBackground(g2d);

           prlx1 = 1;

        for (int i = 0; i < myImages.size(); i++) {
            if (myImages.get(i) != null) {
                g2d.drawImage(myImages.get(i).getImage(), myImages.get(i).getX(), myImages.get(i).getY(), null);//draws the Player
            }
        }

    }

    private void drawBackground(Graphics2D g2d) {
        g2d.drawImage(backgound.getImage(), -position, 0, null);
        g2d.drawImage(Mnt.getImage(), (-position / 10), 0, null);
       // g2d.drawImage(floor.getImage(), -position+1, 8, null);
        drawRandomClouds(g2d);
        g2d.drawImage(img, -position, 8, null);//draws the background
    }

    private void drawRandomClouds(Graphics2D g2d) {
        
        
        
        for (int i = 0; i < Clouds.size(); i++) {
            int newY;
            int newX;
            g2d.drawImage(Clouds.get(i).getImage(),Clouds.get(i).getX() - position,Clouds.get(i).getY(), null);//draws the Player
            Random rand = new Random();
            
            Clouds.get(i).setX((Clouds.get(i).getX() - (int) prlx1));
            if(Clouds.get(i).getX() <= -100){
                newX = rand.nextInt(100);
                Clouds.get(i).setX(img.getWidth(this)+1000-newX);
                newY = rand.nextInt(100);
                Clouds.get(i).setY(newY);
            }
        }
        
        
        
        
        
        
    }

    private void startClouds() {
       Clouds.add(new ImageStore(500,50,  cloud_sm.getImage()));
       Clouds.add(new ImageStore(1000,39, cloud_ml.getImage()));
       Clouds.add(new ImageStore(1500,26, cloud_lg.getImage()));
       Clouds.add(new ImageStore(2000,96, cloud_sm.getImage()));
       Clouds.add(new ImageStore(2500,25, cloud_ml.getImage()));
       Clouds.add(new ImageStore(3000,99, cloud_lg.getImage()));
       Clouds.add(new ImageStore(3500,65, cloud_sm.getImage()));
       Clouds.add(new ImageStore(4000,38, cloud_ml.getImage()));
       Clouds.add(new ImageStore(4500,21, cloud_lg.getImage()));
    }

    private class ImageStore {

        private Image myImage;
        private int x;
        private int y;

        public ImageStore(int a, int b, Image i) {
            x = a;
            y = b;
            myImage = i;
        }

        public Image getImage() {
            return myImage;
        }

        public void setImage(Image myImage) {
            this.myImage = myImage;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

    }
}
