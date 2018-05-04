public class LeetCode83 {

    public static ListNode deleteDuplicates(ListNode head){

        if(head==null)
            return null;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur!=null){


            if(cur.val==pre.val){
                pre.next=cur.next;
                cur=pre.next;
            }else {
                pre=cur;
                cur=cur.next;
            }

        }

        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

}
