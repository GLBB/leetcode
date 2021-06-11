package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树前中后序遍历
 */
public class NC45 {

    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> mid = new ArrayList<Integer>();
        List<Integer> last = new ArrayList<Integer>();
        preOrder(root, pre);
        midleOrder(root, mid);
        laterOrder(root, last);
        int[][] result = new int[3][];
        result[0] = list2Array(pre);
        result[1] = list2Array(mid);
        result[2] = list2Array(last);
        return result;
    }

    private int[] list2Array(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void preOrder(TreeNode node, List<Integer> result){
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    private void midleOrder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        midleOrder(node.left, result);
        result.add(node.val);
        midleOrder(node.right, result);
    }

    private void laterOrder(TreeNode node, List<Integer> result) {
        TreeNode cur = node;
        TreeNode pre = null;
        LinkedList<TreeNode> stack = new LinkedList();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                TreeNode peek = stack.peek();
                if (peek.right != null && pre != peek.right) {
                    cur = peek.right;
                } else {
                    stack.pop();
                    result.add(peek.val);
                    pre = peek;
                    cur = null;
                }
            }
        }
    }
}
