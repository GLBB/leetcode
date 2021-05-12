package cn.gl.newketiba;

import java.util.*;

public class NC54 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0};
        ArrayList<ArrayList<Integer>> result = new NC54().threeSum(arr);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedHashSet<Wrapper> set = new LinkedHashSet<>();
        for (int i = 0; i <= num.length - 3; i++) {
            for (int j = i+1; j <= num.length - 2; j++) {
                for (int k = j+1; k <= num.length - 1; k++) {
                    if (num[i] + num[j] + num[k] == 0) {
                        set.add(new Wrapper(num[i], num[j], num[k]));
                    }
                }
            }
        }
        for (Wrapper wrapper : set) {
            ArrayList<Integer> item = new ArrayList<>();
            item.add(wrapper.x);
            item.add(wrapper.y);
            item.add(wrapper.z);
            result.add(item);
        }
        result.sort((o1, o2) -> {
            if (o1.get(0) < o2.get(0)) {
                return -1;
            } else if (o1.get(0) == o2.get(0)) {
                if (o1.get(1) < o2.get(1)) {
                    return -1;
                } else if (o1.get(1) == o2.get(1)) {
                    if (o1.get(2) < o2.get(2)) {
                        return -1;
                    } else if (o1.get(2) == o2.get(2)) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });
        return result;
    }
    
    static class ListSort implements Comparator<List<Integer>> {
        
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return 0;
        }
    }
    
    static class Wrapper {
        int x;
        int y;
        int z;
        public Wrapper(int x, int y, int z) {
            ArrayList<Integer> list = new ArrayList<>();
            Collections.addAll(list, x, y, z);
            list.sort(Integer::compareTo);
            this.x = list.get(0);
            this.y = list.get(1);
            this.z = list.get(2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Wrapper wrapper = (Wrapper) o;
            return x == wrapper.x &&
                y == wrapper.y &&
                z == wrapper.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
}
