import java.util.*;

public class CopounNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The size of the array: ");
        int n = sc.nextInt();
        sc.nextLine();

        HashSet<Integer> couponSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter  the Coupon Number: ");
            couponSet.add(sc.nextInt());
            sc.nextLine();
        }

        System.out.println("Random number needed to generate the coupon number: " + noOfRandomNumbers(couponSet));
        sc.close();
    }

    public static int noOfRandomNumbers(HashSet<Integer> coupons) {
        Random random = new Random();
        int res = 0;
        while (!coupons.isEmpty()) {
            int number = random.nextInt(Integer.MAX_VALUE);
            if (coupons.contains(number))
                coupons.remove(number);

            res++;
        }
        return res;
    }
}

