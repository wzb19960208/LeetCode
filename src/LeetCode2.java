import java.util.Deque;
import java.util.LinkedList;

public class LeetCode2 {

    public static void main(String[] args) {

        //双端队列 Deque的一个实现
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(2);
        linkedList.addFirst(4);
        linkedList.addFirst(3);

        //peek .get 都是只拿不出的
        System.out.println(linkedList.size());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollFirst());

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        /**
         * 做法一：因为逆序，可以直接算，记录进位即可
         */

        /**
         * 做法二 用栈
         * Java里面就用双端队列 LinkedList是它的实现
         * 但是数的位数并没有说明，int，long都可能会溢出
         */


        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        ListNode cur = null;

        //进位
        int cnt = 0;

        //第一次构造head
        int temp = cur1.val+cur2.val;

        if(temp>=10){
            head = new ListNode(temp%10);
            cnt=1;
        }else{
            head = new ListNode(temp);
        }

        cur = head;
        cur1 = cur1.next;
        cur2 = cur2.next;


        while(true){

            //两个都还有元素
            if(cur1!=null&&cur2!=null){

                temp = cur1.val+cur2.val+cnt;

                if(temp>=10){
                    cur.next = new ListNode(temp%10);
                    cnt=1;
                }else{
                    cur.next = new ListNode(temp);
                    cnt=0;
                }


                cur=cur.next;
                cur1=cur1.next;
                cur2=cur2.next;

            }else if(cur1==null&&cur2!=null){

                //cur1已经结束了，还有课能存在进位
                temp = cur2.val+cnt;

                if(temp>=10){
                    cur.next = new ListNode(temp%10);
                    cnt=1;
                }else{
                    cur.next = new ListNode(temp);
                    cnt=0;
                }

                cur=cur.next;
                cur2=cur2.next;

            }else if(cur1!=null&&cur2==null){
                temp = cur1.val+cnt;

                if(temp>=10){
                    cur.next = new ListNode(temp%10);
                    cnt=1;
                }else{
                    cur.next = new ListNode(temp);
                    cnt=0;
                }

                cur=cur.next;
                cur1=cur1.next;
            }else{

                if(cnt==1){
                    cur.next = new ListNode(1);
                }

                break;

            }

            System.out.println(cur.val);

        }


        return head;


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

}
