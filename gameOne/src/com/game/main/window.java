package com.game.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class window extends Canvas
{
    private static final long serialVersionUID = 8580061806929952973L;

    public window(int width , int height,String title,game game)
    {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(game);
        game.start();

    }
}     