// Import necessary classes from java.awt package
import java.awt.*;
// Import Scanner class from java.util package
import java.util.Scanner;

// Main class declaration
public class Main {
    // Static variable to store the time as a string
    static String timeString = "00:00:00";

    // Main method declaration, throws InterruptedException in case of thread interruption
    public static void main(String[] args) throws InterruptedException {
        // Call static method setFrame() from JFrameUsage class to set up the frame
        JFrameUsage.setFrame();
        // Call chooseTimeUnit() method to get the time unit from user input
        String timeUnit = chooseTimeUnit();
        // Call setTime() method to get the time in seconds based on the chosen time unit
        int time = setTime(timeUnit);

        // Loop until time reaches 0
        while (time > 0) {
            // Reset timeString
            timeString = "";
            // Calculate hours, minutes, and seconds from the total time
            int hours = time / 3600;
            int minutes = (time % 3600) / 60;
            int seconds = time % 60;

            // Construct the timeString in the format "HH:MM:SS"
            if (hours >= 10) {
                timeString += hours + ":";
            } else {
                timeString += "0" +  hours + ":";
            }
            if (minutes >= 10) {
                timeString += minutes + ":";
            } else {
                timeString += "0" + minutes + ":";
            }
            if (seconds >= 10) {
                timeString += seconds;
            } else {
                timeString += "0" + seconds;
            }
            // Set the text of the label in the JFrame to the updated timeString
            JFrameUsage.label.setText(timeString);
            // Pause the execution for 999 milliseconds (approximately 1 second)
            Thread.sleep(999);
            // Decrement time by 1 second
            time--;
        }
        // Set the text of the label to "TIME'S UP!" after the loop ends
        JFrameUsage.label.setText("TIME'S UP!");
        // Set the font of the label to bold with a size of 32
        JFrameUsage.label.setFont(new Font(JFrameUsage.label.getFont().getName(), Font.BOLD, 32));

        // Call playMusic() method from Music class to play music
        Music.playMusic();
    }

    // Method to prompt the user to choose the time unit
    private static String chooseTimeUnit() {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Loop until a valid time unit is entered
        while(true) {
            // Prompt the user to enter the time unit
            System.out.println("Would you like to enter the time in seconds, minutes, or hours?");
            System.out.println("press 'S' for seconds, 'M' for minutes or 'H' for hours: ");
            // Read user input
            String timeUnitAttempt = scanner.next();
            // Check if the input is a valid time unit
            if(timeUnitAttempt.equals("S") || timeUnitAttempt.equals("M") || timeUnitAttempt.equals("H") ||
                    timeUnitAttempt.equals("s") || timeUnitAttempt.equals("m") || timeUnitAttempt.equals("h")) {
                // Return the valid time unit in uppercase
                return timeUnitAttempt.toUpperCase();
            }
        }
    }

    // Method to set the time based on the chosen time unit
    private static int setTime(String timeUnit) {
        // Check the chosen time unit and set the time accordingly
        if(timeUnit.equals("S")) {
            // If seconds, prompt the user for the number of seconds
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many seconds? ");
            // Return the input as the time in seconds
            return scanner.nextInt();
        } else if (timeUnit.equals("M")) {
            // If minutes, prompt the user for the number of minutes
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many minutes? ");
            // Return the input converted to seconds
            return 60 * scanner.nextInt();
        } else {
            // If hours, prompt the user for the number of hours
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many hours? ");
            // Return the input converted to seconds
            return 3600 * scanner.nextInt();
        }
    }
}