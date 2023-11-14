package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame {
    public int[][]maze={{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
                        {1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,9,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    public ArrayList<pair>path=new ArrayList<>();
    //now we need to override the paint funtion which present in graphic class
    //graphis class is used draw a graphis and specifically paint funtion in that


    public Frame() //constructor
    {
        setTitle("MAZE SOLVER");
        setSize(720,850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when we exit all operation will turn off
        int[][]vis=new int[maze.length][maze[0].length];
        DFS.solver(maze,1,1,path,vis);
        for(int i=0;i<path.size();i++)
        {
            System.out.println("x- "+path.get(i).x+" y- "+path.get(i).y);
        }
    }

    @Override
    public void paint(Graphics g)
    {
        g.translate(50,50);
        Color color = null; //will carry color code
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[0].length;j++)
            {
                switch(maze[i][j])
                {
                    case 1: color=Color.BLACK;break;
                    case 0: color=Color.WHITE;break;
                    case 9: color=color.RED;break;
                }

                //so now we have set that color in that  specific grip pixl
                g.setColor(color);
                g.fillRect(27*i,27*j,27,27);

                //now for outline is need to draw on top  of upper pxl
                g.setColor(color.RED);
                g.drawRect(27*i,27*j,27,27);
                // so  x&Y are co-ordinate and another 40 40 are W & H of that pixl of grid
            }
        }
        for(int i=0;i<path.size();i++)
        {
            int x=path.get(i).x;
            int y=path.get(i).y;
            g.setColor(color.RED);
            g.fillOval(27*x,27*y,17,17);
        }
    }
}
