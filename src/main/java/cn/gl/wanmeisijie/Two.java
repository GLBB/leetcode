package cn.gl.wanmeisijie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Two {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String fline = scanner.nextLine();
//            String[] fArr = fline.split(" ");
//            int wei = Integer.parseInt(fArr[0]);
//            int startPoint = Integer.parseInt(fArr[1]);
//            int[][] arr = new int[wei][wei];
//            for (int i = 0; i < wei; i++) {
//                String line = scanner.nextLine();
//                String[] s = line.split(" ");
//                for (int j = 0; j < s.length; j++) {
//                    arr[i][j] = Integer.parseInt(s[j]);
//                }
//            }
//            solution(arr, startPoint);
//        }







        int[][] arr = {
                {-1,1,4, -1, -1, -1},
                {1, -1, 2, 7, 5, -1},
                {4, 2, -1, -1, 1, -1},
                {-1, 7, -1, -1, 3, 2},
                {-1, 5, 1, 3, -1, 6},
                {-1, -1, -1, 2, 6, -1}
        };
        solution(arr, 0);
    }


    public static void solution(int[][] ajanent, int startPoint) {
        ArrayList<Helper> vt = new ArrayList<>();
        Helper helper = new Helper(startPoint, startPoint, 0);
        vt.add(helper);
        ArrayList<Helper> nvt = new ArrayList<>();
        for (int i = 0; i < ajanent.length; i++) {
            if (i==startPoint)
                continue;
            Helper h = new Helper(i, startPoint, ajanent[startPoint][i]);
            nvt.add(h);
        }
        for (int i = 0; i < ajanent.length-1; i++) {
            // find nvt 中距离最小
            // 加入 vt
            // 修改 nvt
            //   nvt 中的点到加入点的距离之和小于原来值
            //  或者 nvt 中原来点为 distance= -1, 且数组中这个值不为-1,就修改 nvt中对应的Helper
            int idx = 0;
            Integer minDis = nvt.get(0).distance;
            for (int j = 1; j < nvt.size(); j++) {
                if (minDis == -1){
                    minDis = nvt.get(j).distance;
                    idx = j;
                }else {
                    int tempDis = nvt.get(j).distance;
                    if (tempDis >= 0 && tempDis < minDis){
                        minDis = tempDis;
                        idx = j;
                    }
                }
            }
            if (minDis == -1)
                break;
            Helper remH = nvt.remove(idx);
            int apoint = remH.point;
            vt.add(remH);
            for (int j = 0; j < nvt.size(); j++) {
                Helper h1 = nvt.get(j);
                if (h1.distance == -1){
                    if (ajanent[h1.point][apoint] != -1){
                        h1.toPoint = apoint;
                        h1.distance = ajanent[h1.point][apoint] + remH.distance;
                    }
                }else {
                    int temp = 0;
                    if (ajanent[h1.point][apoint]!=-1&&  (temp=ajanent[h1.point][apoint] + remH.distance) < h1.distance) {
                        h1.toPoint = apoint;
                        h1.distance = temp;
                    }
                }

            }
        }
        // print
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < vt.size(); i++) {
            if (i== startPoint)
                continue;
            // find point = i;
            int idx = 0;
            for (int j = 0; j < vt.size(); j++) {
                Helper h2 = vt.get(j);
                if (h2.point == i){
                    idx = j;
                    break;
                }
            }
            Helper helper1 = vt.get(idx);
            list.add(helper1.distance);
        }
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i)+",");
        }
        System.out.println(list.get(list.size()-1));
    }
}

class Helper{
    int point;
    Integer toPoint;
    Integer distance;

    public Helper(int point, int toPoint, int distance) {
        this.point = point;
        this.toPoint = toPoint;
        this.distance = distance;
    }
}
