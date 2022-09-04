package cn.gl.leetcode;

/**
 * 142. 环形链表 II
 */
public class L142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode mark = null;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                mark = slow;
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        slow = head;
        while (slow != mark) {
            slow = slow.next;
            mark = mark.next;
        }
        return mark;
    }
    
}
