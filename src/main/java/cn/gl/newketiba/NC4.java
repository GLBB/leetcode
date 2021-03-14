package cn.gl.newketiba;

public class NC4 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
