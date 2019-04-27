package cn.gl;

import java.util.List;

public class PartitionList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode partition = partition(n1, 3);
        System.out.println();

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode th1 = new ListNode(0);
        ListNode t1tail = th1;
        ListNode th2 = new ListNode(0);
        ListNode t2tail = th2;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x){
                t1tail.next = temp;
                t1tail = t1tail.next;
            }else {
                t2tail.next = temp;
                t2tail = t2tail.next;
            }
            temp= temp.next;
        }
        t1tail.next = null;
        t2tail.next = null;
        t1tail.next = th2.next;
        return th1.next;
    }

}
