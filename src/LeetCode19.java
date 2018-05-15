public class LeetCode19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        /**
         *
         * 方法1，遍历第一次，获得总长度
         * 然后一直遍历大概size-n这个位置好了
         *
         * 就要遍历两次吧
         *
         */


        /**
         * 方法2
         * 建立两个指针
         * 这两个指针距离是n，然后最后一个指针到末尾了，就删除前面那个指针的结点
         *
         */

        //两个指针都指向首元素
        //第一个指针，先走n-1步
        //先走n步比较好，因为这样p2刚好指向要删除的前一个元素

        ListNode p1 = head;
        ListNode p2 = head;


        for(int i=0;i<n;i++){
            p1=p1.next;
        }

        //如果n = 链表长度，此时P1=null了
        //就是删除首元素
        if(p1==null){
            return head.next;
        }

        //然后两个指针同时移动
        //当p1.next==null是末尾了，这时候P1是倒数第一个
        while(p1.next!=null){

            p2=p2.next;
            p1=p1.next;

        }

        p2.next = p2.next.next;

        return head;


    }


    public static class ListNode{

        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

    }

}
