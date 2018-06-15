public class LeetCode100 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        /**
         * 如果当前结点相同+左右子树相同，就是相同的。
         * 然后左右子树也能用这个方法去判断，就是递归
         *
         */

        if(p==null&&q==null)
            return true;
        else if(p==null&&q!=null){
            return false;
        }else if(p!=null&&q==null){
            return false;
        }else {
            if(q.val==p.val){

                boolean bleft = isSameTree(p.left,q.left);
                boolean bright = isSameTree(p.right,q.right);

                if(bleft==true&&bright==true)
                    return true;
                else
                    return false;


            }

            else
                return false;
        }

    }

}
