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
        // TODO Auto-generated method stub
       
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(Color.blue);
        g.fillRect(x, y, sizeX, sizeY);
    }
    
}