public class LeetCode206 {


    public ListNode reverseList(ListNode head){

        //三指针
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur!=null){

            next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }

        return pre;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

}
