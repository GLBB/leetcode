package cn.gl.leetcode;

/**
 * 92. 反转链表 II
 */
public class L92 {

    public static void main(String[] args) {
        
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        prev = tempHead;
        ListNode curNode = head;
        ListNode curNodePrev = tempHead;
        int curIdx = 1;
        while (curIdx <= right) {
            if (curIdx == left) {
                prev = curNodePrev;
            }
            if(curIdx == right) {
                next = curNode.next;
            }
            curIdx++;
            curNode = curNode.next;
            curNodePrev = curNodePrev.next;
        }

        ListNode aHead = new ListNode();
        ListNode tail = prev.next;
        curNode = prev.next;
        ListNode curNodeNext = curNode.next;
        prev.next = null;
        while (curNode != next) {
            curNode.next = aHead.next;
            aHead.next = curNode;
            curNode = curNodeNext;
            if (curNodeNext == null) {
                break;
            }
            curNodeNext = curNodeNext.next;
        }
        prev.next = aHead.next;
        tail.next = next;

        return tempHead.next;
    }
}
