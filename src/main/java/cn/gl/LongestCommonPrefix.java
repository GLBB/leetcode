package cn.gl;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] para1 = {"flower","flow","flight"};
        String[] para2 = {"dog","racecar","car"};
        String[] para3 = {};
        String s = solution.longestCommonPrefix(para3);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length == 0){
            return "";
        }

        StringBuilder result = new StringBuilder();
        int leastLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (leastLength > strs[i].length()) {
                leastLength = strs[i].length();
            }
        }
        int i = 0;
        while (i < leastLength) {
            char ch = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                break;
            }
            result.append(ch);
            i++;
        }
        return result.toString();
    }

}
