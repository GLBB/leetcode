package cn.gl;

import java.util.*;
import java.util.stream.Collectors;

public class GrayCode {

    public static void main(String[] args) {
        List<Integer> list = grayCode(3);
        System.out.println(list);
    }

    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n == 0){
            list.add(0);
            return list;
        }
        byte[] arr = new byte[n];
        list.add(0);
        int pow = (int) Math.pow(2, n);
        while (list.size() < pow) {
            if (arr[arr.length-1] == 1)
                arr[arr.length-1] = 0;
            else
                arr[arr.length-1] = 1;
            int v1 = arr2Integer(arr);
            list.add(v1);
            if (list.size() >= pow)
                break;
            for (int i = arr.length-1; i >= 0; i--) {
                if (arr[i] == 1){
                    arr[i-1] = (byte) ((arr[i-1] == 0)?1:0);
                    int v2 = arr2Integer(arr);
                    list.add(v2);
                    break;
                }
            }
        }
        return list;
    }



    public static int arr2Integer(byte[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res * 2 + arr[i];
        }
        return res;
    }
}
