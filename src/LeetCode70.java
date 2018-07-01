public class LeetCode70 {

    public static void main(String[] args) {

        int result = climbStairs(3);
        System.out.println(result);

    }

    //记忆性搜索
    //int可能会溢出
    private static int [] array;

    public static int calway(int n){

        if(n==1)
            return 1;

        //1,1 和 2
        if(n==2)
            return 2;

        if(array[n]==0)
            array[n]=calway(n-1)+calway(n-2);

        return array[n];

    }

    public static int climbStairs(int n) {

        array = new int[n+1];

        //那0级楼梯应该是多少种？
        return calway(n);

    }



}
