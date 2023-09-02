package com.game.main;
import java.awt.Graphics;
public abstract class gameObject implements hitbox
{
    
    protected int  x, y;
    protected ID id;
    protected int velX, velY;
    public int sizeX;
    public int sizeY;
    public gameObject(int x, int y, ID id)
    {
        
        this.x = x;
        this.y = y;
        this.id = id;
    
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;   
    }

    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }

    public void setID(ID id)
    {
        this.id = id;
    }

    public ID getID()
    {
        return this.id;
    }
    
    public void setVelX(int vel)
    {
        this.velX = vel;
    }

    public void setVelY(int vel)
    {
        this.velY = vel;
    }

    public int getVelX()
    {
        return this.velX;
    }
    
    public int getVelY()
    {
        return this.velY;
    }
    public void setSizeX(int size)
    {
        this.sizeX = size;
    }
    public void setSizeY(int size)
    {
        this.sizeY = size;
    }
    public int getSizeX()
    {
        return this.sizeX;
    }
    public int getSizeY()
    {
        return sizeY;
    }

}