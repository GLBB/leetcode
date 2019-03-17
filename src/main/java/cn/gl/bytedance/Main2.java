package cn.gl.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(n); i++) {
            String line = scanner.nextLine();
            list.add(line);
        }

//        List<String> list = new ArrayList<>();
//        list.add("helloo");
//        list.add("wooooooow");
        List<String> solution = solution(list);
        for (String s : solution) {
            System.out.println(s);
        }
    }

    private static List<String> solution(List<String> list){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            for (int j = 0; j < s.length(); j++) {
                Pair pair = rule1(s, j);
                while (pair.flag) {
                    s = pair.s;
                    pair = rule1(s, j);
                }

                pair = rule2(s, j);
                while (pair.flag) {
                    s = pair.s;
                    pair = rule2(s, j);
                }
            }
            result.add(s);
        }
        return result;
    }

    /**
     * 3 相连
     * 满足返回true
     * @param str
     * @param startIdx
     * @return
     */
    private static Pair rule1(String str, int startIdx){
        if (startIdx + 2 < str.length()) {
            char c1 = str.charAt(startIdx);
            char c2 = str.charAt(startIdx+1);
            char c3 = str.charAt(startIdx+2);
            if (c1 == c2 && c1 == c3) {
                String sub1 = str.substring(0, startIdx);
                String sub2 = str.substring(startIdx+1, str.length());
                String r = sub1 + sub2;
                Pair pair = new Pair(true, r);
                return pair;
            }else return new Pair(false, null);
        }else {
            return new Pair(false, null);
        }
    }
    
    private static Pair rule2(String str, int startIdx) {
        if (startIdx + 3 < str.length()) {
            char c1 = str.charAt(startIdx);
            char c2 = str.charAt(startIdx+1);
            char c3 = str.charAt(startIdx+2);
            char c4 = str.charAt(startIdx+3);
            
            if (c1==c2 && c3==c4) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, startIdx+2));
                sb.append(str.substring(startIdx+3, str.length()));
                Pair pair = new Pair(true, sb.toString());
                return pair;
            }else {
                return new Pair(false, null);
            }
            
        }else return new Pair(false, null);
        
    }
    
    static class Pair{
        boolean flag;
        String s;

        public Pair(boolean flag, String s) {
            this.flag = flag;
            this.s = s;
        }
    }

}
