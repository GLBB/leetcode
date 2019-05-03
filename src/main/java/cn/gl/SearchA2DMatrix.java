package cn.gl;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length == 0 || matrix[0].length==0)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[i].length-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        while (low<= high) {
            int mindle = (low+high)/2;
            if (arr[mindle] == target)
                return true;
            else if (arr[mindle] < target)
                low = mindle+1;
            else
                high = mindle-1;
        }
        return false;
    }

}
