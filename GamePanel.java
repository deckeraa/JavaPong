// Copyright Aaron Decker 2012

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Extended JFrame to allow for drawing of graphics.
 * @author Aaron Decker
 */

class GamePanel extends JPanel
{
   BufferedImage backbuffer;

   GamePanel( BufferedImage backbuffer)
   {
      this.backbuffer = backbuffer;
   }

   /**
    * Draws the GamePanel
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(backbuffer,0,0,this);
   }
};
