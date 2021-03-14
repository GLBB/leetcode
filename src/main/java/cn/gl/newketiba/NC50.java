package cn.gl.newketiba;

public class NC50 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        int k = 3;
        ListNode head = reverseKGroup(n1, k);
        System.out.println();
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null || k <= 1) {
            return head;
        }
        ListNode fast = head;
        ListNode nextSegmentHead = null;
        ListNode slow = head;
        Wrapper firstWrapper = null;
        Wrapper lastWrapper = null;
        while (fast != null) {
            int tempK = k;
            while (--tempK > 0 && fast != null) {
                fast = fast.next;
            }
            if (fast == null) {
                if (lastWrapper != null) {
                    lastWrapper.tail.next = slow;
                }
                break;
            }
            nextSegmentHead = fast.next;
            fast.next = null;
            Wrapper curWrapper = reverseGroup(slow);
            if (slow == head) {
                firstWrapper = curWrapper;
                lastWrapper = curWrapper;
            }
            slow = nextSegmentHead;
            fast = nextSegmentHead;
            if (lastWrapper == curWrapper) {
                continue;
            }
            lastWrapper.tail.next = curWrapper.head;
            lastWrapper = curWrapper;
        }
        return firstWrapper == null ? head : firstWrapper.head;
    }

    private static Wrapper reverseGroup(ListNode head) {
        if (head == null) {
            return new Wrapper();
        }
        ListNode tail = head;
        ListNode newHead = null;
        ListNode headNext = head.next;
        while (head != null) {
            head.next = newHead;
            newHead = head;
            head = headNext;
            if (headNext != null)
                headNext = headNext.next;
        }
        Wrapper wrapper = new Wrapper();
        wrapper.head = newHead;
        wrapper.tail = tail;
        return wrapper;
    }

    public static class Wrapper {
        ListNode head;
        ListNode tail;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
