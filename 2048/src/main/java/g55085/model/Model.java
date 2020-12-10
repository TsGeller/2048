/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55085.model;

import DesignPatern.Observer;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public interface Model {

    /**
     *
     * initializes the game
     */
    public void initialGame();

    /**
     * check if the board is filled
     *
     * @return
     */
    public LevelStatus checkBoardFilled();

    /**
     * check if the user has won
     */
    public void checkWin();

    /**
     *
     * make a brick move
     *
     * @param direction the direction
     * @return true if a move have been done
     */
    public boolean deplacementBrick(Direction direction);

    /**
     * move up
     *
     * @return true if there is a move false if not
     */
    public boolean deplacementUp();

    /**
     *
     * addition in the direction
     *
     * @return true if there is an addition false if not
     */
    public boolean additionUp();

    /**
     * move low
     *
     * @return true if there is a move false if not
     */
    public boolean deplacementLow();

    /**
     *
     * addition in the direction
     *
     * @return true if there is an addition false if not
     */
    public boolean additionLow();

    /**
     * move left
     *
     * @return true if there is a move false if not
     */
    public boolean deplacementLeft();

    /**
     *
     * addition in the direction
     *
     * @return true if there is an addition false if not
     */
    public boolean additionLeft();

    /**
     * move right
     *
     * @return true if there is a move false if not
     */
    public boolean deplacementRight();

    /**
     *
     * addition in the direction
     *
     * @return true if there is an addition false if not
     */
    public boolean additionRight();

    /**
     * get the board of the game
     *
     * @return
     */
    public Board getBoard();

    /**
     * add a brick to the board
     */
    public void addBrick();

    /**
     * get the status of the game
     *
     * @return the status
     */
    public LevelStatus getStatus();

    /**
     * simple setteur of board
     *
     * @param board
     */
    public void setBoard(Board board);

    /**
     * set the statu of the game
     *
     * @param status
     */
    public void setStatus(LevelStatus status);

    /**
     * add point to score of the game
     *
     * @param score
     */
    public void scoreBoard(int score);

    /**
     * get the score of the board
     *
     * @return socre of board
     */
    public int getScore();

    /**
     * return hascode 1
     *
     * @param brick
     * @return
     */
    public int hashCode(Brick[][] brick);

    /**
     * check the equality of 2 array
     *
     * @param brick
     * @return
     */
    public boolean equals(Brick[][] brick);

    public void addObserver(Observer observer);

    public void notifyObserver();

    public void notifyObserver(Object arg);
}
