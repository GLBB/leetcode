package cn.gl.newketiba;

/**
 * 二叉树最近公共祖先
 */
public class NC102 {

    int result = -1;
    /**
     *
     * @param root TreeNode类 
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        contains(root, o1, o2);
        return result;
    }


    private boolean contains(TreeNode node, int v1, int v2) {
        if (node == null) {
            return false;
        }

        boolean leftContains = contains(node.left, v1, v2);
        boolean rightContains = contains(node.right, v1, v2);
        if (leftContains && rightContains) {
            result = node.val;
            return false;
        }
        if ((node.val == v1 || node.val == v2) && (leftContains || rightContains)) {
            result = node.val;
            return false;
        }
        if (node.val == v1 || node.val == v2 || leftContains || rightContains) {
            return true;
        }

        return false;
    }
}
