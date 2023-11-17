package com.game.main;
import java.awt.Graphics;
//import java.awt.Color;
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
    //TODO add get and set grid location
    public void setGridLocation(vec2 newGridLocation)
    {
        
    }

    public vec2 getGridLocation()
    {
        return new vec2(0, 0);
    }

    public void animate(vec2 newPos)
    {// snake player class will pass through a new x and y position (seprate from grid position)
     // which refers to the litral location on screen where the tile refrenced from grid location is 
     //this updates vel value so that this animate function need vel to update 
     // fix werid bug that causes var to skip value
     //TODO figure out better way to implement this useing delta
     //horible way to implement this 
        int velocity = 2;


        if(this.getX() < newPos.x)
        {
             this.setVelX(velocity);;
        }
        else if(this.getX() > newPos.x)
        {
            this.setVelX(-(velocity));;
        }
        else{
            this.setVelX(0);
            setX(newPos.x);
        }
        if(this.getY() < newPos.y)
        {
            this.setVelY(velocity);
        }
        else if(this.getY() > newPos.y)
        {
             this.setVelY(-(velocity));
        }
        else
        {
            this.setVelY(0);
            setY(newPos.y);
        }
    }

    // ovride deafault render
    public void render(Graphics g) 
    {
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }

    public vec2 getPos()
    {
        return new vec2(x,y);
    }
    

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