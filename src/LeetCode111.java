public class LeetCode111 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }

    }

    public int minDepth(TreeNode root) {

        /**
         * 求一棵树的最小高度，等于他min{左子数,右子树}+1
         * 这个递归，就很流氓美学
         * 根本没解决问题，而是转移了问题
         * 太强了
         */

        /**
         *
         * 有坑
         * 叶子节点是指没有子节点的节点
         * [1,2]
         * 虽然1的右子树是空，但是1不是叶子结点，只有2是叶子结点，所以高度是2
         * 所以不能像之前那样递归，如果左子树是叶子结点，右子树是空，按照原来的会返回0的。
         */

        if(root==null){
            return 0;
        }

        /**
         * 如果当前是叶子结点
         */
        if(root.left==null&&root.right==null){
            return 1;
        }

        /**
         * 当两边都不是空的时候，才进行判断。否则只取一边的高度
         */
        else if(root.left!=null&&root.right==null){
            return minDepth(root.left)+1;
        }

        else if(root.left==null&&root.right!=null){
            return minDepth(root.right)+1;
        }

        else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return left < right ? left + 1 : right + 1;
        }

    }


}
