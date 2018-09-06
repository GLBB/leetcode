package cn.gl;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        boolean carry = false;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val;
            if (carry){
                sum += 1;
                carry = false;
            }
            if (sum >= 10) {
                sum = sum%10;
                carry = true;
            }
            ListNode listNode = new ListNode(sum);
            if (tail == null){
                tail = listNode;
                head = listNode;
            }else {
                tail.next = listNode;
                tail = listNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int sum = l1.val;
            if (carry){
                sum ++;
                carry = false;
            }
            if (sum >= 10) {
                sum = sum%10;
                carry = true;
            }
            ListNode listNode = new ListNode(sum);
            tail.next = listNode;
            tail = listNode;
            l1 = l1.next;
        }

        while (l2 != null){
            int sum = l2.val;
            if (carry){
                sum ++;
                carry = false;
            }
            if (sum >= 10) {
                sum = sum%10;
                carry = true;
            }
            ListNode listNode = new ListNode(sum);
            tail.next = listNode;
            tail = listNode;
            l2 = l2.next;
        }

        if (carry){
            ListNode node = new ListNode(1);
            tail.next = node;
            tail = node;
        }

        return head;
    }
}


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println();
    }


}
