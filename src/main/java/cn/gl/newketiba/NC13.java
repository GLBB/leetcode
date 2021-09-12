package cn.gl.newketiba;

/**
 * NC13 二叉树的最大深度
 */
public class NC13 {

    public int maxDepth (TreeNode root) {
        // write code here
        int maxDepth = maxDepthHelp(root);
        return maxDepth;
    }

    private int maxDepthHelp(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLength = maxDepth(node.left);
        int rightLength = maxDepth(node.right);
        int maxLength = Math.max(leftLength, rightLength);
        return maxLength + 1;
    }
}
