
import java.awt.*;
import javax.swing.*; 

/**
 * The OutputPanel class displays the employee information and total
 * compensation.
 */
public class OutputPanel extends JFrame {

    JPanel displayPanel; // A panel to hold the display
    public static JTextArea displayTextArea; // Displays area

    public OutputPanel() {
        // Set the window title.
        setTitle("Payroll Viewer");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the screen size for panel placement
        GraphicsConfiguration gc = getGraphicsConfiguration();
        Rectangle bounds = gc.getBounds();

        // Set the Location and Activate
        Dimension size = getPreferredSize();
        setLocation((int) ((bounds.width / 4) - (size.getWidth() / 4)),
                (int) ((bounds.height / 3) - (size.getHeight() / 3)));

        // Build the Query Panel.
        buildDisplayPanel();

        // Add the panels to the content pane.
        add(displayPanel, BorderLayout.NORTH);

        // Pack and display.
        pack();
        setVisible(true);
    }

    /**
     * The buildDisplayPanel method builds the display panel.
     */
    private void buildDisplayPanel() {
        // Create a panel.
        displayPanel = new JPanel();

        // Create a text area, 15 rows by 30 columns.
        displayTextArea = new JTextArea(15, 30);

        // Turn line wrapping on.
        displayTextArea.setLineWrap(true);

        // Make the text area uneditable.
        displayTextArea.setEditable(false);

        // Add a scroll pane to the text area.
        JScrollPane qaScrollPane
                = new JScrollPane(displayTextArea);
        qaScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        qaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add the text area to the panel.
        displayPanel.add(qaScrollPane);
    }
}

