package cn.gl.newketiba;

import java.util.HashSet;

public class NC66 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = pHead2;
        while(cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        ListNode result = null;
        cur = pHead1;

        while(cur != null && !set.contains(cur)) {
            cur = cur.next;
        }

        if (set.contains(cur)) {
            result = cur;
        }
        return cur;
    }
}
