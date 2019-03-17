package cn.gl;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);
        ListNode node = solution.mergeTwoLists(l1, l2);
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            System.out.println("l1 or l2 is null");
        }
        if (l1 == null && l2 == null) return null;

        ListNode head,tail, temp1 = l1, temp2 = l2;
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head = new ListNode(l1.val);
                temp1 = l1.next;
                tail = head;
            } else {
                head = new ListNode(l2.val);
                temp2 = l2.next;
                tail = head;
            }
        } else if (l1 != null) {
            return l1;
        } else return l2;


        while (temp1!=null && temp2!=null){
            ListNode node;
            if (temp1.val < temp2.val) {
                node = new ListNode(temp1.val);
                temp1 = temp1.next;
            }else{
                node = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            tail.next = node;
            tail = tail.next;
        }

        while (temp1 != null) {
            ListNode node = new ListNode(temp1.val);
            tail.next = node;
            tail = tail.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            ListNode node = new ListNode(temp2.val);
            tail.next = node;
            tail = tail.next;
            temp2 = temp2.next;
        }

        return head;
    }
}
