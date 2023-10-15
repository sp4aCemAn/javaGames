package com.game.main;
import java.awt.Graphics;
import java.util.ArrayList;

public class snakePlayer extends player {

/*
 * store player as a list of player objects each player will
 * update its location based on the location of the node infront of it
 * where the snake head is the main node of the snake player 
 * 
 */
    private ArrayList<player> playerObjecList;

    public snakePlayer(int x, int y, ID id) 
    {
        super(x, y, id);
        //TODO Auto-generated constructor stub
    }
        
    public void tick()
    {
            
    

    }




    public void render(Graphics g)
    {
        for(player i : playerObjecList)
        {
            i.render(g);
        }
    }




}
