package cn.gl;


/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "abacab";
        String s1 = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(s1);
    }

    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }

        String longestStr = "";
        for (int i=0; i<s.length(); i++) {
            for (int j = findIdx(s, i, s.length()-1); j > i ;) {
                boolean palindrome = isPalindrome(s, i, j);
                if (palindrome) {
                    if (j+1-i > longestStr.length())
                        longestStr = s.substring(i, j+1);
                }
                j = findIdx(s, i, j-1);
            }
        }
        if (longestStr.length() > 1) return longestStr;
        else return s.charAt(0)+"";
    }

    private int findIdx(String s, int i, int j){
        while (j > i) {
            if (s.charAt(i) == s.charAt(j)) {
                return j;
            }
            j--;
        }
        return -1;
    }

    private boolean isPalindrome(String s, int i, int j){
        if (s.charAt(i) == s.charAt(j) && (i==j|| i+1==j)) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
            return isPalindrome(s, i, j);
        } else {
            return false;
        }
    }
}
