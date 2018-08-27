package JianZhiOffer;

import org.junit.Test;

/**
 * 计算一个十进制数如果换算成二进制数以后有多少个1。
 */
public class Test15 {

    @Test
    public void test() {
        int number = 8;
        int count = NumberOfOne(number);
        System.out.println(Integer.toBinaryString(number) + ": " + count);

        int number2 = -8;
        int count2 = NumberOfOne2(number2);
        System.out.println(Integer.toBinaryString(number2) + ": " + count2);

        // 几种进制转化的输出：
        String a = Integer.toHexString(123); // 10->16
        String b = Integer.toOctalString(123); // 10->8
        String c = Integer.toBinaryString(123); // 10->2
        String d = Integer.valueOf("FFFF", 16).toString(); // 16->10
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    private int NumberOfOne2(int number) {
        int count = 0, flag = 1;
        for (int i = 0; i < 32; i++) {
            int temp = number & flag;
            if (temp > 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 未考虑负数情况的算法。
     */
    private int NumberOfOne(int number) {
        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                count++;
                number = number >> 1;
            } else {
                number = number >> 1;
            }
        }
        return count;
    }
}
