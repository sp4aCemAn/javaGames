package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class player extends gameObject 
{

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
        System.out.println(this.x +  " " + this.sizeX);
        //System.out.println(this.isTouch());

        //y+=velY;
        // debug System.out.println(x);
    }

    //@Override
    public void render(Graphics g) 
    {   // this function declars what the player obj looks like 
        g.setColor(Color.white);
        g.fillRect(x, y, sizeX, sizeY);
        
    }

    
}
