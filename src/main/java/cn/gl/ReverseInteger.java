package cn.gl;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();

        int x = 1534236469;
        int reverse = solution.reverse(x);
        System.out.println(reverse);


    }

    /**
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        String s = x + "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-1 - i];
            chars[chars.length-1 -i] = temp;
        }
        if (chars[chars.length - 1] == '-' || chars[chars.length -1] == '+'){
            char temp = chars[chars.length -1];
            for (int i = chars.length - 1; i > 0 ; i--) {
                chars[i] = chars[i-1];
            }
            chars[0] = temp;
        }
        int result = 0;
        try{
            result = Integer.parseInt(new String(chars));
        } catch (NumberFormatException e) {
        }
        return result;
    }



}
