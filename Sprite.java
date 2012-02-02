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
   Graphics context;

   Sprite( Graphics context)
   {
      this.context = context;
   }

   void draw()
   {
      context.setColor(Color.RED);
      context.fillRect(0,0,50,50);
   }
}
