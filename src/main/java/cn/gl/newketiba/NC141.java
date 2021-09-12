package cn.gl.newketiba;

/**
 * NC141 判断回文
 */
public class NC141 {

    public boolean judge (String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return true;
        }
        int startIdx = 0;
        int endIdx = str.length() - 1;
        while (startIdx <= endIdx) {
            if (str.charAt(startIdx) != str.charAt(endIdx)) {
                return false;
            }
            startIdx ++;
            endIdx --;
        }
        return true;
    }
}
