import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode107 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    /**
     * 同时存储node和对应的层级
     */
    public static class MyNode{
        TreeNode node;
        int level;
        MyNode(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<MyNode> queue = new LinkedList<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //第一层
        MyNode node = new MyNode(root,1);

        queue.addLast(node);

        while(queue.size()!=0){

            MyNode temp = queue.pollFirst();

            if(temp.node!=null){

                /**
                 * 当层级大于resut.size的时候，result就该增长了
                 */
                if(result.size()<temp.level){
                    ArrayList<Integer> array = new ArrayList<>();
                    result.add(array);
                }

                result.get(temp.level-1).add(temp.node.val);

                queue.add(new MyNode(temp.node.left,temp.level+1));
                queue.add(new MyNode(temp.node.right,temp.level+1));

            }

        }



        int len = result.size();


        List<List<Integer>> reverse = new ArrayList<>();

        for(int i=len-1;i>=0;i--){
            reverse.add(result.get(i));
        }

        return reverse;

    }

}
