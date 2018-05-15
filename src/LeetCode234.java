public class LeetCode234 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);


        System.out.println(isPalindrome(head));

    }

    public static boolean isPalindrome(ListNode head) {

        //先获取长度
        int count = 0;

        ListNode temp = head;

        while(temp!=null){
            count++;
            temp=temp.next;
        }

        //null算不算回文串啊？
        //用例里面是算的
        if(count==0){
            return true;
        }

        if (count==1){
            return true;
        }

        if(count==2){
            if(head.val==head.next.val)
                return true;
            else
                return false;
        }

        if(count==3){
            if(head.val==head.next.next.val)
                return true;
            else
                return false;
        }

        //如果是偶数
        if(count%2==0){

            ListNode mid = head;

            for(int i=0;i<count/2-1;i++){
                mid=mid.next;
            }

            //将mid后面的链表反转

            ListNode pre = mid.next;
            ListNode cur = pre.next;
            ListNode next = cur.next;

            //因为现在pre是最后一个元素了
            pre.next = null;

            while(cur!=null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            //反转之后，pre指向首元素
            mid.next = pre;

            //两个指针，第二个指针先走长度的一般
            ListNode p1 = head;
            ListNode p2 = head;

            for(int i=0;i<count/2;i++){
                p2=p2.next;
            }

            while(p2!=null){

                if(p1.val!=p2.val)
                    return false;
                else{
                    p1=p1.next;
                    p2=p2.next;
                }

            }

            return true;

        }else{
            //如果是奇数
            ListNode mid = head;

            for(int i=0;i<count/2;i++){
                mid=mid.next;
            }

            //将mid后面的链表反转

            ListNode pre = mid.next;
            ListNode cur = pre.next;
            ListNode next = cur.next;

            //因为现在pre是最后一个元素了
            pre.next = null;

            while(cur!=null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }


            //反转之后，pre指向首元素
            mid.next = pre;

            //两个指针，第二个指针先走长度的一般+1
            ListNode p1 = head;
            ListNode p2 = head;

            for(int i=0;i<(count/2)+1;i++){
                p2=p2.next;
            }

            while(p2!=null){

                if(p1.val!=p2.val)
                    return false;
                else{
                    p1=p1.next;
                    p2=p2.next;
                }

            }

            return true;

        }


    }




    public static class ListNode{

        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

    }

}
