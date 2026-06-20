package BitManipulation;

import java.util.*;

public class CountSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        //System.out.print("\nThe number of set bits using brute force is: " + bruteforce(number));
        System.out.print("\nThe number of set bits using Brain Kernighan approach is: " + BrainKernighan(number));

    }

    public static int bruteforce(int number) {
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            if ((number & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static int BrainKernighan(int number) {
        int count = 0;
        while (number > 0) {
            number = number & (number - 1);
            count++;
        }
        return count;
    }
}