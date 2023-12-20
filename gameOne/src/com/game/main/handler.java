package com.game.main;


import java.util.LinkedList;
import java.awt.Graphics;
// for the love of god refactor code 
public class handler 
{
    
    
    
    
    int[] direction;
    LinkedList<gameObject> objects = new LinkedList<gameObject>();
   
    private gameObject playerObject;


   
    public void tick()
    {   
        playerObject = objects.get(0);
        // loop through all game objects

        //test
        playerObject.getGridLocation();

        for (gameObject gameObj : objects)
        {
        //tick all objects in list
       

            
            // took me longer than it should of 
            gameObj.isColiding(playerObject);
            if(playerObject.isColiding(gameObj))
            {
                System.out.println("this " + playerObject + " is colliding with " + gameObj.getID() + " type object");
            }
            
            gameObj.tick();
            
        }
    
    }
    public void render(Graphics g)
    {
        //loop through all objects in list
        for(gameObject gameObj : objects)
        {
            // render all abjects in list
            gameObject tempObject = gameObj;

            tempObject.render(g);

        }
    }

    public void animate(double delta) 
    {

        for(gameObject gameObject : objects)
        {
            gameObject.animate(delta);
        }


    }




    public void addObj(gameObject object)
    {
        this.objects.add(object);
        
    }

    public void removeObj(gameObject object)
    {
        this.objects.remove(object);
    }
}
