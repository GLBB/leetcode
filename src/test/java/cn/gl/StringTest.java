package cn.gl;

import org.junit.Test;

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
}
