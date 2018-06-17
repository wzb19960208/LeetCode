import java.util.LinkedList;

public class LeetCode222 {

    /**
     *
     * 对于一个节点node，计算它最左端的节点到node的深度为leftDepth，计算它最右端的节点到node的深度是rightDepth；
        如果leftDepth和rightDepth相等，那么以node为根节点的树是一棵满二叉树，此时以node为根节点的树的节点个数是pow(2,leftDepth)-1；
        如果leftDepth和rightDepth不相等，递归求解node的左子树的节点数和右子树的节点数。
     */
    public int countNodes(TreeNode root) {

        if(root==null)
            return 0;

        int leftDepth = 0;
        int rightDepth = 0;

        /**
         * 统计左边子树高度
         */
        for(TreeNode node = root;node!=null;node=node.left)
            leftDepth++;

        for(TreeNode node = root;node!=null;node=node.right)
            rightDepth++;


        if(leftDepth==rightDepth){
            return pow2(leftDepth);
        } else{

            return 1+countNodes(root.left)+countNodes(root.right);

        }



    }

    public static int pow2(int x){
        if(x==1)
            return 1;
        else{
            /**
             * 必须用一个数来保存左移的结果
             * 否则not a statement
             * 移x位，等于乘以x个2
             * 2 《《 x
             * 这样就是2^x+1次方了
             */
            int num = 0;
            num = 1 << x ;
            return num-1;
        }
    }



    /**
     * 最简单的方法是遍历，但似乎没有用到完全二叉树的性质
     * 如果没有左右孩子，直接return
     * 如果只有左没有右，这就是最后一个孩子的爸爸，直接renturn 2
     * 左右都有，继续递归咯
     *
     * 15 / 18 个通过测试用例
     * 状态：超出时间限制
     * 竟然比用队列快，服了，为啥啊
     * 应该是队列循环里面语句太多了？
     *
     */

    public int countNodes3(TreeNode root) {

        if(root==null)
            return 0;

        if(root.right==null&&root.left==null)
            return 1;

        else if(root.left!=null&&root.right==null)
            return 2;

        /**
         * 不存在有右无左的情况
         * 此时是左右都存在
         */
        else{
            return 1+countNodes3(root.left)+countNodes3(root.right);
        }


    }



    /**
     *用队的方法，进行层次遍历
     * 如果一个结点不是叶子结点，且只有左子树，那么它的左子树就是最后一个点，此时queue.size+1就是剩下的点了
     * 12 / 18 个通过测试用例
     * 状态：超出时间限制
     */
    public int countNodes2(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);

        int count = 0;

        int len = 1;
        /**
         * 用len来代替queue.size
         * 13 / 18 个通过测试用例
         * 还是方法上有问题
         * 怎么改都是13个。
         * 看答案甩了
         */


        while (len!=0){

            TreeNode temp = queue.pollFirst();
            len--;
            if(temp!=null){
                count++;

                if(temp.left!=null&&temp.right!=null){
                    queue.addLast(temp.left);
                    queue.addLast(temp.right);
                    len+=2;
                }else if(temp.left!=null){
                    /**
                     * 不会走到叶子结点去的
                     * 除非一开始就是叶子
                     */
                    count+=(len+1);
                    return count;
                }else {
                    /**
                     * 叶子结点
                     */
                }

            }

        }

        /**
         * 如果是满的
         */
        return count;

    }

}
