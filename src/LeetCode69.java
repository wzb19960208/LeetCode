public class LeetCode69 {

    public static void main(String[] args) {

        System.out.println(mySqrt(2147395599));

    }

    public static int mySqrt(int x){

        //可以证明，在x>4的时候，他的平方根都是小于1/2x的

        if(x==0)
            return 0;

        if(x<4)
            return 1;

        if (x==4)
            return 2;

        //反正多一个也没事
        int right = x/2+1;

        //其实就是在1~1/2x里面，找平方不大于x的最后一个数

        int left=1;

        while (left<right){

            long temp = (left+right);
            int mid = (int)(temp/2);

            //这样会溢出。。。
            //mid*mid==x
            if(x/mid==mid)
                return mid;
            else if(x/mid>mid){
                left=mid+1;
            }else{
                right=mid;
            }

        }

        return right-1;

    }

}
