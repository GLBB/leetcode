package cn.gl.offer_niuke;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {

    public static void main(String[] args) {
        Permutation p = new Permutation();
        ArrayList<String> permutation = p.Permutation("123");
        System.out.println(permutation);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null)
            return list;
        char[] chars = str.toCharArray();
        helper(list, chars, 0);
        Collections.sort(list);
        return list;
    }

    public void helper(ArrayList<String> list, char[] chars, int idx){
        list.add(new String(chars));
        for (int i = idx; i < chars.length; i++) {
            char temp = chars[idx];
            chars[idx] = chars[i];
            chars[i] = temp;
            list.add(new String(chars));
            helper(list, chars, idx+1);
            chars[i] = chars[idx];
            chars[idx] = temp;
        }
    }

}
