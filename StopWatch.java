import java.util.Scanner;
public class StopWatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        System.out.println("StopWatch started");
        System.out.print("Stopwatch started. Press enter to stop");
        sc.nextLine();
        long endTime = System.currentTimeMillis();
        System.out.println("StopWatch has stopped....");
        System.out.println("Elapsed time is: " + (endTime - startTime) + " ms");
        long elapsedTime=endTime-startTime;
        System.out.println("Elapsed Time in formated way is : " + formatElapsedTime(elapsedTime));

        sc.close();
    }
    private static String formatElapsedTime(long elapsedTime) {
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        seconds %= 60;
        minutes %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

