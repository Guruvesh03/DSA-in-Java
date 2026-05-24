package arrays;

public class RepeateNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3};
        boolean checkrep = checkRepeat(arr);
        System.out.println("There are repeat values present in the array: " + checkrep);
    }

    public static boolean checkRepeat(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }
}
