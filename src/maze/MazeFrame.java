package maze;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Applet for the Maze GUI
 * @author Zach Cotter
 */
public class MazeFrame extends JApplet {

    private static final String SOLVE_TEXT = "Solve";
    private static final String NEW_TEXT = "New Maze";
    private static final String BUILD_TEXT = "Build";
    private static final String DIRECTIONS_TEXT = "Click grid to toggle: "
                                                  + "Green=Start, Red=End, "
                                                  + "White=Path, Black=Wall";
    private MazePanel panel;
    private ButtonPanel buttonPanel;
    private static final String[] presetMazes = {Resources.A,
                                                 Resources.B,
                                                 Resources.C,
                                                 Resources.D,
                                                 Resources.E,
                                                 Resources.F};
    private int counter;

    /**
     * Creates the Applet
     */
    public MazeFrame() {
        counter = 0;
        this.setLayout(new BorderLayout());
        buttonPanel = new ButtonPanel();
        this.add(buttonPanel,
                 BorderLayout.PAGE_END);
        initPanel();
        this.setVisible(true);
    }

    //intializes the panel
    private void initPanel() {
        try {
            this.remove(panel);
        }
        catch (Exception e) {//if the panel isn't there, don't worry about it
        }
        counter++;
        if (counter == presetMazes.length) {
            counter = 0;
        }
        panel = new MazePanel(presetMazes[counter]);
        this.add(panel,
                 BorderLayout.CENTER);

        panel.setVisible(true);
        panel.show();
    }
    
    private JButton solveButton;
    private JButton buildButton;

    /**
     * Panel containing the solve and build buttons
     */
    private class ButtonPanel extends JPanel {

        /**
         * Creates the panel
         */
        public ButtonPanel() {
            this.setLayout(new GridLayout(2,
                                          1));
            solveButton = new JButton(SOLVE_TEXT);
            buildButton = new JButton(BUILD_TEXT);
            solveButton.addActionListener(new SolveButtonActionListener());
            buildButton.addActionListener(new BuildButtonActionListener());
            this.add(solveButton);
            this.add(buildButton);
        }
    }

    //called when the build button is pressed
    private void buildActionPerformed() {
        boolean inputVerified = false;
        int selectedSize = 10;
        while (!inputVerified) {
            String input =
                   JOptionPane.showInputDialog(this,
                                               "Please choose a size for your maze",
                                               10);
            try {
                selectedSize = Integer.parseInt(input);
                if (selectedSize < 2) {
                    throw new NumberFormatException();
                }
                inputVerified = true;
            }
            catch (Exception e) {
                inputVerified = false;
                JOptionPane.showMessageDialog(this,
                                              "Please enter an integer larger than 2");
            }
        }
        remove(panel);

        panel = new MazePanel(selectedSize,
                              selectedSize);
        add(panel,
            BorderLayout.CENTER);
        panel.repaint();
        buildButton.setEnabled(false);
        buildButton.setText(DIRECTIONS_TEXT);
        //pack();
        panel.setVisible(true);
        panel.show();
        this.repaint();
        solveButton.setText(SOLVE_TEXT);
    }

    //called when the solve button is pressed.
    private void solveButtonActionPerformed() {
        buildButton.setText(BUILD_TEXT);
        buildButton.setEnabled(true);
        if (solveButton.getText().equals(SOLVE_TEXT)) {

            try {
                Space[][] data = panel.getSpaceArray();
                Grid maze = new Grid(data);
                System.out.println(maze.encode());
                maze.solve();
                panel.showRoute(maze.getRoute());
                panel.repaint();
                this.repaint();
                solveButton.setText(NEW_TEXT);
            }
            catch (Grid.InvalidMazeException ex) {
                JOptionPane.showMessageDialog(this,
                                              ex.getMessage());
            }

        }
        else if (solveButton.getText().equals(NEW_TEXT)) {
            initPanel();
            solveButton.setText(SOLVE_TEXT);
            panel.repaint();
            this.repaint();
        }
    }

    //action listener for the solve button
    private class SolveButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            solveButtonActionPerformed();
        }
    }

    //action listener for the build button.
    private class BuildButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            buildActionPerformed();
        }
    }
}
