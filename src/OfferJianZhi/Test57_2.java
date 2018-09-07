package OfferJianZhi;

import org.junit.Test;

/**
 * 和为 S 的连续正数序列。
 * <p>
 * 例如 15 = 1+2+3+4+5 = 4+5+6+7 = 7+8。
 */
public class Test57_2 {
    @Test
    public void test() {
        int target = 3;
        PrintSerise(target);
    }

    private void PrintSerise(int target) {
        int left = 1, right = 2;
        int sum = 3;
        while (left < right) {
            if (sum == target) {
                Print(left, right);
                right++;
                sum = sum + right;
            } else if (sum < target) {
                right++;
                sum = sum + right;
            } else {
                sum = sum - left;
                left++;
            }
        }
    }

    private void Print(int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
