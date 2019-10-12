package cn.gl.wangyi;

import java.util.*;

public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String th1Line = scanner.nextLine();
            String th2Line = scanner.nextLine();
            Integer th2Value = Integer.valueOf(th2Line);
            ArrayList<Double[]> list = new ArrayList<>();
            for (int i = 0; i < th2Value; i++) {
                String line = scanner.nextLine();
                String[] s = line.split(",");
                Double[] arr = new Double[2];
                arr[0] = Double.valueOf(s[0]);
                arr[1] = Double.valueOf(s[1]);
                list.add(arr);
            }
            solution2(Integer.valueOf(th1Line), list);
            scanner.nextLine();
        }

//        System.out.println(Integer.valueOf("0.0"));

    }

    private static void solution2(int num, ArrayList<Double[]> list){
        if (list.size() <= 0)
            return;
        double[] res = new double[num+1];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        res[0] = 0;
        map.put(0, new HashSet<>());
        for (int i = 0; i < list.size(); i++) {
            Double[] doubles = list.get(i);
            if (doubles[1] <= 0){
                list.remove(i);
            }
        }
        for (int i = 1; i < res.length; i++) {
            double basicValue = res[i - 1];
            HashSet<Integer> set = map.get(i-1);
            double max = basicValue;
            for (int j = 0; j < list.size(); j++) {
                Double[] doubles = list.get(j);
                int x = i - ((int)doubles[0].doubleValue());
                HashSet<Integer> integers = map.get(x);
                if (x >= 0 && !integers.contains(j)) {
                    double value = doubles[0] * doubles[1];
                    double curValue = value + res[x];
                    if (max < curValue){
                        max = curValue;
                        HashSet<Integer> before = map.get(x);
                        set = new HashSet<>(before);
                        set.add(j);
                    }
                }
            }
            res[i] = max;
            map.put(i, set);
        }
        System.out.printf("%.4f%n", res[num]);
    }

    private static void solution(int num, ArrayList<Double[]> list){
        ArrayList<Double> price = new ArrayList<>();
        HashSet<Integer> hasUsed = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Double[] item = list.get(i);
            Double value = item[0] * item[1];
            price.add(value);
        }
        Double value = 0d;
        int count = 0;
        while (count < num) {
            int idx = findNextMax(price, hasUsed);
            if (idx == -1)
                break;
            hasUsed.add(idx);
            value += price.get(idx);
        }
        System.out.printf("%.4f%n", value);

    }


    // 排除负数，排除已使用过的，找到最大的 idx
    private static int findNextMax(ArrayList<Double> price, HashSet<Integer> hasUsed){
        if (price.size() <= 0) {
            return -1;
        }
        int maxIdx = -1;
        // findFirst
        for (int i = 0; i < price.size(); i++) {
            if (price.get(i) <= 0 || hasUsed.contains(i)) {
                continue;
            }
            maxIdx = i;
        }
        for (int i = maxIdx+1; i < price.size(); i++) {
            if (price.get(i) <= 0 || hasUsed.contains(i)) {
                continue;
            }
            if (price.get(i) > price.get(maxIdx)) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
