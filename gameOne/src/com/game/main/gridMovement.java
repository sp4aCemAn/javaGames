package com.game.main;

import java.awt.Graphics;

import java.util.Vector;

public class gridMovement {
    
    private float moveSpeed  = 0.2f;
    private int direction[] = new int[2]; // is going to work like vel x vel y but diffrent
    public Tile  targetGrid[][];  
    public int targetPos[] = new int[2];
    public int gridVelX, gridVelY;
            

    public gridMovement(gameBoard board) {
       
    targetGrid = board.objectGrid;
    
    gridVelX = 0;
    gridVelY = 0;


    }

    public void movePlayer(gameObject player,int direction[])
    {
        
        player.sizeX = targetGrid[0][0].sizeX;
        player.sizeY = targetGrid[0][0].sizeY;

        gridVelX += direction[0];
        gridVelY += direction[1];

        if(gridVelX < 0){
            gridVelX = 0;
            
        }
        if(gridVelY < 0){
            gridVelY = 0;
            
        }        
        if(gridVelX>targetGrid.length){
            gridVelX = targetGrid.length-1;
        }
        if(gridVelY>targetGrid[0].length){
            gridVelY = targetGrid[0].length-1;
        }

        targetPos[0] = targetGrid[gridVelY][gridVelX].x;
        targetPos[1] = targetGrid[gridVelY][gridVelX].y;

        
            player.x = targetPos[0];
            player.y = targetPos[1];
        
            
        




        
    } 
    
    
}
  
 

    
    