package BitManipulation;

import java.util.*;

public class FlipBitsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.print("\nEnter the Goal number: ");
        int goal = sc.nextInt();
        System.out.print("\nThe number of flipped bits are: " + findFlipBitsCount(number, goal));
    }

    public static int findFlipBitsCount(int number, int goal) {
        int newNumber = number ^ goal;
        int count = 0;
        while (newNumber > 0) {
            newNumber = newNumber & (newNumber - 1);
            count++;
        }
        return count;
    }
}