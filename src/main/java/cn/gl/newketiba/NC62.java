package cn.gl.newketiba;

/**
 * NC62 平衡二叉树
 */
public class NC62 {

    public boolean IsBalanced_Solution(TreeNode root) {
        getNodeLength(root);
        return balance;
    }

    boolean balance = true;

    private int getNodeLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLength = getNodeLength(node.left);
        int rightLength = getNodeLength(node.right);
        int minus = Math.abs(leftLength - rightLength);
        if (minus > 1) {
            balance = false;
        }
        int maxLength = Math.max(leftLength, rightLength);
        return maxLength + 1;
    }
}
