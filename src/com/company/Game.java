package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JPanel implements KeyListener
{
    Board game = new Board();

    static Game newGame = new Game();

    static JFrame frame = new JFrame("2048");

    static Color blue;

    String gameBoard = game.toString();

//Ustawienie GUI w odpowiednim rozmiarze oraz dodanie Key Listnera
    public static void setUpGUI()
    {
        frame.addKeyListener(newGame);
        frame.getContentPane().add(newGame);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setResizable(false);

    }
//Instrukcję pobierające informacje czy klawisze "wasd" lub "enter" są wciśnięte i wykonanie odpowiednich
//poleceń związanych z tym.
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w')
        {
            game.up();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 's')
        {
            game.down();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 'a')
        {
            game.left();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 'd')
        {
            game.right();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            game = new Board();
            game.spawn();
            game.spawn();
            frame.repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

//Instrukcja odpowiedzialna za rysowanie. W tym przyapdku: napisów w odpowiednim miejscu, koloru i wielkości plaszny pod komórkami.
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("Press 'Enter' to Start", 210, 315);
        g2.drawString("Use 'wasd' to move", 213, 335);
        g2.drawString( "2048 GAME", 235, 30 );
        g2.setColor(Color.darkGray);

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                drawTiles(g, game.board[i][j], j * 60 + 150, i * 60 + 60);
            }
        }

    }
//Instrukcja odpwiedzialna za rysowanie komórek
    public void drawTiles(Graphics g, Cell cell, int x, int y) {
        int tileValue = cell.getValue();
        int length = String.valueOf(tileValue).length();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.lightGray);
        g2.fillRoundRect(x, y, 50, 50, 5, 5);
        g2.setColor(Color.black);
//Pobiera informacje od odpowiednim kolorze komórki dla danej wartości oraz umieszcza ją odpowiednio.
        if (tileValue > 0) {
            g2.setColor(cell.getColor());
            g2.fillRoundRect(x, y, 50, 50, 5, 5);
            g2.setColor(Color.black);
            g.drawString("" + tileValue, x + 25 - 3 * length, y + 25);
        }
    }
}

