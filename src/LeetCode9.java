public class LeetCode9 {

    public static void main(String[] args) {


        System.out.println(isPalindrome(1001));

    }

    public static boolean isPalindrome(int x) {

        //负数肯定不是
        if(x<0)
            return false;

        //个位数肯定是
        if(x>=0&&x<=9)
            return true;

        int num = x;
        int count = 0;

        while(num>0){
            num/=10;
            count++;
        }

        int des = 1;

        //计算获取最高位，需要除多少
        for(int i=1;i<count;i++){
            des*=10;
        }

        //只需比较到中间就好了
        int middle = count/2;
        //因为是0开始的，<即可

        //num是维护从最高位开始的数字的，所以num不变
        num=x;
        for(int i=0;i<middle;i++){

            //计算首位
            int high = (num/des)%10;

            //计算末尾
            int low = x%10;
            if(high!=low)
                return false;

            x/=10;
            //需要除10的次数减少了
            des/=10;


        }

        return true;


    }

}
