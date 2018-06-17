public class LeetCode112 {


    public boolean hasPathSum(TreeNode root, int sum) {

        /**
         *
         * 感觉应该先想递归过程
         * 再想递归终止条件
         * 因为要过程可行才行啊！
         *
         * 找一颗树有咩有sum，等于找它左右子树有咩有sum-val
         * 所以，当前结点肯定不能为null啦
         *
         */

        if(root==null)
            return false;

        /**
         * 必须是在叶子结点才行
         */
//        if(root.val==sum)
//            return true;
        if(root.left==null&&root.right==null){
            return root.val==sum;
        }

        boolean left = hasPathSum(root.left,sum - root.val);
        if(left)
            return true;

        boolean right = hasPathSum(root.right,sum - root.val);
        if (right)
            return true;

        return false;







    }

}
