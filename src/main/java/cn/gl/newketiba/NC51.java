package cn.gl.newketiba;

import java.util.ArrayList;

/**
 * NC51 合并k个已排序的链表
 */
public class NC51 {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        for (int i = lists.size() - 1; i >= 0; i--) {
            ListNode node = lists.get(i);
            if (node == null) {
                lists.remove(i);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        boolean empty = false;
        while(!lists.isEmpty()) {
            int minIdx = 0;
            ListNode minNode = lists.get(0);
            for (int i = 1; i < lists.size(); i++) {
                if (minNode.val > lists.get(i).val) {
                    minNode = lists.get(i);
                    minIdx = i;
                }
            }
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next == null) {
                lists.remove(minIdx);
            } else {
                lists.set(minIdx, minNode.next);
            }

        }
        return head.next;
    }
}
