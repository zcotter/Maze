package maze;

/**
 * @author Zach Cotter
 */

/**
 * This class represents the wall of a maze.
 * The walls are all the spaces inaccessible to whatever is navigating the maze.
 */
public class Wall extends Space {
    /**
     * Creates a new Wall
     * @param xLoc X coordinate of Wall in grid.
     * @param yLoc Y coordinate of Wall in grid.
     */
    public Wall(int xLoc, int yLoc) {
        super(xLoc, yLoc);
    }
}