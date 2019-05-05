package cn.gl;

import java.util.ArrayList;

public class PermutationSequence {
    public static void main(String[] args) {
        String permutation = getPermutation(4, 9);
        System.out.println(permutation);


    }


    public static String getPermutation(int n, int k) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i+"");
        }
        String res = "";
        int iter = 1;
        for (int i = 2; i <= n; i++) {
            iter *=  i;
        }
        int num = iter / list.size();
        int th = k -1;
        while (list.size() > 0){
            int nh = th / num;
            String s = list.get(nh);
            list.remove(nh);
            res += s;

            // update th, num
            th = th % num;
            if (list.size() == 0)
                break;
            num = num / list.size();
        }
        return res;
    }

}
