public class LeetCode121 {

    public int maxProfit(int[] prices) {

        int len = prices.length;

        //没有交易完成，最大利润是0
        int max = 0;

        //最后一个不用管
        for(int i=len-2;i>=0;i--){

            int cur = prices[i];
            int next = prices[i+1];

            //当前比后面区间的最大值要小，就是有钱赚
            if(cur<next){

                int temp = next-cur;
                if(temp>max)
                    max=temp;

                //更新当前的元素，将它的值，设为这个区间内最大值，也是就后面的元素
                prices[i]=next;

            }else if(cur>next){

                //如果当前比后面区间的大，就是没钱赚
                //因为后面是卖出的价格，比你今天买入的都低

                //不用更新当前区间最大值，因为最大值是它自己

            }else{

                //如果是等于
                //那么也没钱赚，最大值也是他自己

            }

        }

        return max;

    }

}
