package arrays;

//Given a non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining
public class Rainwater {
    public static void main(String[] args) {
        int[] arr = {3, 2, 9, 0, 9, 5, 4, 9};
        rainwater(arr);
    }

    public static void rainwater(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {   // left auxillary array
            left[i] = Math.max(left[i - 1], arr[i]);

        }
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left[i] > arr[i] && right[i] > arr[i]) {
                sum = sum + (Math.min(left[i], right[i]) - arr[i]);
            }

        }
        System.out.println("The total water trapped is: " + sum);

    }
}
