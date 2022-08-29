package cn.gl.leetcode;

/**
 * 23. 合并K个升序链表
 */
public class L23 {

    public ListNode mergeKLists(ListNode[] lists) {
        // check
        ListNode head = new ListNode();
        ListNode tail = head;
        boolean flag = true;
        while(flag) {
            Integer minIdx = null;
            Integer minValue = null;
            int curIdx = 0;

            boolean allNull = true;
            while (curIdx < lists.length) {
                // curIdx ++, flag = false
                if (lists[curIdx] != null && (minValue == null || minValue > lists[curIdx].val)) {
                    minIdx = curIdx;
                    minValue = lists[curIdx].val;
                    allNull = false;
                }
                curIdx++;
            }
            if (allNull) {
                break;
            }

            ListNode minNode = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
            minNode.next = null;

            tail.next = minNode;
            tail = minNode;
        }
        return head.next;
    }
}
