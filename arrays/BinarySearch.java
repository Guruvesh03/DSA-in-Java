package arrays;
import java.util.*;

public class BinarySearch {
    public static int search(int[] arr, int num) {
        int start = 0;//storing the index
        int end = (arr.length) - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num == arr[mid]) {
                return mid;
            }
            if (num > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want ot search:");
        int num = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int result = search(arr, num);
        if (result == -1) {
            System.out.println("Number not found.");
        } else {
            System.out.println("Number found at index: " + result);
        }

    }
}
