public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {

        //[0,len)开区间
        int i=0,j=nums.length;

        //因为是前闭后开，i=j的时候，其实就是没有意义了
        while(i<j){

            int mid = (i+j)/2;
            if(nums[mid]==target)
                return mid;
            if(target<nums[mid])
                j=mid;//因为开区间，刚好没有取到mid
            else
                i=mid+1;//闭区间，为了不取到mid，只能+1

        }

        return j;

    }

}
