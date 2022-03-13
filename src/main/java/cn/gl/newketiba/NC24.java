package cn.gl.newketiba;

/**
 * NC24 删除有序链表中重复的元素-II
 */
public class NC24 {

    /**
     * int null how
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode cur = tempHead;
        while (cur != null) {
            ListNode curN = cur.next;
            if (curN == null) {
                break;
            }
            ListNode curNN = curN.next;
            if (curNN == null) {
                break;
            }

            if (curN.val == curNN.val) {
                int x = curN.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }

        }

        return tempHead.next;


    }
}
