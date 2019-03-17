package cn.gl.bytedance;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String[] s = firstLine.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s2 = secondLine.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }

        Double solution = solution(m, arr);
        print(solution);

    }

    private static Double solution(int m, int[] arr){
        if (m <= arr.length) {
            getMlength(arr, m);
        }
        List<Double> list = arr2List(arr);
        Comparator<Double> comparator = comparator();
        list.sort(comparator);
        while (list.size() < m) {
            Double longest = list.remove(list.size() - 1);
            Double x = longest/2.0;
            insert(list, x);
//            list.add(x);
//            list.add(x);
        }


        list.sort(comparator);
        // 得到最长的，除2 大于最短
        double temp;
        Double longest = list.get(list.size()-1);
        while ( (temp = longest/2 )> list.get(0)) {
            list.remove(0);
            list.remove(list.size() - 1);
//            list.add(temp);
//            list.add(temp);
//            list.sort(comparator);
            insert(list, temp);
        }

        // 得到最短的
        Double result = list.get(0);

        return result;
    }

    private static int getMlength(int[] arr, int m){
        if(arr.length == 0) return 0;
        Arrays.sort(arr);
        return arr[arr.length - m];
    }

    private static List<Double> arr2List(int[] arr){
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Double.parseDouble(arr[i]+""));
        }
        return list;
    }

    private static Comparator<Double> comparator(){
        Comparator<Double> comparator = (i1, i2) -> {
            if (i1>i2) {
                return 1;
            }else if (i1==i2) {
                return 0;
            } else {
                return -1;
            }
        };
        return comparator;
    }

    public static void print(Double d){
        System.out.printf("%.2f%n", d);
    }

    private static void insert(List<Double> list, double v){
        for (int i = 0; i < list.size(); i++) {
            if (v< list.get(i)){
                list.add(i, v);
                list.add(i, v);
                break;
            }
        }

    }

}
