import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {

        /**
         * 先想递归过程
         * 一个树返回的strnglist，是遍历他左右子树的返回数组前面加上val->
         */

        /**
         * 题目要求的，[]要返回[]
         */
        if(root==null)
            return new ArrayList<>();

        /**
         * 叶子结点把自己放进去就完事了
         */
        if(root.left==null&&root.right==null){
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(root.val));
            return list;
        }

        /**
         *
         * 处理左右孩子返回的东西OK了
         *
         */

        List<String> list = new ArrayList<>();
        String cur = String.valueOf(root.val);

        List<String> left = binaryTreePaths(root.left);

        if(left!=null){

            Iterator<String> iterator = left.iterator();

            while (iterator.hasNext()){
                list.add(cur+"->"+iterator.next());
            }

        }

        List<String> right = binaryTreePaths(root.right);

        if(right!=null){

            Iterator<String> iterator = right.iterator();

            while (iterator.hasNext()){
                list.add(cur+"->"+iterator.next());
            }

        }

        return list;

    }

}
