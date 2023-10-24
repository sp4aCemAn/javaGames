package com.game.main;

import com.sun.tools.javac.Main;

public class gridMovement 
{  
   
    private float moveSpeed  = 1.0f;
    private vec2 direction = new vec2(0,0) ; // is going to work like vel x vel y but diffrent
    public Tile  targetGrid[][];  
    //public int targetPos[] = new int[2];
    public vec2 targetPos = new vec2(0,0);
    public int gridPosX, gridPosY;
            
// constructor 
    public gridMovement(gameBoard board) 
    {
    targetGrid = board.objectGrid;
    gridPosX = 0;
    gridPosY = 0;

    }
   
    
    


    
    // see documentation on game board class for details 
    // update player movement to tile dep on vec (arr) 

    //TOOD rewrite to use dumb vec2 class
    public void movePlayer(gameObject player,vec2 direction)
    {
       boolean inproc = false; 

        player.setSizeX(targetGrid[0][0].sizeX); // update player size will be removed later 
        player.setSizeY(targetGrid[0][0].sizeY);

        
        if(!inproc){

        }
         
        
        // RETARDED !!!!!
        if(!(player.getX() != targetPos.x))
        gridPosX += direction.x;
        
        
        if(!(player.getY() != targetPos.y))
        gridPosY += direction.y;




        if(gridPosX < 0)
        {
            gridPosX = 0;
        }
        if(gridPosY < 0)
        {
            gridPosY = 0;
        }        
        if(gridPosX>targetGrid.length-1)
        {
            gridPosX = targetGrid.length-1;
        }
        if(gridPosY>targetGrid[0].length-1)
        {
            gridPosY = targetGrid[0].length-1;
        }


        System.out.println(gridPosX + " " + gridPosY);
        targetPos.x = targetGrid[gridPosY][gridPosX].x;
        targetPos.y = targetGrid[gridPosY][gridPosX].y;

        
        //animate(player, targetPos.x, targetPos.y);
       
        player.animate(targetPos);

        
        
        
        
        System.out.println(gridPosX +  " " + gridPosY);
        
    } 

  
    
}
  
 

    
    