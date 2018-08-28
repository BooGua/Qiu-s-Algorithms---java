package OfferJianZhi;

import org.junit.Test;

/**
 * 剪绳子问题，动态规划算法。
 */
public class Test14 {

    public static int maxProductAfterCutting(int len) {
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return 1;
        }
        if (len == 3) {
            return 2;
        }
        // 存储长度从 0—len 的最大结果。
        int[] result = new int[len + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        // 自底向上开始求解。
        int max = 0;
        for (int i = 4; i <= len; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int tempResult = result[j] * result[i - j];
                if (max < tempResult) {
                    max = tempResult;
                }
                result[i] = max;
            }
        }
        max = result[len];
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxProductAfterCutting(9));
    }
}
