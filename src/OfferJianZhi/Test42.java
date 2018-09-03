package OfferJianZhi;

import org.junit.Test;

/**
 *
 */
public class Test42 {
    @Test
    public void test() {
        int[] ints_1 = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] ints_2 = {-101, -2, -9, -10};
        int[] ints_3 = {0, 0, 0, 0, 3, -1, -1, -1};
        System.out.println(FindGreatestSumOfSubArray(ints_1));
        System.out.println(FindGreatestSumOfSubArray(ints_2));
        System.out.println(FindGreatestSumOfSubArray(ints_3));
    }

    private int FindGreatestSumOfSubArray(int[] ints) {
        if (ints.length == 1)
            return ints[0];
        int sum = ints[0], max = ints[0];
        for (int i = 1; i < ints.length; i++) {
            int temp = sum + ints[i];
            if (temp <= 0) {
                sum = 0;
                if (max < ints[i]) {
                    max = ints[i];
                }
                continue;
            }
            if (max < temp) {
                max = temp;
            }
            sum = temp;
        }
        return max;
    }
}
