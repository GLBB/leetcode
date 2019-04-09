package cn.gl;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 0};
        int kthLargest = findKthLargest(nums, 3);
        System.out.println();
    }

    static int heapSize;

    public static int findKthLargest(int[] nums, int k) {
        heapSize  = nums.length;
        buildHeap(nums);
        int result = 0;
        for (int i = k-1; i >0 ; i--) {
            Integer integer = remove(nums);
        }
        result = remove(nums);
        return result;
    }



    public static Integer remove(int[] nums){
        if (heapSize == 0){
            throw new RuntimeException("error");
        }
        int result = nums[0];
        nums[0] = nums[heapSize-1];
        heapSize--;
        heapfy(nums, 0);
        return result;
    }

    public static void buildHeap(int[] nums){
        for (int i = heapSize/2; i >= 0 ; i--) {
            heapfy(nums, i);
        }
    }

    /**
     *
     * @param nums
     * @param idx
     */
    public static void heapfy(int[] nums, int idx){
       if (idx >= heapSize)
           return;
       int lagest = getLeft(idx);
       if (lagest >= heapSize)
           return;
       if (nums[idx] > nums[lagest]) {
           lagest = idx;
       }
       int right = getRight(idx);
       if (right < heapSize){
           if (nums[right] > nums[lagest]) {
               lagest = right;
           }
       }
       if (lagest != idx){
           int temp = nums[idx];
           nums[idx] = nums[lagest];
           nums[lagest] = temp;
           heapfy(nums, lagest);
       }
    }

    public static int getLeft(int idx){
        return (idx << 1) + 1;
    }

    public static int getRight(int idx) {
        return (idx << 1) + 2;
    }
}
