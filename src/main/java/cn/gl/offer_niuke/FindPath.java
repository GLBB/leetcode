package cn.gl.offer_niuke;

import java.util.ArrayList;
import java.util.Comparator;

public class FindPath {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        FindPath fp = new FindPath();
        ArrayList<ArrayList<Integer>> arrayLists = fp.FindPath(n1, 22);
        System.out.println(arrayLists);
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(res, list, root, 0, target);
        Comparator<ArrayList> comparator = (list1, list2) -> {
            if (list1.size() > list2.size()) {
                return -1;
            }else if (list1.size() == list2.size()) {
                return 0;
            }else {
                return 1;
            }
        };
        res.sort(comparator);
        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
                        TreeNode curNode, int curV, int target){
        if (curNode == null)
            return;
        list.add(curNode.val);
        if (curNode.val + curV == target && curNode.left == null && curNode.right == null) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            res.add(temp);
        }else {
            helper(res, list, curNode.left, curV+curNode.val, target);
            helper(res, list, curNode.right, curV+curNode.val, target);
        }
        list.remove(list.size() - 1);
    }


}
