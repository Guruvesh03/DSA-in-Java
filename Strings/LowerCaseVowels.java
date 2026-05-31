package Strings;

import java.util.*;

public class LowerCaseVowels {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String str = sc.nextLine();
        countVowels(str);
    }

    public static void countVowels(String str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
            }
        }
        System.out.println("The number of lowercase vowels present in the string " + str + " is " + count);
    }


}
