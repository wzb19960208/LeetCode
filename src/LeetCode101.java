import java.util.ArrayList;
import java.util.List;

public class LeetCode101 {

    public static void main(String[] args) {




    }



    public static void fanzhuan(TreeNode root){

        if(root==null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        fanzhuan(root.left);
        fanzhuan(root.right);

    }

    public static void inorder(TreeNode root, List<Integer> list){

        if (root==null){
            list.add(-321);
            return;
        }

        /**
         * 叶子结点就不要把后面的null放进去了
         */
        if(root.left==null&root.right==null){
            list.add(root.val);
        }else{
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }



    }

    public static boolean isSame(TreeNode tree1,TreeNode tree2){

        if(tree1==null&&tree2==null){
            return true;
        }else if(tree1==null&&tree2!=null){
            return false;
        }else if(tree1!=null&&tree2==null){
            return false;
        }else {

            if(tree1.val!=tree2.val){
                return false;
            }else {

                boolean bleft = isSame(tree1.left,tree2.left);
                boolean bright = isSame(tree1.right,tree2.right);

                if(bleft&&bright)
                    return true;
                else
                    return false;

            }

        }

    }

    /**
     * 要复制数组
     * 不然只有=是浅复制，没有用
     */
    public static TreeNode copy(TreeNode ori){

        if(ori==null)
            return null;

        TreeNode des = new TreeNode(ori.val);
        des.left = copy(ori.left);
        des.right = copy(ori.right);

        return des;

    }


    public boolean isSymmetric(TreeNode root) {

        /**
         *
         * 先将树翻转，然后中序遍历
         * 先序会错的，自己试过了
         * null要也要加入，不然也会错
         * 直接加null也不行，要判断叶子结点
         *
         *
         * 别用遍历再判断数组了，太傻了
         *
         * 直接递归判断两棵树是不是一样
         *
         */

        if(root==null)
            return true;

        TreeNode ori = null;
        ori = copy(root);

        fanzhuan(root);

        return isSame(ori,root);

    }

}
