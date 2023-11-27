45import java.util.Scanner;

public class PerfectNumber {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (isPerfectNumber(number)) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.println(number + " is not a perfect number.");
        }
        scanner.close();
    }
    private static boolean isPerfectNumber(int num) {
        if (num <= 1) {
            return false; 
        }
        int sum = 1; 
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num; 
    }
}
