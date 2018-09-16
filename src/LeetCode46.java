import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public static void main(String[] args) {

        int [] a = {1,2,3};

        List<List<Integer>> res = permute(a);

        for(int i=0;i<res.size();i++){
            List<Integer> list = res.get(i);
            for(int j=0;j<list.size();j++){
                System.out.print(list.get(j));
            }
            System.out.println();
        }


    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            List<Integer> temp = new ArrayList<>();
            //对每个元素进行递归
            temp.add(nums[i]);
            digui(nums,temp,res);
        }

        return res;
    }


    //其实是每次对list和剩下的元素进行全排列
    public static void digui(int nums[],List<Integer> list,List<List<Integer>> res){

        //最后的递归，在这里收集数据，上一次的结果list长度和数组一样长了，就是说一次排列完成
        if(list.size()==nums.length){
            res.add(list);
            return;
        }

        for(int i=0;i<nums.length;i++){

            //如果这个数字前面没出现过的话，那么就加入当前数组中，进行下一次全排列
            if(!list.contains(nums[i])){
                List<Integer> temp = new ArrayList<>();
                for(int j=0;j<list.size();j++){
                    temp.add(list.get(j));
                }
                temp.add(nums[i]);
                digui(nums,temp,res);
            }

        }

        //循环跑完了就退出了

    }

}
