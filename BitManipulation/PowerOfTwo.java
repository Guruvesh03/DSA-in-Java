package BitManipulation;

import java.util.*;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.print("Enter the value of the power: ");
        Scanner sc = new Scanner(System.in);
        int power = sc.nextInt();
        System.out.print("\nEnter the number you want to check if its power of two:");
        int number = sc.nextInt();

        System.out.println("2^" + power + " = " + findPower(power));
        System.out.println("Is the number power of two: " + checkPower(number));


    }

    public static int findPower(int power) {
        return 1 << power;
    }

    public static boolean checkPower(int number) {
        if ((number & (number - 1)) == 0) {
            return true;
        }
        return false;
    }
}
