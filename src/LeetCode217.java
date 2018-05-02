import java.util.HashSet;

public class LeetCode217 {

    public boolean containsDuplicate(int[] nums){

        //查找
        //重复
        //这两个词肯定是用set

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){

            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }

        }

        return false;

    }

}
