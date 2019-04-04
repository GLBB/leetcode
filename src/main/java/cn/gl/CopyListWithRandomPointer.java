package cn.gl;

import java.util.HashMap;

/**
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap();
        Node ah = new Node();
        ah.val = head.val;
        map.put(head, ah);

        Node pioneer = ah;
        Node iterator = head.next;
        while (iterator != null) {
            Node node = new Node();
            node.val = iterator.val;
            pioneer.next = node;
            pioneer = pioneer.next;
            map.put(iterator, node);
            iterator = iterator.next;
        }

        iterator = head;
        while (iterator!=null) {
            if (iterator.random == null){
                iterator = iterator.next;
                continue;
            }
            Node node = map.get(iterator);
            Node temp = map.get(iterator.random);
            node.random = temp;
            iterator = iterator.next;
        }
        return ah;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;
        public Node() {}
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
