/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import g55085.model.Direction;
import g55085.model.LevelStatus;
import g55085.model.Model;
import g55085.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import g55085.view.MessageToDisplay;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class Controller {

    private Model model;
    private MainView view;

    public Controller(Model model, MainView view) {
        this.model = model;
        this.view = view;
    }
    private final EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if (model.getStatus() == LevelStatus.IN_PROGRESS) {
                switch (event.getCode()) {
                    case UP:
                        if (model.deplacementBrick(Direction.NORTH)) {
                            model.addBrick();

                        } else {
                            view.getList().addStatus(MessageToDisplay.movementImpossible());
                        }
                        break;
                    case DOWN:
                        if (model.deplacementBrick(Direction.SOUTH)) {
                            model.addBrick();

                        } else {
                            view.getList().addStatus(MessageToDisplay.movementImpossible());
                        }
                        break;
                    case RIGHT:
                        if (model.deplacementBrick(Direction.EAST)) {
                            model.addBrick();

                        } else {
                            view.getList().addStatus(MessageToDisplay.movementImpossible());
                        }
                        break;
                    case LEFT:
                        if (model.deplacementBrick(Direction.WEST)) {
                            model.addBrick();

                        } else {
                            view.getList().addStatus(MessageToDisplay.movementImpossible());
                        }
                        break;
                }
                
                updateScore();
                statusGame();
            }
        }
    };

    /**
     * update the score of the game
     */
    public void updateScore() {
        view.getScore().setText(String.valueOf(model.getScore()));
    }

    /**
     * start the game
     */
    public void startGame() {
        model.initialGame();               
        addListener();
        view.addAction(this);
        model.addObserver(view);
        model.addBrick(); 

    }

    /**
     * check the status of the game
     */
    public void statusGame() {        
        model.checkWin();
        model.checkBoardFilled();
        if (model.getStatus() == LevelStatus.WIN) {
            view.getList().addStatus(MessageToDisplay.winGame());
        } else if (model.getStatus() == LevelStatus.FAIL) {
            view.getList().addStatus(MessageToDisplay.gameOver());
        }

    }

    /**
     * action of the button restart
     */
    public void buttonRestart() {
        model.initialGame();
        model.addBrick();
        view.getScore().setText(String.valueOf(model.getScore()));                
        view.getList().addStatus(MessageToDisplay.restartGame());

    }

    /**
     * add a listener to view
     */
    public void addListener() {
        view.addEventFilter(KeyEvent.KEY_PRESSED, keyListener);
    }

    /**
     * get the movement impossible
     *
     * @return return the sentence
     */
    
    

}
