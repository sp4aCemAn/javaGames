package com.game.main;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class snakePlayer extends gameObject 
{

/*
 * store player as a list of player objects each player will
 * update its location based on the location of the node infront of it
 * where the snake head is the main node of the snake player 
 * 
 */
    private ArrayList<vec2> lastGridlocation = new ArrayList<vec2>();
    public ArrayList<player> playerObjectList = new ArrayList<player>();
    
    public snakePlayer(int x, int y, ID id) 
    {
        super(x, y, id);
        player snakeHead = new player(x,y,id);
        player Node = new player(x-snakeHead.sizeX, y, id);
        player Node2 = new player(x-snakeHead.sizeX, y, id);
        snakeHead.setGridLocation(new vec2(6,6));
        playerObjectList.add(0,snakeHead);
        playerObjectList.add(1,Node);
        playerObjectList.add(2,Node2);

        snakeHead.setGridLocation(new vec2(6,6));
        snakeHead.setLocation(new vec2(6*32, 6*32));



         for (int i = 1; i < playerObjectList.size(); i++)
         {
            playerObjectList.get(i).setGridLocation(new vec2 ((snakeHead.getGridLocation().x) - i,snakeHead.getGridLocation().y));
            int tempx = playerObjectList.get(i).getGridLocation().x;
            int tempy = playerObjectList.get(i).getGridLocation().y;

            playerObjectList.get(i).setLocation(new vec2(tempx*32, tempy*32));
        

    
        }
        
        
        
        



        //playerObjectList.add(1, testNode);
        //playerObjectList.get(1).setGridLocation(new vec2(playerObjectList.get(0).getGridLocation().x, playerObjectList.get(0).getGridLocation().y));
     
        System.out.println(playerObjectList.get(0));
    }
        
    public void tick()
    {
        //playerObjectList.get(0).setVelX(velX);
        //playerObjectList.get(0).setVelY(velY);
        //loop through all objects and update location based on prev head location 
        // maybe create a animate function inside of every player node?
        
        for (player objecPlayer  : playerObjectList) 
        {
            objecPlayer.tick();
        }

        // optimization made to make getting grid location faster 
        
    }

    @Override
    public void setGridLocation(vec2 newGridlocation)
    {
    //System.out.println("called : setgrid");

        

            playerObjectList.get(0).setGridLocation(newGridlocation);
        
            for(int i = playerObjectList.size()-1; i > 0 ;i--)
            {   
                
                //System.out.println("called : setgrid" + playerObjectList.get(i) + " new grid location " + playerObjectList.get(i-1).getGridLocation().x + " " + playerObjectList.get(i-1).getGridLocation().y );
                if((playerObjectList.get(i).getGridLocation().getX() == (playerObjectList.get(i-1).getGridLocation().getX()+1)) || 
                   (playerObjectList.get(i).getGridLocation().getX() == (playerObjectList.get(i-1).getGridLocation().getX()-1)) || 
                   (playerObjectList.get(i).getGridLocation().getY() == (playerObjectList.get(i-1).getGridLocation().getY()+1)) ||
                   (playerObjectList.get(i).getGridLocation().getY() == (playerObjectList.get(i-1).getGridLocation().getY()-1)) )
                {
                    System.out.println("called : setgrid" + playerObjectList.get(i) + " new grid location " + playerObjectList.get(i-1).getGridLocation().x + " " + playerObjectList.get(i-1).getGridLocation().y );
                    //playerObjectList.get(i).setGridLocation(playerObjectList.get(i-1).getGridLocation());
                }
                    
                
            
            }
        
        
        
       // playerObjectList.get(0).setGridLocation(newGridlocation);

        
        

        //playerObjectList.get(0).setGridLocation(newGridlocation);

        
           
        
            

        
        //playerObjectList.get(0).setGridLocation(newGridlocation);    
    }


    public void render(Graphics g)
    {
        g.setColor(Color.pink);
        
        for(player i : playerObjectList)
        {
            i.render(g); 
        }
    }

    public void animate(double delta)
    {    
        
        for (player node : playerObjectList) 
        {
            vec2 pos = new vec2(0,0);

            pos.setX(node.getGridLocation().x * gameBoard.getUnitSize()); 
            pos.setY(node.getGridLocation().y * gameBoard.getUnitSize());

            node.setLocation(pos);
            System.out.println(pos.x + " " + pos.y  +  node);
            node.animate(delta);
        }
        
    }
    
    


    public void setX(int x)
    {
        playerObjectList.get(0).setX(x);
    }

    public int getX()
    {
        return playerObjectList.get(0).getX();
    }
    public void setY(int y)
    {
        playerObjectList.get(0).setY(y);
    }

    public int getY()
    {
        return playerObjectList.get(0).getY();
    }

    public void setSizeX(int x)
    {
        playerObjectList.get(0).setSizeX(x);
        for (player player : playerObjectList)
        {
            player.setSizeX(x);
        }    
    }
    
    public void setSizeY(int y)
    {
        playerObjectList.get(0).setSizeY(y);
        for (player player : playerObjectList) 
        {
            player.setSizeY(y);
        }
    }
    
    public int getSizeX()
    {
        return playerObjectList.get(0).getSizeX();
    }
    
    public int getSizeY()
    {
        return playerObjectList.get(0).getSizeY();
    }

    @Override
    public boolean isColiding(gameObject object) 
    { 
        return playerObjectList.get(0) != object && playerObjectList.get(0).isColiding(object);
    }


    // figure out how to store last position
    //TODO fix 


    @Override
    public vec2 getGridLocation()
    {
        vec2 grid = playerObjectList.get(0).getGridLocation();


        System.out.println(grid.x+" "+grid.y + "get grid loco");
        return grid;
    }
 

}
