public class LeetCode203 {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val){

        /**
         *
         * []  1  这种输入你说是不是狗？
         *
         */

        if(head==null)
            return null;


        //随便给一个值都行，因为没有影响
        ListNode first = new ListNode(0);
        ListNode cur = first;

        first.next = head;

        /**
         *
         * 考虑 [1]   2
         * [1,2,3,4,5,6] 6
         *
         */


        //到末尾的时候 cur移到了null
        while(cur!=null&&cur.next!=null){

            //删除
            if(cur.next.val==val){
                cur.next = cur.next.next;
            }else {
                //确定下一个不会是删除目标，才会移到下一个
                cur=cur.next;
            }



        }

        //不用判断，无论如何都是返回first后面的
        return first.next;

    }

    public static class ListNode{

        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }

    }

}
