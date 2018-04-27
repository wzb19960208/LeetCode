import java.util.HashMap;

public class LeetCode1 {

    public static void main(String[] args) {

        int [] nums = {2,7,2,15};

        int target = 4;

        int [] result = twoSum(nums,target);

        for (int i:result
             ) {
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] nums, int target){

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int len = nums.length;

        int [] result = new int[2];

        //维护一个[0,i]的查找表
        //巧妙的解决了重复数字的覆盖问题
        for(int i=0;i<len;i++){

            int temp = target-nums[i];

            //对应的数在查找表能找到
            if(hashMap.get(temp)!=null){
                result[0]=i;
                result[1]=hashMap.get(temp);
                return result;
            }else{
                //如果找不到,添加进去
                hashMap.put(nums[i],i);
            }

        }

        return result;

    }

}
