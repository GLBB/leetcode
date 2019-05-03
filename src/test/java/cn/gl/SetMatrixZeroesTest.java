package cn.gl;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetMatrixZeroesTest {

    @Test
    public void test1(){
        outer:
        for (int i=0; i<3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.println(i + " "  + j);
                if (j==2){
                    break outer;
                }
            }
        }
    }

}