package OfferJianZhi;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组中唯一只出现一次的数字。
 * <p>
 * 再一个数组中除一个数字只出现一次以外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Test56_2 {
    @Test
    public void test() {
        int[] ints = {2, 2, 2, 6, 6, 19, 6};
        int result = FindTheOne(ints);
        System.out.println(result);
    }

    private int FindTheOne(int[] ints) {
        int[] bits = new int[32];
        for (int i = 0; i < ints.length; i++) {
            AddByBits(bits, ints[i]);
        }
        System.out.println(Arrays.toString(bits));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            bits[i] = bits[i] % 3;
            sb = sb.append(bits[i]);
        }
        System.out.println(Arrays.toString(bits));
        System.out.println(sb.toString());
        return Integer.valueOf(sb.toString(), 2);
    }

    // 二进制每位相加。
    private void AddByBits(int[] bits, int anInt) {
        for (int i = bits.length - 1; i >= 0; i--) {
            bits[i] = bits[i] + (anInt & 1);
            anInt = anInt >> 1;
        }
    }
}
