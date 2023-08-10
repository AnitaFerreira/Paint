package org.academiadecodigo.paint;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ArrayList;

public class Square implements KeyboardHandler {

    private Rectangle cub;
    private Keyboard keyboard;

    private static int cellSize = 25; //size of each cell in the grid

    private Rectangle paintedsquare; //the painted square

    private Rectangle clearsquare;

    private ArrayList<Rectangle> paintedCubs = new ArrayList<>(); //ñ tem capacidade


    public Square() {
        this.cub = new Rectangle(10, 10, 25, 25);
        this.cub.setColor(Color.PINK);
        cub.fill();
        keyboardInit(); //initialize keyboard events

    }

    //initialize keyboard events
    public void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        //define keyboard events for various keys
        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPress.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent upPress = new KeyboardEvent();
        upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPress.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent downPress = new KeyboardEvent();
        downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPress.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePress.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent cleanspace = new KeyboardEvent();
        cleanspace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        cleanspace.setKey(KeyboardEvent.KEY_C);


        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(upPress);
        keyboard.addEventListener(downPress);
        keyboard.addEventListener(spacePress);
        keyboard.addEventListener(cleanspace);

    }

    //handle key press events
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                System.out.println("moving right");
                if (cub.getX() < 500 - cellSize) {
                    cub.translate(25, 0);
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                System.out.println("moving left");
                if (cub.getX() > 0 + cellSize) {
                    cub.translate(-25, 0);
                }
                break;

            case KeyboardEvent.KEY_UP:
                System.out.println("moving up");
                if (cub.getY() > 0 + cellSize) {
                    cub.translate(0, -25);
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                System.out.println("moving down");
                if (cub.getY() < 500 - cellSize) {
                    cub.translate(0, 25);
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                //paint a black square and add it to the list
                System.out.println("painting");
                paintedsquare = new Rectangle(cub.getX(), cub.getY(), cellSize, cellSize);
                paintedsquare.setColor(Color.BLACK);
                paintedsquare.fill();
                paintedCubs.add(paintedsquare);
                break;

            case KeyboardEvent.KEY_C:
                //clear a painted square at the current position
                System.out.println("clear");
                for (Rectangle paintedsquare: paintedCubs) {
                    if (cub.getX() == paintedsquare.getX() && cub.getY() == paintedsquare.getY()) {
                        paintedsquare.delete();
                        paintedCubs.remove(paintedsquare);
                    }
                }
                break;
        }


        }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }

    }

