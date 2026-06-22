package BitManipulation;

import java.util.*;

public class UpdateKthBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.print("\nEnter the bit number: ");
        int bitnum = sc.nextInt();
        System.out.print("\nEnter the bit you want to update to: ");
        int bit = sc.nextInt();
        System.out.print("\nThe number after updating the bit is: " + updateKthBit(number, bitnum, bit));
    }

    public static int updateKthBit(int number, int bitnum, int bit) {
        //clear the bit
        // for clearing we use inverse method
        number = number & ~(1 << bitnum);
        number = number | (bit << bitnum);

        return number;

    }
}