import java.util.LinkedList;
import java.util.List;

public class LeetCode429 {

    //多x树
    static class Node {
        public int val;
        //孩子是一个list
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {



    }

    public List<List<Integer>> levelOrder(Node root) {

        if(root==null)
            return new LinkedList<>();


        LinkedList<Node> queue = new LinkedList<>();

        List<List<Integer>> result = new LinkedList<>();



        int current = 1;
        int child = 0;
        //层级
        int level = 0;


        //第一个先创建好
        result.add(new LinkedList<>());
        queue.addLast(root);





        //队列里没有值，可以退出了
        while (queue.size()>0){
            //拿出当前的
            Node node = queue.pollFirst();

            if(node==null)
                continue;

            //数值放进list里
            result.get(level).add(node.val);

            //把他的孩子加到队列末尾
            for(int i=0,len=node.children.size();i<len;i++){
                queue.addLast(node.children.get(i));
            }

            //当前要操作的数--,操作成功才--，因为这个是记录这非null的
            current--;
            //下一次要操作的数就是孩子的数量相加
            child += node.children.size();

            //这一层刚好操作完了
            if(current==0){
                //多加一个数组
                result.add(new LinkedList<>());
                //level提高
                level++;
                //处理子孩子
                current=child;
                child=0;
            }



        }

        //要去掉最后一个，因为总会导致最后一个为[]
        result.remove(result.size()-1);

        return result;


    }

}
