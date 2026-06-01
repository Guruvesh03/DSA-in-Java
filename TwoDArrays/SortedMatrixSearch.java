package TwoDArrays;

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        bruteforce(matrix);
        staircasesearch(matrix);

    }

    public static void bruteforce(int[][] matrix) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int count = 0;
        int key = 333;
        // Time complexity is O(n^2)
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                count++;
                if (key == matrix[i][j]) {
                    System.out.println("Element found at index " + "(" + i + "," + j + ")");
                    System.out.println("The number of searches for Brute force are: " + count);

                    return;
                }
            }
        }
    }

    public static boolean staircasesearch(int[][] matrix) {

        // we start from the top right corner because from that if we moved left the numbers are decreasing
        // and if we moved downwards the numbers are increasing so we can check if the key is larger or smaller
        // and move accordingly
        // In this search we eliminate a row or a column in every comparison, making it better than the binary search

        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int top = 0;
        int right = matrix[0].length - 1;
        int count = 0;
        int key = 333;
        while (top <= rows && right >= 0) {
            count++;
            if (key == matrix[top][right]) {
                System.out.println("The key found at index " + "(" + top + "," + right + ")");
                System.out.println("The number of comparisons done are: " + count);
                return true;
            } else if (key < matrix[top][right]) {
                right--;
            } else if (key > matrix[top][right]) {
                top++;
            }
        }
        System.out.println("The key is not found.");
        System.out.println("The number of comparisons is: " + count);
        return false;
    }
}
