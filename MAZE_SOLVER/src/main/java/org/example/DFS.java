package org.example;

import java.util.ArrayList;
public class DFS {
    static int[]rx={-1,0,+1,0};
    static int[]cx={0,+1,0,-1};

    public static boolean isValid(int i,int j,int[][]maze,int[][]vis)
    {
        return (i>=1 && j>=1 && i<maze.length-1 && j<maze[0].length-1 && vis[i][j]!=1);
    }
    public static boolean solver(int[][]maze, int i, int j, ArrayList<pair> list,int[][]vis)
    {
        if(maze[i][j]==9)
        {
            list.add(new  pair(i,j));
            vis[i][j]=1;
            return true;
        }

        if(maze[i][j]==0)
        {
            list.add(new pair(i,j));
            vis[i][j]=1;
            for(int x=0;x<4;x++)
            {
                if(isValid(i+rx[x],j+cx[x],maze,vis) && solver(maze,i+rx[x],j+cx[x],list,vis))
                {
                    return true;
                }
            }
            list.remove(list.size() - 1);
            return false;
        }
        else
        {
            return false;
        }
    }
}
