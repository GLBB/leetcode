package cn.gl;

import java.util.LinkedList;

public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size()-1; i++) {
            TreeNode treeNode = list.get(i);
            treeNode.left = null;
            treeNode.right = list.get(i+1);
        }
        list.get(list.size()-1).left = null;
    }

    public void preOrder(TreeNode node, LinkedList<TreeNode> list){
        if (node == null)
            return;
        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

}
