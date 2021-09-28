package cn.gl.newketiba;

/**
 * NC5 二叉树根节点到叶子节点的所有路径和
 */
public class NC5 {

    public int sumNumbers (TreeNode root) {
        // write code here
        sumNumHelper(root, "");
        return sum;
    }

    int sum = 0;

    public void sumNumHelper(TreeNode node, String prefix) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(prefix + node.val);
        }
        sumNumHelper(node.left, prefix + node.val);
        sumNumHelper(node.right, prefix + node.val);

    }
}
