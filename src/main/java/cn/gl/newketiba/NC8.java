package cn.gl.newketiba;

import java.util.ArrayList;

/**
 * 二叉树根节点到叶子节点和为指定值的路径
 */
public class NC8 {

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here 
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        pathSumHelp(root, list, result, sum, 0);
        return result;
    }

    private void pathSumHelp(TreeNode node, ArrayList<Integer> list,
                             ArrayList<ArrayList<Integer>> result, int sum,
                             int curSum)  {
        if (node == null) {
            return;
        }
        curSum = curSum + node.val;
        list.add(node.val);
        if (curSum == sum && node.left == null && node.right == null) {
            ArrayList<Integer> tempList = new ArrayList<Integer>(list);
            result.add(tempList);
        }
        pathSumHelp(node.left, list, result, sum, curSum);
        pathSumHelp(node.right, list, result, sum, curSum);
        list.remove(list.size() - 1);
        curSum = curSum - node.val;
    }
}
