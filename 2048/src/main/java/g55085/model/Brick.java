package g55085.model;

/**
 * Class Brick , use to create a brick
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class Brick {

    private int value;

    /**
     * create a new brick with value in param
     *
     * @param value the value in question
     */
    public Brick(int value) {
        this.value = value;
    }

    /**
     * simple getter of value
     *
     * @return the value of the brick
     */
    public int getValue() {
        return value;
    }

    /**
     * simple setter of value
     *
     * @param value update the value of the brick
     */
    public void setValue(int value) {
        this.value = value;
    }

}
