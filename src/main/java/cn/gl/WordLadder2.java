package cn.gl;

import java.util.*;

/**
 * 广度遍历，超时
 */
public class WordLadder2 {

    public static void main(String[] args) {
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        int i = ladderLength("hit", "cog", Arrays.asList(arr));
        System.out.println();
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList==null || wordList.size()==0)
            return 0;
        boolean[] visit = new boolean[wordList.size()];
        int endWordIdx = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)){
                endWordIdx = i;
                visit[i] = true;
                break;
            }
        }
        if (endWordIdx == -1)
            return 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.push(endWord);
        int count = 1;
        while (!queue.isEmpty()) {
            ArrayList<String> tempRes = new ArrayList<>();
            while (!queue.isEmpty()) {
                String poll = queue.poll();
                int diff = match(poll, beginWord);
                if (diff <2)
                    return ++count;
                else {
                    // not match
                    // find all match poll and not visited
                    // add to tempRes
                    // update visit[i]
                    findNotVisited(wordList, visit, poll, tempRes);

                }
            }
            // add tempRes to queue
            queue.addAll(tempRes);
            count++;
        }
        return 0;
    }

    private static void findNotVisited(List<String> wordList,
                                             boolean[] visit, String target, ArrayList<String> tempRes) {
//        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (visit[i])
                continue;
            int diff = match(wordList.get(i), target);
            if (diff < 2) {
                tempRes.add(wordList.get(i));
                visit[i] = true;
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
}
