package cn.gl;

public class ReverseLinkedListII {

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
        ListNode node = reverseBetween(n1, 2, 4);
        System.out.println();
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        int c = 1;
        ListNode temp = head;
        ListNode th = new ListNode(0);
        th.next = head;
        ListNode prev = th;
        while (c < m){
            c++;
            temp = temp.next;
            prev = prev.next;
        }
        ListNode tail = temp;
        if (m < n) {
            ListNode g = temp.next;
            ListNode p = null;
            while (c <= n){
                temp.next = p;
                p = temp;
                temp = g;
                if (g != null && c!=n) {
                    g = g.next;
                }else {
//                    break;
                }
                c++;
            }
            prev.next = p;
            tail.next = g;
        }
        return th.next;
    }

}
