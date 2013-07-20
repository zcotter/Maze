package maze;

/**
 * @author Zach Cotter
 */

/**
 * This class represents the path in a maze.
 * A path is any space that can be moved to besides the StartPoint and EndPoint.
 */
public class Path extends Space {
    private boolean visited;

    /**
     * Creates a new Path
     * @param xLoc x coordinate of path
     * @param yLoc y coordinate of path
     */
    public Path(int xLoc, int yLoc) {
        super(xLoc, yLoc);
        visited = false;
    }

    /**
     * Marks that this space has been passed over by the navigator.
     */
    public void visit() {
        visited = true;
    }

    /**
     * Determines whether or not this space has been passed over by the navigator.
     * @return
     */
    public boolean isVisited() {
        return visited;
    }
}