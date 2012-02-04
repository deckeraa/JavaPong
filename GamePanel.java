// Copyright Aaron Decker 2012

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * Extended JFrame to allow for drawing of graphics.
 * @author Aaron Decker
 */

class GamePanel extends JPanel
{
   GameBuffer gbuffer;
   LinkedList <MouseEvent>mouse_events = new LinkedList<MouseEvent>();
   MyMouseAdapter mouse_adapter;

   GamePanel( GameBuffer gbuffer)
   {
      this.gbuffer = gbuffer;
      mouse_adapter = new MyMouseAdapter();
      addMouseListener(mouse_adapter);
      addMouseMotionListener(mouse_adapter);
   }


   /**
    * Draws the GamePanel
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(gbuffer.getBuffer(),0,0,this);
   }

   /*public MouseEvent getNextMouseEvent()
   {
   }*/

   public boolean areMouseEventsLeft()
   {
      if( mouse_events.size() > 0 )
         return true;
      return false;
   }
   
   class MyMouseAdapter extends MouseAdapter
   {
      public void mouseDragged(MouseEvent e)
      {
         System.out.println("Mouse dragged.");
         mouse_events.add(e);
      }

      public void mousePressed(MouseEvent e)
      {
         System.out.println("Mouse pressed.");
         mouse_events.add(e);
      }

   };
};
