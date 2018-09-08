package OfferJianZhi;

import org.junit.Test;

/**
 * 股票的最大利润。
 *
 * 使用一个最小数组记录。
 */
public class Test63 {
    @Test
    public void test() {
        int[] ints = {9, 11, 8, 5, 7, 12, 16, 14};
        int[] mins = new int[ints.length];
        int minest = ints[0];
        for (int i = 0; i < mins.length; i++) {
            if (minest < ints[i]) {
                mins[i] = minest;
            } else {
                minest = ints[i];
            }
        }
        int max = ints[ints.length - 1] - ints[0];
        for (int i = ints.length - 1; i >= 0; i--) {
            int maxTemp = ints[i] - mins[i];
            if (max < maxTemp) {
                max = maxTemp;
            }
        }
        System.out.println(max);
    }
}
