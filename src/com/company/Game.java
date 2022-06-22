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


    public static void setUpGUI()
    {
        frame.addKeyListener(newGame);
        frame.getContentPane().add(newGame);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP)
        {
            game.up();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            game.down();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            game.left();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT)
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

