package cn.gl.leetcode;

public class L5 {

    public static void main(String[] args) {
        String palindrome = new L5().longestPalindrome("babad");
        System.out.println(palindrome);
    }
    
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        String newStr = sb.toString();
        int longestLength = 1;
        int longestLeft = 1;
        int longestRight = 1;
        int i = 0;
        while (i < newStr.length()) {
            int left = i;
            int right = i;
            while (left >= 0 && right < newStr.length() && newStr.charAt(left) == newStr.charAt(right)) {
                left --;
                right ++;
            }
            left ++;
            right --;
            int tempLength = right - left + 1;
            if (tempLength > longestLength) {
                longestLength = tempLength;
                longestLeft = left;
                longestRight = right;
            }
            i++;
        }
        StringBuilder result = new StringBuilder();
        for(int idx = longestLeft; idx <= longestRight; idx++) {
            if(newStr.charAt(idx) == '#') {
                continue;
            }
            result.append(newStr.charAt(idx));
        }
        return result.toString();

    }
}
