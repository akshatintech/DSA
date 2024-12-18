class Solution {
    public int[] finalPrices(int[] prices) {
        int left = 0;
        for(int i =0;i < prices.length-1 ;i++){
            int current_price = prices[i];
            for(int j = i+1 ;j < prices.length;j++){
                int discount = prices[j];
                if(discount <= current_price){
                    prices[i] = current_price-discount;
                    break;
                }
            }
        }

        return prices;
    }
}