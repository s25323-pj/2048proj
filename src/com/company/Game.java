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
//Instrukcję pobierające informacje czy klawisze "wasd" oraz "enter" są wciśnięte i wykonanie odpowiednich
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

