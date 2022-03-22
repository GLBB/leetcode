package cn.gl.leetcode;

import java.util.HashMap;

/**
 * 146. LRU 缓存
 */
public class L146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }

    static class LRUCache {

        static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity = 0;

        private HashMap<Integer, Node> map = new HashMap<>(capacity);

        private Node head = new Node(0, 0);
        private Node tail = new Node(0, 0);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            // get key value
            // remove node from linkedlist
            // add to head
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            removeNodeFromList(node);
            addNodeToHead(node);
            return node.value;
        }

        private void addNodeToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void removeNodeFromList(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        public void put(int key, int value) {
            // if map contains key
            //   update key value
            //   remove node from linkedlist
            //   add to head
            // else map not contains key && map.size == capacity
            //   get linkledlist last
            //   remove from map
            //   remove from linkedlist
            //   add new key value to map
            //   add new key value to linkedlist head
            // else -> not contains key
            //   add new key value to linkedlist head
            //   put map key value
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                get(key);
            } else if (!map.containsKey(key) && map.size() == capacity) {
                Node lastNode = tail.prev;
                removeNodeFromList(lastNode);
                map.remove(lastNode.key);
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addNodeToHead(newNode);
            } else {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addNodeToHead(newNode);
            }
        }
    }
}
