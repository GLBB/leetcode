package cn.gl.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 102. 二叉树的层序遍历
 */
public class L102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> layer = new LinkedList<>();
        layer.add(root);

        while (!layer.isEmpty()) {
            LinkedList<TreeNode> nextLayer = new LinkedList<>();
            for (TreeNode node : layer) {
                if (node.left != null) {
                    nextLayer.addLast(node.left);
                }

                if (node.right != null) {
                    nextLayer.addLast(node.right);
                }
            }

            List<Integer> values = layer.stream().map(n -> n.val).collect(Collectors.toList());
            result.add(values);
            layer = nextLayer;
        }
        return result;
    }
}
