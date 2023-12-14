package com.game.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 6953287513222897904L;
    public static final int WIDTH = 700, HEIGHT = 600;
        
    private Thread thread;

    private boolean running = false;

    private handler Handler;

    private keyImput keyInput;
    
    private gameBoard Grid;

    public double delta;
    
    public player test;

    // game 
    public game() // game constructor 
    {   
        
        new window(WIDTH, HEIGHT, "test", this);
        Grid =  new gameBoard(WIDTH-32, HEIGHT - 100, 31);
        Handler = new handler(); //initate handler class
        keyInput = new keyImput(Handler,Grid);
        this.addKeyListener(keyInput);
        snakePlayer player = new snakePlayer(WIDTH/5-32,HEIGHT/5-32,ID.Player);
        player.setGameBoard(Grid);
        Handler.addObj(player);
        Handler.addObj(new testObjcet(WIDTH/4-32,HEIGHT/4-32,ID.testObjcet));
        test = new player(100,500,ID.testObjcet);
        
        //Handler.addObj(new player(WIDTH/2-32, HEIGHT/2-32, ID.Player)); // fist object of linked list will have player controls attached 
        
        
        
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
        delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0; // for viewing fps

        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now; // keeps tick speed
            while(delta >= 1)
            {
                animate(delta);
                tick();
                
                delta --;
                //System.out.println(delta);
            }

            if(running)
            {
                render();
                
            }
                
            
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS " + frames);
                frames = 0;
            }
        
        }
        stop();
    }
   
    private void tick()
    {
        test.animate(new vec2(200,100));
        Handler.tick(); // tick game object
        keyInput.tick();
        test.tick();
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

        //TODO figure out wierd render bug that causes NULL exeption every other time this is ran
        g.setColor(Color.red);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        Grid.render(g);
        Handler.render(g);
        test.render(g);
         // render game object
        
        g.dispose();
        
        
        bs.show();
    }

    private void animate (double delta){
        Handler.animate(delta);
    }


    


    public static void main (String arg [])
    {
        new game(); // initate game class

    }





}
