package cn.gl._360;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TWO {

    static int main(int[] arr) {
        if (arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer value = map.get(arr[i]);
            if (value == null){
                map.put(arr[i], 1);
            }else {
                map.put(arr[i], value+1);
            }
        }
        HashSet<Integer> nums = getNums(map);
        int factor = gcd(nums);
        if (factor == 0)
            return 0;
        int count = 0;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Integer value = map.get(key);
            count += (value / factor);
        }
        return count;
    }

    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int res;
//        while (scanner.hasNextLine()){
//            String first = scanner.nextLine();
//            String second = scanner.nextLine();
//            int[] arr = str2Arr(second);
//            res = main(arr);
//            System.out.println(String.valueOf(res));
//        }

        int[] arr =  {1, 1, 1, 2, 2};
        int main = main(arr);
        System.out.println(main);

    }

    private static int[] str2Arr(String line){
        String[] strArr = line.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

    private static HashSet<Integer> getNums(HashMap<Integer, Integer> map){
        HashSet<Integer> set = new HashSet<>();
        Set<Integer> keys = map.keySet();
        for (Integer key :  keys) {
            Integer v = map.get(key);
            set.add(v);
        }
        return set;
    }

    public static int gcd(HashSet<Integer> set){
        int min = Integer.MAX_VALUE;
        for (Integer i : set) {
            if (min > i){
                min = i;
            }
        }
        for (int i = min; i >= 1; i--) {
            boolean flag = true;
            for (int v : set){
                if (v % i == 0){
                    flag = false;
                }
            }
            if (flag)
                return i;
        }
//        return 0;
        throw new RuntimeException();
    }
}
