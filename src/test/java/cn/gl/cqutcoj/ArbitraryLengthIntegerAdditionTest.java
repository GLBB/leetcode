package cn.gl.cqutcoj;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ArbitraryLengthIntegerAdditionTest {

    @Test
    public void test1(){
        BigInteger bigInteger = new BigInteger("123456789");
        BigInteger b2 = new BigInteger("987654321");
        BigInteger add = bigInteger.add(b2);
        System.out.println(add.toString());
    }

}