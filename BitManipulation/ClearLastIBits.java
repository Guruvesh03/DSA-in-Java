package BitManipulation;

import java.util.*;

public class ClearLastIBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.print("\nEnter the number of bits: ");
        int bits = sc.nextInt();
        System.out.print("\nThe number after clearing of " + bits + " of " + number + " is " + clearLastIBits(number, bits));
    }

    public static int clearLastIBits(int number, int bits) {
        int bitmask = ((-1) << bits);
        return (number & bitmask);
    }
}