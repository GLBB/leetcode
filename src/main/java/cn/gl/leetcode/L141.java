package cn.gl.leetcode;

/**
 * 141. Linked List Cycle
 */
public class L141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}
