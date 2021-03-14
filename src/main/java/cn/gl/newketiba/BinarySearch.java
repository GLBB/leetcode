package cn.gl.newketiba;

public class BinarySearch {

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        if (a == null && a.length == 0) {
            return 1;
        }
        if (a[a.length - 1] < v) {
            return a.length + 1;
        }
        int start = 0;
        int end = a.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = ( start + end ) / 2;
            if (a[mid] > v) {
                end = mid -1;
            } else if (a[mid] < v) {
                start = mid + 1;
            } else if (a[mid] == v) {
                int target = mid;
                while ( target > 0 && a[target - 1] == a[mid]) {
                    target -= 1;
                }
                return target + 1;
            }
        }
        return 0;
    }
}
