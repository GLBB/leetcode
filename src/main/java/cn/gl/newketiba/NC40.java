package cn.gl.newketiba;

import java.util.LinkedList;

/**
 * 两个链表相加生成的链表
 */
public class NC40 {

    /**
     *
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        LinkedList<Integer> stack1 = getStack(head1);
        LinkedList<Integer> stack2 = getStack(head2);
        LinkedList<Integer> resultList = new LinkedList<>();
        int prev = 0;
        while (stack1.size() > 0 || stack2.size() > 0) {
            int v1 = getStackVal(stack1);
            int v2 = getStackVal(stack2);
            Wrapper wrapper = add(v1, v2, prev);
            resultList.addFirst(wrapper.val);
            prev = wrapper.prev;
        }
        ListNode tmpHead = new ListNode(0);
        ListNode tail = tmpHead;
        while(resultList.size() > 0) {
            int val = resultList.removeFirst();
            ListNode node = new ListNode(val);
            tail.next = node;
            tail = node;
        }
        return tmpHead.next;
    }

    private int getStackVal(LinkedList<Integer> stack) {
        if (stack.size() > 0) {
            return stack.removeLast();
        } else {
            return 0;
        }
    }

    private LinkedList<Integer> getStack(ListNode head) {
        ListNode cur = head;
        LinkedList<Integer> stack = new LinkedList<>();
        while(cur != null) {
            stack.addLast(cur.val);
            cur = cur.next;
        }
        return stack;
    }

    static class Wrapper {
        int val;
        int prev;
    }

    private Wrapper add(int v1, int v2, int prev) {
        int sum = v1 + v2 + prev;
        Wrapper wrapper = new Wrapper();
        wrapper.val = sum % 10;
        wrapper.prev = sum / 10;
        return wrapper;
    }

}
