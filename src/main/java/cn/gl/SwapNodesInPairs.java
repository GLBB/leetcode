package cn.gl;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {

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



        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode node = solution.swapPairs(n1);
        System.out.println(node);

    }


    public ListNode swapPairs(ListNode head) {
        List<ListNode> list = prepare(head);
        if (list.size() <= 1) return head;

        for (int i = 0; i < list.size(); i+=2) {
            ListNode prior = list.get(i);
            ListNode successor = null;
            if(i + 1 < list.size()) successor = list.get(i+1);
            else break;
            successor.next = prior;
            if (i+3 < list.size()) prior.next = list.get(i+3);
            else if(i+2 < list.size()) prior.next = list.get(i + 2);
            else prior.next = null;
        }
        head = list.get(1);
        return head;
    }

    private List<ListNode> prepare(ListNode head){
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        return list;
    }
}
