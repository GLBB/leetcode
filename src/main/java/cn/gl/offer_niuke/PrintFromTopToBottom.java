package cn.gl.offer_niuke;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addLast(root);
        while (queue.size() > 0) {
            TreeNode treeNode = queue.removeFirst();
            if (treeNode == null){
                continue;
            }
            res.add(treeNode.val);
            queue.add(treeNode.left);
            queue.add(treeNode.right);
        }
        return res;
    }
}
