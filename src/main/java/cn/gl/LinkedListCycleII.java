package cn.gl;

import java.util.HashSet;

public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        ListNode node = detectCycle(n1);
        System.out.println();
    }

    /**
     * 额外空间做法
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        set.add(temp);
        temp = temp.next;
        while (temp != null && !set.contains(temp)) {
            set.add(temp);
            temp = temp.next;
        }
        if (temp == null)
            return null;
        else {
            return temp;
        }
    }

    /**
     * 不需要额外空间做法
     */
    public static ListNode detectCycle2(ListNode head) {
        if(head == null)
            return null;
        ListNode sp = head;
        ListNode fp = head;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (sp == fp)
                break;
        }
        if (fp == null || fp.next == null)
            return null;
        sp = head;
        while (sp != fp) {
            sp = sp.next;
            fp = fp.next;
        }
        return fp;
    }
}
