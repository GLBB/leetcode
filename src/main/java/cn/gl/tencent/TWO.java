package cn.gl.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TWO {

    static class Pair{
        int key;
        int value;

        public Pair(int i, int i1) {
            key = i;
            value = i1;
        }

        public Pair() {
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key1=" + key +
                    ", key2=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String n = scanner.nextLine();
            ArrayList<Pair> list = new ArrayList<>();
            for (int i = 0; i < Integer.valueOf(n); i++) {
                String s = scanner.nextLine();
                String[] s1 = s.split(" ");
                Pair pair = new Pair();
                pair.key = Integer.valueOf(s1[0]);
                pair.value = Integer.valueOf(s1[1]);
                list.add(pair);
            }
            solution(list);
        }

//        test();
    }

    private static void solution(ArrayList<Pair> list){
        Comparator<Pair> comparator = (o1, o2) -> {
            if (o1.value > o2.value)
                return 1;
            else if (o1.value == o2.value)
                return 0;
            else
                return -1;
        };
        int worker = 0;
        for (int i = 0; i < list.size(); i++) {
            worker += list.get(i).key;
        }
        list.sort(comparator);
        ArrayList<Integer> work = new ArrayList<>();
        for (int i = 0; i < worker / 2; i++) {
            Pair minPair = list.get(0);
            Pair maxPair = list.get(list.size()-1);
            Integer workerTime = (minPair.value + maxPair.value);
            minPair.key = minPair.key - 1;
            maxPair.key = maxPair.key - 1;
            if (minPair.key == 0) {
                list.remove(minPair);
            }
            if (maxPair.key == 0) {
                list.remove(maxPair);
            }
            work.add(workerTime);
        }
        Collections.sort(work);
        System.out.println(work.get(work.size() -1));
    }

    private static void test(){
        Comparator<Pair> comparator = (o1, o2) -> {
            if (o1.value > o2.value)
                return 1;
            else if (o1.value == o2.value)
                return 0;
            else
                return -1;
        };
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(1, 2));
        list.add(new Pair(1, 3));
        list.sort(comparator);
        System.out.println(list);

    }
}
