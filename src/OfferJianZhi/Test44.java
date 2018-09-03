package OfferJianZhi;

import org.junit.Test;

/**
 * 数字序列中某一位的数字。
 * <p>
 * 题目描述：
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从0开始计数）是5，第13位是1，
 * 第19位是4，等等。请写一个函数，求任意第n位对应的数字。
 */
public class Test44 {

    @Test
    public void test() {
        int theNumber = TheNumber(1001);
        System.out.println("最终答案：" + theNumber);
    }

    private int TheNumber(int number) {
        int[] ints = new int[2];
        GetIAndSum(ints, number);
        int i = ints[0]; // 在 i 区间。
        int sum = ints[1]; // 前区间数位和。
        int numberI = number - sum; // 在 i 区间的第 numberI 个数字。
        System.out.println("在当前区间的第 numberI 个数：" + numberI);
        int numberTrue = NumberTrue(numberI, i);
        int m = (int) ((number - (Math.pow(10, i - 1) - 1)) % i); // 第 m 位数。
        if (m == 0) {
            return numberTrue % 10;
        } else {
            String s = "" + numberTrue;
            String c = "" + s.charAt(m - 1);
            return Integer.parseInt(c);
        }
    }

    // numberI 对应的真实数字是多少。
    private int NumberTrue(int numberI, int i) {
        int a = (int) (Math.ceil((double) numberI / i));
        int b = (int) Math.pow(10, i - 1) - 1;
//        System.out.println("a:" + a + ",b:" + b);
        return a + b;
    }

    // 获取第 number 个数字的区间、前区间和。
    private void GetIAndSum(int[] ints, int number) {
        int sum = 0, i = 0;
        int sumFinaly = 0;
        while (number - sum > 0) {
            sumFinaly = sum;
            i++;
            sum = sum + (int) (Math.pow(10, i) - Math.pow(10, i - 1)) * i;
        }
        ints[0] = i;
        ints[1] = sumFinaly;
        System.out.println("[" + number + "] 区间数：" + ints[0] + "，前区间和： " + sumFinaly);
    }

}