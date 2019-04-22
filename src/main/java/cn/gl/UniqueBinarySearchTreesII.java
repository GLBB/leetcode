package cn.gl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return Collections.emptyList();
        return toTree(1, n);
    }

    public List<TreeNode> toTree(int start, int end){
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start == end){
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }else if (start > end){
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = toTree(start, i - 1);
            List<TreeNode> rights = toTree(i + 1, end);
            for (TreeNode left: lefts){
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
