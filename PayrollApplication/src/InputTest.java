
/**
 * The InputTest class is used to test the user input.
 */
public class InputTest {

    /**
     * This method ensures that the user's input consists of only numbers.
     */
    public static boolean isValidString(String test) {
        boolean goodSoFar = true; // Flag
        char[] array; // To hold the input as an array

        // Test for empty string.
        if (test.length() > 4 | test.length() < 1) {
            goodSoFar = false;
        }
        
        // Convert the string to a char array.
        array = test.toCharArray();

        // Analyze the characters.
        for (int i = 0; i < array.length; i++) {
            if (!Character.isDigit(array[i])) {
                goodSoFar = false;
            }
        }

        // Return the results
        return goodSoFar;
    }

    /**
     * This method ensures that the user's input 
     * is larger than 5 and less than  or equal to 150.
     */
    public static boolean isValidWage(String test) {
        boolean goodSoFar = true; // Flag

        try {
            int number = Integer.parseInt(test);

            // Is the number at least 6?
            if (number < 6) {
                goodSoFar = false;
            }
            // Is the number less than 150?
            if (number > 150) {
                goodSoFar = false;
            }
            // Catch exceptions.
        } catch (NumberFormatException e) {
        }

        // Return the results
        return goodSoFar;
    }

    /**
     * This method ensures that the user's input 
     * is at least 0 and less than or equal to 60.
     */
    public static boolean isValidHours(String test) {
        boolean goodSoFar = true; // Flag

        try {
            int number = Integer.parseInt(test);

            // Is the number at least 0?
            if (number < 0) {
                goodSoFar = false;
            }
            // Is the number less than 60?
            if (number > 60) {
                goodSoFar = false;
            }

            // Catch exceptions.
        } catch (NumberFormatException e) {
        }

        // Return the results
        return goodSoFar;
    }
}
