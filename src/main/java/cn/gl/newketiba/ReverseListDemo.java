package cn.gl.newketiba;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}

public class ReverseListDemo {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode headNext = head.next;
        ListNode newHead = null;
        while (head != null) {
            head.next = newHead;
            newHead = head;
            head = headNext;
            if (headNext != null) {
                headNext = headNext.next;
            }
        }
        return newHead;
    }

}
