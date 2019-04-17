package cn.gl;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        int[] x = new int[0];
        System.out.println(x.length);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder ==  null || postorder.length == 0)
            return null;
        int v = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(v);
        Help help = helperFun(v, inorder, postorder);
        toTree(root, help.leftInorder, help.rightInorder, help.leftPostorder, help.rightPostorder);
        return root;
    }

    public static void toTree(TreeNode p, int[] leftInorder, int[] rightInorder,
                              int[] leftPostorder, int[] rightPostorder){
        if (leftPostorder.length != 0){
            int v = leftPostorder[leftPostorder.length-1];
            TreeNode leftNode = new TreeNode(v);
            p.left = leftNode;
            Help help = helperFun(v, leftInorder, leftPostorder);
            toTree(leftNode, help.leftInorder, help.rightInorder, help.leftPostorder, help.rightPostorder);
        }
        if (rightPostorder.length!=0) {
            int v = rightPostorder[rightPostorder.length - 1];
            TreeNode rightNode = new TreeNode(v);
            p.right = rightNode;
            Help help = helperFun(v, rightInorder, rightPostorder);
            toTree(rightNode, help.leftInorder, help.rightInorder, help.leftPostorder, help.rightPostorder);
        }
    }

    public static Help helperFun(int value, int[] inorder, int[] postorder) {
        int idx = findIdx(value, inorder);

        int[] leftInorder = new int[idx];
        int[] rightInorder = new int[inorder.length - idx-1];
        System.arraycopy(inorder, 0, leftInorder, 0, idx);
        System.arraycopy(inorder, idx+1, rightInorder, 0, inorder.length - idx-1);
        int[] leftPostorder  = new int[idx];
        int[] rightPostorder = new int[inorder.length - idx-1];
        System.arraycopy(postorder, 0, leftPostorder, 0, idx);
        System.arraycopy(postorder, idx, rightPostorder, 0, inorder.length - idx-1);
        Help help = new Help(leftInorder, rightInorder, leftPostorder, rightPostorder);
        return help;
    }

    static class Help{
        int[] leftInorder;
        int[] rightInorder;
        int[] leftPostorder;
        int[] rightPostorder;

        public Help(int[] leftInorder, int[] rightInorder, int[] leftPostorder, int[] rightPostorder) {
            this.leftInorder = leftInorder;
            this.rightInorder = rightInorder;
            this.leftPostorder = leftPostorder;
            this.rightPostorder = rightPostorder;
        }
    }

    public static int findIdx(int value, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
