package cn.gl.leetcode;

/**
 * 25. K 个一组翻转链表
 */
public class L25 {

    static class ListNode {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        fakeHead.next = tail;

        ListNode cur = head;
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (nextHead != null) {
                nextHead = nextHead.next;
            } else {
                return head;
            }
        }

        while (nextHead != null) {
            // reverse cur
            ListNode curNext = cur.next;
            ListNode tempTail = cur;
            ListNode tempHead = new ListNode(0);
            while (cur != nextHead) {
                cur.next = tempHead.next;
                tempHead.next = cur;
                cur = curNext;
                curNext = curNext.next;
            }
            tail.next = tempHead.next;
            tail = tempTail;

            cur = nextHead;
            int i = 0;
            while (i < k && nextHead != null) {
                i++;
                nextHead = nextHead.next;
            }
        }

        boolean surplusK = false;
        ListNode tempCur = cur;
        int count = 0;
        while (tempCur != null) {
            count += 1;
            tempCur = tempCur.next;
        }

        if (count == k) {
            ListNode tempHead = new ListNode(0);
            while (cur != null) {
                ListNode curNext = cur.next;
                cur.next = tempHead.next;
                tempHead.next = cur;
                cur = curNext;
            }
            tail.next = tempHead.next;
        } else {
            tail.next = cur;
        }

        return fakeHead.next;
    }
}
