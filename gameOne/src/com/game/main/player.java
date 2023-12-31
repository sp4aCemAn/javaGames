package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class player extends gameObject
{
    public boolean Ishead;
    public vec2 gridLocation = new vec2(0,0);
    public double Delta;
    public player(int x, int y, ID id)  // player constructor 
    {
        super(x, y, id);
        this.sizeX = 32;
        this.sizeY = 32;
    }

    //@Override
    public void tick() 
    {
        y += velY;
        x += velX;
        
        //System.out.println(this.isTouch());

        //y+=velY;
        // debug System.out.println(x);
    }

    //@Override
    public void render(Graphics g) 
    {   // this function declars what the player obj looks like 
        //g.setColor(new Color(255, 105, 60));
        g.fillRect(x, y, sizeX, sizeY);
        
    }
   
   
    @Override
    public boolean isColiding(gameObject object) 
    {
       
        if((object != this) && ((this.x < object.x + object.sizeX - 1) && (this.x + this.sizeX > object.x + 1)) && 
                                (this.y < object.y + object.sizeY - 1) && (this.y + this.sizeY > object.y + 1))
        {
            return true;
        }
        return false;
   
    }
    
    
    

    


    

  

    
}
