package main.java.snake;

import snake.SnakePanel;

import javax.swing.*;
import java.awt.*;

public class Snake extends JFrame {

    private static final long serialVersionUID = 1L;
    private SnakePanel[][] pixel = new SnakePanel[40][40];
    private final Color worm = new Color(0, 180, 0);
    private char nextDirection = 'r';
    private char lastDirection;
    private int length;
    private int xsnake;
    private int ysnake;
    private volatile boolean running;

    public Snake() {
        this.setSize(400 + 6, 400 + 28);
        this.setResizable(false);
        this.setLayout(new GridLayout(40, 40));
        this.setTitle("Snake");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        length = 2;
        xsnake = 20;
        ysnake = 5;

        initPixels();

        makeWorm();
        makeApple();
        setVisible(true);
    }

    private void initPixels() {
        for (int j = 0; j < 40; j++) {
            for (int i = 0; i < 40; i++) {
                pixel[i][j] = new SnakePanel();
                if (i == 0 || i == 39 || j == 0 || j == 39) {
                    pixel[i][j].setBackground(Color.orange);
                } else {
                    pixel[i][j].setBackground(Color.black);
                }
                this.add(pixel[i][j]);
            }
        }
    }

    private void makeWorm() {
        pixel[19][5].setBackground(worm);
        pixel[19][5].setLength(1);
        pixel[20][5].setBackground(worm);
        pixel[20][5].setLength(2);
    }

    public void startMovement() {
        Thread thread = new Thread(new Running());
        thread.setDaemon(true);
        thread.start();
    }


    public void moveSnake() {
        if (nextDirection == 'u') {
            ysnake--;
        } else if (nextDirection == 'd') {
            ysnake++;
        } else if (nextDirection == 'r') {
            xsnake++;
        } else if (nextDirection == 'l') {
            xsnake--;
        }
        lastDirection = nextDirection;
        if (pixel[xsnake][ysnake].getLength() > 1 || xsnake == 0 || xsnake == 39 || ysnake == 0 || ysnake == 39) {
            collision();
        } else if (pixel[xsnake][ysnake].isApple()) {
            length++;
            pixel[xsnake][ysnake].setApple(false);
            makeApple();
        }
        pixel[xsnake][ysnake].setLength(length + 1);
    }

    public void collision() {
        System.err.println("Collision! Stopping main.java.snake");
        running = false;
    }

    public void iterateSnake() {
        for (int j = 1; j < 39; j++) {
            for (int i = 1; i < 39; i++) {
                pixel[i][j].iterate();
                if (pixel[i][j].getLength() > 0) {
                    pixel[i][j].setBackground(worm);
                } else if (pixel[i][j].isApple()) {
                    pixel[i][j].setBackground(Color.red);
                } else {
                    pixel[i][j].setBackground(Color.black);
                }
            }
        }
    }

    public void makeApple() {
        int x = (int) Math.round(Math.random() * 38) + 1;
        int y = (int) Math.round(Math.random() * 38) + 1;
        if (pixel[x][y].getLength() > 0) {
            makeApple();
        } else {
            pixel[x][y].setApple(true);
        }
    }

    public void up() {
        if (lastDirection != 'd') {
            nextDirection = 'u';
        }
    }

    public void down() {
        if (lastDirection != 'u') {
            nextDirection = 'd';
        }
    }

    public void left() {
        if (lastDirection != 'r') {
            nextDirection = 'l';
        }
    }

    public void right() {
        if (lastDirection != 'l') {
            nextDirection = 'r';
        }
    }

    public void start() {
        startMovement();
    }

    public class Running implements Runnable {

        public void run() {
            running = true;
            while (running) {
                try {
                    Thread.sleep(100);
                    moveSnake();
                    iterateSnake();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}