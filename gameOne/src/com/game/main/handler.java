package com.game.main;


import java.util.LinkedList;
import java.awt.Graphics;

public class handler {
    
    LinkedList<gameObject> objects = new LinkedList<gameObject>();



    
   
    public void tick()
    {
        // loop through all game objects
        for (gameObject gameObj : objects)
        {
        //tick all objects in list
            gameObject tempObject = gameObj;
            tempObject.tick();
    
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

    public void addObj(gameObject object)
    {
        this.objects.add(object);
    }

    public void removeObj(gameObject object)
    {
        this.objects.remove(object);
    }
}
