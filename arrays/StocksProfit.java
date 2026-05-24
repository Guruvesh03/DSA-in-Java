package arrays;

// You are given an array prices where prices[i] is the price of a
// given stock on the ith day.
//Return the maximum profit you can achieve from this transaction.
// if you cannot achieve any profit, return zero
public class StocksProfit {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int maxprofit = profit(arr);
        System.out.println("The max profit that can be made is: " + maxprofit);
    }

    public static int profit(int[] arr) {
        int buyprice = arr[0];
        int maxprofit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > buyprice) {
                maxprofit = Math.max((arr[i] - buyprice), maxprofit);
                if (maxprofit < 0) {
                    maxprofit = 0;
                }
            } else {
                buyprice = arr[i];
            }
        }
        return maxprofit;
    }
}
