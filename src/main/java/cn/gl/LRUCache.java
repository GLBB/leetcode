package cn.gl;

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int r1 = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        int r2 = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        int r3 = cache.get(1);       // returns -1 (not found)
        int r4 =  cache.get(3);       // returns 3
        int r5 = cache.get(4);       // returns 4
        System.out.printf("%d  %d  %d  %d  %d",r1,r2,r3,r4,r5);

    }


    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head, tail;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        deleteNode(node);
        addNode2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            move2Head(node);
        }else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            // 添加到 head
            addNode2Head(node);
            // 添加到 map 中
            map.put(key, node);
            // if capacity 满了 移除尾节点的前一个
            if (map.size() == capacity+1) {
                Node temp = tail.prev;
                deleteNode(temp);
                map.remove(temp.key);
            }
        }
    }

    private void move2Head(Node node) {
        deleteNode(node);
        addNode2Head(node);

    }

    private void deleteNode(Node node){
        // 先移除节点
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }

    private void addNode2Head(Node node){
        // 在添加到节点头部
        Node oldFirst = head.next;
        oldFirst.prev = node;
        node.next = oldFirst;
        head.next = node;
        node.prev = head;
    }
}
