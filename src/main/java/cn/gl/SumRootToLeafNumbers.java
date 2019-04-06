package cn.gl;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int sum = sum(root, 0);
        return sum;
    }

    public int sum(TreeNode node, int sum) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return sum * 10 + node.val;
        int left = sum(node.left, sum*10 + node.val);
        int right = sum(node.right, sum*10 + node.val);
        return left + right;
    }


}
