package cn.gl;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void test1(){
        char[] chs = {'1', '2', '3'};
        char[] chars = Arrays.copyOf(chs, 2);
        System.out.println();
    }

    @Test
    public void test2(){
        char[][] chs = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
        char[][] chars = Arrays.copyOf(chs, 2);
        System.out.println();

    }

}