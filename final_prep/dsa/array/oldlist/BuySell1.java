package final_prep.dsa.array.oldlist;

/*
121. Best Time to Buy and Sell Stock
 */
public class BuySell1 {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit= 0;
        for(int i=0;i<prices.length;i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(prices[i], minPrice);
        }

        return maxProfit;
    }
}
