package cn.gl;

import java.util.List;

/**
 * 快排思路
 * 错误
 * -1->5->3->4->0
 *  不知道如何更新之前的节点的 next 指针
 *
 *  */
public class SortList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = sortList(n1);
        System.out.println();
    }

    public static ListNode sortList(ListNode head) {
        ListNode sort = sort(head, null, head);
        return sort;
    }
//    static ListNode tempHead = null;
    public static ListNode sort(ListNode fromNode, ListNode toNode, ListNode prev){
        if (fromNode == toNode || fromNode.next == toNode)
            return fromNode;
        ListNode temp = fromNode.next;
        ListNode pivotNode = fromNode;
        pivotNode.next = null;
        ListNode minHead = null, minTail = minHead, ghead=null, gtail = ghead;
        while (temp != null && temp != toNode) {
            if (temp.val >= pivotNode.val) {
                if(ghead==null) {
                    ghead = temp;
                    gtail = temp;
                    temp = temp.next;
                    if (gtail.next != toNode)
                        gtail.next = null;
                } else {
                    gtail.next = temp;
                    temp = temp.next;
                    gtail = gtail.next;
                    if (gtail.next != toNode)
                        gtail.next = null;
                }
            }else {
                if (minHead == null) {
                    minHead = temp;
                    minTail = temp;
                    temp = temp.next;
                    if (minTail.next != toNode)
                        minTail.next = null;
                }else {
                    minTail.next = temp;
                    minTail = minTail.next;
                    temp = temp.next;
                    if (minTail.next != toNode)
                        minTail.next = null;
                }
            }
        }
        // merge
        if (minHead != null) {
            minTail.next = pivotNode;
            pivotNode.next = ghead;
            prev = minHead;
//            tempHead = minHead;
            sort(minHead, pivotNode, prev);
            if (gtail == null) {
                sort(pivotNode.next, null, pivotNode);
            }else {
                sort(pivotNode.next, gtail.next, pivotNode);
            }
            return minHead;
        }else {
            pivotNode.next = ghead;
//            tempHead = pivotNode;
            if (gtail == null) {
                sort(pivotNode.next, null, pivotNode);
            }else {
                sort(pivotNode.next, gtail.next, pivotNode);
            }
            return pivotNode;
        }


    }




}
