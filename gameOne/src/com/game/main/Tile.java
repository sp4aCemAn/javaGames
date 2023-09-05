package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class Tile extends gameObject {
    public Color color;
    public Tile(int x, int y, int size, ID id) {
        super(x, y, id);
        
        this.sizeX = size;
        this.sizeY = size;
    }

    

    @Override
    public boolean isColiding(gameObject object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isColiding'");
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tick'");
    }

    @Override
    public void render(Graphics g) {
        
        
        g.setColor(color);
        g.fillRect(x, y, sizeX, sizeY);

       
    }



   
    
    
}
