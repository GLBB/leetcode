package cn.gl.newketiba;

public class NC69 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        k--;
        while (k < 0 || pHead == null) {
            return null;
        }
        ListNode fast = pHead;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return null;
        }
        fast = fast.next;
        ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
