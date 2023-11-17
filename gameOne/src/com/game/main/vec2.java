package com.game.main;

public class vec2 
{
    public int x,y;

    public vec2 (int X, int Y)
    {
        
        x = X;
        y = Y;

    }

    public vec2 ()
    {
        
        x = 0;
        y = 0;

    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }

    
    public void setX(int X)
    {
        x = X;
    }
   
    public void setY(int Y)
    {
        y = Y;
    }
}
