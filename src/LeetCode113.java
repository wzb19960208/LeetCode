import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        /**
         *
         * 如果到达了叶子结点，符合的才返回自己。
         * 否则返回[]
         *
         * 看看子树有没有sum-val即可
         */


        /**
         * 输入[] 1
         * 预期[]
         */
        if(root==null){
            return new ArrayList<>();
        }


        if(root.left==null&&root.right==null){

            List<List<Integer>> list = new ArrayList<>();

            if(root.val==sum){
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                list.add(temp);
                return list;
            }else{
                return list;
            }

        }

        /**
         *
         * 不是叶子结点
         */

        List<List<Integer>> left = pathSum(root.left,sum-root.val);
        List<List<Integer>> right = pathSum(root.right,sum-root.val);

        List<List<Integer>> result = new ArrayList<>();

        if(left!=null){

            int len = left.size();

            for (int i=0;i<len;i++){

                List<Integer> temp = left.get(i);

                List<Integer> cur = new ArrayList<>();

                cur.add(root.val);

                int ltemp = temp.size();

                for(int k=0;k<ltemp;k++){
                    cur.add(temp.get(k));
                }

                result.add(cur);

            }

        }

        if(right!=null){

            int len = right.size();

            for (int i=0;i<len;i++){

                List<Integer> temp = right.get(i);

                List<Integer> cur = new ArrayList<>();

                cur.add(root.val);

                int rtemp = temp.size();

                for(int k=0;k<rtemp;k++){
                    cur.add(temp.get(k));
                }

                result.add(cur);

            }

        }

        return result;



    }

}
