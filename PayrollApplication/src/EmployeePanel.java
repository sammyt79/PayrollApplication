
import java.awt.*;
import javax.swing.*;

/**
 * The EmployeePanel class allows the user to input first and last name.
 */
public class EmployeePanel extends JPanel {

    private static JTextField firstTextField; // Text field for first name.
    private static JTextField lastTextField; // Text field for last name.

    /**
     * Constructor
     */
    public EmployeePanel() {
        
        // Create a GridLayout manager with
        // two rows and one column.
        setLayout(new GridLayout(2, 1));

        // Create text fields for first and last name.
        firstTextField = new JTextField(10);
        lastTextField = new JTextField(10);

        // Create labels for first and last name.
        JLabel messageLabelFirst = new JLabel("First Name   ");
        JLabel messageLabelLast = new JLabel("Last Name   ");

        // Create panels for first and last name.
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        // Add the labels to the panels.
        panel1.add(messageLabelFirst);
        panel2.add(messageLabelLast);

        // Add the text fields to the panels.
        panel1.add(firstTextField);
        panel2.add(lastTextField);

        // Add a border around the panel.
        setBorder(BorderFactory.createTitledBorder("Employee Input"));

        // Add the panels to the content pane.
        add(panel1); // Row 1.
        add(panel2); // Row 2.
    }

    /**
     * The getEmployee method returns the employee's full name.
     */
    public static String getEmployee() {

        String firstName;
        String lastName;

        firstName = firstTextField.getText();

        lastName = lastTextField.getText();

        // Return the cost of the selected bagel.
        return firstName + " " + lastName;
    }
}
