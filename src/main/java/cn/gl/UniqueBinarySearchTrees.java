package cn.gl;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n==0 || n==1)
            return 1;
        int[] res = new int[n+1];
        res[0] = res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += res[j] * res[(i-1-j)];
            }
            res[i] = sum;
        }
        return res[n];
    }

}
