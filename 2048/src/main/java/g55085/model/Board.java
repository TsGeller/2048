package g55085.model;

/**
 * class board , she builds a game board
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class Board {

    /**
     * initial board of the game
     *
     * @return the board
     */
    static Board getInitialBoard() {
        Board board = new Board(new Brick[][]{
            {new Brick(0), new Brick(0), new Brick(0), new Brick(0)},
            {new Brick(0), new Brick(0), new Brick(0), new Brick(0)},
            {new Brick(0), new Brick(0), new Brick(0), new Brick(0)},
            {new Brick(0), new Brick(0), new Brick(0), new Brick(0)},});
        return board;
    }

    private final Brick[][] tab;

    /**
     * create a new board witth tab of Brick
     *
     * @param tab
     */
    Board(Brick[][] tab) {
        this.tab = tab;
    }

    /**
     * get the double tab of board
     *
     * @return the double tab
     */
    public Brick[][] getTab() {
        return tab;
    }

}
