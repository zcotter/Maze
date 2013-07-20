package maze;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JPanel;

/**
 * A Panel for representing a Grid in the GUI
 * @author Zach Cotter
 */
public class MazePanel extends JPanel {

    private int xLength;
    private int yLength;
    private Color[][] maze;
    private static final int SIZE = 500;
    private int cellSize;

    /**
     * Creates a new panel in which the user can create the maze
     * @param xLength X dimension of the maze
     * @param yLength Y dimension of the maze
     */
    public MazePanel(int xLength,
                     int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.setSize(SIZE,
                     SIZE);
        cellSize = SIZE / xLength;
        buildArray();
        this.setOpaque(true);
        this.addMouseListener(new MazeFrameMouseListener());
    }

    /**
     * Creates a new panel in which the given grid encoding is rendered.
     * @param encodedGrid 
     */
    public MazePanel(String encodedGrid) {
        String[] rows = encodedGrid.split("\n");
        xLength = Integer.parseInt(rows[0]);
        yLength = Integer.parseInt(rows[1]);
        this.setSize(SIZE,
                     SIZE);
        cellSize = SIZE / xLength;
        maze = new Color[xLength][yLength];
        rows = Arrays.copyOfRange(rows,
                                  2,
                                  rows.length);
        for (int i = 0; i < rows.length; i++) {
            String[] row = rows[i].split(",");
            for (int j = 0; j < row.length; j++) {
                maze[i][j] = decode(row[j]);
            }
        }
        this.setOpaque(true);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SIZE,
                             SIZE);
    }

    //decodes a single encoded space token
    private Color decode(String space) {
        if (space.equals("p")) {
            return Color.WHITE;
        }
        if (space.equals("w")) {
            return Color.BLACK;
        }
        if (space.equals("s")) {
            return Color.GREEN;
        }
        if (space.equals("e")) {
            return Color.RED;
        }
        else {
            throw new RuntimeException("Unknown Space");
        }
    }

    /**
     * Shows the given path in blue
     * @param route the route to display in the GUI
     */
    public void showRoute(Stack<Path> route) {
        Path p;
        while (!route.empty()) {
            p = route.pop();
            maze[p.getX()][p.getY()] = Color.CYAN;
        }
    }

    //initializes an empty gui representation of a maze.
    private void buildArray() {
        maze = new Color[xLength][yLength];
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                maze[x][y] = Color.BLACK;
            }
        }
        repaint();
    }

    /**
     * Paint the maze
     * @param g The Graphics to paint on.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                g.setColor(maze[x][y]);
                g.fillRect(x * cellSize,
                           y * cellSize,
                           cellSize,
                           cellSize);
            }
        }
    }

    /**
     * Returns a matrix of spaces typed according to their color in the 
     * GUI representation of the maze.
     * @return the spaces in this maze.
     */
    public Space[][] getSpaceArray() {
        Space[][] grid = new Space[xLength][yLength];
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                Color c = maze[x][y];
                if (c == Color.WHITE) {
                    grid[x][y] = new Path(x,
                                          y);
                }
                else if (c == Color.GREEN) {
                    grid[x][y] = new StartPoint(x,
                                                y);
                }
                else if (c == Color.RED) {
                    grid[x][y] = new EndPoint(x,
                                              y);
                }
                else {
                    grid[x][y] = new Wall(x,
                                          y);
                }
            }
        }

        return grid;
    }

    /**
     * Toggles GUI spaces: White -> Green -> Red -> Black -> White
     */
    private class MazeFrameMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int xLoc = e.getX() / cellSize;
            int yLoc = e.getY() / cellSize;
            Color c = maze[xLoc][yLoc];
            if (c == Color.BLACK) {
                maze[xLoc][yLoc] = Color.WHITE;
            }
            else if (c == Color.WHITE) {
                maze[xLoc][yLoc] = Color.GREEN;
            }
            else if (c == Color.GREEN) {
                maze[xLoc][yLoc] = Color.RED;
            }
            else if (c == Color.RED) {
                maze[xLoc][yLoc] = Color.BLACK;
            }
            repaint();
        }
    }
}
