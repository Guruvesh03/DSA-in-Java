package BitManipulation;

import java.util.*;

public class ClearBitsInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.println("The number after clearing the bits is: " + clearBitsInRange(number, 2, 5));

    }

    public static int clearBitsInRange(int number, int leftindex, int rightindex) {
        int a = (~0) << rightindex + 1;
        int b = (1 << leftindex) - 1;
        int bitmask = a | b;

        return number & bitmask;
    }
}