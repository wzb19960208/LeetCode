import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode {
    public static void main(String[] args) {
//        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) ->(a[0]-b[0]));
//
//        int a[] = {1,2,3};
//        int b[] = {2,3,4};
//        int d[] = {3,4,5};
//
//        pqCap.add(a);
//        pqCap.add(b);
//        pqCap.add(d);
//
//        System.out.println(pqCap.poll()[0]);
//        System.out.println(pqCap.poll()[0]);
//        System.out.println(pqCap.poll()[0]);


        /**
         * 证明了java引用就是一个指针
         */
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder("123456"));

        StringBuilder sb = list.get(0);
        sb.setCharAt(2,'9');

        System.out.println(sb);
        System.out.println(list.get(0));





    }

}
