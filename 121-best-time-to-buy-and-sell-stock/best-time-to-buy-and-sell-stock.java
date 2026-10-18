class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int maxP=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy) buy=prices[i];
            else{
                int p=prices[i]-buy;
                maxP=Math.max(maxP,p);
            }
        }
        return maxP;
    }
}