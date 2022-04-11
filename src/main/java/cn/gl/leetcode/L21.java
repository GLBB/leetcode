package cn.gl.leetcode;

/**
 * 21. 合并两个有序链表
 */
public class L21 {

    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode();
        ListNode tail = tempHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                ListNode temp = cur1;
                cur1 = cur1.next;
                temp.next = null;
                tail.next = temp;
                tail = temp;
            } else {
                ListNode temp = cur2;
                cur2 = cur2.next;
                temp.next = null;
                tail.next = temp;
                tail = temp;
            }
        }

        if (cur1 == null) {
            tail.next = cur2;
        } else {
            tail.next = cur1;
        }

        return tempHead.next;

    }
}
