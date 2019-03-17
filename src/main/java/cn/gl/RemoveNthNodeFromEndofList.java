package cn.gl;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null) {
            list.add(temp);
            temp = temp.next;
        }
        int targetIdx = list.size() - n;
        ListNode targetNode = list.get(targetIdx);
        if (targetIdx == 0) {
            head = head.next;
        } else {
            ListNode prior = list.get(targetIdx - 1);
            prior.next = targetNode.next;
        }
        return head;
    }
}
