public class LeetCode92 {

    public static ListNode reverseBetween(ListNode head, int m, int n){

        if(m==n)
            return head;

        //循环次数
        int count = n-m+1;

        ListNode mNode = null;
        ListNode nNode = null;
        ListNode mPre = null;
        ListNode nNext = null;


        //第一次遍历，找到m，n，m的前一个和n的下一个的地方

        ListNode pre = null;
        ListNode cur =head;
        ListNode next =null;

        int index = 1;
        while(cur!=null){

            next = cur.next;

            if(index==m){
                mNode = cur;
                mPre = pre;
            }

            if(index==n){
                nNode = cur;
                nNext = cur.next;
                //找完n可以退出了
                break;
            }

            pre = cur;
            cur = next;
            index++;

        }



        //反转部分数组
        cur = mNode;
        pre = nNext;
        // System.out.println("cur = "+cur.val);
        // System.out.println("next = "+cur.next.val);

        while(count>0){

            //System.out.println("cur = "+cur.val);
            next = cur.next;
            //System.out.println("next = "+next.val);
            cur.next=pre;
            pre=cur;
            cur=next;
            count--;

        }



        if(m==1){
            return pre;
        }else{

            mPre.next=pre;
            return head;

        }





    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

}
