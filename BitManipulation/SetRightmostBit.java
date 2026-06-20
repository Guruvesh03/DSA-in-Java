package BitManipulation;

import java.util.*;

public class SetRightmostBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.print("\nThe number after changing the rightmost bit of " + number + " is " + setRightmostBit(number));
    }

    public static int setRightmostBit(int number) {
        return (number | number + 1);
    }
}