package cn.gl.test;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(null, "111");
        String s = map.get(null);

        map.put(8, "111");
        map.put(24, "222");
        map.put(23, "222");
        map.put(25, "222");

        System.out.println(s);
    }
}
