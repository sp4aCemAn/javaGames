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

    public snakePlayer(int x, int y, ID id) 
    {
        super(x, y, id);
        player snakeHead = new player(x,y,id);
        playerObjecList.add(0,snakeHead);
        System.out.println(playerObjecList.get(0));

        
    }
        
    public void tick()
    {
        //playerObjecList.get(0).setVelX(velX);
        //playerObjecList.get(0).setVelY(velY);

    }




    public void render(Graphics g)
    {
        g.setColor(Color.pink);
        
        for(player i : playerObjecList)
        {

            i.render(g);
        }
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
    }
    
    public void setSizeY(int y)
    {
        playerObjecList.get(0).setSizeY(y);
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
    public boolean isColiding(gameObject object) {
        // TODO actually implement
        return playerObjecList.get(0).isColiding(object);
        //throw new UnsupportedOperationException("Unimplemented method 'isColiding'");
    }




}
