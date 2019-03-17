package cn.gl;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution =
                new LetterCombinationsOfAPhoneNumber();

        String para1 = "23";
        List<String> list = solution.letterCombinations(para1);
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        Map<Integer, String> map = prepare();
        digits.replace("1", "");
        String zeroStr = map.get(char2int(digits.charAt(0)));
        Set<String> set = str2Set(zeroStr);
        for (int i = 1; i < digits.length(); i++) {
            int key = char2int(digits.charAt(i));
            String temp = map.get(key);
            Set<String> tempSet = str2Set(temp);
            set = cartesianProduct(set, tempSet);
        }
        List<String> list = set2List(set);
        return list;
    }

    private Map<Integer, String> prepare(){
        Map<Integer, String> map = new HashMap<>();
        char a = 'a';
        for (int i = 2; i < 7; i++) {
            int start = (i-2) * 3;
            char c1 = (char) (a+start);
            char c2 = (char) (a+start+1);
            char c3 = (char)(a+start+2);
            String s = c1+""+c2+""+c3;
            map.put(i, s);
        }
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return map;
    }

    private int char2int(char c){
        return c - '0';
    }

    private Set<String> str2Set(String str){
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i) + "");
        }
        return set;
    }

    /**
     * 计算集合的笛卡尔积
     * @param one
     * @param two
     * @return
     */
    private Set<String> cartesianProduct(Set<String> one, Set<String> two){
        Set<String> set = new LinkedHashSet<>();
        Iterator<String> iterator2 = two.iterator();
        while (iterator2.hasNext()) {
            String next2 = iterator2.next();
            Iterator<String> iterator1 = one.iterator();
            while (iterator1.hasNext()) {
                String next1 = iterator1.next();
                set.add(next1+next2);
            }
        }
        return set;
    }

    private List<String> set2List(Set<String> set){
        List<String> list = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
