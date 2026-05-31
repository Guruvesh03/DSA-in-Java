package Strings;

import java.util.*;

public class LargestString {
    public static void main(String[] args) {
        System.out.print("Enter the strings you want to check:");
        Scanner sc = new Scanner(System.in);
        String[] fruits = new String[5];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = sc.next();
        }
        System.out.println();
        for (int i = 0; i < fruits.length; i++) {
            System.out.print(fruits[i] + " ");
        }
        largestCheck(fruits);

    }

    public static void largestCheck(String[] arr) {
        String largestString = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int result = largestString.compareToIgnoreCase(arr[i]);
            if (result < 0) {
                largestString = arr[i];
            }
        }
        System.out.println();
        System.out.println("Largest string :");
        System.out.println(largestString);
    }
}
