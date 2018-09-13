public class LeetCode231 {

    public boolean isPowerOfTwo(int n) {

        //2的幂次方，肯定不是负数
        //-2的幂次方才是正负数

        if(n<=0)
            return false;


        while(n!=1){
            if(n%2!=0){
                return false;
            }

            n /= 2;

        }

        return true;

    }

}
