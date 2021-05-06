package cn.gl.leetcode.weekly52;

public class One {

    public static void main(String[] args) {
        One one = new One();
        String str = "a1c1e1";
        String s = one.replaceDigits(str);
        System.out.println(s);
    }

    public String replaceDigits(String s) {
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            if (idx + 1 == s.length()) {
                builder.append(s.charAt(idx));
                return builder.toString();
            }
            Character shift = shift(s.charAt(idx), Integer.parseInt(String.valueOf(s.charAt(idx + 1))));
            builder.append(s.charAt(idx));
            builder.append(shift);
            idx+=2;
        }
        return builder.toString();
    }
    
    public Character shift(char ch, int x) {
        char target = (char) (ch + x);
        if (target > 'z') {
            return 'z';
        }
        return target;
    }
}
