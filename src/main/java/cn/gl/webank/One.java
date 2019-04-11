package cn.gl.webank;

import java.util.ArrayList;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
//        Scanner scanner =  new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            String[] strArr = line.split(" ");
//            int m = Integer.parseInt(strArr[0]);
//            int n = Integer.parseInt(strArr[1]);
//            solution(m, n);
//        }


    }

    public static void solution(int m, int n){
        if (m==1){
            System.out.println();
            System.out.println(1);
            return;
        }
        boolean[] barr = new boolean[m];
        int count = m;
        int startIdx = 0;
        int curIdx = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (count > 1) {
            int c = 0;
            while (true) {
                boolean flag = false;
                curIdx = startIdx;
                while (curIdx<m) {
                    if (barr[curIdx] == false){
                        c++;
                        if (c == n){
                            flag = true;
                            break;
                        }
                    }
                    curIdx++;
                }
                if (flag) {
                    break;
                }
                curIdx = 0;
                while (curIdx < startIdx){
                    if (barr[curIdx] == false) {
                        c++;
                        if (c == n) {
                            flag = true;
                            break;
                        }
                    }
                    curIdx++;
                }
                if (flag){
                    break;
                }
            }
            barr[curIdx] = true;
            res.add(curIdx+1);
            startIdx = findStartIdx(barr, curIdx);
            count--;
        }
        print(res, barr);

    }

    public static int findStartIdx(boolean barr[], int curIdx) {
        for (int i = curIdx+1; i < barr.length; i++) {
            if (barr[i] == false) {
                return i;
            }
        }
        for (int i = 0; i < curIdx; i++) {
            if (barr[i] == false)
                return i;
        }
        throw new RuntimeException();
    }

    public static void print(ArrayList<Integer> list, boolean[] bArr){
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(list.size()-1));
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == false) {
                System.out.println(i+1);
            }
        }
    }
}
