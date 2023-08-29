package com.game.main;

import java.awt.Graphics;

public class hitBox extends gameObject {

    public hitBox(int x, int y, ID id) {
        super(x, y, id);
        



    }


    public boolean isTouch(gameObject object)
        {
            /* TODO finsish implementing hitboxes
            // and test hitbox values req to figure out size and locaiotn have already been created 
            // for all game objects check game object class for details 
            // figure out best way to check this every tick 
             or if its best to check every tick or via a action state  */

        if((this.x < object.x+1)&&(this.x+this.sizeX > object.x + object.sizeX))
        {
            System.out.println("intersenting on x");
        }
        

        return false;

    }
    @Override
    public void tick() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tick'");
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
    
}
