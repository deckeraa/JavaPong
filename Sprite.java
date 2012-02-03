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

   // position
   private float x,y; // position pixels
   private float xvel, yvel; // velocities, pixels/sec
   private int height, width;

   static final double SECONDS_PER_MILLISECOND = 0.001; 

   Sprite( Graphics context)
   {
      this.context = context;
      x = 0;
      y = 0;
      xvel = yvel = 0;
      height = width = 50;

      //testing code
      yvel = xvel = 20;
   }

   /**
    * The general running function for a sprite
    * @param number of milliseconds in simulated game time
    */
   public void tick( int milliseconds )
   {
      x += xvel * milliseconds * SECONDS_PER_MILLISECOND;
      y += yvel * milliseconds * SECONDS_PER_MILLISECOND;
      //System.out.println(xvel + " * " + milliseconds + " * " + SECONDS_PER_MILLISECOND);
   }

   public void draw()
   {
      context.setColor(Color.RED);
      context.fillRect( (int)x, (int)y, height, width);
   }
}
