package com.game.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 6953287513222897904L;
    public static final int WIDTH = 700, HEIGHT = (WIDTH / 12 * 9);
        
    private Thread thread;

    private boolean running = false;

    private handler Handler;
    
    
    // game 
    public game() // game constructor 
    {   
        
        new window(WIDTH, HEIGHT, "test", this);
        
        Handler = new handler(); //initate handler class
        this.addKeyListener(new keyImput(Handler));
        Handler.addObj(new player(WIDTH/2-32, HEIGHT/2-32, ID.Player)); // fist object of linked list will have player controls attached 
        Handler.addObj(new testObjcet(WIDTH/4-32,HEIGHT/4-32,ID.testObjcet) );

    }



    public synchronized void start()
    {

        thread = new Thread(this);
        thread.start();
        running = true;

    }
    public synchronized void stop()
    {   
        try 
        {
            thread.join();
            running = false;

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }



    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0; // for viewing fps

        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now; // keeps tick speed
            while(delta >= 1)
            {
                tick();
                delta --;
            }

            if(running)
            {
                render();
            }
                
            
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
               // System.out.println("FPS " + frames);
                frames = 0;
            }
        
        }
        stop();
    }

    private void tick()
    {
        Handler.tick(); // tick game object
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();


        g.setColor(Color.red);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        Handler.render(g);
         // tender game object

        g.dispose();
        
        bs.show();
    }


    


    public static void main (String arg [])
    {
        new game(); // initate game class

    }





}
