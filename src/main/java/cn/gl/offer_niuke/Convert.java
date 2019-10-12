package cn.gl.offer_niuke;

public class Convert {


    public static void main(String[] args) {
        Convert convert = new Convert();
        TreeNode n1 =  new TreeNode(1);
        TreeNode n2 =  new TreeNode(2);
        TreeNode n3 =  new TreeNode(3);
        TreeNode n4 =  new TreeNode(4);
        TreeNode n5 =  new TreeNode(5);
        TreeNode n6 =  new TreeNode(6);
        TreeNode n7 =  new TreeNode(7);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        TreeNode convert1 = convert.Convert(n4);
        System.out.println();
    }


    TreeNode fackH = new TreeNode(0);
    TreeNode tail = fackH;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        inorder(pRootOfTree);
        TreeNode head = fackH.right;
        head.left = null;
        return head;
    }

    private void inorder(TreeNode cur){
        if (cur == null)
            return;
        inorder(cur.left);
        tail.right = cur;
        cur.left = tail;
        tail = cur;
        inorder(cur.right);
    }

}
