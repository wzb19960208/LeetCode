public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode cur = null;

        //先构造第一个结点，不然没法玩
        if(l1==null)
            return l2;

        //l1不是null
        if(l2==null)
            return l1;

        //两个都不是null
        if(l1.val<l2.val){
            result = new ListNode(l1.val);
            l1=l1.next;
        }else{
            result = new ListNode(l2.val);
            l2=l2.next;
        }

        cur = result;


        //两个都没有到末尾
        while (l1!=null&&l2!=null){

            if(l1.val<l2.val){
                cur.next = new ListNode(l1.val);
                l1=l1.next;
            }else{
                cur.next = new ListNode(l2.val);
                l2=l2.next;
            }

            cur = cur.next;

        }

        if(l1==null){
            cur.next = l2;
        }

        if(l2==null){
            cur.next=l1;
        }

        return result;


    }

    public static class ListNode{

        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

    }

}
