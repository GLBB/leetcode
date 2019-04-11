package cn.gl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null)
            return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Node> tempQueue = new ArrayList<>();
            while (!queue.isEmpty()){
                Node pop = queue.pop();
                if (pop.left != null){
                    tempQueue.add(pop.left);
                    tempQueue.add(pop.right);
                }
            }
            for (int i = 0; i <= tempQueue.size()-2; i++) {
                Node left = tempQueue.get(i);
                Node right = tempQueue.get(i + 1);
                left.next = right;
            }
            queue.addAll(tempQueue);
        }
        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}