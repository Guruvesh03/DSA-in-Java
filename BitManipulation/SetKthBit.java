package BitManipulation;

import java.util.*;

public class SetKthBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the Number you want to set bit of:");
        int number = sc.nextInt();
        System.out.print("\nEnter the bitnumber you want to set:");
        int bitNumber = sc.nextInt();
        setKthBit(number, bitNumber);
    }

    public static void setKthBit(int number, int bitNumber) {
        int bitMask = 1 << bitNumber;
        int newNumber = number | bitMask;
        System.out.println("The number after setting the " + bitNumber + "th bit of " + number + " is " + newNumber);
    }
}
