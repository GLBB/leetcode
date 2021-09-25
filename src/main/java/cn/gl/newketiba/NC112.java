package cn.gl.newketiba;

/**
 * 查看解答
 * NC112 进制转换
 */
public class NC112 {

    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        // write code here
        String str = "0123456789ABCDEF";
        if (M == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean negative = M > 0 ? false : true;
        int num = Math.abs(M);
        while (num != 0) {
            int surplus = num % N;
            sb.append(str.charAt(surplus));
            num = num / N;
        }
        String result = sb.reverse().toString();
        return negative ? "-" + result : result;
    }
}
