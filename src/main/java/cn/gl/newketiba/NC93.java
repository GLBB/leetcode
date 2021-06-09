package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NC93 {

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        if (k <= 0 || operators == null || operators.length == 0) {
            return new int[]{};
        }
        List<Integer> resultList = new ArrayList<>();
        LRUCache cache = new LRUCache(k);
        for (int[] op : operators) {
            switch (op[0]) {
                case 1: {
                    cache.set(op[1], op[2]);
                    break;
                }
                case 2: {
                    Integer value = cache.get(op[1]);
                    resultList.add(value);
                    break;
                }
            }
        }
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    public static class LRUCache {

        private Integer capacity;

        private Node head;
        private Node tail;

        HashMap<Integer, Node> map = new HashMap<>();

        public LRUCache(Integer capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void set(Integer key, Integer value) {
            if (map.size() == capacity) {
                // remove item
                Node removeNode = tail.prev;
                if (removeNode == head) {
                    return;
                }
                Node prevNode = removeNode.prev;
                // link remove
                prevNode.next = tail;
                tail.prev = prevNode;
                // map remove
                map.remove(removeNode.key);
                // set item
                set(key, value);
            } else {
                Node node = new Node();
                node.key = key;
                node.value = value;

                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;

                map.put(key, node);
            }
        }

        public Integer get(Integer key) {
            //  move to head
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                Node prevNode = node.prev;
                Node behindNode = node.next;
                // remove link
                prevNode.next = behindNode;
                behindNode.prev = prevNode;
                // add head
                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;
            }
            return node.value;
        }

    }

    public static class Node {
        Integer key;
        Integer value;
        Node next;
        Node prev;
    }
}
