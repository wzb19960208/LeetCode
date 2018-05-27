import java.util.LinkedList;
import java.util.List;

public class LeetCode94 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }

    }


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        /**
         * 递归实现
         */

        inorder(root,list);


        return list;
    }

    public void inorder(TreeNode node,List<Integer> list){

        if(node==null)
            return;

        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);

    }

    public static class MyNode{

        boolean check;
        TreeNode node;

        MyNode(TreeNode node,boolean check){
            this.check = check;
            this.node = node;
        }

    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        /**
         * 循环实现
         *
         * 一个最大的问题就是 可以这样做
         *
         * if(left!=null) addLast
         *
         * else print and right addLast
         *
         * 但是如果左孩子读完了，回到了父结点，那么就会再判断是否有左子树，死循环了
         *
         * 所以，要是有办法判断这些结点是应该遍历它的左子树还是直接打印就好了
         *
         * 所以新建了一个数据结构
         *
         * MyNode
         * bool check 真就是遍历过了，直接打印即可
         * TreeNode node 它对应的Node
         *
         */


        LinkedList<MyNode> stack = new LinkedList<>();


        MyNode node = new MyNode(root,false);

        stack.addLast(node);

        while (stack.size()!=0){

            MyNode temp = stack.pollLast();

            if(temp.node!=null){

                //检查过了就直接打印就好了
                if(temp.check){

                    list.add(temp.node.val);

                }else{

                    //这个是待遍历的结点
                    stack.addLast(new MyNode(temp.node.right,false));
                    stack.addLast(new MyNode(temp.node,true));
                    stack.addLast(new MyNode(temp.node.left,false));

                }


            }

        }


        return list;
    }


}
