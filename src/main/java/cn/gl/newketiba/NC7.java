package cn.gl.newketiba;

/**
 * 买卖股票的最好时机
 */
public class NC7 {

    /**
     *
     * @param prices int整型一维数组 
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int[] incomes = new int[prices.length];
        incomes[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int maxIncome = 0;
                for (int j = 0; j < i; j++) {
                    int tempIncome = prices[i] - prices[j];
                    if (tempIncome > maxIncome) {
                        maxIncome = tempIncome;
                    }
                }
                if (maxIncome > incomes[i - 1]) {
                    incomes[i] = maxIncome;
                } else {
                    incomes[i] = incomes[i - 1];
                }

            } else {
                incomes[i] = incomes[i - 1];
            }
        }
        return incomes[incomes.length - 1];
    }
}
