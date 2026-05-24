package arrays;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] arr = {1, -2, -3, -4, -5, -9, -8};
        maxsubarraysum(arr);
    }

    public static void maxsubarraysum(int[] arr) {
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(arr[i], (sum + arr[i]));
            maxsum = Math.max(sum, maxsum);
        }
        System.out.println("The maximum sum of the sub array is: " + maxsum);


//        int smallestnum = Integer.MIN_VALUE;
//        boolean flag = false;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < 0) {
//                if (arr[i] > smallestnum) smallestnum = arr[i];
//                flag = true;
//            } else {
//                flag = false;
//                break;
//            }
//        }
//
//        if (flag == false) {
//            for (int i = 0; i < arr.length; i++) {
//                sum += arr[i];
//                if (sum < 0) sum = 0;
//                maxsum = Math.max(sum, maxsum);
//            }
//            return maxsum;
//        } else return smallestnum;
    }
}
