package cn.gl.offer_niuke;

public class VerifySquenceOfBST {

    public static void main(String[] args) {
        VerifySquenceOfBST x = new VerifySquenceOfBST();
        int[] arr = {4, 6, 7, 5};
        boolean b = x.VerifySquenceOfBST(arr);
        System.out.println(b);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return check(sequence, sequence.length -1, 0, sequence.length -2);
    }

    private boolean check(int [] sequence, int rootIdx, int left, int right){
        if (left > right)
            return true;
        int idx = left;
        while (idx <= right ) {
            if (sequence[idx] < sequence[rootIdx]) {
                idx++;
            }else {
                break;
            }
        }
        if (idx <= right) {
            for (int i = idx; i <= right; i++) {
                if (sequence[i] < sequence[rootIdx]){
                    return false;
                }
            }
        }
        boolean res1 = check(sequence, idx-1, left, idx - 2);
        boolean res2 = check(sequence, rootIdx-1, idx, rootIdx-2);
        if (res1 && res2)
            return true;
        else
            return false;
    }

}
