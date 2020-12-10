package g55085.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * class test
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class GameTest {

    Board board;

    public GameTest() {
    }

    /**
     * check if the board is filled
     */
    @Test
    public void testCheckBoardFillednop() {
        System.out.println("checkBoardFilled Nope");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        LevelStatus expResult = LevelStatus.IN_PROGRESS;
        LevelStatus result = instance.checkBoardFilled();
        assertEquals(expResult, result);

    }

    /**
     * check if the board is filled
     */
    @Test
    public void testCheckBoardFilledYes() {
        System.out.println("checkBoardFilled Yes");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[0][0].setValue(2);
        instance.getBoard().getTab()[0][1].setValue(4);
        instance.getBoard().getTab()[0][2].setValue(2);
        instance.getBoard().getTab()[0][3].setValue(4);
        instance.getBoard().getTab()[1][0].setValue(4);
        instance.getBoard().getTab()[1][1].setValue(2);
        instance.getBoard().getTab()[1][2].setValue(4);
        instance.getBoard().getTab()[1][3].setValue(2);
        instance.getBoard().getTab()[2][0].setValue(2);
        instance.getBoard().getTab()[2][1].setValue(4);
        instance.getBoard().getTab()[2][2].setValue(2);
        instance.getBoard().getTab()[2][3].setValue(4);
        instance.getBoard().getTab()[3][0].setValue(4);
        instance.getBoard().getTab()[3][1].setValue(2);
        instance.getBoard().getTab()[3][2].setValue(4);
        instance.getBoard().getTab()[3][3].setValue(2);
        LevelStatus result = instance.checkBoardFilled();
        assertEquals(LevelStatus.FAIL, result);

    }

    /**
     * check if the board is filled
     */
    @Test
    public void testCheckBoardFilledNo() {
        System.out.println("checkBoardFilled no ");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        int nb = 0;
        while (nb < 16) {
            instance.addBrick();
            nb++;
        }
        LevelStatus expResult = LevelStatus.IN_PROGRESS;
        LevelStatus result = instance.checkBoardFilled();
        assertEquals(expResult, result);

    }

    /**
     * check if the user has won
     */
    @Test
    public void testCheckWinNo() {
        System.out.println("checkWinNo");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.initialGame();
        assertEquals(LevelStatus.IN_PROGRESS, instance.getStatus());

    }

    /**
     * check if the user has won
     */
    @Test
    public void testCheckWinYes() {
        System.out.println("checkWinYes");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.initialGame();
        instance.getBoard().getTab()[0][0].setValue(2048);
        instance.checkWin();
        assertEquals(LevelStatus.WIN, instance.getStatus());

    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementBrickNo() {
        System.out.println("deplacementBrickNo");
        board = Board.getInitialBoard();
        Direction direction = Direction.EAST;
        Game instance = new Game(board);
        boolean expResult = false;
        boolean result = instance.deplacementBrick(direction);
        assertEquals(expResult, result);

    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementBrickYes() {
        System.out.println("deplacementBrickYes");
        board = Board.getInitialBoard();
        Direction direction = Direction.EAST;
        Game instance = new Game(board);
        instance.getBoard().getTab()[0][0].setValue(2048);
        boolean expResult = true;
        boolean result = instance.deplacementBrick(direction);
        assertEquals(expResult, result);

    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementUpYES() {
        /* */
        System.out.println("deplacementUp");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2048);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[1][2].setValue(2048);
        instance.deplacementUp();
        assertEquals(instance.equals(board1.getTab()), true);
    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementUpno() {
        /* */
        System.out.println("deplacementUpnop");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[0][2].setValue(2048);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[0][2].setValue(2048);
        instance.deplacementUp();
        assertEquals(instance.equals(board1.getTab()), true);
    }
    /**
     * addition of brick
     */
    @Test
    public void testAdditionUp() {
        System.out.println("AdditionUp");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2);
        instance.getBoard().getTab()[3][2].setValue(2);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[2][2].setValue(4);
        instance.additionUp();
        assertEquals(instance.equals(board1.getTab()), true);

    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementLowYES() {
        System.out.println("DeplacementLow");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2048);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[3][2].setValue(2048);
        instance.deplacementLow();
        assertEquals(instance.equals(board1.getTab()), true);
    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementLowNo() {
        System.out.println("DeplacementLowNo");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[3][2].setValue(2048);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[3][2].setValue(2048);
        instance.deplacementLow();
        assertEquals(instance.equals(board1.getTab()), true);
    }
    /**
     * addition of brick
     */
    @Test
    public void testAdditionLow() {
        System.out.println("AdditionLow");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2);
        instance.getBoard().getTab()[3][2].setValue(2);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[3][2].setValue(4);
        instance.additionLow();
        assertEquals(instance.equals(board1.getTab()), true);

    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementLeftYES() {
        System.out.println("DeplacementLeft");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2048);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[2][1].setValue(2048);
        instance.deplacementLeft();
        assertEquals(instance.equals(board1.getTab()), true);
    }
    /**
     * addition of brick
     */
    @Test
    public void testAdditionLeft() {
        System.out.println("AdditionLeft");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2);
        instance.getBoard().getTab()[2][1].setValue(2);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[2][1].setValue(4);
        instance.additionLeft();
        assertEquals(instance.equals(board1.getTab()), true);

    }

    /**
     * deplacement of brick
     */
    @Test
    public void testDeplacementRightYES() {
        System.out.println("DeplacementRight");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2048);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[2][3].setValue(2048);
        instance.deplacementRight();
        assertEquals(instance.equals(board1.getTab()), true);
    }
    /**
     * addition of brick
     */
    @Test
    public void testAdditionRight() {
        System.out.println("deplacementRight");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.getBoard().getTab()[2][2].setValue(2);
        instance.getBoard().getTab()[2][1].setValue(2);
        Board board1 = Board.getInitialBoard();
        board1.getTab()[2][2].setValue(4);
        instance.additionRight();
        assertEquals(instance.equals(board1.getTab()), true);

    }

    /**
     * check if there is a new brick on the board
     */
    @Test
    public void testAddBrick() {
        System.out.println("addBrick");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.addBrick();
        Brick[][] brick = board.getTab();
        boolean verite = false;

        for (Brick[] brick1 : brick) {
            for (int j = 0; j < brick.length; j++) {
                if (brick1[j].getValue() == 2 || brick1[j].getValue() == 4) {
                    verite = true;
                }
            }
        }
        assertEquals(verite, true);
    }

    /**
     * check if the score is exact
     *
     * @param score
     */
    @Test
    public void scoreBoard(int score) {
        System.out.println("get score");
        board = Board.getInitialBoard();
        Game instance = new Game(board);
        instance.initialGame();

        assertEquals(instance.getScore(), 0);
    }

}
