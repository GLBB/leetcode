package cn.gl.offer_niuke;

public class th6 {

    public static void main(String[] args) {
        int[] arr = { 1,1,1,0,1};
        th6 t = new th6();
        int i = t.minNumberInRotateArray(arr);
        System.out.println(i);
    }

    // if arr[low] < arr[mid] < arr[high] return arr[low]
    // if arr[low] < arr[mid] min in arr[mid],arr[high],
    // if arr[mid] < arr[high] min in arr[low],arr[mid]
    // if arr[low] == arr[mid] == arr[high] for
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int low = 0, high = array.length - 1, mid = 0;
        while (array[low] >= array[high]) {
            if (low + 1 == high){
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[low] == array[mid] && array[mid] == array[high]) {
                return findMin(array, low, high);
            }
            if (array[low] <= array[mid])
                low = mid;
            else if (array[mid] <= array[high])
                high = mid;
        }
        return array[mid];
    }

    private int findMin(int[] arr, int low, int high) {
        int min = arr[low];
        for (int i = low; i <= high; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
