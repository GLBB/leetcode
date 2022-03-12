package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.List;

/**
 * NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 */
public class NC60 {

    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if (root == null) {
            return new boolean[]{true, true};
        } else {
            return new boolean[]{judgeSearchTree(root), judgeCompleteTree(root)};
        }
    }

    public boolean judgeCompleteTree(TreeNode node) {
        List<TreeNode> layerList = new ArrayList<>();
        layerList.add(node);
        while (!layerList.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            List<TreeNode> nextLayer = new ArrayList<>();
            for (TreeNode elem : layerList) {
                tempList.add(elem.left);
                tempList.add(elem.right);
                if (elem.left != null) {
                    nextLayer.add(elem.left);
                }
                if (elem.right != null) {
                    nextLayer.add(elem.right);
                }
            }
            boolean containNull = false;
            for (TreeNode elem : tempList) {
                if (elem == null) {
                    containNull = true;
                } else if (containNull && elem != null) {
                    return false;
                }
            }
            layerList = nextLayer;
        }
        return true;
    }

    private boolean judgeSearchTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midTraverse(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i -1)) {
                return false;
            }
        }
        return true;
    }

    public void midTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            midTraverse(root.left, list);
            list.add(root.val);
            midTraverse(root.right, list);
        }
    }
}
