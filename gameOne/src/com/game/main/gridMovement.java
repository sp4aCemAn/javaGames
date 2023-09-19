package com.game.main;

import com.sun.tools.javac.Main;

public class gridMovement 
{  
   
    private float moveSpeed  = 1.0f;
    private vec2 direction = new vec2(0,0) ; // is going to work like vel x vel y but diffrent
    public Tile  targetGrid[][];  
    public int targetPos[] = new int[2];
    public int gridPosX, gridPosY;
            
    // constructor 
    public gridMovement(gameBoard board) 
    {
    targetGrid = board.objectGrid;
    gridPosX = 0;
    gridPosY = 0;

    }
    // TODO fix race condition problem that causes target posiotion to be updated before player reaches said position 
    public void animate(gameObject player,int newPosX,int newPosY)
    {
                

        gridPosX += direction.x;  // store "vector" in X and Y values to ref for velX velY
        gridPosY += direction.y;
        while(player.getY() != targetPos[0] || player.getY() != targetPos[1])
        {

        
            if(player.x < newPosX)
            {
                player.setX(player.getX()+1);
                
            }
            if(player.x > newPosX)
            {
                player.setX(player.getX()-1);
                
            }
            if(player.y < newPosY)
            {
                player.setY(player.getY()+1);
                
            }
            if(player.y > newPosY)
            {
                player.setY(player.getY()-1);
                
            }else{
               
            }
        }
        
      
        


    }
    


    
    // see documentation on game board class for details 
    // update player movement to tile dep on vec (arr) 

    //TOOD rewrite to use dumb vec2 class
    public void movePlayer(gameObject player,vec2 direction)
    {
       boolean inproc = false; 

        player.sizeX = targetGrid[0][0].sizeX; // update player size will be removed later 
        player.sizeY = targetGrid[0][0].sizeY;

        
        if(!inproc){

        }
         // if only vectors existed in the way i want them to work would make code more readable 
        direction = direction;


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
        targetPos[0] = targetGrid[gridPosY][gridPosX].x;
        targetPos[1] = targetGrid[gridPosY][gridPosX].y;

        
        animate(player, targetPos[0], targetPos[1]);
       


        
        
        
        
        System.out.println(gridPosX +  " " + gridPosY);
        
    } 

  
    
}
  
 

    
    