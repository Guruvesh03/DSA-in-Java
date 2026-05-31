package Strings;

import java.util.*;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string you want to check for palindrome: ");
        String str = sc.next();
        System.out.println(ispalindorme(str));

    }

    public static boolean ispalindorme(String str) {
        for (int i = 0; i <= (str.length() - 1) / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
