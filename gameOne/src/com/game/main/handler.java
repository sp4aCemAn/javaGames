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
        /*TODO implement hitbox
         * essentually we have to have to compare whether or not each object is
         * within  a rage of eachother so if we call data from plater object (x to x + sizeOfplayer) this goes for y axis is intersecting
         * with the rage and domain of some other object (this.x to this.x + this.SizeOfObject) actual attribute names are obviously diffrent
         * as they extend from the game object class and have predifind attributes and accesor and modifire classes however 
         * this is just a representation of how to handle hitbox detection its sorta primitive and probebly not efficient
         * as we are calculating this every tick but idk im not a game dev
         * 
         */
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
