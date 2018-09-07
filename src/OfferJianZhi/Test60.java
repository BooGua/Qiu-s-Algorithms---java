package OfferJianZhi;

import org.junit.Test;

/**
 * n 个骰子的点数。
 * <p>
 * 原题：把n个骰子扔到地上，所有骰子朝上一面的点数之后为s. 输入n，打印出s所有可能的值出现的概率。
 * （每个骰子6个面，点数从1到6）
 */
public class Test60 {
    private static final int g_maxValue = 6;

    @Test
    public void test() {
        int number = 2;
        PrintProbability(number);
        MyPrintProbability(number);
    }

    private void MyPrintProbability(int number) {
        int[] numbers = new int[number * 6];
        for (int i = 1; i <= 6; i++) {
            CalculateSixNumber(6, i, numbers);
        }
    }

    private void CalculateSixNumber(int countNumber, int sum, int[] numbers) {
        if (countNumber == 0) {
            numbers[sum]++;
        }
        for (int j = 1; j <= 6; j++) {
            CalculateSixNumber(countNumber--, j, numbers);
        }
    }

    //基于递归求骰子点数，时间效率不高
    public static void PrintProbability(int number) {
        if (number < 1) return;
        int maxSum = number * g_maxValue;
        int[] pProbabilities = new int[maxSum - number + 1];
        //初始化，开始统计之前都为0次
        for (int i = number; i <= maxSum; i++) {
            pProbabilities[i - number] = 0;
        }
        double total = Math.pow(g_maxValue, number);
        //probability(number,pProbabilities);这个函数计算n~6n每种情况出现的次数
        probability(number, pProbabilities);
        for (int i = number; i <= maxSum; i++) {
            double ratio = pProbabilities[i - number] / total;
            System.out.println("i: " + i + " ratio: " + ratio);
        }
    }

    public static void probability(int number, int[] pProbabilities) {
        for (int i = 1; i <= g_maxValue; i++) {//从第一个骰子开始
            probability(number, number, i, pProbabilities);
        }
    }

    //总共original个骰子，当前第 current个骰子，当前的和，贯穿始终的数组
    public static void probability(int original, int current, int sum, int[] pProbabilities) {
        if (current == 1) {
            pProbabilities[sum - original]++;
        } else {
            for (int i = 1; i <= g_maxValue; i++) {
                probability(original, current - 1, sum + i, pProbabilities);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////看不懂！！！！！//////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    //基于循环求骰子点数
    public static void PrintProbability_1(int number) {
        if (number < 1) {
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue * number + 1];
        for (int i = 0; i < g_maxValue; i++) {//初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++) {//当第一次抛掷骰子时，有6种可能，每种可能出现一次
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= g_maxValue * k; i++) {//第k次掷骰子，和最小为k，最大为g_maxValue*k
                pProbabilities[1 - flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for (int j = 1; j <= i && j <= g_maxValue; j++) {
                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = pProbabilities[flag][i] / total;
            System.out.println("sum: " + i + " ratio: " + ratio);
        }
    }
}
