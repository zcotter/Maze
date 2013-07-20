package maze;


import java.util.Stack;

/**
 * @author Zach Cotter
 */
/**
 * This class creates a grid representing a maze and determines the best route through it.
 */
public class Grid {

    private Space[][] grid;
    private Stack<Path> route;
    private int xLength;
    private int yLength;
    private int currentX;
    private int currentY;
    
    /*
     * These correspond to the coordinate offset for a move
     * in each cardinal direction, [N, E, S, W] by index.
     */
    public static final int[] xMoves = {0,
                                        1,
                                        0,
                                        -1};
    public static final int[] yMoves = {1,
                                        0,
                                        -1,
                                        0};

    /**
     * Creates a new grid
     * @param maze Space[][] representing the maze and the type of each space.
     * @param xSize Integer value of width of maze
     * @param ySize Integer value of height of maze
     */
    public Grid(Space[][] maze,
                int xSize,
                int ySize) {
        xLength = xSize;
        yLength = ySize;
        init(maze);
    }

    /**
     * Creates a new grid
     * @param maze Space[][] representing the maze and the type of each space.
     */
    public Grid(Space[][] maze) {
        xLength = maze.length;
        yLength = maze[0].length;
        init(maze);
    }

    //initializes the grid
    private void init(Space[][] maze) {
        grid = maze;
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                if (grid[x][y] instanceof StartPoint) {
                    currentX = x;
                    currentY = y;
                }
            }
        }
        route = new Stack<Path>();
    }

    /*
   
     */
    /**
     * Encodes the maze as a String.
     * A Grid is encoded as a string in the following manner:
     * 1) Each space is transcribed from left to right, then top to bottom.
     * 2) Each column is separated by ','
     * 3) Each row is separated by '\n'
     * 4) Each space type is represented as follows:
     *      Path = 'p'
     *      Wall = 'w'
     *      StartPoint = 's'
     *      EndPoint = 'e'
     * 5) The first line of the encoding will display the xLength
     * 6) The second line of the encoding will display the yLength;
     * @return the encoded String representing the maze.
     */
    public String encode() {
        String encoding = xLength + "\\n" + yLength + "\\n";
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                encoding += encodingHelper(grid[x][y]) + ",";
            }
            encoding += "\\n";
        }
        return encoding;
    }

    //returns the appropriate character for each sub-type of space
    private String encodingHelper(Space space) {
        if (space instanceof Path) {
            return "p";
        }
        if (space instanceof Wall) {
            return "w";
        }
        if (space instanceof StartPoint) {
            return "s";
        }
        if (space instanceof EndPoint) {
            return "e";
        }
        else {
            throw new RuntimeException("Unknown Space");
        }
    }

    /**
     * Finds the shortest route from start to finish.
     */
    public void solve()
            throws InvalidMazeException {
        int start = 0;
        int end = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] instanceof StartPoint) {
                    start++;
                }
                if (grid[x][y] instanceof EndPoint) {
                    end++;
                }
            }
        }
        if (start != 1) {
            throw new InvalidStartPointException();
        }
        if (end != 1) {
            throw new InvalidEndPointException();
        }
        boolean next = true;
        while (next) {
            next = step();
        }
    }

    

    /**
     * Provides the route taken to reach the EndPoint
     * @return Stack\<\Path\> representing the route taken.
     */
    public Stack<Path> getRoute() {
        return route;
    }

    /**
     * Advances the current position of the navigator to the next Path space.
     * @return whether or not to keep stepping.
     */
    private boolean step() {
        boolean moveMade = false;
        for (int d = 0; d < 4; d++) {
            int nextX = currentX + xMoves[d];
            int nextY = currentY + yMoves[d];
            if (isValid(nextX,
                        nextY) && grid[nextX][nextY] instanceof Wall
                                  == false) {
                if (grid[nextX][nextY] instanceof EndPoint) {
                    grid[nextX][nextY] = new Path(nextX,
                                                  nextY);
                    ((Path) grid[nextX][nextY]).visit();
                    route.push((Path) grid[nextX][nextY]);
                    moveMade = true;
                    return false;
                }
                else if (grid[nextX][nextY] instanceof Path) {
                    if (((Path) grid[nextX][nextY]).isVisited() == false) {
                        currentX = nextX;
                        currentY = nextY;
                        ((Path) grid[currentX][currentY]).visit();
                        route.push((Path) grid[nextX][nextY]);
                        moveMade = true;
                        return true;
                    }
                }
            }
        }
        if (!moveMade) {
            backTrack();
        }
        return true;
    }

    /**
     * Called by step method if there are no more unvisited spots to move to.
     * The navigator retraces it's path until it reaches a point where it can move in a different direction.
     */
    private void backTrack() {
        while (!route.empty() && hasUnvisitedNeighbors(route.peek().getX(),
                                                       route.peek().getY()) == false) {
            route.pop();
            currentX = route.peek().getX();
            currentY = route.peek().getY();
        }
    }

    /**
     * Determines if a given Path has neighboring Paths that have not yet been visited.
     * @param x X coordinate of path
     * @param y Y coordinate of path
     * @return Whether or not the given path has unvisited neighbors.
     */
    private boolean hasUnvisitedNeighbors(int x,
                                          int y) {
        for (int d = 0; d < 4; d++) {
            int nextX = x + xMoves[d];
            int nextY = y + yMoves[d];
            if (isValid(nextX,
                        nextY) && grid[nextX][nextY] instanceof Path) {
                if (((Path) grid[nextX][nextY]).isVisited() == false) {
                    return true;
                }
            }
            else if (isValid(nextX,
                             nextY)
                     && grid[nextX][nextY] instanceof EndPoint) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if a given Space is contained in the maze.
     * @param x X coordinate of Space
     * @param y Y coordinate of Space
     * @return Whether or not the Space is valid.
     */
    private boolean isValid(int x,
                            int y) {
        if (x > -1 && x < xLength && y > -1 && y < yLength) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Exception to be thrown if a user created maze is unusable.
     * Possible exceptions:
     * There is no/+1 start point
     * There is no/+1 end point
     * They do not connect (StackOverflow)
     */
    public class InvalidMazeException extends RuntimeException {
    }

    public class InvalidStartPointException extends InvalidMazeException {

        @Override
        public String getMessage() {
            return "Please make exactly one startpoint (green) for the maze";
        }
    }

    public class InvalidEndPointException extends InvalidMazeException {

        @Override
        public String getMessage() {
            return "Please make exactly one endpoint (red) for the maze";
        }
    }
}
