import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode414 {
    public static void main(String[] args) {

//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//        queue.add(2);
//        queue.add(1);
//        queue.add(3);
//
//        //优先队列，默认是返回最小的
//        System.out.println(queue.poll());

        int [] nums = {1,2,2,5,3,5};

        System.out.println(thirdMax(nums));


    }

    public static int thirdMax(int[] nums) {

        //去重
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        Iterator<Integer> iterator = set.iterator();

        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        //把数字都遍历一次，如果比queue里最小的元素大，就删掉queue里最小的元素，扔进queue
        //这样到最后，queue里面的元素，肯定都是比这些元素大的，这就是topK了
        while(iterator.hasNext()){
            int temp = iterator.next();
            if(count<3){
                queue.add(temp);
                count++;
            }else{
                if(temp>queue.peek()){
                    queue.poll();
                    queue.add(temp);
                }
            }
        }

        //麻烦一点，这样语意明确
        if(queue.size()>=3){
            return queue.poll();
        }else if (queue.size()==2){
            queue.poll();
            return queue.poll();
        }else {
            return queue.poll();
        }


    }
}
