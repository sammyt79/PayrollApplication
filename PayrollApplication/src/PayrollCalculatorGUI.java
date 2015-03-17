
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * The PayrollCalculatorGUI class creates the GUI for the payroll application.
 */
public class PayrollCalculatorGUI extends JFrame {

    // The following variables will reference the
    // custom panel objects.
    private EmployeePanel employeess; // Employee panel
    private DepartmentPanel departments; // Department panel
    private PayrollPanel payrolls; // Payroll panel

    // The following variables will reference objects
    // needed to add the Calculate and Exit buttons.
    private JPanel buttonPanel; // To hold the buttons
    private JButton calcButton; // To calculate total compensation
    private JButton exitButton; // To exit the application

    /**
     * Constructor
     */
    public PayrollCalculatorGUI() {

        // Display a title.
        super("Payroll Application");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager for
        // the content pane.
        setLayout(new BorderLayout());

        // Create the custom panels.
        employeess = new EmployeePanel();
        departments = new DepartmentPanel();
        payrolls = new PayrollPanel();

        // Call the buildButtonPanel method to
        // create the button panel.
        buildButtonPanel();

        // Add the components to the content pane.
        add(employeess, BorderLayout.WEST);
        add(departments, BorderLayout.CENTER);
        add(payrolls, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        // Pack the contents of the window and display it.
        pack();
        setVisible(true);
    }

    /**
     * The buildButtonPanel method builds the button panel.
     */
    private void buildButtonPanel() {

        // Create a panel for the buttons.
        buttonPanel = new JPanel();

        // Create the buttons.
        calcButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        // Register the action listeners.
        calcButton.addActionListener(new CalcButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        // Add the buttons to the button panel.
        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);
    }

    /**
     * Private inner class that handles the event when the user clicks the
     * Calculate button.
     */
    private class CalcButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Create a DecimalFormat object to format
            // the total compensation as a dollar amount.
            DecimalFormat dollar = new DecimalFormat("$#,##0.00");

            if (DepartmentPanel.getDepartment() == null) {
                // Display an error message.
                JOptionPane.showMessageDialog(null,
                        "Please select a department",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                // Test hours worked for non numeric values.
            } else if (!InputTest.isValidString(PayrollPanel.hoursTextField.getText())) {
                // Display an error message.
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid number for \"Hours Worked\"",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                // Test hourly wage for non numeric values.
            } else if (!InputTest.isValidString(PayrollPanel.wageTextField.getText())) {
                // Display an error message.
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid number for \"Hourly Wage\"",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                // Hours worked in bounds check.
            } else if (!InputTest.isValidHours(PayrollPanel.hoursTextField.getText())) {
                // Display an error message.
                JOptionPane.showMessageDialog(null,
                        "The hours worked cannot be greater than 60.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                // Hourly wage in bounds check.
            } else if (!InputTest.isValidWage(PayrollPanel.wageTextField.getText())) {
                // Display an error message.
                JOptionPane.showMessageDialog(null,
                        "The hourly wage must be at least $6 per hour "
                        + "and cannot be more than $150 per hour.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                // Display to Output panel if no errors are present.
                OutputPanel.displayTextArea.append("Employee:\t\t"
                        + EmployeePanel.getEmployee() + "\n"
                        + "Department:\t\t"
                        + DepartmentPanel.getDepartment() + "\n"
                        + "Total Compensation:\t"
                        + dollar.format(PayrollPanel.getCompensation()) + "\n\n");
            }
        }
    }

    /**
     * Private inner class that handles the event when the user clicks the Exit
     * button.
     */
    private class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Exit the application.
            System.exit(0);
        }
    }
}
