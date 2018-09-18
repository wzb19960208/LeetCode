public class LeetCode278 {
    public static void main(String[] args) {

    }

    public static boolean isBadVersion(int n){
        return false;
    }

    public int firstBadVersion(int n) {

        int low =1;
        int high = n;

        //[1,n]闭区间
        //当low=high的时候就是结果
        while (low<=high){

            //不会溢出
            int mid = low + (high-low)/2;

            if(isBadVersion(mid)){
                //这个mid不能去掉，因为有可能这个就是第一个错误的地方
                high = mid;
            }else {
                low = mid+1;
            }

        }

        return low;

    }
}
