package cn.gl.offer_niuke;

/**
 * 二叉树的下一节点
 */
public class th7 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode p = pNode.right;
            TreeLinkNode temp = p.left;
            while (temp != null) {
                p = temp;
                temp = temp.left;
            }
            return p;
        } else if (pNode.next == null) {
            return null;
        } else if (pNode.next.left == pNode) {
            return pNode.next;
        } else {
            TreeLinkNode ppNode = pNode.next;
            TreeLinkNode curNode = pNode;
            while (curNode == ppNode.right) {
                curNode = curNode.next;
                ppNode = ppNode.next;
                if (ppNode == null)
                    return null;
            }
            return ppNode;
        }
    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
