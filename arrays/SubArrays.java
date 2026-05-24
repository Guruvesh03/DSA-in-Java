package arrays;

public class SubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        subarray(arr);
    }

    public static void subarray(int[] arr) {
        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("[ ");
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    System.out.print(arr[k] + " ");
                }
                System.out.print("]");
                System.out.print("   = " + sum);
                System.out.println();
                if (sum > largest) {
                    largest = sum;
                }
                if (sum <= smallest) {
                    smallest = sum;
                }

            }
            System.out.println();
        }
        System.out.println("Smallest sum of the array is: " + smallest);
        System.out.println("Largest sum of the array is: " + largest);

    }

}
