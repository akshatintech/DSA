class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int curr_profit =0;
        int profit =0;
        for(int i = 0;i< prices.length-1 ; i++){
            if(prices[i+1]> buyPrice){
                curr_profit = prices[i+1] - buyPrice;
                profit = Math.max(curr_profit , curr_profit+profit);
                buyPrice = prices[i+1];
            }
            if(prices[i+1] < buyPrice){
                buyPrice = prices[i+1];
            }
            

        }
        return profit;
        
    }
}