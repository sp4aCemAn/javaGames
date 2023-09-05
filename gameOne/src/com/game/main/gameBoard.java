package com.game.main;
import java.awt.Color;
import java.awt.Graphics;

// TODO REFATOR!!!!! 
public class gameBoard
{
    protected int HIGHT,WIDTH;
    private int UNIT_SIZE; 
    private int UNIT_PER_ROW; // tiles per row
    public Color COLOR_ONE, COLOR_TWO;
    public Tile objectGrid[][];

    //create array of game objects to ref X and Y pos from
    public gameBoard(int Width, int Hight, int Tpr){
    HIGHT = Hight;
    WIDTH = Width;
    UNIT_PER_ROW = Tpr;
    COLOR_ONE = Color.WHITE;
    COLOR_TWO = Color.BLACK;
    UNIT_SIZE = (Hight) / UNIT_PER_ROW;
    objectGrid  = new Tile[UNIT_PER_ROW][UNIT_PER_ROW];
    
    
        int Ypoint = 0;

        
        
        for (int i = 0; i < objectGrid.length; i++) 
        {
            int Xpoint = 0;
            for (int j = 0; j < objectGrid[i].length; j++)
            {
                objectGrid[i][j] = new Tile(Xpoint, Ypoint, UNIT_SIZE, ID.Tile);
                Xpoint += UNIT_SIZE;
                
            }
        Ypoint += UNIT_SIZE;

    }
}


    

    
    

 
    public void render(Graphics g) // render grid
    {
    
    boolean BorW = false;
        //System.out.println("first object of array " + objectGrid[0][0] + " " + objectGrid[0][0].getX() + " " + objectGrid[0][0].getY());
    for (Tile[] gameObjects : objectGrid) {
        for (Tile gameObject : gameObjects) {

            //System.out.println(gameObject + " " + gameObject.getX() + " " + gameObject.getY());
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
