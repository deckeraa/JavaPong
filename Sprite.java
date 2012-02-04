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
   private float xaccel, yaccel; // acceleration, pixels/( sec^2 )
   private int height, width;

   static final double SECONDS_PER_MILLISECOND = 0.001; 

   // vector drawing
   Color color;

   Sprite( Graphics context)
   {
      this.context = context;
      x = 0;
      y = 0;
      xvel = yvel = 0;
      xaccel = yaccel = 0;
      height = width = 50;
      color = Color.RED;
   }

   /**
    * The general running function for a sprite
    * @param number of milliseconds in simulated game time
    */
   public void tick( int milliseconds )
   {
      // add accelerations to velocities
      xvel += xaccel * milliseconds * SECONDS_PER_MILLISECOND;
      yvel += yaccel * milliseconds * SECONDS_PER_MILLISECOND;
      x += xvel * milliseconds * SECONDS_PER_MILLISECOND;
      y += yvel * milliseconds * SECONDS_PER_MILLISECOND;
      //System.out.println(xvel + " * " + milliseconds + " * " + SECONDS_PER_MILLISECOND);
   }

   public void draw()
   {
      context.setColor(color);
      context.fillRect( (int)x, (int)y, height, width);
   }

   public void setX( float x )
   {
      this.x = x;
   }

   public void setY( float y )
   {
      this.y = y;
   }

   public void setXAccel( float xaccel )
   {
      this.xaccel = xaccel;
   }
   
   public void setYAccel( float yaccel )
   {
      this.yaccel = yaccel;
   }

   public void setColor( Color color )
   {
      this.color = color;
   }

   public Color getColor()
   {
      return color;
   }
}
