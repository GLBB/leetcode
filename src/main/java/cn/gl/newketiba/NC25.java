package cn.gl.newketiba;

/**
 * NC25 删除有序链表中重复的元素-I
 */
public class NC25 {

    /**
     *
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if (cur.val == next.val) {
                ListNode nnext = next.next;
                cur.next = nnext;
                next = cur.next;
            } else {
                cur = next;
                next = next.next;
            }
        }
        return head;
    }
}
