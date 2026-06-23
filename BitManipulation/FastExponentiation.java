package BitManipulation;

import java.util.*;

public class FastExponentiation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.print("\nEnter the value of the power: ");
        int power = sc.nextInt();
        System.out.println("The answer is: " + fastPowerCalculator(number, power));
        System.out.println("The answer by optimized approach is: " + OptimizedApproach(number, power));

    }

    public static int fastPowerCalculator(int number, int power) {
        int mul = 1;
        while (power > 0) {
            if (power % 2 == 0) {
                number = number * number;
                power = power >> 1;
            } else {
                mul = mul * number;
                power--;
            }
        }
        return mul;
    }

    public static int OptimizedApproach(int number, int power) {
        int ans = 1;
        while (power > 0) {
            if ((power & 1) != 0) {
                ans = ans * number;

            }
            number = number * number;
            power = power >> 1;

        }
        return ans;
    }
}