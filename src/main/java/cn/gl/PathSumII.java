package cn.gl;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, sum, list, res);
        return res;
    }

    public static void dfs(TreeNode node, int partialSum, int sum, ArrayList<Integer> list, List<List<Integer>> res) {
        if (node == null)
            return;
        list.add(node.val);
        if (partialSum + node.val == sum && node.left==null && node.right == null) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            res.add(temp);
        }
        dfs(node.left, partialSum+node.val, sum,list, res);
        dfs(node.right, partialSum+node.val, sum,list, res);
        list.remove(list.size()-1);
    }


}
