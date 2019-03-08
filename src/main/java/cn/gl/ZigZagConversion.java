package cn.gl;

public class ZigZagConversion {


    public static void main(String[] args) {
        ZigZagConversion solution = new ZigZagConversion();

        String s = "PAYPALISHIRING";
        String result = solution.convert(s, 5);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        int maxInterval = getMaxInterval(numRows);
        int times = 0;
        StringBuilder result = new StringBuilder();
        int interval = maxInterval;
        while (times < numRows) {
            int curIdx = times;
            boolean flag = true;
            int interval2 = maxInterval - 1 - interval;
            while (curIdx < s.length()) {
                result.append(s.charAt(curIdx));
                if (flag || interval == maxInterval) {
                    curIdx = curIdx + interval + 1;
                    flag = false;
                } else {
                    curIdx = curIdx + interval2 + 1;
                    flag = true;
                }
            }
            interval -= 2;
            if (interval < 0) {
                interval = maxInterval;
            }
            times++;
        }
        return result.toString();
    }

    private int getMaxInterval(int row){
        if (row >= 3) {
            return 3 + (row - 3) * 2;
        }else {
            System.out.println("row less than 3, row: " + row);
            if (row == 2) {
                return 1;
            } else if (row == 1) {
                return 0;
            } else {
                System.out.println("row less than 0, row: " + row);
                return 0;
            }
        }
    }

}
