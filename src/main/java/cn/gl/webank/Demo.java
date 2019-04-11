package cn.gl.webank;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] strArr = line.split(" ");
            int m = Integer.parseInt(strArr[0]);
            int n = Integer.parseInt(strArr[1]);
            solution(m, n);
        }

//        solution(81, 4);
    }

    public static void solution(int m, int n){

    }
}
