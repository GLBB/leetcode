package cn.gl;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextPermutationTest {

    @Test
    public void test(){
        int[] arr = {5, 4, 3, 2};
        int pivot = NextPermutation.pivot(arr, 0, arr.length - 1);
        System.out.println();
    }

}