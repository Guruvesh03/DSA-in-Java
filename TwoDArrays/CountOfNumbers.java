package TwoDArrays;

import java.util.*;

public class CountOfNumbers {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {9, 9, 9, 9, 9, 9, 9}
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want the count of:");
        int num = sc.nextInt();
        int count = countofnum(matrix, num);
        System.out.println("The count of the number " + num + " in the matrix is " + count);
    }

    public static int countofnum(int[][] matrix, int num) {
        int count = 0;
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[i].length - 1; j++) {
                if (matrix[i][j] == num) {
                    count++;
                }
            }
        }
        return count;
    }
}
