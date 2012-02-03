import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

class GameBuffer
{
   private BufferedImage buffer;
   private Graphics context;
   private int width, height;
   private Color color;

   public GameBuffer( int width, int height )
   {
      this.width = width;
      this.height = height;
      color = Color.RED;
      backbuffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
      context = buffer.createGraphics();
   }

   public GameBuffer( int width, int height, Color color )
   {
      this.width = width;
      this.height = height;
      this.color = color;
      backbuffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
      context = buffer.createGraphics();
   }

   public Graphics getGraphics()
   {
      return context;
   }

   public void clear_to_color( Color color)
   {
      context.setColor(color);
      context.fillRect( 0, 0, height, width);
   }

   public void clear()
   {
      clear_to_color( color );
   }
}
