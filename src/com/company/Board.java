package com.company;

public class Board
{
    public Cell[][] board;

    int grids = 4;

    int border = 0;

    public int score = 0;


    public Board()
    {
        board = new Cell[4][4];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard()
    {
        return board;
    }


    public String toString()
    {
        String s = "";
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                s += board[i][j].toString() + " ";
            }
            s += "\n";
        }
        return s;
    }

    public void spawn()
    {
        boolean empty = true;
        while ( empty )
        {
            int row = (int)( Math.random() * 4 );
            int col = (int)( Math.random() * 4 );
            double x = Math.random();
            if ( board[row][col].getValue() == 0 )
            {
                if ( x < 0.2 )
                {
                    board[row][col] = new Cell( 4 );
                    empty = false;
                }
                else
                {
                    board[row][col] = new Cell( 2 );
                    empty = false;
                }
            }

        }

    }
