package cn.gl.newketiba;

public class NC53 {
    /**
     *
     * @param head ListNode类 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if (head == null)
            return null;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return head.next;
        }
        ListNode pNode = head;
        ListNode ppNode = new ListNode(0);
        ppNode.next = head;
        while(cur != null) {
            cur = cur.next;
            pNode = pNode.next;
            ppNode = ppNode.next;
        }
        ppNode.next = pNode.next;
        return head;
    }
}
