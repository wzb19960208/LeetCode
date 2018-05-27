import java.util.LinkedList;
import java.util.List;

public class LeetCode144 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        /**
         * 递归实现
         * 单个递归程序是不会引发递归问题的
         */

        List<Integer> list = new LinkedList<>();
        pre(root,list);
        return list;



    }

    public void pre(TreeNode root,List<Integer> list){

        if (root==null)
            return;

        list.add(root.val);
        pre(root.left,list);
        pre(root.right,list);

    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        /**
         * 循环实现
         * 递归转循环，要用到栈
         */

        List<Integer> list = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.addLast(root);

        while (stack.size()!=0){

            TreeNode temp = stack.pollLast();

            if(temp!=null){

                //先让右子树进去
                list.add(temp.val);
                stack.addLast(temp.right);
                stack.addLast(temp.left);

            }

        }

        return list;



    }
}
