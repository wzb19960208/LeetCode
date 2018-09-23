import java.util.LinkedList;
import java.util.List;

public class LeetCode236 {

    public static void main(String[] args) {

    }

    public static boolean find(TreeNode node, TreeNode target, LinkedList<TreeNode> queue){

        if(node==null)
            return false;

        if(node==target){
            //因为是包括自己的，自己也能算别人的祖先
            queue.add(node);
            return true;
        }

        //左边找到就不去找右边了
        //左右孩子如果能找到那个元素，自己就是祖先，把自己加进去
        boolean left = find(node.left,target,queue);
        if(left){
            queue.add(node);
            return true;
        }

        boolean right = find(node.right,target,queue);
        if(right){
            queue.add(node);
            return true;
        }

        //左右孩子都没有，那就找不到了
        return false;


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //获取到达p的路径
        LinkedList<TreeNode> list1 = new LinkedList<>();
        find(root,p,list1);

        LinkedList<TreeNode> list2 = new LinkedList<>();
        find(root,q,list2);

        TreeNode last = null;

        //从右边开始
        while (list1.size()!=0&&list2.size()!=0){

            //poll是返回队列头部
            TreeNode temp1 = list1.pollLast();
            TreeNode temp2 = list2.pollLast();

            if(temp1==temp2)
                last=temp1;
            else
                break;

        }

        return last;


    }

}
