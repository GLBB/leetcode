package cn.gl;

import java.util.*;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        int para1 = 3;
        int para2 = 4;
        int para3 = 9;
        int para4 = 58;
        int para5 = 1994;
        int para6 = 45;
        String result = solution.intToRoman(para6);
        System.out.println(result);
    }

    public String intToRoman(int num) {
        List<Pair> list = prepare1();
        List<Pair> list2 = prepare2(list);
        System.out.println(list2);
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            int curIdx = 0;
            for (int i = 0; i < list2.size(); i++) {
                if (num >= list2.get(i).money){
                    curIdx = i;
                    break;
                }
            }

            num -= list2.get(curIdx).money;
            result.append(list2.get(curIdx).des);
        }
        return result.toString();
    }

    class Pair{
        int money;
        String des;

        public Pair(int money, String des) {
            this.money = money;
            this.des = des;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return money == p.money;
        }

        @Override
        public int hashCode() {
            return money;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "money=" + money +
                    ", des='" + des + '\'' +
                    '}';
        }
    }

    /**
     * 基本面值
     * @return
     */
    private List<Pair> prepare1(){
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(1, "I"));
        list.add(new Pair(5, "V"));
        list.add(new Pair(10, "X"));
        list.add(new Pair(50, "L"));
        list.add(new Pair(100, "C"));
        list.add(new Pair(500, "D"));
        list.add(new Pair(1000, "M"));
        return list;
    }

    private List<Pair> prepare2(List<Pair> list){
        Set<Pair> set = new HashSet<>(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                // 排除 999 这样的数
                if (list.get(i).money/list.get(j).money > 10) continue;
                // 还需排除 45, 450,
                if (list.get(j).money == 5 || list.get(j).money == 50) continue;;


                int money = list.get(i).money - list.get(j).money;
                String des = list.get(j).des + list.get(i).des;
                Pair pair = new Pair(money, des);
                set.add(pair);
            }
        }


        Comparator<Pair> comparator = (o1, o2)->{
            if (o1.money > o2.money) {
                return -1;
            } else if (o1.money == o2.money) {
                return 0;
            } else {
                return 1;
            }
        };
        ArrayList<Pair> result = new ArrayList<>(set);
        result.sort(comparator);
        return result;
    }
}
