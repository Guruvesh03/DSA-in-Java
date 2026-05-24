package arrays;

public class Triplets {
    public static void main(String[] args) {
        //int[] arr = {5, 4, 3, 2, 1, 0};
        //int[] arr = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3};
        //int[] arr = {-1, -1, -1, 2, 2};
        int[] arr = {-10, -5, -5, -2, -2, -2, 0, 0, 1, 2, 2, 3, 5, 5, 10};
        triplets(arr);
    }

    public static void triplets(int[] arr) {
        //sorting the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { // -2 because we will atleast need 3 numbers for a triplet so we spare last two numbers
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1; //left pointer
            int r = arr.length - 1; // right pointer
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    System.out.println("[" + arr[i] + "," + arr[l] + "," + arr[r] + "]");
                    while (l < r && arr[l] == arr[l + 1]) l++;
                    while (l < r && arr[r] == arr[r - 1]) r--;
                    l++;
                    r--;
                }
            }
        }
    }
}