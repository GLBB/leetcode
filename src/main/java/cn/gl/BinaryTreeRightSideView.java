package cn.gl;

import java.util.*;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;

        List<Integer> list = rightSideView(n1);
        System.out.println();

    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        list.add(root.val);
        LinkedList<TreeNode> tempQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            for (TreeNode node : queue) {
                if (node.left != null)
                    tempList.add(node.left);
                if (node.right != null)
                    tempList.add(node.right);
            }
            if (tempList.size() > 0) {
                TreeNode node = tempList.get(tempList.size() - 1);
                list.add(node.val);
            }
            queue.clear();
            for (TreeNode node: tempList) {
                queue.addLast(node);
            }
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
