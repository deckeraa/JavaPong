// Copyright Aaron Decker

import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;

/**
 * The main class of JavaPong
 * @author Aaron Decker
 */

class JavaPong implements Runnable
{

   private JFrame window;
   private GamePanel gamepanel;
   private GameBuffer backbuffer;
   private Thread thread;

   static final int TICK_LENGTH_MS = 15;

   // desired height and width for the window
   static final int DESIRED_WIDTH = 550;
   static final int DESIRED_HEIGHT = 350;

   // keyboard events
   MyKeyboardAdapter keyboard_adapter;

   // testing code
   Sprite test;

   public static void main(String[] args)
   {
      JavaPong javapong = new JavaPong();
      // goes to JavaPong() constructor from here
   }

   JavaPong()
   {
      backbuffer = new GameBuffer(DESIRED_WIDTH,DESIRED_HEIGHT, Color.ORANGE);
      // setup window
      window = new JFrame("Java Pong");
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setSize(DESIRED_WIDTH,DESIRED_HEIGHT);
      //window.setResizable(false);
      window.setVisible(true);

      // setup gamepanel
      gamepanel = new GamePanel( backbuffer );
      window.add( gamepanel );
      window.pack();

      // keyboard events
      keyboard_adapter = new MyKeyboardAdapter();

      // testing code
     test = new Sprite( backbuffer.getGraphics() );
     thread = new Thread(this);
     thread.start();
   }

   /** Implemented from Runnable
    *
    */
   public void run()
   {
      Thread current = Thread.currentThread();

      while( current == thread )
      {
         // throttle frame rate
         try
         {
            Thread.sleep(TICK_LENGTH_MS);
         }
         catch( InterruptedException e )
         {
            e.printStackTrace();
         }

         // tick sprites 
         test.tick(TICK_LENGTH_MS);

         handleMouseEvents();
         handleKeyEvents();

         // draw
         backbuffer.clear();
         test.draw();
         gamepanel.repaint();
      }
   }

   public void handleMouseEvents()
   {
      try
      {
         MouseEvent e = gamepanel.getNextMouseEvent();
         test.setX( e.getX() );
         test.setY( e.getY() );
         if( e.getID() == MouseEvent.MOUSE_RELEASED )
         {
            // just a sample of how to test the event type
         }

      }
      catch ( java.util.NoSuchElementException exception )
      {
         // no events on queue, so nothing to do
      }
   }

   public void handleKeyEvents()
   {
      try
      {
         KeyEvent e = gamepanel.getNextKeyEvent();
         System.out.println( e.getKeyCode() );
      }
      catch ( java.util.NoSuchElementException exception )
      {
         // no events on queue, so nothing to do
      }
   }

   class MyKeyboardAdapter implements KeyListener
   {
      MyKeyboardAdapter()
      {
         addKeyListener( this );
      }
      public void keyPressed(KeyEvent e)
      {
         System.out.println( e.getKeyCode() );
      }

      public void keyReleased(KeyEvent e)  
      {
      }

      public void keyTyped(KeyEvent e)
      {
      }
   };

};
