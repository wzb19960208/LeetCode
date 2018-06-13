import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode199 {

    public static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }

    }

    public static class MyNode{
        TreeNode node;
        int level;
        MyNode(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }


    /**
     * 用队就好了，层次遍历，每一层最右边的元素肯定最后出队，会把前面的元素给覆盖掉
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        LinkedList<MyNode> queue = new LinkedList<>();

        MyNode node = new MyNode(root,1);

        queue.addLast(node);

        while(queue.size()!=0){

            MyNode temp = queue.pollFirst();

            if(temp.node!=null){

                /**
                 * 因为只会差一个，所以直接add就行
                 */
                if(result.size()<temp.level){
                    result.add(0);
                }

                result.set(temp.level-1,temp.node.val);

                queue.addLast(new MyNode(temp.node.left,temp.level+1));
                queue.addLast(new MyNode(temp.node.right,temp.level+1));


            }

        }

        return result;

    }

}
