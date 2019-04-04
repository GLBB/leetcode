package cn.gl;

import java.util.*;


/**
 * {"$id":"1",
 * "neighbors":[{"$id":"2",
 *              "neighbors":[{"$ref":"1"},{"$id":"3",
 *                                          "neighbors":[{"$ref":"2"},{"$id":"4",
 *                                                                      "neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],
 *                                        "val":3}],
 *                           "val":2},{"$ref":"4"}],
 * "val":1}
 *
 * {"$id":"1",
 * "neighbors":[{"$id":"2",
 *              "neighbors":[{"$ref":"1"},{"$id":"3",
 *                                          "neighbors":[{"$id":"4",
 *                                                     "neighbors":[{"$ref":"1"},{"$ref":"3"}],"val":4},{"$ref":"2"}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 */

public class CloneGraph {

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        n1.neighbors = new ArrayList<Node>();
        n2.neighbors = new ArrayList<Node>();
        n3.neighbors = new ArrayList<Node>();
        n4.neighbors = new ArrayList<Node>();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        Collections.addAll(n1.neighbors,  n2, n4);
        Collections.addAll(n2.neighbors,  n1, n3);
        Collections.addAll(n3.neighbors,  n2, n4);
        Collections.addAll(n4.neighbors,  n1, n3);

        Node node = cloneGraph(n1);
        System.out.println();

    }

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);

        Set<Node> keys = map.keySet();
        for (Node key : keys) {
            // cn : clone node, nb: node neiborrs, cnb: clone node
            Node cn = map.get(key);
            if (key.neighbors == null)
                continue;
            if (cn.neighbors == null)
                cn.neighbors = new ArrayList<>();
            for (Node nb : key.neighbors) {
                if (nb.neighbors == null)
                    continue;
                Node cnb = map.get(nb);
                if (cnb.neighbors == null)
                    cnb.neighbors = new ArrayList<>();
                if (!cn.neighbors.contains(cnb)){
                    cn.neighbors.add(cnb);
//                    cnb.neighbors.add(cn);
                }
                // node sequnce
//                if (!cnb.neighbors.contains(cn)) {
//                    cnb.neighbors.add(cn);
//                }

            }
        }
        return  map.get(node);
    }

    public static void dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node))
            return;
        Node cloneNode = new Node();
        cloneNode.val = node.val;
//        visit.add(node);
        map.put(node, cloneNode);
//        list.add(cloneNode);
        for (Node n: node.neighbors) {
            dfs(n, map);
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
