package cn.gl;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        String para1 = "III";
        String para2 = "IV";
        String para3 = "IX";
        String para4 = "LVIII";
        String para5 = "MCMXCIV";

        int result = solution.romanToInt(para5);
        System.out.println(result);
    }

    public int romanToInt(String s) {
        int money = 0;
        List<Pair> pairs = prepare1();

        int i =  0;
        while (i < s.length() - 1) {
            char ch = s.charAt(i);
            char chNext = s.charAt(i + 1);
            int idx = getIndex(ch, pairs);
            int idxNext = getIndex(chNext, pairs);
            if (idx < idxNext) {
                money += pairs.get(idxNext).money - pairs.get(idx).money;
                i+=2;
            } else {
                money += pairs.get(idx).money;
                i++;
            }
        }
        // 最后一个
        if (i == s.length() - 1) {
            int idx = getIndex(s.charAt(s.length() - 1), pairs);
            money += pairs.get(idx).money;
        }

        return money;
    }

    class Pair{
        int money;
        String des;

        public Pair(int money, String des) {
            this.money = money;
            this.des = des;
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

    private int getIndex(char ch, List<Pair> pairs){
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).des.equals(ch+"")){
                return i;
            }
        }
        System.out.println("不存在");
        return -1;
    }
}
