import java.util.List;

public class LeetCode141 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if(head==null)
            return false;

        //环形跑道，有速度差，肯定会相遇
        ListNode p1 = head;
        ListNode p2 = head;

        while(true){

            //p1走一步
            p1=p1.next;

            //空了肯定不是环
            if(p1==null)
                return false;

            //next的next相当于走了两步
            p2=p2.next;
            if(p2.next==null)
                return false;
            p2=p2.next;
            if(p2.next==null)
                return false;

            //相遇就是环
            if(p1==p2)
                return true;

        }

    }


}
