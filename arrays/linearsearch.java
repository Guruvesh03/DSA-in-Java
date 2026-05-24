package arrays;

public class linearsearch {
    public static int linear(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111, 22, 33, 44, 55, 66, 77, 88, 99,};
        int target = 9999;
        int check = linear(arr, target);
        if (check == -1) {
            System.out.println("Target element not found.");
        } else {
            System.out.println("Target element found.");
        }
    }
}