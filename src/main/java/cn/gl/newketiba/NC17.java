package cn.gl.newketiba;

/**
 * 最长回文子串
 */
public class NC17 {

    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (A == null || n <= 0 || A.length() == 0) {
            return 0;
        }
        int start = 0;
        int maxLength = 0;
        while (start < A.length()) {
            int end = A.length() - 1;
            while (end >= start) {
                if (isPalindrome(A, start, end) && end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                    break;
                }
                end --;
            }
            start++;
        }
        return maxLength;
    }
    
    private boolean isPalindrome(String str, int start, int end) {
        while (start < str.length() && end >= 0 && str.charAt(start) ==  str.charAt(end) && start <= end) {
            start++;
            end--;
        }
        if (start > end) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
