import java.util.HashSet;

public class LeetCode219 {

    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k){

        HashSet<Integer> set = new HashSet<>();

        int l=0,r=0;

        //间隔是k 0~k间隔是k，0~k有k+1个数
        //r到了最后还没有找到重复的，肯定就没有了
        //l~r之间，维护一个查找表，后面的从里面查
        while (r<nums.length){

            //如果r在set里面找到了
            if(set.contains(nums[r])){
                return true;
            }else{

                //没找到

                //不用担心重复的问题，因为有重复早就返回了
                set.add(nums[r]);

                //满了，必须维护这个窗口，最大为k
                if(set.size()==k+1){
                    set.remove(nums[r-k]);
                }

                //必须减了元素再++
                r++;

            }


        }

        return false;

    }
}
