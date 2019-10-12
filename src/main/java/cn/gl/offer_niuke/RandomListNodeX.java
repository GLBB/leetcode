package cn.gl.offer_niuke;


import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListNodeX {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode head = new RandomListNode(pHead.label);
        map.put(pHead, head);
        RandomListNode tail = head;
        RandomListNode temp = pHead.next;
        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            tail.next = node;
            tail = tail.next;
            map.put(temp, node);
            temp = temp.next;
        }
        temp = pHead;
        RandomListNode temp2 = head;
        while (temp != null) {
            RandomListNode randomListNode = map.get(temp.random);
            temp2.random =  randomListNode;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head;
    }
}
