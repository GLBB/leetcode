package cn.gl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 构造图，来解决问题
 * 发现比较复杂，
 * 另选一种方法
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0)
            return 0;
        if (!wordList.contains(endWord))
            return 0;
        List<HeadNode> head = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            int m = 0;
            int sum = 0;
            if ((m=match(wordList.get(i), beginWord)) < 2){
                HeadNode hNode = new HeadNode();
                hNode.idx = i;
                hNode.v = wordList.get(i);
                head.add(hNode);
                if (m == 1){
                    hNode.sum = 1;
                }else {
                    hNode.sum = 0;
                }
            }
        }

        return 0;
    }

    public static int dfs(Node node, int cur, boolean[] visit, String end){
        if (node == null)
            return 0;
        if (node.v.equals(end)){
            return cur;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node popN = stack.pop();
            List<Node> list = popN.neighbor;
            for (int i = 0; i < list.size(); i++) {
                Node neighborNode = list.get(i);
                stack.push(nodes.get(neighborNode.idx));
//                dfs(node, 0)
            }
        }
        return 0;
    }

    class HeadNode extends Node{
        int sum = 0;
    }

    public void graph(List<String> wordList){
        for (int i = 0; i < wordList.size(); i++) {
            Node node = new Node();
            node.v = wordList.get(i);
            nodes.add(node);
            for (int j = 0; j < wordList.size(); j++) {
                if (i == j)
                    continue;
                if (match(wordList.get(i), wordList.get(j)) < 2){
                    Node n = new Node();
                    n.v = wordList.get(j);
                    n.idx = j;
                    node.neighbor.add(n);
                }
            }
        }
    }

    public static int match(String s1, String s2){
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sum++;
                if (sum>1)
                    return 2;
            }
        }
        return sum;
    }

    static ArrayList<Node> nodes = new ArrayList<>();

    class Node{
        String v;
        List<Node> neighbor = new ArrayList<>();
        Integer idx;
    }

}
