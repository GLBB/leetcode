package cn.gl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String str = "leetcode";
        String[] dic = {"leet", "code"};
        boolean b = wordBreak(str, Arrays.asList(dic));
        System.out.println();
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] && set.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
