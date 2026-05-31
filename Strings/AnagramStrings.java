package Strings;

import java.util.*;

public class AnagramStrings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the two strings you want to check:");
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(isAnagram(str1, str2));
    }

    public static boolean isAnagram(String str1, String str2) {

        int[] count = new int[26];
        str1.toLowerCase();
        str2.toLowerCase();

        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {

            count[(str1.charAt(i) - 'a')]++;
            count[(str2.charAt(i) - 'a')]--;

        }

        for (int i = 0; i < count.length; i++) {

            if (count[i] != 0) return false;
            
        }

        return true;
    }
}
