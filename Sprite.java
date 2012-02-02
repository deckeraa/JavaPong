// Copyright Aaron Decker 2012

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Handles drawing and location of sprites
 * @author Aaron Decker
 */

class Sprite
{
   BufferedImage backbuffer;

   Sprite( BufferedImage backbuffer)
   {
      this.backbuffer = backbuffer;
   }

   void draw()
   {
      Graphics g = backbuffer.createGraphics();
      g.setColor(Color.RED);
      g.fillRect(0,0,50,50);
   }
}
