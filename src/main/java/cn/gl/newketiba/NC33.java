package cn.gl.newketiba;

public class NC33 {

    public static void main(String[] args) {
        
    }

    /**
     *
     * @param l1 ListNode类 
     * @param l2 ListNode类 
     * @return ListNode类
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode l1Prev = new ListNode(0);
        ListNode head = l1Prev;
        l1Prev.next = l1;
        ListNode l1P = l1Prev.next;
        ListNode l2P = l2;
        ListNode l2Pnext = l2.next;
        while (l2P != null && l1P != null) {
            if (l1P.val < l2P.val) {
                l1Prev = l1Prev.next;
                l1P = l1Prev.next;
            } else {
                l2Pnext = l2P.next;
                l2P.next = l1P;
                l1Prev.next = l2P;
                l1P = l1Prev.next;
                l2P = l2Pnext;
            }
        }
        if (l1P == null) {
            l1Prev.next = l2P;
        }
        return head.next;
    }
}
