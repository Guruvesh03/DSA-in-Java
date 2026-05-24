package arrays;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4};
        int num = 4;
        int index = sorted(arr, num);
        System.out.println(index);
    }

    public static int sorted(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {

            mid = (start + end) / 2;
            if (arr[mid] == num) return mid;

            if (arr[start] <= arr[mid]) {
                if (arr[start] <= num && num < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < num && num <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }


        }
        return -1;
    }
}
