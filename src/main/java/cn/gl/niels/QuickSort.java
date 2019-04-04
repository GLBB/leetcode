package cn.gl.niels;

/**
 * 快速排序：
 * 1）是一种原地排序，即不需要额外的空间。
 * 2）不稳定排序，即对于有相同值的不同元素，原来在后面的元素可能会被交换到前面。
 *    如给每一个值赋予一个标识符，如下 第一个数字1的标识符为 a。
 *    图示：a b c d e
 *          1 3 3 4 5
 *          可能会被排序成为如下：
 *          a c b d e
 *          1 3 3 4 5
 */
public class QuickSort {

    /**
     * 对整个数组进行原地排序
     * @param arr
     */
    public void sort(int[] arr){
        sort(arr, 0, arr.length);
    }

    /**
     * 算法思想：每次让第 n 小的元素到第 n-1 的位置。
     * 1）find pivot point
     * 2) sort pivot point left
     * 3) sort pivot point right
     * <br/>
     * 排序数组索引从 i 到 小于 j 的元素，即 i <= x < j, 即范围为: [i,j)
     * @param arr 待排序数字
     * @param i
     * @param j
     */
    public void sort(int[] arr, int i, int j) {
        if (i == j)
            return;
        int pivot = pivot(arr, i, j);
        sort(arr, i, pivot);
        sort(arr, pivot+1, j);
    }

    /**
     * 寻找数组索引范围在 startIdx <= x < endIdx 的枢点，[startIdx, endIdx)
     * @param arr
     * @param startIdx
     * @param endIdx
     * @return
     */
    private int pivot(int[] arr, int startIdx, int endIdx){
        int i = startIdx - 1;
        int j = startIdx;
        while (j < endIdx) {
            if (arr[j] < arr[endIdx-1]) {
                i++;
                // swap(arr[i], arr[j])
                swap(arr, i, j);
            }
            j++;
        }
        // swap
        swap(arr, i+1, endIdx-1);
        return i+1;
    }

    /**
     * 交换数组中索引为 i 和 j 的值。
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
