package cn.gl.leetcode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class L236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private TreeNode ans = null;

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean leftResult = dfs(node.left, p, q);
        boolean rightResult = dfs(node.right, p, q);
        if (leftResult && rightResult) {
            ans = node;
        } else if ((leftResult || rightResult) && (node.val == p.val || node.val == q.val)) {
            ans = node;
        }
        return leftResult || rightResult || node.val == p.val || node.val == q.val;

    }
    
}
