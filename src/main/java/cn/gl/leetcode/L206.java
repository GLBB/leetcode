package cn.gl.leetcode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class L206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        ListNode fakeHead = new ListNode(0);
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = fakeHead.next;
            fakeHead.next = cur;
            cur = curNext;
        }

        return fakeHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
