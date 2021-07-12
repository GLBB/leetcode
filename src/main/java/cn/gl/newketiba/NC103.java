package cn.gl.newketiba;

/**
 * 反转字符串
 */
public class NC103 {

    /**
     * 反转字符串
     * @param str string字符串 
     * @return string字符串
     */
    public String solve (String str) {
        // write code here
        char[] chArr = str.toCharArray();
        int midle = chArr.length / 2;
        for (int i = 0; i < midle; i++) {
            int left = i;
            int right = chArr.length - 1 - i;
            swap(chArr, left, right);
        }
        return new String(chArr);
    }

    private void swap(char[] chArr, int left, int right) {
        char temp = chArr[left];
        chArr[left] = chArr[right];
        chArr[right] = temp;

    }
}
