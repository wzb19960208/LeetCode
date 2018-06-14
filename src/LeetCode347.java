import java.util.*;

public class LeetCode347 {

    public static void main(String[] args) {

        /**
         * 你add进去...这个对列也会增大，并不能维持一个固定大小的堆。
         * 所以说不是堆，就是一个优先队列
         * int i = size;
         if (i >= queue.length)
         grow(i + 1);minCapacity
         size = i + 1;
         */

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(0);

        Iterator<Integer> iterator = priorityQueue.iterator();

        while(iterator.hasNext())
            System.out.println(iterator.next());


        int [] a = {1,1,1,2,2,3};
        int k=2;

        topKFrequent(a,k);



    }

    public static class MyInt implements Comparable{
        int val;
        int count;
        MyInt(int val,int count){
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {

            if(o instanceof MyInt){

                if(this.count>((MyInt) o).count){
                    return 1;
                }else if(this.count<((MyInt) o).count){
                    return -1;
                }

            }

            return 0;

        }
    }

    /**
     * 队列的初始大小是没有用的，必须自己维护
     *
     * 自己设一个len就行了，如果比当前peek值大的话，就放进去，手动poll了顶堆。
     *
     * 小顶堆，后面的元素都比顶堆大，因为统计前k大的，肯定去掉最小的那个
     *
     * 妈的要是【1，2，3，4，5，6】 k=2 那么前2高的应该是啥？不过说K是合理的，应该默认没有这种情况
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        //统计频率
        for(int i=0;i< nums.length;i++){

            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }

        }

        int len = 0;

        PriorityQueue<MyInt> queue = new PriorityQueue<>();

        /**
         * 不应该对数组遍历，因为很多重复的数字
         */

        Set<Integer> set = map.keySet();

        Iterator<Integer> iterator = set.iterator();

        while(iterator.hasNext()){

            int temp = iterator.next();

            if(len<k){
                queue.add(new MyInt(temp,map.get(temp)));
                len++;
            }else{

                MyInt top = queue.peek();
                int current = map.get(temp);
                if(current>top.count){
                    queue.poll();
                    queue.add(new MyInt(temp,current));
                }

            }


        }



        /**
         * queue里可以同时放一个数据结构，数字+频率的，这样统计一次就直接储结果了，不需要再遍历一次map
         * 而且怎么判断一个数字是不是在queue里呢？
         * 每个数字都要对queue做一次遍历，看看是不是在这几个频率里面，就是k*n了，很慢
         */

        List<Integer> result = new ArrayList<>();

        System.out.println(queue.size());

        while(queue.size()>0){
            MyInt temp = queue.poll();
            result.add(temp.val);
        }


        return result;




    }
}
