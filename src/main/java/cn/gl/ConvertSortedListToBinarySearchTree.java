package cn.gl;

import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        TreeNode treeNode = sortedListToBST(n1);
        System.out.println();
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        Result r = findMiddle(head);
        if (r.middle != null) {
            int v = r.middle.val;
            TreeNode root = new TreeNode(v);
            toTreeNode(root, r.l, r.r);
            return root;
        }
        return null;
    }

    public static TreeNode toTreeNode(TreeNode p, ListNode left, ListNode right){
        Result lSubR = findMiddle(left);
        Result rSubR = findMiddle(right);
        if (lSubR.middle != null) {
            int lv = lSubR.middle.val;
            TreeNode lSub = new TreeNode(lv);
            p.left = lSub;
            toTreeNode(lSub, lSubR.l, lSubR.r);
        }
        if (rSubR.middle != null) {
            int rv = rSubR.middle.val;
            TreeNode rSub = new TreeNode(rv);
            p.right = rSub;
            toTreeNode(rSub, rSubR.l, rSubR.r);
        }
        return p;
    }



    public static Result findMiddle(ListNode h){
        if (h==null)
            return new Result();
        ListNode f = h, s = h;
        ListNode middlerPivot = null;
        while (f.next != null && f.next.next!=null) {
            middlerPivot = s;
            s = s.next;
            f = f.next.next;
        }
        Result result = new Result();
        result.middle = s;
        if (middlerPivot == null) {
            result.r = h.next;
            h.next = null;
        }else {
            result.l = h;
            middlerPivot.next = null;
            result.r = s.next;
            s.next = null;
        }
        return result;
    }

    static class Result{
        ListNode middle;
        ListNode l;
        ListNode r;
    }

}
