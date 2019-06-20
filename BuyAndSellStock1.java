public class BuyAndSellStock1 {


//    public static int maxProfit(int[] prices) {
//
//        int n = prices.length;
//
//        int max = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = i+1; j < n; j++){
//                if (prices[j] - prices[i] >0 && prices[j]-prices[i]> max)
//                    max = prices[j] - prices[i];
//            }
//        }
//
//        return max;
//    }

    public static int maxProfit(int[] prices) {

        int n = prices.length;

        int minPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxprofit)
                maxprofit = prices[i] - minPrice;
        }

        return maxprofit;
    }

    public static void main(String args[]) {

    }
}
