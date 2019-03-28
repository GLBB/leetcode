package cn.gl;


/**
 * 网上的代码
 * 目前还未看懂
 * 来日再看
 * KO
 */
public class SortList2 {

    private class MergeHelper {
        public ListNode newHead;
        public ListNode newTail;
    }
    public ListNode sortList(ListNode head) {
        if ( head == null || head.next == null) {
            return head;
        }

        ListNode dummyHeadOne = new ListNode(0);
        ListNode dummyHeadTwo = new ListNode(0);
        ListNode dummySortedHead = new ListNode(0);
        ListNode dummySortedLast = dummySortedHead;
        ListNode unvisitedNode = head;
        MergeHelper mergeRst = new MergeHelper();

        int listLength = 0;
        int level = 0;
        while ( unvisitedNode != null && unvisitedNode.next != null ) {
            unvisitedNode = addNode ( dummyHeadOne, unvisitedNode, 1<<level);
            unvisitedNode = addNode ( dummyHeadTwo, unvisitedNode, 1<<level);
            merge ( dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
            dummySortedLast.next = mergeRst.newHead;
            dummySortedLast = mergeRst.newTail;
            listLength += 2;
        }
        if (unvisitedNode != null) {
            dummySortedLast.next = unvisitedNode;
            listLength ++;
        }
        level ++;

        while ( listLength > 1 << level) {
            dummySortedLast = dummySortedHead;
            unvisitedNode = dummySortedHead.next;
            while (unvisitedNode != null) {
                unvisitedNode = addNode ( dummyHeadOne, unvisitedNode, 1<<level);
                unvisitedNode = addNode ( dummyHeadTwo, unvisitedNode, 1<<level);
                merge ( dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
                dummySortedLast.next = mergeRst.newHead;
                dummySortedLast = mergeRst.newTail;
            }
            level ++;
        }

        return dummySortedHead.next;
    }

    /* merge listOne and listTwo.
    Save the sorted list head into rst.newHead
    Save the last node of the sorted list into rst.newTail
    */
    private void merge (ListNode listOne, ListNode listTwo, MergeHelper rst) {
        ListNode dummyHead = new ListNode (0);
        ListNode lastNode = dummyHead;
        while (listOne != null && listTwo != null) {
            if ( listOne.val < listTwo.val ) {
                lastNode.next = listOne;
                listOne = listOne.next;
            } else {
                lastNode.next = listTwo;
                listTwo = listTwo.next;
            }
            lastNode = lastNode.next;
        }

        while (listOne != null) {
            lastNode.next = listOne;
            listOne = listOne.next;
            lastNode = lastNode.next;
        }
        while ( listTwo != null ) {
            lastNode.next = listTwo;
            listTwo = listTwo.next;
            lastNode = lastNode.next;
        }
        rst.newHead = dummyHead.next;
        rst.newTail = lastNode;
    }

    /*
     add at max #"count" nodes into "head" from "source"
     return the new position of source after adding.
    */
    private ListNode addNode ( ListNode head, ListNode source, int count ) {
        while (count > 0 && source != null) {
            head.next = source;
            head = head.next;
            source = source.next;
            count --;
        }
        head.next = null;
        return source;
    }

}
