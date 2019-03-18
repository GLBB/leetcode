package cn.gl.cqutcoj;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DecompositionPrimeFactorTest {

    @Test
    public void test1(){
        List<Integer> result = DecompositionPrimeFactor.getResult(35);
        System.out.println(result);
    }

}