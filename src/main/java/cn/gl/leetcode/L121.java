package cn.gl.leetcode;

/**
 * 121. 买卖股票的最佳时机
 */
public class L121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int max = prices[0];
        int min = prices[0];
        int maxSurplus = 0;

        for (int i = 1; i < prices.length; i++) {
            int surplus = 0;

            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
                surplus = max - min;
            }

            if (surplus > maxSurplus) {
                maxSurplus = surplus;
            }

        }

        return maxSurplus;

    }
}
