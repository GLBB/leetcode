package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树之字型遍历
 */
public class NC14 {

    /**
     *
     * @param root TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> layerNode = new ArrayList<>();
        layerNode.add(root);
        boolean leftToRight = true;
        while (!layerNode.isEmpty()) {
            ArrayList<Integer> layerValue = new ArrayList<>();
            LinkedList<TreeNode> tempNodes = new LinkedList<>();
            if (leftToRight) {
                for (int i = 0; i < layerNode.size(); i++) {
                    TreeNode node = layerNode.get(i);
                    layerValue.add(node.val);
                    if (node.left != null) {
                       tempNodes.addLast(node.left); 
                    }
                    if (node.right != null) {
                        tempNodes.addLast(node.right);
                    }
                }
            } else {
                for (int i = layerNode.size() - 1; i >= 0; i--) {
                    TreeNode node = layerNode.get(i);
                    layerValue.add(node.val);
                    if (node.right != null) {
                        tempNodes.addFirst(node.right);
                    }
                    if (node.left != null) {
                        tempNodes.addFirst(node.left);
                    }
                }
            }
            leftToRight = leftToRight ? false : true;
            result.add(layerValue);
            layerNode = tempNodes;
        }
        return result;
    }
}
