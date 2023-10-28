package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class player extends gameObject
{
    public boolean Ishead;
    public vec2 gridLocation = new vec2(0,0);

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
        g.setColor(new Color(255, 105, 60));
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
    
    @Override
    public void animate(vec2 newPos)
    {// snake player class will pass through a new x and y position (seprate from grid position)
     // which refers to the litral location on screen where the tile refrenced from grid location is 
     //this updates vel value so that this animate function need vel to update 
     // fix werid bug that causes var to skip value 
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
     else{
        
        this.setVelY(0);
        setY(newPos.y);

 }
    }


    public vec2 getGridLocation(){
        return gridLocation;
    }

    public void setGridLocation(vec2 targetGridLcoation){
        gridLocation = targetGridLcoation;
    }


    public vec2 getLocation()
    {
        return new vec2(getX(), getY()); // a fast way to get location in a vector 2 
    }

  

    
}
