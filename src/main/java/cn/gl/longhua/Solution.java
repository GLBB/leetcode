package cn.gl.longhua;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {

    static int divisor = 15;
    /**
     * 输入情况有正数，负数，如果输入负数，在结果前面加负号
     *
     * @param num
     */
    public static String convert15Decimal(int num){
        ArrayList<Integer> list = new ArrayList<>();
        boolean negative = num >= 0 ? false : true;
        num = Math.abs(num);
        while (num >= divisor) {
            int reminder = num%15;
            list.add(reminder);
            num = num / 15;
        }
        list.add(num);
        StringBuilder builder = new StringBuilder();
        if (negative){
            builder.append("-");
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            String position = convert15DecimalChar(list.get(i));
            builder.append(position);
        }
        return builder.toString();
    }

    private static String convert15DecimalChar(int num){
        switch (num) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            default:
                if (num >= 0 && num <= 9)
                    return num+"";
                else
                    throw new RuntimeException("Illegal Parameter");
        }
    }

    /**
     * 功能测试
     */
    @Test
    public void test1(){
        String res1 = convert15Decimal(235);
        String res2 = convert15Decimal(-235);
        String res3 = convert15Decimal(10);
        String res4 = convert15Decimal(-10);
        String res5 = convert15Decimal(16);
        String res6 = convert15Decimal(-16);
        System.out.println("235: " + res1);
        System.out.println("-235: " + res2);
        System.out.println("10: " + res3);
        System.out.println("-10: " + res4);
        System.out.println("16: " + res5);
        System.out.println("-16: " + res6);
        System.out.println("0: " + convert15Decimal(0));
    }
}
