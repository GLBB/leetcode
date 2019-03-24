package cn.gl;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list =  new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode node, ArrayList<Integer> list){
        if (node == null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
