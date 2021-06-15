package cn.gl.newketiba;

public class NC88 {

    private Integer res = 0;
    private boolean findRes = false;

    public int findKth(int[] a, int n, int K) {
        int kthMin = n - K + 1;
        findKthByQuickSort(a, 0, n - 1, kthMin);
        return res;
    }

    private void findKthByQuickSort(int[] arr, int start, int end, int k) {
        int pivot = findPivot(arr, start, end);
        if (k - 1 == pivot) {
            res = arr[pivot];
            findRes = true;
            return;
        }
        if (pivot == -1) {
            return;
        }
        if (!findRes) {
            findKthByQuickSort(arr, start, pivot - 1, k);
            findKthByQuickSort(arr, pivot + 1, end, k);
        }
    }

    private int findPivot(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int i = start + 1;
        int j = end;
        while( i <= j && i <= end && j > start) {
            if (arr[start] >= arr[i])  {
                i++;
            } else if (arr[start] <= arr[j]) {
                j--;
            } else if (arr[i] > arr[j]) {
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
