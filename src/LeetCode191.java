public class LeetCode191 {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(hammingWeight(12));
    }

    public static int hammingWeight(int n) {



            //2147483648 就是 在最大值的基础上+1  01111111111111111111111111111111111111 + 1 = 1000000000000000000000000
            //转换成int就是0
            //但由于开头是1，右移不会补0，而是补1，会导致永远不会结束，这个时候原数据不要动，将1移位即可。
            //1,10,100这样就能从右往左，而不改变原数据去比较了

            int i = 0;
            int test = 1;
            int count = 0;
            while(i<32){

                if((n&test)==test)
                    count++;

                test=test<<1;
                i++;

            }

            return count;




    }
}
