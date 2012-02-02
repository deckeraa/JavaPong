// Copyright Aaron Decker

import javax.swing.JFrame;

/**
 * The main class of JavaPong
 * @author Aaron Decker
 */

class JavaPong implements Runnable
{

   private JFrame window;

   public static void main(String[] args)
   {
      JavaPong javapong = new JavaPong();
      // goes to JavaPong() constructor from here
   }

   JavaPong()
   {
      // setup window
      window = new JFrame("Java Pong");
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setSize(250,250);
      window.setVisible(true);
   }

   /** Implemented from Runnable
    *
    */
   public void run()
   {
   }
};
