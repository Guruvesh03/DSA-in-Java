package BitManipulation;

import java.util.*;

public class CheckKthBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number you want to check the bit: ");
        int num = sc.nextInt();
        System.out.print("\nEnter the bit you want to check: ");
        int bitnum = sc.nextInt();
        checkBit(num, bitnum);

    }

    public static void checkBit(int num, int bitnum) {
        int bitmask = 1 << bitnum;
        if ((num & bitmask) == 0) {
            System.out.println("The " + bitnum + "th bit is not set.");
        } else {
            System.out.println("The " + bitnum + "th bit is set.");

        }
    }
}
