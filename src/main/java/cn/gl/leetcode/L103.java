package cn.gl.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        boolean leftToRight = true;

        while(!layer.isEmpty()) {
            ArrayList<TreeNode> nextLayer = new ArrayList<>();
            for(TreeNode node: layer) {
                if (node.left != null) {
                    nextLayer.add(node.left);
                }

                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }

            ArrayList<Integer> layerValues = new ArrayList<>();
            if (leftToRight) {
                leftToRight = false;
                for (TreeNode node : layer) {
                    layerValues.add(node.val);
                }
            } else {
                leftToRight = true;
                for (int i = layer.size() - 1; i >= 0; i--) {
                    TreeNode temp = layer.get(i);
                    layerValues.add(temp.val);
                }
            }

            result.add(layerValues);
            layer = nextLayer;
        }

        return result;
    }
}
