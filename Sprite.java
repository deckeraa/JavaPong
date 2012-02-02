// Copyright Aaron Decker 2012

import java.awt.Graphics;
import java.awt.Color;

/**
 * Handles drawing and location of sprites
 * @author Aaron Decker
 */

class Sprite
{
   GamePanel gpanel;

   Sprite( GamePanel gpanel)
   {
      this.gpanel = gpanel;
   }

   void draw(Graphics g)
   {
      g.setColor(Color.RED);
      g.fillRect(0,0,50,50);
   }
}
