package cn.gl;

public class ReorderList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reorderList(n1);
        System.out.println();
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // step fast slow
        ListNode fp = head;
        ListNode sp = head;
        while (fp.next != null && fp.next.next != null) {
            fp = fp.next.next;
            sp =  sp.next;
        }

        // step 2
        ListNode pc = sp.next;
        while (pc.next != null) {
            ListNode cur = pc.next;
            pc.next = cur.next;
            cur.next = sp.next;
            sp.next = cur;
        }

        // step 3
        ListNode pre = head;
        while (pre != sp) {
            ListNode cur = sp.next;
            sp.next = sp.next.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = pre.next.next;
        }

    }
}
