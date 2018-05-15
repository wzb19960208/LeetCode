public class LeetCode237 {


    public void deleteNode(ListNode node) {

        //给我的只有当前要删除的结点
        //没有办法获取到它前面的结点，所以没法让pre.next = node.next

        //方法一
        //pre.next 和 node 指向的内存是一个东西，所以直接修改它们指向的东西即可，但是Java好像没有办法这样做

        //方法二
        //修改值，把后面的覆盖前面的就好了
        //或者直接后面的一个覆盖当前的，删除后面的那个结点就好了


        if(node==null)
            return;

        //node是末尾的时候，Java好像没法弄。将node设为null，只是将node指向null而已，对原来的元素没影响
        //也没有直接回收的办法。。
        //不过题目说了 非末尾 就不考虑了
        if(node.next==null){
            return;
        }

        //1->2->3->4->5
        //1,2,4,4,5
        node.val = node.next.val;

        //1,2,4  , 5
        node.next = node.next.next;

        return;


    }


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

}
