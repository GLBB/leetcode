package cn.gl;

public class InsertionSortList {

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
        ListNode node = insertionSortList(n1);
        System.out.println();
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode temp = head.next;
        ListNode tempPrior = head;
        while (temp != null) {
            ListNode tempTemp = temp.next;

            ListNode prior = fakeHead;
            ListNode sortPoint = fakeHead.next;
            while(sortPoint != null && temp.val > sortPoint.val && sortPoint != temp) {
                prior = prior.next;
                sortPoint = sortPoint.next;
            }
            if (sortPoint== temp){

            }else {
                // 删除 temp
                tempPrior.next = temp.next;
                temp.next = sortPoint;
                prior.next = temp;
            }

            temp = tempTemp;
            tempPrior = findPrior(temp, fakeHead);
        }
        return fakeHead.next;
    }

    private static ListNode findPrior(ListNode temp, ListNode fakeNode) {
        ListNode iterator = fakeNode.next;
        ListNode prior = fakeNode;
        while (iterator!=null && iterator!=temp){
            iterator = iterator.next;
            prior = prior.next;
        }
        return prior;
    }
}
