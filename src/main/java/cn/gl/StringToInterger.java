package cn.gl;


/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
public class StringToInterger {

    public static void main(String[] args) {
        StringToInterger solution = new StringToInterger();
        String para1 = "42"; // cur 2
        String para2 = "3.14159"; // cur 1
        String para3 = "4193 with words"; // cur 4
        String para4 = "   -42";
        String para5 =  "words and 987";
        String para6 = "2147483648";
        int result = solution.myAtoi(para6);
        System.out.println(result);
    }

    /**
     * 参数 str 开头可能有空格
     * 数可能有 + - 号
     * 在整数后面可能有附加的字符
     * 如果第一个字符是字母，"",可以返回0
     * 如果超限，返回最小值或最大值
     *
     * 算法：
     * 首先去掉 str 前面的空格
     * 取出 str 中有效数字
     * 转换
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        String headNoWhitespace = str.trim();
        if (headNoWhitespace.length() == 0) {
            return 0;
        }
        char head = headNoWhitespace.charAt(0);
        if (head == '+' || head == '-' || (head >= 48 && head <= 57)) {
            // 找到有效字符
            int cur = findIdx(headNoWhitespace);
            // 如果输入 +xxx, 返回 0
            if ((head == '+' || head == '-') && cur == 1) return 0;
            String valid = "";
            try{
                valid = headNoWhitespace.substring(0, cur);
                return Integer.parseInt(valid);
            } catch (NumberFormatException e) {
                return outRange(head);
            }
        }
        return 0;
    }

    private int findIdx(String headNoWhitespace){
        int cur = 1;
        while (cur < headNoWhitespace.length()) {
            if (headNoWhitespace.charAt(cur) >= '0' && headNoWhitespace.charAt(cur) <= '9') {
                cur++;
            } else {
                // 进入这里的情况：
                // 1. 非数字, 返回 cur
                break;
            }
        }
        return cur;
    }

    // 超限
    private int outRange(char head){
        // 正数可能 + 或 数字开头
        if (head == '-') {
            return Integer.MIN_VALUE;
        } else{
            return Integer.MAX_VALUE;
        }
    }
}
