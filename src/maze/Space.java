package maze;

/**
 * @author Zach Cotter
 */

/**
 * This class represents a space within a maze represented by a grid.
 * Extensions of this class represent more specific types of spaces.
 */
public abstract class Space {
    protected int x;
    protected int y;

    /**
     * Creates a new Space
     * @param xLoc x coordinate of space
     * @param yLoc y coordinate of space
     */
    public Space(int xLoc, int yLoc) {
        x = xLoc;
        y = yLoc;
    }

    /**
     * Accesses the x coordinate of this space.
     * @return integer value of x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Accesses the y coordinate of this space.
     * @return integer value of y coordinate.
     */
    public int getY() {
        return y;
    }
}
