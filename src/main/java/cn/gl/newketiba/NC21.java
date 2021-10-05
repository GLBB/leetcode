package cn.gl.newketiba;

public class NC21 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;
        ListNode listNode = new NC21().reverseBetween(listNode1, 1, 1);
        System.out.println();
    }
    
    /**
     *
     * @param head ListNode类 
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if (m == n) {
            return head;
        }
        ListNode tempH = new ListNode(0);
        tempH.next = head;
        ListNode cur = tempH;
        int curIdx = 1;
        while (curIdx < m) {
            curIdx++;
            cur = cur.next;
        }
        ListNode markStart = cur;
        ListNode reverseHead = null;
        if (cur == null) {
            return tempH.next;
        }
        cur = cur.next;
        ListNode markEnd = cur;
        if (cur == null) {
            return tempH.next;
        }
        ListNode curNext = cur.next;
        int count = 0;
        while (count <= n - m && cur != null) {
            cur.next = reverseHead;
            reverseHead = cur;
            cur = curNext;
            count++;
            if (curNext != null) {
                curNext = curNext.next;
            } else {
                break;
            }
        }
        markStart.next = reverseHead;
        markEnd.next = cur;
        return tempH.next;
    }
}
