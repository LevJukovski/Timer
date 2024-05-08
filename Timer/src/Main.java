import java.awt.*;
import java.util.Scanner;

public class Main {
    static String timeString = "00:00:00";

    public static void main(String[] args) throws InterruptedException {
        JFrameUsage.setFrame();
        String timeUnit = chooseTimeUnit();
        int time = setTime(timeUnit);

        while (time > 0) {
            timeString = "";
            int hours = time / 3600;
            int minutes = (time % 3600) / 60;
            int seconds = time % 60;

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
            JFrameUsage.label.setText(timeString);
            Thread.sleep(999);
            time--;
        }
        JFrameUsage.label.setText("TIME'S UP!");
        JFrameUsage.label.setFont(new Font(JFrameUsage.label.getFont().getName(), Font.BOLD, 32));

        Music.playMusic();
    }

    private static String chooseTimeUnit() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Would you like to enter the time in seconds, minutes, or hours?");
            System.out.println("press 'S' for seconds, 'M' for minutes or 'H' for hours: ");
            String timeUnitAttempt = scanner.next();
            if(timeUnitAttempt.equals("S") || timeUnitAttempt.equals("M") || timeUnitAttempt.equals("H") ||
                    timeUnitAttempt.equals("s") || timeUnitAttempt.equals("m") || timeUnitAttempt.equals("h")) {
                return timeUnitAttempt.toUpperCase();
            }
        }
    }

    private static int setTime(String timeUnit) {
        if(timeUnit.equals("S")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many seconds? ");
            return scanner.nextInt();
        } else if (timeUnit.equals("M")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many minutes? ");
            return 60 * scanner.nextInt();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many hours? ");
            return 3600 * scanner.nextInt();
        }
    }
}