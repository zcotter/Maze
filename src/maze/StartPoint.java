package maze;

/**
 * @author Zach Cotter
 */

/**
 * This class represents the Starting Point of a maze.
 * The starting point marks the spot that the navigator begins at.
 */
public class StartPoint extends Space {
    
    /**
     * Creates a new StartPoint
     * @param xLoc x coordinate of this space
     * @param yLoc y coordinate of this space
     */
    public StartPoint(int xLoc, int yLoc) {
        super(xLoc, yLoc);
    }
}