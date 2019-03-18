package cn.gl.cqutcoj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DecompositionPrimeFactor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> result = getResult(n);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        }
    }

    public static List<Integer> getResult(int n){
        List<Integer> result = new ArrayList<>();
        Pair pair = isPrime(n);
        if (pair.prime){
            result.add(1);
            result.add(n);
            return result;
        }

        while (!pair.prime) {
            result.add(pair.factor);
            n = n / pair.factor;
            pair = isPrime(n);
        }

        result.add(n);
        result.sort(getComparator());

        return result;
    }

    private static Pair isPrime(int n){
        for (int i = 2; i < n/2; i++) {
            if (n%i==0) {
                return new Pair(false, i);
            }
        }
        return new Pair(true, 1);
    }

    static class Pair{
        boolean prime;
        int factor;

        public Pair(boolean prime, int factor) {
            this.prime = prime;
            this.factor = factor;
        }
    }

    private static Comparator<Integer> getComparator(){


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                else if (o1==o2) return 0;
                else return -1;
            }
        };

        return comparator;

    }
}
