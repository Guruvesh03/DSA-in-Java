package arrays;

public class StockProfit {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};// these are the selling prices of the stocks
        profit(arr);
    }

    public static void profit(int[] arr) {
        int maxprofit = 0;
        int buyingprice = arr[0];

        for (int i = 1; i < arr.length; i++) {
            buyingprice = Math.min(arr[i], buyingprice);
            maxprofit = Math.max(maxprofit, (arr[i] - buyingprice));
//            if (maxprofit < 0) maxprofit = 0; since we are initializing the max profit=0, it will always be greater than
//            negative values because of the math.max function.
        }
        System.out.println(" The maximum profit that can be made is: " + maxprofit);

    }
}
