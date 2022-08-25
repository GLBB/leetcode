package cn.gl.leetcode;

public class L160 {
    /**
     * 2
     * [1,9,1,2,4]
     * [3,2,4]
     * 3
     * 1
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);

        ListNode l6 = new ListNode(3);
        
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        
        l6.next = l4;

        ListNode intersectionNode = new L160().getIntersectionNode(l1, l6);
        System.out.println();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA = headA;
        ListNode cursorB = headB;

        while (cursorA != null && cursorB != null) {
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }

        ListNode cursorA2 = headA;
        while (cursorA != null) {
            cursorA = cursorA.next;
            cursorA2 = cursorA2.next;
        }

        ListNode cursorB2 = headB;
        while (cursorB != null) {
            cursorB = cursorB.next;
            cursorB2 = cursorB2.next;
        }


        while (cursorA2 != null && cursorB2 != null && cursorA2 != cursorB2) {
            cursorA2 = cursorA2.next;
            cursorB2 = cursorB2.next;
        }

        if (cursorA2 != null && cursorA2 == cursorB2) {
            return cursorA2;
        } else {
            return null;
        }
    }
}
