package cn.gl.offer_niuke;

public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0)
            return null;
        ListNode front = head;
        ListNode behind = head;
        for (int i = 1; i < k; i++) {
            if (front != null)
                front = front.next;
            else
                return null;
        }
        while (front != null) {
            if (front.next == null)
                return behind;
            front = front.next;
            behind = behind.next;
        }
        return null;
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        else if (list1 == null && list2 == null)
            return null;
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        while (list1 != null && list2 != null) {
            ListNode temp = null;
            if (list1.val < list2.val) {
                temp = list1;
                list1 = list1.next;
            }else {
                temp = list2;
                list2 = list2.next;
            }
            temp.next = null;
            tail.next = temp;
            tail =  tail.next;
        }
        if (list1 == null) {
            tail.next = list2;
        }else {
            tail.next = list1;
        }
        return fakeHead.next;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

