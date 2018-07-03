public class LeetCode343 {

    private int memo[];

    public int integerBreak(int n) {

        memo = new int[n+1];

        //基础问题 1 的值对应什么？ 1 还是不要遍历了，memo【1】没法填。。。
        memo[2]=1;

        //对于3-n的每个值，填memo数组，对应的是该值的解
        for(int i=3;i<=n;i++){

            int max = 0;


            //因为不遍历1，所以j要到i-1之前就停止
            for(int j=1;j<i-1;j++){

                //计算j*（i-j）
                int temp1 = j*(i-j);
                int temp2 = j*memo[i-j];

                //因为memo【n】不一定比n大，比如2和3
                //memo【n】是n分割乘积的最大值，也就是别的组合里面最大值
                int tempMax = temp1;
                if(temp2>tempMax)
                    tempMax=temp2;

                if(tempMax>max)
                    max=tempMax;

            }

            memo[i]=max;

        }

        return memo[n];


    }

}
