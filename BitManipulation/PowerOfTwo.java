package BitManipulation;

import java.util.*;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println("Enter the value of the power: ");
        Scanner sc = new Scanner(System.in);
        int power = sc.nextInt();

        System.out.println("2^" + power + " = " + findPower(power));


    }

    public static int findPower(int power) {
        return 1 << power;
    }
}
