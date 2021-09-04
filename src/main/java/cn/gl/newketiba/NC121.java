package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * NC121 字符串的排列
 */
public class NC121 {

    public ArrayList<String> Permutation(String str) {
        LinkedList<Character> chList = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            chList.add(str.charAt(i));
        }
        premutationHelp("", chList, result);
        Set<String> set = new HashSet<>(result);
        result = new ArrayList<>(set);
        return result;
    }

    private void premutationHelp(String prefix, LinkedList<Character> chList,
                                 ArrayList<String> result) {
        if (chList.size() == 0) {
            result.add(prefix);
        }
        for (int i = 0; i< chList.size(); i++) {
            Character ch = chList.get(i);
            chList.remove(i);
            premutationHelp(prefix + ch, chList, result);
            chList.add(i, ch);
        }
    }
}
