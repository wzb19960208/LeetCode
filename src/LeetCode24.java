public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {

        //为了统一操作，添加一个虚拟头指针
        ListNode first = new ListNode(0);

        first.next = head;

        //四个辅助的指针
        //p指向当前的结点
        //node1表示第一个结点
        //node2表示第二个结点
        //node1和2交换
        //next是node2的下一个结点

        ListNode p = first;

        //有一个为空，就没法交换了，结束
        //当head为空，或者为一个，也成立
        while(p.next!=null&&p.next.next!=null){

            ListNode node1= p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;

            //交换
            //p->node2->node1->next
            node2.next = node1;
            node1.next = next;
            p.next = node2;

            //下一步是交换node1后面的两个了
            p = node1;

        }

        return first.next;

    }



    public static class ListNode{

        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

    }

}
