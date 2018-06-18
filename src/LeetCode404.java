public class LeetCode404 {

    public static int leftLeaves(TreeNode root,boolean isLeft){

        if (root==null)
            return 0;

        /**
         * 如果是左叶子
         */
        if(root.right==null&&root.left==null&&isLeft){
            return root.val;
        }


        /**
         * 如果不是左叶子
         */
        int left = leftLeaves(root.left,true);
        int right = leftLeaves(root.right,false);

        return left+right;

    }

    public int sumOfLeftLeaves(TreeNode root) {

        /**
         * 先想递归过程
         * 一棵树的左叶子之和=左子数的左叶子之和+右子树的左叶子之和
         */

        /**
         * 终止条件其实是要解决的问题
         * 在左叶子那返回，那怎么计算左叶子？
         * 单纯的叶子结点没法判断是左是右，可以新定义一个函数，在调用时声明左右
         */


        /**
         * 特殊情况，root==null，或者只有root一个结点呢？
         *
         * 嘻嘻，一次AC
         */
        if(root==null)
            return 0;

        return leftLeaves(root.left,true)+leftLeaves(root.right,false);






    }

}
