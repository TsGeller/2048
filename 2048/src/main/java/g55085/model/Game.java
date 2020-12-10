package g55085.model;

import DesignPatern.Observable;
import DesignPatern.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * the class game , we need it to make the game
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class Game implements Observable, Model {

    public static int randomNumber() {
        int nombreAleatoire = 1 + (int) (Math.random() * ((10 - 1) + 1));
        return nombreAleatoire == 10 ? 4 : 2;
    }
    private List<Observer> observers;
    private Board board;
    private LevelStatus status = LevelStatus.NOT_STARTED;
    private int score;

    public Game() {
        observers = new ArrayList<>();
    }

    public Game(Board board) {
        this.board = board;
    }

    @Override
    public void initialGame() {
        this.board = Board.getInitialBoard();
        this.status = LevelStatus.IN_PROGRESS;
        this.score = 0;        
    }

    @Override
    public LevelStatus checkBoardFilled() {
        Brick[][] tableau = board.getTab();
        for (Brick[] tableau1 : tableau) {
            for (Brick tableau11 : tableau1) {
                if (tableau11.getValue() == 0) {
                    return this.status = LevelStatus.IN_PROGRESS;
                }
            }
        }
        for (Brick[] tableau1 : tableau) {
            for (int j = 0; j < tableau1.length - 1; j++) {
                if (tableau1[j].getValue() == tableau1[j + 1].getValue()) {
                    return this.status = LevelStatus.IN_PROGRESS;
                }
            }
        }
        int j = 0;
        while (j < tableau.length) {
            for (int i = 0; i < tableau.length - 1; i++) {
                if (tableau[i][j].getValue() == tableau[i + 1][j].getValue()) {
                    return this.status = LevelStatus.IN_PROGRESS;
                }
            }
            j++;
        }

        return this.status = LevelStatus.FAIL;

    }

    @Override
    public void checkWin() {
        Brick[][] tableau = board.getTab();
        for (Brick[] tableau1 : tableau) {
            for (Brick tableau11 : tableau1) {
                if (tableau11.getValue() == 2048) {
                    this.status = LevelStatus.WIN;
                }
            }
        }

    }

    @Override
    public boolean deplacementBrick(Direction direction) {
        boolean verite = false;
        switch (direction) {
            case NORTH:
                if (deplacementUp()) {
                    verite = true;
                }
                deplacementUp();
                deplacementUp();
                if (additionUp()) {
                    deplacementUp();
                    verite = true;
                }
                break;
            case SOUTH:
                if (deplacementLow()) {
                    verite = true;
                }
                deplacementLow();
                deplacementLow();
                if (additionLow()) {
                    deplacementLow();
                    verite = true;
                }

                break;
            case EAST:
                if (deplacementRight()) {
                    verite = true;
                }
                deplacementRight();
                deplacementRight();
                if (additionRight()) {
                    deplacementRight();
                    verite = true;
                }

                break;
            case WEST:
                if (deplacementLeft()) {
                    verite = true;
                }
                deplacementLeft();
                deplacementLeft();
                if (additionLeft()) {
                    deplacementLeft();
                    verite = true;
                }
                break;
            default:
                throw new IllegalArgumentException();
        }        
        notifyObserver(getBoard());        
        return verite;

    }

    @Override
    public boolean deplacementUp() {
        Brick[][] tableau = board.getTab();
        int j = 0;
        int i = 0;
        boolean verite = false;
        while (j < tableau.length) {
            for (i = 0; i < tableau.length; i++) {
                if (i != 0) {
                    if (tableau[i][j].getValue() != 0
                            && tableau[i - 1][j].getValue() == 0) {
                        tableau[i - 1][j].setValue(tableau[i][j].getValue());
                        tableau[i][j].setValue(0);
                        verite = true;
                    }

                }

            }
            j++;
        }
        return verite;
    }

    @Override
    public boolean additionUp() {
        Brick[][] tableau = board.getTab();
        int j = 0;
        int i = 0;
        boolean verite = false;
        while (j < tableau.length) {
            for (i = 0; i < tableau.length; i++) {
                if (i != 0) {
                    if (tableau[i][j].getValue() == tableau[i - 1][j].getValue()
                            && tableau[i][j].getValue() != 0) {
                        tableau[i - 1][j].setValue(tableau[i][j].getValue() * 2);
                        tableau[i][j].setValue(0);
                        scoreBoard(tableau[i - 1][j].getValue());
                        verite = true;
                    }

                }

            }
            j++;
        }
        return verite;
    }

    @Override
    public boolean deplacementLow() {
        Brick[][] tableau = board.getTab();
        int j = 0;
        int i = 0;
        boolean verite = false;
        while (j < tableau.length) {

            for (i = 3; i >= 0; i--) {
                if (i != 3) {
                    if (tableau[i][j].getValue() != 0
                            && tableau[i + 1][j].getValue() == 0) {
                        tableau[i + 1][j].setValue(tableau[i][j].getValue());
                        tableau[i][j].setValue(0);
                        verite = true;
                    }

                }

            }
            j++;

        }
        return verite;
    }

    @Override
    public boolean additionLow() {
        Brick[][] tableau = board.getTab();
        int j = 0;
        int i = 0;
        boolean verite = false;
        while (j < tableau.length) {
            for (i = 3; i >= 0; i--) {
                if (i != 3) {
                    if (tableau[i][j].getValue() == tableau[i + 1][j].getValue()
                            && tableau[i][j].getValue() != 0) {
                        tableau[i + 1][j].setValue(tableau[i][j].getValue() * 2);
                        scoreBoard(tableau[i + 1][j].getValue());
                        tableau[i][j].setValue(0);
                        verite = true;
                    }

                }

            }
            j++;
        }
        return verite;
    }

    @Override
    public boolean deplacementLeft() {
        Brick[][] tableau = board.getTab();
        int nb = 0;
        boolean verite = false;
        while (nb < 1) {
            for (Brick[] tableau1 : tableau) {
                for (int j = 0; j < tableau1.length; j++) {
                    if (j != 0) {
                        if (tableau1[j].getValue() != 0
                                && tableau1[j - 1].getValue() == 0) {
                            tableau1[j - 1].setValue(tableau1[j].getValue());
                            tableau1[j].setValue(0);
                            verite = true;
                        }
                    }
                }
            }
            nb++;
        }
        return verite;
    }

    @Override
    public boolean additionLeft() {
        Brick[][] tableau = board.getTab();
        boolean verite = false;
        for (Brick[] tableau1 : tableau) {
            for (int j = 0; j < tableau1.length; j++) {
                if (j != 0) {
                    if (tableau1[j].getValue() == tableau1[j - 1].getValue()
                            && tableau1[j].getValue() != 0) {
                        tableau1[j - 1].setValue(tableau1[j].getValue() * 2);
                        scoreBoard(tableau1[j - 1].getValue());
                        tableau1[j].setValue(0);
                        verite = true;
                    }
                }
            }
        }
        return verite;
    }

    @Override
    public boolean deplacementRight() {
        Brick[][] tableau = board.getTab();
        boolean verite = false;
        for (Brick[] tableau1 : tableau) {
            for (int j = 3; j >= 0; j--) {
                if (j != 3) {
                    if (tableau1[j].getValue() != 0
                            && tableau1[j + 1].getValue() == 0) {
                        tableau1[j + 1].setValue(tableau1[j].getValue());
                        tableau1[j].setValue(0);
                        verite = true;
                    }
                }
            }
        }

        return verite;
    }

    @Override
    public boolean additionRight() {
        Brick[][] tableau = board.getTab();
        boolean verite = false;
        for (Brick[] tableau1 : tableau) {
            for (int j = 3; j >= 0; j--) {
                if (j != 3) {
                    if (tableau1[j].getValue() == tableau1[j + 1].getValue()
                            && tableau1[j].getValue() != 0) {
                        tableau1[j + 1].setValue(tableau1[j].getValue() * 2);
                        tableau1[j].setValue(0);
                        scoreBoard(tableau1[j + 1].getValue());
                        verite = true;
                    }
                }
            }
        }

        return verite;
    }

    @Override
    public void addBrick() {
        int number = 0;
        int nbRandom = 1 + (int) (Math.random() * ((16 - 1) + 1));
        boolean find = false;
        while (!find) {
            for (int i = 0; i < board.getTab().length && !find; i++) {
                for (Brick item : board.getTab()[i]) {
                    if (item.getValue() == 0) {
                        if (number > nbRandom) {
                            item.setValue(randomNumber());
                            find = true;
                            break;
                        }
                    }
                    number++;
                }
            }
        }
        notifyObserver(getBoard());
    }

    @Override
    public void scoreBoard(int score) {
        this.score = this.score + score;
        //notifyObserver();

    }

    public List<Observer> getObserver() {
        return observers;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public LevelStatus getStatus() {
        return status;
    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public void setStatus(LevelStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode(Brick[][] brick) {
        return 1;
    }

    @Override
    public boolean equals(Brick[][] brick) {
        for (int i = 0; i < brick.length; i++) {
            for (int j = 0; j < brick.length; j++) {
                if (board.getTab()[i][j].getValue() != brick[i][j].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this, null);
        }

    }

    @Override
    public void notifyObserver(Object arg) {
        for (Observer observer : observers) {
            observer.update(this, arg);
        }
    }

}
