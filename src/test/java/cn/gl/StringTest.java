package cn.gl;

import org.junit.Test;

import java.util.ArrayList;

public class StringTest {

    @Test
    public void test1(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        System.out.println(sb.toString());
    }

    @Test
    public void test(){
        System.out.println(3>>-1);
    }
    
    @Test
    public void test2(){
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
        System.out.println(list.size());
    }
}
