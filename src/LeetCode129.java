import java.util.ArrayList;
import java.util.List;

public class LeetCode129 {

    public int sumNumbers(TreeNode root) {

        if(root==null)
            return 0;

        /**
         * 返回字符串，最后再一次计算
         * 比int数组好很多
         */

        /**
         * null返回啥？
         */
        List<String> list = sum(root);

        int temp = 0;

        int len = list.size();

        for(int i=0;i<len;i++){
            temp+=Integer.parseInt(list.get(i));
        }

        return temp;



    }

    public static List<String> sum(TreeNode root){


        if(root==null)
            return null;

        if(root.left==null&&root.right==null){
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(root.val));
            return list;
        }

        List<String> left = sum(root.left);
        List<String> right = sum(root.right);

        List<String> result = new ArrayList<>();

        String cur = String.valueOf(root.val);

        if(left!=null){

            int len = left.size();

            for(int i =0;i<len;i++){
                result.add(cur+left.get(i));
            }

        }

        if(right!=null){

            int len = right.size();

            for(int i =0;i<len;i++){
                result.add(cur+right.get(i));
            }

        }

        return result;

    }

}
