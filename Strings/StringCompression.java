package Strings;

import java.util.*;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string you want to compress:");
        String str = sc.nextLine();
        System.out.println(toCompress(str));
    }

    public static String toCompress(String str) {

        StringBuilder compressedstr = new StringBuilder();
        compressedstr.append(str.charAt(0));

        int count = 1;

        if (str.length() == 0) return "";

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else {
                if (count > 1) {
                    compressedstr.append(count);
                }
                count = 1;
                compressedstr.append(str.charAt(i));
            }
        }

        if (count > 1) {
            compressedstr.append(count);
        }
        
        return compressedstr.toString();
    }
}
