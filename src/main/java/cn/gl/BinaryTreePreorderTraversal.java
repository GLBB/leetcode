package cn.gl;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {


    public static void main(String[] args) {
        TreeNode n1 =  new TreeNode(1);
        TreeNode n2 =  new TreeNode(2);
        TreeNode n3 =  new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        List<Integer> list = preorderTraversal(n1);
        System.out.println();

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list =  new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }


    public static void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node== null)
            return;
        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }
}
