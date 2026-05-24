package arrays;

import java.util.*;

public class LargestSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how among how much elements you want to find the largest:");
        int n = sc.nextInt();
        int largest[] = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            largest[i] = sc.nextInt();
        }
        int large = largest[0];
        // also we can write int largest= Integer.MIN_VALUE (it stores -infinity) and .MAX_VALUE +infinity
        int smallest = largest[0];
        for (int i = 0; i < largest.length; i++) {
            if (largest[i] > large) {
                large = largest[i];
            }
            if (largest[i] < smallest) {
                smallest = largest[i];
            }
        }
        System.out.println("The smallest number in the array is:" + smallest);
        System.out.println("The largest number in the array is:" + large);
    }
}
