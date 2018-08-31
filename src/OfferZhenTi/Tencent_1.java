package OfferZhenTi;

import org.junit.Test;

import java.util.Scanner;

/**
 * 小Q定义了一种数列称为翻转数列:
 * 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
 * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
 * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
 * 小Q现在希望你能帮他算算前n项和为多少。
 * <p>
 * 【输入描述】
 * <p>
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
 * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 * <p>
 * 分析：这道题比较好的处理方法也最容易理解的是用组合数来求解，
 * 说到组合数就很容易想到这道题和我们高中做的从两个盒子里取小球的排列组合题。
 * <p>
 * 此题可以转换为这样一道数学题，有两个盒子，一个盒子里装有3个红球，一个盒子里装有3个白球，红球代表2分，白球代表3分，
 * 则从两个盒子中任意拿球使其分数等于9的拿法有多少种。
 * <p>
 * 这样就会想如果拿了0个红球，白球有多少种拿法，如果拿了1个、2个、3个红球，白球各有多少种拿法。
 * <p>
 * 再者，将球的数量和球的分数换成未知的量：即有两个盒子，一个盒子里装有X个红球，一个盒子里装有Y个白球，红球代表A分，
 * 白球代表B分，则从两个盒子中任意拿球使其分数等于K的拿法有多少种。很显然就和面试题一样了，
 * 可以想到假设拿了 i 个红球（ i  <= X），需要满足条件：
 * （ i * A <= K : 分数不能超过K）&&（（ K - i* A）% B == 0  ：确保分数相加等于K） &&  （（ K - i* A）/  B  <= Y  :不能超过白球的数目），
 * 将满足条件的结果相加起来就是最后的结果。
 * <p>
 * 而当满足条件后从各自的盒子里拿球就有不同的拿法，是很典型的排列组合问题，对于这道题我们可以建一个二维数组来存这些组合数，
 * 行标代表排列组合公式的下标，列标代表排列组合公式的上标，具体的存法和杨辉三角有些类似，可以直接看代码：
 */
public class Tencent_1 {

    private int[][] arr = new int[101][101]; // 因为歌曲的数量不超过100种。

    @Test
    public void main() {
        int k = 5; // 总长度。
        int A = 2; // 长度为 A 的 X 首歌曲。
        int X = 3;
        int B = 3; // 长度为 B 的 Y 首歌曲。
        int Y = 3;
        Initial(arr);
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(Calculate(k, A, X, B, Y));
    }

    /**
     * @param k 总长度。
     * @param a 长度为 A 的 X 首歌曲。
     * @param x
     * @param b 长度为 B 的 Y 首歌曲。
     * @param y
     * @return
     */
    private int Calculate(int k, int a, int x, int b, int y) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            int aLength = a * i;
            int bLength = k - aLength;
            boolean bOK = bLength % b == 0;
            if (aLength <= k && bOK && bLength / b <= y) {
                sum = (sum + (arr[x][i] * arr[y][bLength / b]) % 1000000007) % 1000000007;
            }
        }
        return sum;
    }

    /**
     * 构建杨辉三角，用于计算 C（m，n）。
     *
     * @param arr
     */
    private void Initial(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i][1] = i;
        }
        for (int i = 2; i < arr[0].length; i++) {
            for (int j = 2; j <= i; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % 1000000007;
            }
        }
    }
}
