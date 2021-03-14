package cn.gl.newketiba;

import java.util.*;

public class LRUDemo {

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

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("k1", "v1");
        linkedHashMap.put("k2", "v2");
        linkedHashMap.put("k3", "v3");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * set和get方法的时间复杂度为O(1)
     * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
     * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
     */
    public static class LRUCache {

        private Integer capacity;

        Node head;
        Node tail;

        HashMap<Integer, Node> map = new HashMap<>();

        public LRUCache(Integer capacity) {
            this.capacity = capacity;
        }

        public void set(Integer key, Integer value) {
            if (map.size() == capacity) {
                // remove item
                if (tail == null) {
                    return;
                }
                Node prevTail = tail.prev;
                if (prevTail == null) {
                    map.remove(tail.key);
                    head = null;
                    tail = null;
                } else {
                    prevTail.next = null;
                    tail.prev = null;
                    map.remove(tail.key);
                    tail = prevTail;
                }
                // set item
                set(key, value);
            } else {
                Node node = new Node();
                node.key = key;
                node.value = value;
                if (head != null) {
                    head.prev = node;
                }
                if (tail == null) {
                    tail = node;
                }
                node.next = head;
                head = node;
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
                Node nextNode = node.next;
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
                set(key, node.value);
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
