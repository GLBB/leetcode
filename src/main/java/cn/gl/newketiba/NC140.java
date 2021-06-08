package cn.gl.newketiba;

/**
 * 排序
 */
public class NC140 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
        // write code here
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private void sort(int[] arr, int start, int end) {
        int pivotIdx = piovt(arr, start, end);
        if (pivotIdx == -1) {
            return;
        }
        sort(arr, start, pivotIdx - 1);
        sort(arr, pivotIdx + 1, end);
    }

    private int piovt(int[] arr, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int i = start + 1;
        int j = end;
        while (i <= j && i <= end && j > start) {
            if (arr[i] <= arr[start]) {
                i++;
            } else if (arr[j] >= arr[start]) {
                j--;
            } else {
                swap(arr, i, j);
            }
        }
        swap(arr, start, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
