public class LeetCode437 {


    public static int find(TreeNode root,int sum){

        /**
         * 对一个确定的数，找路径
         */

        int count = 0;

        if(root==null)
            return 0;

        if(root.val==sum)
            count++;

        /**
         * 不会停下，因为有0有负数，直到为空
         */
        int left = find(root.left,sum-root.val);
        int right = find(root.right,sum-root.val);

        return count+left+right;


    }


    public int pathSum(TreeNode root, int sum) {

        if(root==null)
            return 0;


        /**
         * 把每个结点都当新的开始即可
         */

        int count = find(root,sum);
        int left = pathSum(root.left,sum);
        int right = pathSum(root.right,sum);

        return count+left+right;


        /**
         * 不是叶子结点，也能作为返回
         */

        /**
         * 如果当前就找到了，肯定+1
         */





        /**
         * 这个递归不行
         * 比如一开始8-10 = -2
         * 这个-2会作为sum一直传递下去，一直到找到了-2
         */
//        int left = pathSum(root.left,sum-root.val)+pathSum(root.left,sum);
//        int right = pathSum(root.right,sum-root.val)+pathSum(root.right,sum);



    }

}
