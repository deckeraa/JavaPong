Java Pong Clone # 53827
=======================

A Pong clone written in Java in order to play around with 
rendering graphics using Swing.

Rendering the graphics
-----------------------

So here's how we can create a good, object-oriented
model for a pong game.
I will be examining the way that the sprites are drawn.

First, we need to extend a JPanel into a new class.
A JPanel does nothing normally but draw its background.

    public void paintComponent(Graphics g)

This is the signature of the method that gets called whenever
the JPanel is told to ````repaint````.
The "Graphics g" is a rendering context that, if drawn to, will
show up on our window.

So how do we get the "Graphics g" to our sprites, so that they can
draw themselves?
We give them a different graphics context.
By making a BufferedImage in the main class, we can

    backbuffer.createGraphics();

which creats a graphics context for an image.

Once all of our sprites drawn on the BufferedImage,
we tell our JPanel to transfer the BufferedImage to its own
graphics context. "buffer" is our BufferedImage.
````public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      g.drawImage(buffer,0,0,this);
    }
````
