
import java.awt.*;
import javax.swing.*;

/**
 * The DepartmentPanel class allows the user to select the employee's
 * department.
 */
public class DepartmentPanel extends JPanel {

    // Radion buttons for department.
    private static JRadioButton humanResources;
    private static JRadioButton informationTechnology;
    private static JRadioButton maintenance;
    private static JRadioButton production;
    private static JRadioButton warehouse;

    private static String department; // Return variable.

    // The following variable will reference a
    // ButtonGroup object to group the radio buttons.
    private ButtonGroup bg;

    /**
     * Constructor
     */
    public DepartmentPanel() {

        // Create a GridLayout manager with
        // three rows and two columns.
        setLayout(new GridLayout(3, 2));

        // Create the radio buttons.
        humanResources = new JRadioButton("Human Resources");
        informationTechnology = new JRadioButton("Information Technology");
        maintenance = new JRadioButton("Maintenance");
        production = new JRadioButton("Production");
        warehouse = new JRadioButton("Warehouse");

        // Group the radio buttons and add them to this panel.
        bg = new ButtonGroup();
        bg.add(humanResources);
        bg.add(informationTechnology);
        bg.add(maintenance);
        bg.add(production);
        bg.add(warehouse);

        // Add a border around the panel.
        setBorder(BorderFactory.createTitledBorder("Department"));

        // Add the radio buttons to this panel.
        add(humanResources);
        add(informationTechnology);
        add(maintenance);
        add(production);
        add(warehouse);
    }

    /**
     * The getDepartment method returns the selected department.
     */
    public static String getDepartment() {

        // Determine which department is selected.
        if (humanResources.isSelected()) {
            department = "Human Resources";
        }
        if (informationTechnology.isSelected()) {
            department = "Information Technology";
        }
        if (maintenance.isSelected()) {
            department = "Maintenance";
        }
        if (production.isSelected()) {
            department = "Production";
        }
        if (warehouse.isSelected()) {
            department = "Warehouse";
        }
        return department;
    }
}
