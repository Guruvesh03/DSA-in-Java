package arrays;

public class RainwaterTraping {
    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 4, 1, 3, 4};
        int ans = rainwater(arr);
        System.out.println(ans);
    }

    public static int rainwater(int[] arr) {
        int[] leftarr = new int[arr.length];
        int[] rightarr = new int[arr.length];
        leftarr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftarr[i] = Math.max(arr[i], leftarr[i - 1]);
//            System.out.print("left array: " + leftarr[i] + " ");
        }
        rightarr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightarr[i] = Math.max(arr[i], rightarr[i + 1]);
//            System.out.print("right array: " + rightarr[i] + " ");
        }
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            int waterlevel = Math.min(leftarr[i], rightarr[i]);
            sum += waterlevel - arr[i];
        }
        return sum;

    }
}
