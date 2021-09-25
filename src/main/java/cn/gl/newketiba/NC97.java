package cn.gl.newketiba;


import java.util.*;

/**
 * @TODO 未通过
 * NC97 字符串出现次数的TopK问题
 */
public class NC97 {

    public static void main(String[] args) {
        String[] strArr = {"2","1", "1","1","2","3", "2"};
        String[][] strings = new NC97().topKstrings(strArr, 2);
        System.out.println(Arrays.toString(strings));
    }

    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        // gen node
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i< strings.length; i++) {
            Integer count = countMap.get(strings[i]);
            if (count == null) {
                countMap.put(strings[i], 1);
            } else {
                countMap.put(strings[i], count + 1);
            }
        }
        List<Node> list = new ArrayList<>();
        for (String key : countMap.keySet()) {
            Node node = new Node();
            node.value = key;
            node.priority = countMap.get(key);
            list.add(node);
        }
        // quick sort   biger in before
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.priority > o2.priority) {
                    return -1;
                } else if (o1.priority == o2.priority) {
                    // compare string
                    int i = o1.value.compareTo(o2.value);
                    return i;
                } else {
                    return 1;
                }
            }
        };
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.addAll(list);
        String[][] result = new String[k][2];
        int i = 0;
        while (i < k) {
            Node node = priorityQueue.remove();
            result[i][0] = node.value;
            result[i][1] = node.priority + "";
            i++;
        }
        return result;
    }

    public static class Node {
        private String value;
        private Integer priority;
    }
}
