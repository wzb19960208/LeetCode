public class LeetCode7 {

    public static void main(String[] args) {

        System.out.println(reverse(-123));

    }

    public static int reverse(int x){

        if(x==0)
            return 0;

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        //结果用long来存，肯定不会溢出了
        Long result = 0L;

        boolean flag = true;

        if(x<0){
            flag=false;
            x = -x;
        }

        while (x>0){

            int temp = x%10;
            result+=temp;
            result*=10;
            x/=10;

        }

        result/=10;

        if(flag==false)
            result=-result;

        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
            return 0;
        }



        return result.intValue();

    }

}
