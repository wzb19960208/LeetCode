public class LeetCode226 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    public TreeNode invertTree(TreeNode root) {

        /**
         *
         * 反转一颗二叉树
         * 等于
         * 交换两颗子树，再翻转他们
         *
         */

        if (root==null)
            return null;

        TreeNode temp = null;

        temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

}
