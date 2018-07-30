public class LeetCode53 {

    public static void main(String[] args) {
        int a [] ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {

        int max = nums[0];

        for(int i=1,len=nums.length;i<len;i++){

            int last = nums[i-1];
            int current = nums[i];

            //如果当前是正数，肯定加上去会使子序列变大啊！
            if(current>=0){

                //如果前面小于0，那就是给自己拖后腿的，还不如以自己开头
                if(last<0){

                }else{
                    //如果前面大于0，毫无疑问要加上自己
                    nums[i] = last+current;
                }

                //判断此时的自己是不是当前最大
                if(nums[i]>max)
                    max = nums[i];


            }else{

                //如果小于0,无论如何，都会减少当前序列的最大值了，但是可能后头有更大的值

                //如果前面小于0，那就是给自己拖后腿的，还不如以自己开头
                if(last<0){

                }else{
                    //如果前面大于0，毫无疑问要加上自己
                    nums[i] = last+current;
                }

                //负数其实也要判断，因为有可能一直都是负数，那么最大的那个负数就是最大值了
                if(nums[i]>max)
                    max = nums[i];

            }


        }


        //其实可以看到无论当前大于0还是小于0，都是一样的操作，懒得改了

        return max;

    }

}
