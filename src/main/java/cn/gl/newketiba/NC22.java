package cn.gl.newketiba;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class NC22 {

    public static void main(String[] args) {
        int[] A = {1, 0};
        int[] B = {2};
        new NC22().merge(A, 1, B, 1);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int A[], int m, int B[], int n) {
        int aIdx = m - 1;
        int bIdx = n - 1;
        int idx = A.length - 1;
        while (aIdx >= 0 && bIdx >= 0) {
            if (A[aIdx] > B[bIdx]) {
                A[idx] = A[aIdx];
                aIdx --;
            } else {
                A[idx] = B[bIdx];
                bIdx --;
            }
            idx --;
        }
        if (bIdx >= 0) {
            int i = 0;
            while (i <= bIdx) {
                A[i] = B[i];
                i++;
            }
            idx += 1;
            while (idx < A.length) {
                A[i] = A[idx];
                i++;
                idx++;
            }
            while (i < A.length) {
                A[i] = 0;
                i++;
            }
        } else {
            aIdx += 1;
            idx += 1;
            while (aIdx < A.length && idx  < A.length) {
                A[aIdx] = A[idx];
                aIdx ++;
                idx++;
            }
            while (aIdx < A.length) {
                A[aIdx] = 0;
                aIdx ++;
            }
        }
    }
    
}
