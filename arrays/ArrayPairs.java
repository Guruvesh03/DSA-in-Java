package arrays;

public class ArrayPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};// total number of possible pairs formula= n(n-1)/2
        pairs(arr);
    }

    public static void pairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }
}
