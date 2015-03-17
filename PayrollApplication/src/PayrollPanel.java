
import java.awt.*;
import javax.swing.*;

/**
 * The PayrollPanel class allows the user to input hourly wage and hours worked.
 */
public class PayrollPanel extends JPanel {

    public static JTextField wageTextField; // Text field for hourly wage.
    public static JTextField hoursTextField; // Text field for hours worked.

    // these variables are needed for the 
    // conversion from string to double.
    public static double hourlyWage;
    public static double hoursWorked;

    /**
     * Constructor
     */
    public PayrollPanel() {

        // Create a GridLayout manager with
        // two rows and one column.
        setLayout(new GridLayout(2, 1));

        // Create text fields for hourly wage and hours worked.
        wageTextField = new JTextField(10);
        hoursTextField = new JTextField(10);

        // Create labels for hourly wage and hours worked.
        JLabel messageLabelWage = new JLabel("Hourly Wage");
        JLabel messageLabelHours = new JLabel("Hours Worked");

        // Create panels for hourly wage and hours worked.
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        // Add the labels to the panels.
        panel1.add(messageLabelWage);
        panel2.add(messageLabelHours);

        // Add the text fields to the panels.
        panel1.add(wageTextField);
        panel2.add(hoursTextField);

        // Add a border around the panel.
        setBorder(BorderFactory.createTitledBorder("Pay Input"));

        // Add the panels to the content pane.
        add(panel1); // Row 1.
        add(panel2); // Row 2. 
    }

    /**
     * The getCompensation method converts the text string to double and returns
     * the employee's total compensation with applicable overtime pay.
     */
    public static double getCompensation() {

        String str; // Conversion variable
        double compensation; // Return variable
        double overtime; // Applicable overtime

        // Convert hours worked and hourly wage to double.
        str = wageTextField.getText();
        hourlyWage = Double.parseDouble(str);
        str = hoursTextField.getText();
        hoursWorked = Double.parseDouble(str);

        // Test for overtime.
        if (hoursWorked > 40) {
            overtime = hoursWorked - 40;
            compensation = overtime * (hourlyWage * 1.5)
                    + (40 * hourlyWage);
        } else {
            compensation = hourlyWage * hoursWorked;
        }

        // Return compensation.
        return compensation;
    }
}
