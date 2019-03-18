package cn.gl.cqutcoj;

import java.util.ArrayList;
import java.util.Scanner;

public class DecimalToOctal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int n = Integer.parseInt(s);
            String result = getResult(n);
            System.out.println(result);
        }
    }

    public static String getResult(int n){
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        while (n >= 2) {
            int x = n%2;
            list.add(x);
            n/=2;
        }
        if (n == 1) list.add(1);

        String result = "";
        int i = 0;
        while (i < list.size()) {
            if (i + 2 < list.size()) {
                Integer i1 = list.get(i);
                Integer i2 = list.get(i+1);
                Integer i3 = list.get(i+2);
                int octol = toOctol(i3, i2, i1);
                result = octol + result;
            }
            i += 3;
        }


        if (i == list.size()) {
            return result;
        }else if (i == list.size()+1) {
            int octol = toOctol(0, list.get(list.size() -1), list.get(list.size()-2) );
            return octol + result;
        }else if (i == list.size() + 2) {
            int octol = toOctol(0, 0, list.get(list.size()-1));
            return octol+result;
        }else {
            System.out.println("未知");
            return null;
        }

    }

    private static int toOctol(int i1, int i2, int i3) {
        int count = 0;
        if (i1 == 1){
            count += 4;
        }

        if (i2 == 1) count += 2;

        if (i3==1) count+=1;
        return count;
    }
}
