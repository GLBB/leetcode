package cn.gl.leetcode;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 */
public class L3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0;
        int right = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(left), 0);
        int maxLength = 0;

        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            if (index != null) {
                if (right - left > maxLength) {
                    maxLength = right - left;
                }
                for (int i = left; i <= index; i++) {
                    map.remove(s.charAt(i));
                }
                left = index + 1;
            }
            map.put(s.charAt(right), right);
            right++;
        }

        if (s.length() - left > maxLength) {
            return s.length() - left;
        }

        return maxLength;
    }
}
