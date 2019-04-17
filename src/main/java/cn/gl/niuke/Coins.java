package cn.gl.niuke;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/c0503ca0a12d4256af33fce2712d7b24?toCommentId=1156326
 * 来源：牛客网
 *
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
 *
 * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
 *
 * 测试样例：
 * 6
 * 返回：2
 */
public class Coins {

    public static void main(String[] args) {
        int i = countWays(20);
        System.out.println(i);
    }
    public static int countWays(int n) {
        if (n<= 0)
            return 0;
        int[] coins = {1, 5, 10, 25};
        int[][] res = new int[coins.length][n+1];
        for (int i = 0; i < coins.length; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < n+1; j++) {
                int v1 = 0, v2 = 0;
                if (j-coins[i]>=0)
                    v1 = res[i][j-coins[i]];
                if (i!= 0)
                    v2 = res[i-1][j];
                res[i][j] = v1 + v2;
            }
        }
        return res[coins.length-1][n]%1000000007;
    }
}
