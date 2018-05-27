import java.util.LinkedList;
import java.util.List;

public class LeetCode145 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public static class MyNode{

        boolean check;
        TreeNode node;
        MyNode(TreeNode node,boolean check){
            this.check = check;
            this.node = node;
        }

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        LinkedList<MyNode> stack = new LinkedList<>();

        MyNode node = new MyNode(root,false);

        stack.addLast(node);

        while(stack.size()!=0){

            MyNode temp = stack.pollLast();

            if(temp.node!=null){

                if(temp.check){
                    list.add(temp.node.val);
                }else{

                    stack.addLast(new MyNode(temp.node,true));
                    stack.addLast(new MyNode(temp.node.right,false));
                    stack.addLast(new MyNode(temp.node.left,false));

                }


            }


        }

        return list;


    }

}
