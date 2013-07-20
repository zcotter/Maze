package maze;


/**
 * @author Zach Cotter
 */
/**
 * This class represents the exit of a maze.
 * This is the space within the grid that is navigated to.
 */
public class EndPoint extends Space {

    /**
     * Creates a new EndPoint
     * @param xLoc X coordinate of EndPoint in grid.
     * @param yLoc Y coordinate of EndPoint in grid.
     */
    public EndPoint(int xLoc,
                    int yLoc) {
        super(xLoc,
              yLoc);
    }
}