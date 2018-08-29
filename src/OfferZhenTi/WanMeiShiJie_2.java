package OfferZhenTi;

import java.util.Arrays;

/**
 * 题目描述：
 * 今年教师节活动中，完美公司里为培训讲师提供了不同面值的饮料兑换券（假设每种面值数量不限），
 * 培训讲师可以领取兑换券去完美食堂兑换鲜榨果汁饮品，要求兑换券和果汁必须等价，不能多也不能少。
 * 假设姜小虎想兑换一杯果汁，请帮计算出他最少要领取几张兑换券。如果无法兑换返回-1。
 * 举例：
 * 1.有3种兑换券，面值分别是5，2，3。饮料的价值是20，用4个5元的兑换券正好兑换，其他的兑换方法都要更多的兑换券，所以返回4
 * 2.有两种兑换券，面值分别是5,3，饮料的价值是2.无法正好兑换，所以返回-1
 * <p>
 * 输入
 * 第一行：兑换券的面值种类（种类>0）
 * 第二行：数组，代表兑换券的面值（面值>0）
 * 第三行：一个整数，代表饮料的价值（饮料的价值>0）
 * 输出
 * 对于每个测试实例，要求输出最少兑换券张数。
 * <p>
 * 样例输入
 * 3
 * 5 2 3
 * 20
 * <p>
 * 样例输出
 * 4
 */


public class WanMeiShiJie_2 {
    public static void main(String args[]) {
        /*
        Scanner reader = new Scanner(System.in);
        int x = reader.nextInt();
        int[] array = new int[x];
        for (int i = 0; i < x; i++) {
            array[i] = reader.nextInt();
        }
        int y = reader.nextInt();
        */
        int[] array = {5, 2, 3}; // 零钱的面额。
        int y = 20;
        System.out.println(minCoins(array, y));
    }

    /**
     * 分硬币。
     *
     * @param arr 零钱面额。
     * @param aim 总钱数。
     * @return
     */
    public static int minCoins(int[] arr, int aim) {
        int[] ints = new int[aim + 1];
        for (int i = 0; i < arr.length; i++) {
            ints[arr[i]] = 1;
        }
        System.out.println(Arrays.toString(ints)); // 查看初始化 ints。
        for (int i = 1; i <= aim; i++) {
            ints[i] = MinInts(ints, i);
        }
        System.out.println(Arrays.toString(ints)); // 查看更改后的 ints。
        return ints[ints.length - 1];
    }

    /**
     * 计算当前金额的最少零钱数。
     *
     * @param ints
     * @param index
     * @return
     */
    private static int MinInts(int[] ints, int index) {
        if (ints[index] == 1) {
            return 1;
        }
        int tempSum, min = 0;
        for (int i = 0; i <= index / 2; i++) { // index = 2;
            if (ints[i] != 0 && ints[index - i] != 0) {
                tempSum = ints[i] + ints[index - i];
                if (min == 0) {
                    min = tempSum;
                } else {
                    min = tempSum < min ? tempSum : min;
                }
            }
        }
        return min;
    }
}