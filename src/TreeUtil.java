import java.util.List;

public class TreeUtil {



    /**
     * 数组构造树
     * 用数组表示的树，不是某种序
     * 0就root 2n+1就是左孩子，2n+2是右孩子
     */
    public static TreeNode createTree(List<Integer> list, int index){

        if(index>=list.size())
            return null;

        if(list.get(index)==null){
            return null;
        }

        TreeNode node = new TreeNode(list.get(index));
        node.left = createTree(list,2*index+1);
        node.right = createTree(list,2*index+2);

        return node;

    }

    /**
     * 中序遍历
     */
    public static void inorder(TreeNode root){

        if(root==null)
            return;

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);

    }

    /**
     * 先序遍历
     */
    public static void preorder(TreeNode root){

        if(root==null)
            return;

        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);

    }


    /**
     * 深复制树
     */
    public static TreeNode copy(TreeNode ori){

        if(ori==null)
            return null;

        TreeNode des = new TreeNode(ori.val);
        des.left = copy(ori.left);
        des.right = copy(ori.right);

        return des;

    }

}
