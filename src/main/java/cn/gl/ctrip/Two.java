package cn.gl.ctrip;

import java.util.Scanner;

public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String x = scanner.nextLine();
            solution(line, x);
        }

//        String line = "[1,2,3,4,5,6,7,8]";
//        String x = "3";
//        solution(line, x);
    }

    public static void solution(String line, String x){
        line = line.replace("[", "");
        line = line.replace("]", "");
        String[] strArr = line.split(",");
        int value = Integer.parseInt(x);
        // value == 1, return line;
        if (value<=1)
            System.out.println(line);
        
        int idx = 0;
        while (idx < strArr.length){
            if (idx + value > strArr.length)
                break;
            // swap 
            int startIdx = idx;
            int endIdx = startIdx + value - 1;
            while (startIdx < endIdx) {
                String temp = strArr[startIdx];
                strArr[startIdx] = strArr[endIdx];
                strArr[endIdx] = temp;
                startIdx++;
                endIdx--;
            }
            idx += value;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < strArr.length-1; i++) {
            sb.append(strArr[i]+",");
        }
        sb.append(strArr[strArr.length-1]);
        sb.append("]");

        System.out.println(sb.toString());
    }
    
//    public static void subSolution()
}
