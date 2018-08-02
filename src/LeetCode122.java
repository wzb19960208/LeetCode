public class LeetCode122 {

    public int maxProfit(int[] prices) {

        int count = 0;

        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]<prices[i+1]){
                count += prices[i+1]-prices[i];
            }
        }

        return count;

    }

}
