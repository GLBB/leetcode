package cn.gl.newketiba;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历
 */
public class NC15 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        while (!layer.isEmpty()) {
            ArrayList<Integer> layerValues = new ArrayList<>();
            ArrayList<TreeNode> layerNode = new ArrayList<>();
            for (TreeNode node : layer) {
                layerValues.add(node.val);
                if (node.left != null) {
                    layerNode.add(node.left);
                }
                if (node.right != null) {
                    layerNode.add(node.right);
                }
            }
            layer = layerNode;
            result.add(layerValues);
        }
        return result;
    }
}
