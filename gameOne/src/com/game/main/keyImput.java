package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class keyImput extends KeyAdapter {
    private handler Handler;
    private boolean isKeyDowm; // unused 

    public keyImput(handler Handler)
    {
        this.Handler = Handler;
    }


    public void keyPressed(KeyEvent e)
    {//test
        
        
        int key = e.getKeyCode();
        //System.out.println(isKeyDowm);
        isKeyDowm = true;
        
        
        for(gameObject obj : Handler.objects)
        {
            gameObject tempObj = null; // fuck awfull bandiad fix 
            // find another better way of doing this prob going to require a rewrite 

            if(obj.id == ID.Player)
            {

                tempObj = obj;
            }

            
        try { // dumb fix for now while i test hitbox
            // TODO Fix this ASAP
             switch (key)
            {
                case 38: // down arrow
                tempObj.setVelY(-5);
                break;
                
                case 39: // right arrow
                tempObj.setVelX(+5);
                break;
                
                case 40: // up arrow 
                tempObj.setVelY(+5);
                break;
        
                case 37: // left arrow
                tempObj.setVelX(-5);
                break;

                case 65:
                tempObj.setSizeX(tempObj.getSizeX() + 5);
                break;

                case 68:
                tempObj.setSizeX(tempObj.getSizeX() - 5);
                break;
                default:

                break;

            }
        } catch (Exception error) {
            System.out.println("FIX THIS CODE");
        }
       
            
            // keyevents
        }


    }

    public void keyReleased(KeyEvent e){
        isKeyDowm = false;
        int key = e.getKeyCode();
        for(gameObject obj : Handler.objects)
        {
        
        gameObject tempObj = obj;

        switch (key)
            {
                case 38: // down arrow
                tempObj.setVelY(0);
                break;
                
                case 39: // right arrow
                tempObj.setVelX(0);
                break;
                
                case 40: // up arrow 
                tempObj.setVelY(0);
                break;
        
                case 37: // left arrow
                tempObj.setVelX(0);
                break;

                default:

                break;

            }
            
            // keyevents
        }
        
    }

}
