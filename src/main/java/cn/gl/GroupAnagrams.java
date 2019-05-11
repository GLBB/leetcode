package cn.gl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> tempMap = Arrays.stream(strs)
                .collect(HashMap<String, List<String>>::new, (map, str) -> {
                    String key = str.chars().sorted().collect(StringBuilder::new, (sb, i) -> {
                        sb.append((char) i);
                    }, StringBuilder::append)
                            .toString();
                    List<String> list = map.getOrDefault(key, new ArrayList<String>());
                    list.add(str);
                    map.put(key, list);
                }, HashMap::putAll);
//        System.out.println(tempMap);
        ArrayList<List<String>> collect = tempMap.values().stream()
                .collect(ArrayList<List<String>>::new, (res, list) -> {
                    res.add(list);
                }, ArrayList::addAll);
        return collect;
    }
}
