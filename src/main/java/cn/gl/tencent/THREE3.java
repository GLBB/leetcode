package cn.gl.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class THREE3 {

    static class Pair{
        int key1;
        int key2;

        public Pair(int i, int i1) {
            key1 = i;
            key2 = i1;
        }

        public Pair() {
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key1=" + key1 +
                    ", key2=" + key2 +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pair> res = new ArrayList();
        while (scanner.hasNextInt()) {
            String t = scanner.nextLine();
            for (int i = 0; i < Integer.valueOf(t); i++) {
                String fLine = scanner.nextLine();
                String sLine = scanner.nextLine();
                ArrayList<Integer> list = new ArrayList<>();
                String[] s = sLine.split(" ");
                for (int j = 0; j < s.length; j++) {
                    list.add(Integer.valueOf(s[j]));
                }
                solution(list, res);
            }
            for (int i = 0; i < res.size(); i++) {
                int key1 = res.get(i).key1;
                int key2 = res.get(i).key2;
                int min = key1 < key2 ? key1 :key2;
                int max = key1 < key2 ? key2 : key1;
                System.out.println(min + " " + max);
            }
        }
    }

    public static void solution(ArrayList<Integer> list, ArrayList<Pair> res){
        Pair pair = new Pair();
        pair.key1 = 0;
        pair.key2 = 0;
        Collections.sort(list);
        while (list.size() >= 4) {
            int value1 = list.get(0) + list.get(list.size() - 1);
            int value2 = list.get(1) + list.get(list.size() - 2);
            int max = 0, min = 0;
            if (value1 > value2) {
                max = value1;
                min = value2;
            }else {
                max = value2;
                min = value1;
            }
            if (pair.key1 < pair.key2) {
                pair.key1 += max;
                pair.key2 += min;
            }else{
                pair.key1 += min;
                pair.key2 += max;

            }
            list.remove(0);
            list.remove(1);
            list.remove(list.size()-1);
            list.remove(list.size() - 1);
        }
        if (list.size() == 0){

        }else if (list.size() == 1) {
            if (pair.key1 < pair.key2) {
                pair.key1 += list.get(0);
            }else {
                pair.key2 += list.get(0);
            }
        }else if (list.size() == 2){
            if (pair.key1 < pair.key2) {
                pair.key1 += list.get(1);
                pair.key2 += list.get(0);
            }else {
                pair.key1 += list.get(0);
                pair.key2 += list.get(1);
            }
        }else if (list.size() == 3) {
            int value1 = list.get(0) + list.get(2);
            int value2 = list.get(1);
            int min=0, max=0;
            if (value1 > value2) {
                min = value2;
                max = value1;
            }else {
                min = value1;
                max = value2;
            }
            if (pair.key1 < pair.key2) {
                pair.key1 += max;
                pair.key2 += min;
            }else {
                pair.key1 += min;
                pair.key2 += max;
            }
        }
        res.add(pair);
    }
}
