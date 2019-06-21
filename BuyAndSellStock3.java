public class BuyAndSellStock3 {

    public static int maxProfit(int[] prices) {

        int n = prices.length;

        if (prices == null || n == 0)
            return 0;

        int minPrice = prices[0];
        int[] dp = new int[prices.length];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {

            dp[i] = maxProfit;

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice >= maxProfit) {
                maxProfit = prices[i] - minPrice;
                dp[i] = maxProfit;
            }
        }


        int maxProfit2 = maxProfit;
        int secondMax = 0;
        int highest = prices[prices.length - 1];
        for (int i = n - 1; i >= 2; i--) {
            if (prices[i] > highest) {
                highest = prices[i];
            } else if (highest - prices[i] > secondMax) {
                secondMax = highest - prices[i];
                maxProfit2 = Math.max(maxProfit2, secondMax + dp[i - 1]);
            }
        }

        return maxProfit2;
    }

    public static void main(String args[]) {

        int[] arr = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};

        System.out.println(maxProfit(arr));


    }
}
