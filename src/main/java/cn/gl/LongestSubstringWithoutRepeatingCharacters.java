package cn.gl;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        int length = solution.lengthOfLongestSubstring("cbefg");
        System.out.println(length);
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            String longest = "";
            for (int i=0; i<s.length(); i++){
                StringBuilder sb = new StringBuilder();
                for(int j=i; j<s.length(); j++){
                    String temp = sb.toString();
                    if (temp.contains(s.charAt(j)+"")){
                        if (longest.length() < temp.length()){
                            longest = temp;
                        }
                        break;
                    }
                    sb.append(s.charAt(j));
                    // 防止字符串没有重复字符，而没有对 longest 赋值的情况
                    if (j == s.length()-1  &&  sb.toString().length() > longest.length()){
                        longest = sb.toString();
                    }
                }
                if (longest.length() == s.length()){
                    break;
                }
            }
            return longest.length();
        }
    }
}

