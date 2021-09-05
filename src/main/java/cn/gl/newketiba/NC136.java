package cn.gl.newketiba;

import java.util.ArrayList;

/**
 * NC136 输出二叉树的右视图
 */
public class NC136 {

    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = treeHelper(xianxu, zhongxu, 0, xianxu.length - 1);
        ArrayList<ArrayList<TreeNode>> list = new ArrayList<>();
        ArrayList<TreeNode> levelList = new ArrayList<>();
        levelList.add(root);
        while(!levelList.isEmpty()) {
            ArrayList<TreeNode> childLevel = new ArrayList<>();
            for (TreeNode node : levelList) {
                if (node.left != null) {
                    childLevel.add(node.left);
                }
                if (node.right != null) {
                    childLevel.add(node.right);
                }
            }
            list.add(levelList);
            levelList = childLevel;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i< list.size(); i++) {
            ArrayList<TreeNode> level = list.get(i);
            result[i] = level.get(level.size() - 1).val;
        }
        return result;
    }

    private static int xianxuIdx = 0;

    private static TreeNode treeHelper(int[] xianxu,
                                       int[] zhangxv, int left, int right) {
        if (xianxuIdx >= xianxu.length || left > right) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = xianxu[xianxuIdx];
        int idx = findIdx(zhangxv, left, right, xianxu[xianxuIdx]);
        if (xianxuIdx + 1 >= xianxu.length) {
            return node;
        }
        xianxuIdx++;
        node.left = treeHelper(xianxu, zhangxv, left, idx - 1);
        node.right = treeHelper(xianxu, zhangxv, idx + 1, right);
        return node;
    }

    private static int findIdx(int[] zhangxv, int left, int right, int val) {
        for (int i = left; i <= right; i++) {
            if (zhangxv[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
