package com.game.main;
import java.awt.Color;
import java.awt.Graphics;


// TODO REFATOR!!!!! 
public class gameBoard
{   
   
    
    //private ArrayList<gameObject> objectList = new ArrayList<gameObject>();
    protected int HIGHT,WIDTH;
    private int UNIT_SIZE; 
    private int UNIT_PER_ROW; // tiles per row
    public Color COLOR_ONE, COLOR_TWO;
    public Tile objectGrid[][];

    /*
     * this class creates a 2D array of objects (tiles)
     * to refrence x and y pos for grid based movement 
     * sorta like a ches board if press up refence to the tile above the player in the 2d grid array 
     * visual representation     
     * 
     * {[#,#,#,#,#,#,#],
     * [#,#,#,#,#,#,#],
     * [#,#,#,p,#,#,#], So if the player which is represented as p wants to go up refrence to the 
     * [#,#,#,#,#,#,#], the Tile object above the player == > if player presses up p[3][3] >> p[3][2] update player location to location of that Tile obj 
     * [#,#,#,#,#,#,#],}of course the player isint stored in the array however the tile in which this player resides on is detected by the hitbox 
     *                  the players locateion is updated to the location of the Tile in question 
     *                  location of the player in refrence to the game board is not stored however hitbox detection is what deciedes the interacion of 
     *                  and location of in essence (plaer is coliding with tile on [3][3]) this is probebly going to be changed as 
     *                  hit box calc is more computationally expensive than just storeing the player and obj location and so this might change
     *                  rn its just if (player) collides with (apple) do thing this might change later on how the spesific code for hitbox det works
     */

    //CONSTRUCTOR 
    public gameBoard(int Width, int Hight, int Tpr)
    {

        HIGHT = Hight;
        WIDTH = Width;
        UNIT_PER_ROW = Tpr;
        COLOR_ONE = Color.BLACK;
        COLOR_TWO = new Color(211, 143, 0);
        UNIT_SIZE = (Hight) / UNIT_PER_ROW;
        objectGrid  = new Tile[UNIT_PER_ROW][UNIT_PER_ROW]; 
    

    // populate array
        int Ypoint = 0; // keeps track of y pos of grid in loop
        
        for (int i = 0; i < objectGrid.length; i++) 
        {
            int Xpoint = 0; // keeps track of x pos of grid 
            for (int j = 0; j < objectGrid[i].length; j++)
            {
                objectGrid[i][j] = new Tile(Xpoint, Ypoint, UNIT_SIZE, ID.Tile);
                Xpoint += UNIT_SIZE;
                
            }
            Ypoint += UNIT_SIZE;
        }
    }


    public void update(gameObject object)
    {
        // store information on what the current state of the board is 


    }

    public int getUnitSize()
    {
        return UNIT_SIZE;
    }
    

    // render Grid 
    public void render(Graphics g) // render grid
    {
    boolean BorW = false;
    //System.out.println("first object of array " + objectGrid[0][0] + " " + objectGrid[0][0].getX() + " " + objectGrid[0][0].getY()); DEBUG
        for (Tile[] gameObjects : objectGrid) // loops through entire array and calls render function of each tile obj
        {
            for (Tile gameObject : gameObjects) 
            {

            //System.out.println(gameObject + " " + gameObject.getX() + " " + gameObject.getY());
                
                // this alternates between color 1 and 2 and renders each color accordingly
                if(BorW == true) 
                {
                    gameObject.color = COLOR_ONE;
                }
                else
                {
                    gameObject.color = COLOR_TWO;
                }
                BorW = !BorW;

                gameObject.render(g);

            }   
        }
    }
    




}
