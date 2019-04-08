package cn.gl.ctrip;

import java.util.HashSet;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            boolean solution = solution(line);
            System.out.println(solution);
        }

//        String s = "a,b,c,d,a";
//        boolean solution = solution(s);
//        System.out.println();
    }

    public static boolean solution(String line){
        String[] strArr = line.split(",");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < strArr.length; i++) {
            if (set.contains(strArr[i])){
                return true;
            }
            set.add(strArr[i]);
        }
        return false;
    }

}
