import java.util.*;

public class LeetCode502 {

    public static class Node{

        //一定要有这个标识，不然删除不知道删哪个
        //int index;

        //被选过了就是true，没选就是false
        boolean flag = false;
        int cap;
        int pro;
        public Node(int x,int y){
            cap = x;
            pro = y;
        }


    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        //怎么通过每个启动资金，找到对应的利润呢？不解决这个问题，就无法对C进行排序，不然会找不到对应的P
        //Map不行，因为可能会有相同启动资金，但是利润不同的
        //自定义一个类即可！自定义数据结构真的是厉害。

        //构建一个Node的数组

        List<Node> list = new ArrayList<>();

        for(int i=0;i<Capital.length;i++){
            Node node = new Node(Capital[i],Profits[i]);
            list.add(node);
        }

        //通过C对list进行降序排序
        Collections.sort(list, (o1,o2)->{
            if(o1.cap>o2.cap)
                return -1;
            if(o1.cap<o2.cap)
                return 1;
            return 0;
        });

        //每次遍历list，找到小于或等于W的第一个node，因为是降序，该node后面的都是比W小的
        //在比W小的所有node里面，找到P最大的那个
        //好像不用每次都维护一个新的优先队列
        //因为W肯定是递增的，那么只要把新元素加进优先队列就好了
        int len = list.size();

        //指向末尾
        int last = len-1;
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                if(o1.pro>o2.pro)
//                    return -1;
//                if(o1.pro<o2.pro)
//                    return 1;
//                return 0;
//            }
//        });

        //lambda表达式也可以，好像简便易行
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1,o2)->{
                if(o1.pro>o2.pro)
                    return -1;
                if(o1.pro<o2.pro)
                    return 1;
                return 0;
        });

        for(int i=0;i<k;i++){

            int j = 0;
            for(;j<len;j++){
                Node node = list.get(j);
                if(W>=node.cap){
                    break;
                }
            }

            //把j~last之间的值，放到优先队列里！
            for(int q=j;q<=last;q++){
                Node node = list.get(q);
                if(!node.flag)
                    priorityQueue.add(node);
            }

            //更新last
            //如果last=j，那么j就多放了一次了
            last=j-1;

            //对后续的都放入优先队列里，就能找到里面的最大值了
            Node node = priorityQueue.poll();
            //没有适合W的项目了
            if(node==null)
                return W;
            W+=node.pro;
            node.flag=true;

            //删掉该项目
            //不需要这样删，想到了一个常数级优化
//            Iterator<Node> iterator = list.iterator();
//            while (iterator.hasNext()){
//                Node temp = iterator.next();
//                if(temp.index==node.index){
//                    iterator.remove();
//                    break;
//                }
//            }

        }

        return W;


    }

}
