package cn.gl.newketiba;

/**
 * 判断一个链表是否为回文结构
 */
public class NC96 {

    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        // revers
        ListNode h2 = null;
        ListNode startNode = slow.next;
        ListNode markNode = startNode.next;
        slow.next = null;
        while (startNode != null) {
            startNode.next = h2;
            h2 = startNode;
            startNode = markNode;
            if (markNode != null) {
                markNode = markNode.next;
            }

        }
        ListNode cur2 = h2;
        ListNode cur1 = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val == cur2.val) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
