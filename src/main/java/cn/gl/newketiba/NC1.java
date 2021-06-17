package cn.gl.newketiba;

public class NC1 {



    public static void main(String[] args) {
        String res = new NC1().solve("9", "99999999999999999999999999999999999999999999999999999999999994");
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        StringBuilder builder = new StringBuilder();
        Character prev = '0';
        for (int i = s.length() - 1, j = t.length() - 1; i >= 0 || j >= 0; i--, j--) {
            Character ch1 = getStringIdxValue(s, i);
            Character ch2 = getStringIdxValue(t, j);
            AddRes addRes = add(ch1, ch2, prev);
            if (addRes.high == 1) {
                prev = '1';
            } else {
                prev = '0';
            }
            builder.insert(0, addRes.cur + "");
        }
        if (prev != '0') {
            builder.insert(0, prev);
        }
        return builder.toString();
    }
    
    private Character getStringIdxValue(String str, int idx) {
        if(str.length() > idx && idx >= 0) {
            return str.charAt(idx);
        } else {
            return '0';
        }
    }

    static class AddRes {
        Integer cur;
        Integer high;
    }

    private AddRes add(Character ch1, Character ch2, Character ch3) {
        int v1 = getCharValue(ch1);
        int v2 = getCharValue(ch2);
        int v3 = getCharValue(ch3);
        int res = v1 + v2 + v3;
        int high = res / 10;
        int cur = res % 10;
        AddRes addRes = new AddRes();
        addRes.cur = cur;
        addRes.high = high;
        return addRes;
    }

    private int getCharValue(Character ch) {
        return ch - '0';
    }
}
