package BitManipulation;

import java.util.*;

public class ToggleKthBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.print("\nEnter the bitNumber: ");
        int bitNumber = sc.nextInt();
        System.out.println("The number after toggling the " + bitNumber + "th bit of " + number + " is " + toggleKthBit(number, bitNumber));

    }

    public static int toggleKthBit(int number, int bitnumber) {
        int bitMask = 1 << bitnumber;
        return (number ^ bitMask);
    }
}
