package cn.gl.offer_niuke;

public class th4 {

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        th4 t = new th4();
        t.reConstructBinaryTree(pre, in);
    }

    Integer pos = 0;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        int idx = findPosition(in, pre[0]);
        if (idx == -1)
            return null;
        int[] subLeftArr = new int[idx];
        int[] subRightArr = new int[in.length - pos - 1];
        System.arraycopy(in, 0, subLeftArr, 0, idx);
        System.arraycopy(in, idx+1, subRightArr, 0, in.length - idx -1);
        pos++;
        leftAndRight(root, pre, subLeftArr, subRightArr);
        return root;
    }

    public void leftAndRight(TreeNode node, int[] pre, int[] left, int[] right){
        // add left node
        if (pos >= pre.length)
            return;
        if (left.length != 0){
            TreeNode subLeft = new TreeNode(pre[pos]);
            node.left = subLeft;
            // split left
            int idx = findPosition(left, pre[pos]);
            if (idx == -1)
                return;
            int[] subLeftArr = new int[idx];
            int[] subRightArr = new int[left.length - idx - 1];
            System.arraycopy(left, 0, subLeftArr, 0, idx);
            System.arraycopy(left, idx+1, subRightArr, 0, left.length - idx -1);
            pos++;
            leftAndRight(subLeft, pre, subLeftArr, subRightArr);
        }
        if (pos >= pre.length)
            return;
        if (right.length != 0) {
            TreeNode subRight = new TreeNode(pre[pos]);
            node.right = subRight;
            int idx = findPosition(right, pre[pos]);
            if (idx == -1)
                return;
            int[] subLeftArr = new int[idx];
            int[] subRightArr = new int[right.length - idx - 1];
            System.arraycopy(right, 0, subLeftArr, 0, idx);
            System.arraycopy(right, idx+1, subRightArr, 0, right.length - idx -1);
            pos++;
            leftAndRight(subRight, pre, subLeftArr, subRightArr);
        }
    }

    private int findPosition(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
