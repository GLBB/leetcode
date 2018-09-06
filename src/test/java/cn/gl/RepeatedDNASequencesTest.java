package cn.gl;

import org.junit.Test;

import java.util.List;

public class RepeatedDNASequencesTest {
//    9223372036854775807
    @Test
    public void test(){
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.pow(10, 9));
    }

    @Test
    public void test2(){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        s = "AAAAAAAAAAAA";
        RepeatedDNASequences solution = new RepeatedDNASequences();
        List<String> list = solution.findRepeatedDnaSequences(s);
        for (String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void test3(){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        s = "AAAAAAAAAAAA";
        RepeatedDNASequences solution = new RepeatedDNASequences();
        List<String> list = solution.findRepeatedDnaSequences3(s);
        for (String str : list){
            System.out.println(str);
        }
    }
}
