public class LeetCode104 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }

    }

    public int maxDepth(TreeNode root) {

        /**
         * 求一棵树的最大高度，等于他max{左子数,右子树}+1
         * 这个递归，就很流氓美学
         * 根本没解决问题，而是转移了问题
         * 太强了
         */

        if(root==null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left>right?left+1:right+1;


    }

}
