package cn.gl.newketiba;

/**
 * 计算平方根
 */
public class NC32 {

    /**
     *
     * @param x int整型 
     * @return int整型
     */
    public int sqrt (int x) {
        // write code here
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i * i > x) {
                return i - 1;
            }
        }
        return 0;
    }
}
