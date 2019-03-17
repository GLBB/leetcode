package cn.gl.bytedance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class Main4Test {

    @Test
    public void test1(){
        double x = 2.3334;
        Main4.print(x);
    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(2, 1);

    }

}