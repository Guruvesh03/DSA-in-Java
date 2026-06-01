package TwoDArrays;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}//,
//                {13, 14, 15, 16}
        };
        diagonalsum(matrix);
    }

    public static void diagonalsum(int[][] matrix) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int sum = 0;

        // Brute force time complexity of O(n^2)
        System.out.print("BY BRUTE FORCE APPROACH: ");
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                // primary diagonal sum
                if (i == j) {
                    sum += matrix[i][j];
                } else if (i + j == row) {
                    sum += matrix[i][j];
                }

//                if (i + j == row && i != j) {
//                    sum += matrix[i][j];
//                }
            }
        }
        System.out.print(sum);
        System.out.println();

        //Optimized Approach time complexity of O(n)
        // for this problem, i==j is always necessary that is matrix is always for nxn.
        sum = 0;
        for (int i = 0; i <= row; i++) {
            sum += matrix[i][i];
            if (i != row - i) { // i != j j in this case is row-i
                sum += matrix[i][row - i];
            }
        }
        System.out.println("BY OPTIMIZED APPROACH: " + sum);
    }
}
