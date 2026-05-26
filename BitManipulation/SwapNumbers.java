package BitManipulation;

import java.util.*;

public class SwapNumbers {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers you want to swap:");
        System.out.print("a = ");
        a = sc.nextInt();
        System.out.println();
        System.out.print("b = ");
        b = sc.nextInt();
        System.out.println();

        swapNumbers(a, b);

    }

    public static void swapNumbers(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
