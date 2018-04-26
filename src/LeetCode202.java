import java.util.HashSet;

public class LeetCode202 {

    public static void main(String[] args) {

        System.out.println(isHappy(19));

    }

    /**
     * 主要的方法就是判断是否成死循环
     * 出现了一个总和，就把他放在map里
     * 如果map出现过这个数字，就是说成环了
     * 如果每次都出现不同的数字呢。。。
     *
     * 方法二
     * 如果出现4，就是死循环。。这个太玄学
     * @param n
     * @return
     */
    public static boolean isHappy(int n){

        if(n==1)
            return true;

        HashSet set = new HashSet();
        int sum=0;

        /*
        2-9,进入循环都ok
         */
        while(true){

            //计算他的sum
            sum = sum(n);


            if(sum==1)
                return true;

            if(set.contains(sum))
                return false;
            else{
                set.add(sum);
            }

            n=sum;

        }

    }

    private static int sum(int n){

        int sum = 0;
        int temp = 0;


        while(n>0){
            temp = n%10;
            sum+=temp*temp;
            n/=10;
        }

        return sum;

    }



}
