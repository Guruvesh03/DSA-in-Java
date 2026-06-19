package BitManipulation;

import java.util.*;

public class ClearKthBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = sc.nextInt();
        System.out.println("Enter the bitNumber:");
        int bitNumber = sc.nextInt();
        System.out.println("The number after clearing the " + bitNumber + "th bit of " + number + " is " + clearKthBit(number, bitNumber));

    }

    public static int clearKthBit(int number, int bitNumber) {
        int bitMask = 1 << bitNumber;
        return (number & (~bitMask));

    }
}
