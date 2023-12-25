package com.game.main;



public class gridMovement 
{  
   
    private float moveSpeed  = 1.0f;
    //private vec2 direction = new vec2(0,0) ; // is going to work like vel x vel y but diffrent
    public Tile  targetGrid[][];  
    public vec2 targetPos = new vec2(6,6); // littral pixel position
    public vec2 targetGridPos = new vec2(0,0); // grid position
    
   
            
// constructor 
    public gridMovement(gameBoard board) 
    {
        targetGrid = board.objectGrid;

        targetGridPos.x = 6;
        targetGridPos.y = 6;
    
        
    }
   
    
    


    
    // see documentation on game board class for details 
    // update player movement to tile dep on vec (arr) 

    //TOOD rewrite to use dumb vec2 class
    public void movePlayer(gameObject player,vec2 direction)
    {
   
        
        player.setSizeX(targetGrid[0][0].sizeX); // update player size will be removed later 
        player.setSizeY(targetGrid[0][0].sizeY);

        // RETARDED !!!!!


        
        
        
        
        
        
        
        //System.out.println(player.getX() +  " player x " + " " + (player.getX() == (int)targetPos.x) + " " + player.getX() + " == " + targetPos.x );
        System.out.println((player.getX() == (int)targetPos.x) && (player.getY() == (int)targetPos.y));
        
        if((player.getX() == (int)targetPos.x) && (player.getY() == (int)targetPos.y))
        {   
            System.out.println("UPDATED GRID POSITION");
            player.setGridLocation(targetGridPos);

            //player.setGridLocation(targetGridPos);
            targetGridPos.x += direction.x;
            targetGridPos.y += direction.y;
        }
        
        

        // keep player in bounds
        
        if(targetGridPos.x < 0)
        {
            targetGridPos.x = 0;
        }
        if(targetGridPos.y < 0)
        {
            targetGridPos.y = 0;
        }        
        if(targetGridPos.x > targetGrid.length-1)
        {
            targetGridPos.x = targetGrid.length-1;
        }
        if(targetGridPos.y > targetGrid[0].length-1)
        {
            targetGridPos.y = targetGrid[0].length-1;
        }
         
         
       

        
       // System.out.println(targetGridPos.x + " " + targetGridPos.y); // debug
        targetPos = targetGrid[targetGridPos.y][targetGridPos.x].getPos();
        //targetPos.x = targetGrid[targetGridPos.y][targetGridPos.x].x; // store litral pos in vec2 to pass to animate function
        //targetPos.y = targetGrid[targetGridPos.y][targetGridPos.x].y;

        
        //animate(player, targetPos.x, targetPos.y);
       
         // set grid position for follow the leader stuff with snake player 
        
        //System.out.println(player.getGridLocation());// debug 

        
        
        
        
        //System.out.println(targetGridPos.x +  " " + targetGridPos.y);// debug 
        
    } 

  
    
}
  
 

    
    