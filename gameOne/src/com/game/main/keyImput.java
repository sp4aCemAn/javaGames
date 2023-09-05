package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class keyImput extends KeyAdapter {
    private handler Handler;
    
    //private boolean isKeyDowm; // unused 
    private gridMovement movementBehavoir;
    public keyImput(handler Handler,gameBoard board)
    {

        movementBehavoir = new gridMovement(board);
        this.Handler = Handler;
        
    
    }



    public void keyPressed(KeyEvent e)
    {//test
        
        
        int key = e.getKeyCode();
        //System.out.println(isKeyDowm);
        //isKeyDowm = true;
        
        
        for(gameObject obj : Handler.objects) /// refactor code later 
        {
            gameObject tempObj = Handler.objects.get(0); // less awfull fix 
            gameObject testObj = Handler.objects.get(1); // debug to grow test object 
            int direction[] = {0,0};

            //System.out.println(key);
        try 
        { // dumb fix for now while i test hitbox
            // TODO Fix this ASAP
          
             switch (key)
             {
                case 38: // down arrow
                //tempObj.setVelY(-5);
                direction[1] -= 1;
                
                break;
                
                case 39: // right arrow
                direction[0] += 1;
                //tempObj.setVelX(+5);
                break;
                
                case 40: // up arrow 
                direction[1] += 1;
                //tempObj.setVelY(+5);
                break;
        
                case 37: // left arrow
                direction[0] -= 1;
                //tempObj.setVelX(-5);
                break;

                case 65:
                //tempObj.setSizeX(tempObj.getSizeX() + 5);
                break;

                case 68:
                //tempObj.setSizeX(tempObj.getSizeX() - 5);
                break;

                case 93:// [
                testObj.sizeX = (testObj.sizeX + 5);
                testObj.sizeY = (testObj.sizeY + 5);
                break;
                case 91:// ]
                testObj.sizeX = (testObj.sizeX - 5);
                testObj.sizeY = (testObj.sizeY - 5);
                break;
                default:

                break;

            }
            System.out.println(direction[0]+ " " + direction[1]);
            movementBehavoir.movePlayer(tempObj, direction);
        } 
        catch (Exception error) 
        {//TODO make better
            System.out.println("FIX THIS CODE " + error);
        }
       
            
            // keyevents
        }


    }

    public void keyReleased(KeyEvent e)
    {
        //isKeyDowm = false;
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
