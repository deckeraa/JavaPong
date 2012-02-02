// Copyright Aaron Decker

import javax.swing.JFrame;
import java.awt.image.BufferedImage;

/**
 * The main class of JavaPong
 * @author Aaron Decker
 */

class JavaPong implements Runnable
{

   private JFrame window;
   private GamePanel gamepanel;
   BufferedImage backbuffer;

   // testing code
   Sprite test;

   public static void main(String[] args)
   {
      JavaPong javapong = new JavaPong();
      // goes to JavaPong() constructor from here
   }

   JavaPong()
   {
      backbuffer = new BufferedImage(250,250,BufferedImage.TYPE_INT_RGB);
      // setup window
      window = new JFrame("Java Pong");
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setSize(250,250);
      window.setVisible(true);

      // setup gamepanel
      gamepanel = new GamePanel( backbuffer );
      window.add( gamepanel );
      window.pack();

      // testing code
     test = new Sprite( backbuffer );
   }

   /** Implemented from Runnable
    *
    */
   public void run()
   {
      test.draw();
      gamepanel.repaint();
   }
};
