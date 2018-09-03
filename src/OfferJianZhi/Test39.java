package OfferJianZhi;

public class Test39 {
    /*
     * 方法1：如果输入数组符合要求，那么所求数字的出现次数要多于其他所有数字次数之和
     * 			该方法不需要对输入数组进行操作
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null)
            return 0;
        int N = array.length;
        int root = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (count == 0) {
                root = array[i];
                count = 1;
            }
            if (array[i] == root) {
                count++;
            } else {
                count--;
            }
        }
        //判断数组中书否存在出现次数大于一半的数字
        if (checkArray(array, root)) {
            return root;
        } else
            return 0;
    }

    //检查数组是否存在出现次数超过一半的数字
    private boolean checkArray(int[] array, int root) {
        int N = array.length;
        int num = 0;
        for (int i = 0; i < N; i++) {
            if (array[i] == root) {
                num++;
            }
        }
        if (num * 2 > N)
            return true;
        else
            return false;
    }
}
