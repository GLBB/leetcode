package cn.gl.newketiba;

/**
 * NC70 单链表的排序
 */
public class NC70 {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        ListNode tempHead = new ListNode(0);
        ListNode tail = tempHead;
        while (head != null) {
            ListNode minPrev = null;
            ListNode min = head;
            ListNode cur = head.next;
            ListNode curPrev = head;
            while (cur != null) {
                if (cur.val < min.val) {
                    min = cur;
                    minPrev = curPrev;
                }
                cur = cur.next;
                curPrev = curPrev.next;
            }
            // remove
            if (minPrev == null) {
                // remove head
                head = head.next;
            } else {
                minPrev.next = min.next;
            }
            tail.next = min;
            tail = tail.next;
            tail.next = null;
        }
        return tempHead.next;
    }
}
