import java.util.PriorityQueue;

public class LeetCode155 {

    public static class MinStack{

        int size;
        int index;

        //只有一个min，或者两个min，不能实现该功能
        //如果pop了一个min，没法获取之前的最小值了

        //使用最小堆就好了
        PriorityQueue<Integer> min;

        int [] array;


            /** initialize your data structure here. */
            // 初始化给16
            public MinStack() {
                size = 16;
                index = 0;
                array = new int [16];
                min = new PriorityQueue<>();
            }

            public void push(int x) {
                //扩容
                if(index==size-1){
                    size*=2;
                    int [] temp = new int [size];
                    int ori = size/2;
                    for(int i=0;i<ori;i++){
                        temp[i]=array[i];
                    }
                    array = temp;
                }

                array[index++]=x;
                min.add(x);

            }

            public void pop() {
                int temp = array[--index];
                //如果pop掉的是最小值，那么队列也要删掉一个最小值
                if(temp==getMin()){
                    min.poll();
                }
            }

            public int top() {
                return array[index-1];
            }

            public int getMin() {
                return min.peek();
            }


    }

}
