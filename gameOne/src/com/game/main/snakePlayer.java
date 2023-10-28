package com.game.main;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class snakePlayer extends gameObject {

/*
 * store player as a list of player objects each player will
 * update its location based on the location of the node infront of it
 * where the snake head is the main node of the snake player 
 * 
 */
    public ArrayList<player> playerObjecList = new ArrayList<player>();
    public gameBoard gameBoard;
    public snakePlayer(int x, int y, ID id) 
    {
        super(x, y, id);
        player snakeHead = new player(x,y,id);
        player testNode = new player(x-snakeHead.sizeX, y, id);
        player testNode2 = new player(x-snakeHead.sizeX*2, y, id);
        
        playerObjecList.add(0,snakeHead);
        playerObjecList.add(1, testNode);
        playerObjecList.get(1).setGridLocation(new vec2(playerObjecList.get(0).getGridLocation().x, playerObjecList.get(0).getGridLocation().y));
     
        System.out.println(playerObjecList.get(0));

        
    }
        
    public void tick()
    {
        //playerObjecList.get(0).setVelX(velX);
        //playerObjecList.get(0).setVelY(velY);
        //loop through all objects and update location based on prev head location 
        // maybe create a animate function inside of every player node?
        
        for (player objecPlayer  : playerObjecList) {
            objecPlayer.tick();
        }


        vec2 pos = new vec2(0,0);
        for (int i = 0; i< playerObjecList.size();i++) {
            player player = playerObjecList.get(i);
            
            

            pos.x = player.getGridLocation().x *gameBoard.getUnitSize();
            pos.y = player.getGridLocation().y *gameBoard.getUnitSize();
            player.animate(pos);
            System.out.println("test " + player.getGridLocation().x + " " + getGridLocation().y);
            System.out.println("test 2 " + player.x + " " + player.y);
        }
        


    }






    public void render(Graphics g)
    {
        g.setColor(Color.pink);
        
        for(player i : playerObjecList)
        {

            i.render(g);
        }
    }

    public void animate(vec2 targetPos)
    {
        
        
        playerObjecList.get(0).animate(targetPos);


   
        
    }
    
    public void setGameBoard(gameBoard GameBoard)
    {
        gameBoard = GameBoard;
    }


    public void setX(int x)
    {
        playerObjecList.get(0).setX(x);
    }

    public int getX()
    {
        
        return playerObjecList.get(0).getX();

    }
    public void setY(int y)
    {
        playerObjecList.get(0).setY(y);
    }

    public int getY()
    {
        return playerObjecList.get(0).getY();
    }

    public void setSizeX(int x)
    {
        playerObjecList.get(0).setSizeX(x);
        for (player player : playerObjecList)
        {
            player.setSizeX(x);
        }    
    }
    
    public void setSizeY(int y)
    {
        playerObjecList.get(0).setSizeY(y);
        for (player player : playerObjecList) 
        {
            player.setSizeY(y);
        }
    }
    
    public int getSizeX()
    {
        return playerObjecList.get(0).getSizeX();
    }
    
    public int getSizeY()
    {
        return playerObjecList.get(0).getSizeY();
    }

    @Override
    public boolean isColiding(gameObject object) 
    {
        // TODO actually implement
        return playerObjecList.get(0) != object && playerObjecList.get(0).isColiding(object);
        //throw new UnsupportedOperationException("Unimplemented method 'isColiding'");
    }


    // figure out how to store last position
    public void setGridLocation(vec2 newGridlocation)
    {
    
        
        
        
        for(int i = playerObjecList.size()-1; i>0 ;i--)
        {
            playerObjecList.get(i).setGridLocation(playerObjecList.get(i-1).getGridLocation());
        }
        
        playerObjecList.get(0).setGridLocation(newGridlocation);
        

    }


    public vec2 getGridLocation()
    {
        vec2 grid = playerObjecList.get(0).getGridLocation();
        System.out.println(grid.x+" "+grid.y + "get grid loco");
        return grid;
    }
 

}
