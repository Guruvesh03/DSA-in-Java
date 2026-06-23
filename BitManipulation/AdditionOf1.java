package BitManipulation;

import java.util.*;

public class AdditionOf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number: ");
        int number = sc.nextInt();
        System.out.println("The result is: " + addOne(number));
    }

    public static int addOne(int number) {
        return -(~number);
    }
}