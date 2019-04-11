package cn.gl;

import java.util.ArrayList;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeII {

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
                }
                if (pop.right != null) {
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
