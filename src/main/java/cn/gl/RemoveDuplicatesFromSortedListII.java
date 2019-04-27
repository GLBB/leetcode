package cn.gl;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode node = deleteDuplicates(n1);
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode th = new ListNode(0);
        th.next = head;
        ListNode prev = th;
        ListNode cur = head;
        while (cur != null){
            ListNode curNext = cur.next;
            boolean flag = false;
            while (curNext != null && curNext.val == cur.val){
                curNext = curNext.next;
                flag = true;
            }
            if (flag) {
                prev.next = curNext;
                if (curNext == null)
                    cur = null;
                else
                    cur = prev.next;
            }else {
                cur = curNext;
                prev = prev.next;
            }

        }
        return th.next;
    }

}
