package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class testObjcet extends gameObject {

    public testObjcet(int x, int y, ID id) {
        super(x, y, id);
        this.sizeX = 32;
        this.sizeY = 32;

    }

    @Override
    public void tick() {
       
       
    }

    @Override
    public void render(Graphics g) {
     
        g.setColor(Color.blue);
        g.fillRect(x, y, sizeX, sizeY);
    }

   

    @Override
    public boolean isColiding(gameObject object) {

        if((object != this) && ((this.x < object.getX() + object.getSizeX() - 1) && (this.x + this.getSizeX() > object.getX() + 1)) && 
                                (this.y < object.getY() + object.getSizeY() - 1) && (this.y + this.getSizeY() > object.getY() + 1))
       {
            this.setX((int)(Math.random()*701));
            this.setY((int)(Math.random()*351));
           return true;
       }
       return false;
  
    }
    
}
